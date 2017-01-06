package com.rodbate.fastdfs;


import java.util.Date;




public class FileInfo {


    private String srcIp;

    private long fileSize;

    private int createUnixTime;

    private int crc32;


    public FileInfo() {
    }

    public FileInfo(String srcIp, long fileSize, int createUnixTime, int crc32) {
        this.srcIp = srcIp;
        this.fileSize = fileSize;
        this.createUnixTime = createUnixTime;
        this.crc32 = crc32;
    }

    public String getSrcIp() {
        return srcIp;
    }

    public void setSrcIp(String srcIp) {
        this.srcIp = srcIp;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public int getCreateUnixTime() {
        return createUnixTime;
    }

    public void setCreateUnixTime(int createUnixTime) {
        this.createUnixTime = createUnixTime;
    }

    public int getCrc32() {
        return crc32;
    }

    public void setCrc32(int crc32) {
        this.crc32 = crc32;
    }
}
