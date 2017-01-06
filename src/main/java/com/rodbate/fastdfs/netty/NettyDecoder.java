package com.rodbate.fastdfs.netty;


import com.rodbate.fastdfs.codec.FDFSAbstractDecoder;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


import static com.rodbate.fastdfs.common.CommonUtil.*;


public class NettyDecoder extends ByteToMessageDecoder {

    private static final Logger LOGGER = LoggerFactory.getLogger(NettyDecoder.class);

    private final AtomicReference<FDFSAbstractDecoder> decoder = new AtomicReference<FDFSAbstractDecoder>();

    public void setDecoder(FDFSAbstractDecoder decoder){
        this.decoder.set(decoder);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        decoder.get().decode(in);
    }



}
