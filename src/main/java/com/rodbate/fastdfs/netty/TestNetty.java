package com.rodbate.fastdfs.netty;


import com.rodbate.fastdfs.codec.FDFSAbstractDecoder;
import com.rodbate.fastdfs.common.CommonUtil;
import com.rodbate.fastdfs.common.RequestCode;
import com.rodbate.fastdfs.protocol.FDFSHeader;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class TestNetty {


    public static void main(String[] args) throws InterruptedException {


        Bootstrap bootstrap = new Bootstrap();

        bootstrap.group(new NioEventLoopGroup(1))
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, false)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new NettyDecoder());
                    }
                });


        ChannelFuture future = bootstrap.connect("rodbate1", 22122);

        future.awaitUninterruptibly();

        if (future.isSuccess())
        {
            System.out.println(" ======== connect remote server <>" + future.channel().remoteAddress().toString());

            Channel ch = future.channel();
            byte body[] = new byte[16];

            Arrays.fill(body, (byte) 0);

            byte groupName[] = "rodbate2".getBytes();

            System.arraycopy(groupName, 0, body, 0, groupName.length);


            ByteBuf buffer = ch.alloc().buffer(16);
            buffer.writeBytes(body);

            ch.write(buildCmdBufferHeader(RequestCode.TRACKER_PROTO_CMD_SERVICE_QUERY_STORE_WITH_GROUP_ONE, (byte)0, 16, ch.alloc()));
            ch.write(buffer);
            ch.flush();

            FDFSAbstractDecoder decoder = new FDFSAbstractDecoder(ch) {
                @Override
                protected void decodeBody0(ByteBuf in, FDFSHeader header) {
                    byte groupName[] = new byte[16];
                    Arrays.fill(groupName, (byte) 0);

                    byte ipAddr[] = new byte[16];
                    Arrays.fill(ipAddr, (byte) 0);

                    in.readBytes(groupName);
                    in.readBytes(ipAddr);

                    //port 7 byte +    store path 1 byte
                    byte port[] = new byte[7];
                    in.readBytes(port);
                    int p = (int) CommonUtil._7bytesToLong(port);

                    byte storePath = in.readByte();




                    System.out.println("group name " + new String(groupName));
                    System.out.println("ip address " + new String(ipAddr));
                    System.out.println("ip port " + p);
                    System.out.println("store path " + storePath);
                }

                @Override
                protected long expectBodyLength() {
                    return 10;
                }
            };

        }


    }




    public static ByteBuf buildCmdBufferHeader(byte cmd, byte statusCode, long bodyLen, ByteBufAllocator alloc){

        ByteBuf buf = alloc.buffer(10);

        buf.writeLong(bodyLen);
        buf.writeByte(cmd);
        buf.writeByte(0);


        return buf;
    }
}
