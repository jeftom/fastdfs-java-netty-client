package com.rodbate.fastdfs.protocol;






public class FDFSHeader {


    private long bodyLen;

    private byte cmd;

    private byte statusCode;


    public FDFSHeader() {
    }

    public FDFSHeader(long bodyLen, byte cmd, byte statusCode) {
        this.bodyLen = bodyLen;
        this.cmd = cmd;
        this.statusCode = statusCode;
    }


    public long getBodyLen() {
        return bodyLen;
    }

    public void setBodyLen(long bodyLen) {
        this.bodyLen = bodyLen;
    }

    public byte getCmd() {
        return cmd;
    }

    public void setCmd(byte cmd) {
        this.cmd = cmd;
    }

    public byte getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(byte statusCode) {
        this.statusCode = statusCode;
    }
}
