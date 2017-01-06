package com.rodbate.fastdfs;







public class StorageServer {


    private String groupName;

    private String ip;

    private int port;

    private byte storePath;


    public StorageServer() {
    }

    public StorageServer(String groupName, String ip, int port, byte storePath) {
        this.groupName = groupName;
        this.ip = ip;
        this.port = port;
        this.storePath = storePath;
    }


    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public byte getStorePath() {
        return storePath;
    }

    public void setStorePath(byte storePath) {
        this.storePath = storePath;
    }
}
