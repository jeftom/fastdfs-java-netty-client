package com.rodbate.fastdfs.codec;


import com.rodbate.fastdfs.netty.NettyDecoder;
import com.rodbate.fastdfs.protocol.FDFSHeader;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;


import java.io.IOException;
import java.util.Objects;

import static com.rodbate.fastdfs.common.RequestCode.*;




public abstract class FDFSAbstractDecoder {

    private final Channel channel;

    private volatile boolean isDecodeHeader = true;

    public FDFSAbstractDecoder(Channel channel) {
        Objects.requireNonNull(channel);
        this.channel = channel;
    }

    public void execute() {
        NettyDecoder nettyDecoder = this.channel.pipeline().get(NettyDecoder.class);
        nettyDecoder.setDecoder(this);
    }

    public void decode(ByteBuf in) throws IOException {

        FDFSHeader fdfsHeader = null;

        if (isDecodeHeader) {
            fdfsHeader = decodeHeader(in);
        }

        if (fdfsHeader != null) {
            decodeBody(in, fdfsHeader);
        }
    }


    private FDFSHeader decodeHeader(ByteBuf in) throws IOException {

        long bodyLength = in.readLong();

        if (bodyLength < 0) {
            throw new IOException("FDFSAbstractDecoder : decodeHeader => bodyLength < 0");
        }

        long expectBodyLength = expectBodyLength();

        if (expectBodyLength >= 0 && bodyLength != expectBodyLength) {
            throw new IOException("FDFSAbstractDecoder : decodeHeader => bodyLength != expectBodyLength");
        }

        byte cmd = in.readByte();
        if (cmd != CMD_RESPONSE) {
            throw new IOException("FDFSAbstractDecoder : decodeHeader => response cmd != " + CMD_RESPONSE);
        }

        byte statusCode = in.readByte();
        if (statusCode != 0) {
            throw new IOException("FDFSAbstractDecoder : decodeHeader => response code != 0 [failed]");
        }

        return new FDFSHeader(bodyLength, cmd, statusCode);
    }


    private void decodeBody(ByteBuf in, FDFSHeader header) {
        decodeBody0(in, header);
        isDecodeHeader = false;
    }


    protected abstract void decodeBody0(ByteBuf in, FDFSHeader header);

    protected long expectBodyLength() {
        return -1;
    }
}
