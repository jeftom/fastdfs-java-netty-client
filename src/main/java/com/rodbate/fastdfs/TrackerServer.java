package com.rodbate.fastdfs;







public class TrackerServer {


    private String ip;

    private int port;

    public TrackerServer() {
    }

    public TrackerServer(String ip, int port) {
        this.ip = ip;
        this.port = port;
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
}
