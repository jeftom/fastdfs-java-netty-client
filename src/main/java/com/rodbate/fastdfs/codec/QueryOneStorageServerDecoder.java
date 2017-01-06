package com.rodbate.fastdfs.codec;


import com.rodbate.fastdfs.common.CommonUtil;
import com.rodbate.fastdfs.protocol.FDFSHeader;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;


import java.util.Arrays;

import static com.rodbate.fastdfs.common.RequestCode.*;
import static com.rodbate.fastdfs.common.CommonUtil.*;


/**
 *
 * 查询单个storage server decoder
 *
 */
public class QueryOneStorageServerDecoder extends FDFSAbstractDecoder{


    public QueryOneStorageServerDecoder(Channel channel) {
        super(channel);
    }

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
        return FDFS_BODY_LENGTH + FDFS_GROUP_NAME_LEN + FDFS_IPADDR_SIZE;
    }
}
