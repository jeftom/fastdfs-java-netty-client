package com.rodbate.fastdfs.common;


import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class CommonUtil {


    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);


    public static long _7bytesToLong(byte[] src) {

        return  (long)(src[0] >= 0 ? src[0] : 256 + src[0]) << 48 |
                (long)(src[1] >= 0 ? src[1] : 256 + src[1]) << 40 |
                (long)(src[2] >= 0 ? src[2] : 256 + src[2]) << 32 |
                (long)(src[3] >= 0 ? src[3] : 256 + src[3]) << 24 |
                (long)(src[4] >= 0 ? src[4] : 256 + src[4]) << 16 |
                (long)(src[5] >= 0 ? src[5] : 256 + src[5]) <<  8 |
                (long)(src[6] >= 0 ? src[6] : 256 + src[6]);
    }


    public static void closeChannel(final Channel channel) {

        channel.closeFuture().addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                LOGGER.warn("close channel <{}> , state : {}", parseRemoteAddress(channel), future.isSuccess() ? "success" : "fail");
            }
        });
    }


    public static String parseRemoteAddress(Channel channel) {

        InetSocketAddress address = (InetSocketAddress) channel.remoteAddress();

        if (address != null) {
            return address.getHostName() + ":" + address.getPort();
        }
        return "";
    }

}
