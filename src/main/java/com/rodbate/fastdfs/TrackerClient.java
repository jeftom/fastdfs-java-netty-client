package com.rodbate.fastdfs;


import java.util.List;




public interface TrackerClient {


    /**
     * 获取单个storage server 用于上传文件
     *
     * @param trackerServer tracker server
     * @return StorageServer
     */
    StorageServer getUploadStorageServer(TrackerServer trackerServer);


    /**
     * 根据指定的group 获取 单个storage server 用于上传文件
     *
     * @param trackerServer tracker server
     * @param groupName group name
     * @return StorageServer
     */
    StorageServer getUploadStorageServer(TrackerServer trackerServer, String groupName);


    /**
     *
     * 获取多个storage server 用于上传文件
     *
     * @param trackerServer tracker server
     * @return List<StorageServer>
     */
    List<StorageServer> getUploadStorageServerList(TrackerServer trackerServer);

    /**
     *
     * 根据指定的group 获取多个storage server 用于上传文件
     *
     * @param trackerServer tracker server
     * @param groupName group name
     * @return List<StorageServer>
     */
    List<StorageServer> getUploadStorageServerList(TrackerServer trackerServer, String groupName);


    /**
     * 根据指定group 和file 文件名 获取多个storage server 用于下载或修改文件 (即该文件已经存在于服务器)
     *
     * @param trackerServer tracker server
     * @param groupName group name
     * @param fileName file name
     * @param cmd request code
     * @return List<StorageServer>
     */
    List<StorageServer> getDownloadOrUpdateStorageServerList(TrackerServer trackerServer, String groupName, String fileName, byte cmd);


    /**
     * 根据指定group 和file 文件名 获取单个storage server 用于下载文件
     *
     * @param trackerServer tracker server
     * @param groupName group name
     * @param fileName file name
     * @return StorageServer
     */
    StorageServer getDownloadStorageServer(TrackerServer trackerServer, String groupName, String fileName);


    /**
     * 根据指定group 和file 文件名 获取多个storage server 用于下载文件
     *
     * @param trackerServer tracker server
     * @param groupName group name
     * @param fileName file name
     * @return List<StorageServer>
     */
    List<StorageServer> getDownloadStorageServerList(TrackerServer trackerServer, String groupName, String fileName);


    /**
     * 根据指定group 和file 文件名 获取单个storage server 用于修改文件
     *
     * @param trackerServer tracker server
     * @param groupName group name
     * @param fileName file name
     * @return StorageServer
     */
    StorageServer getUpdateStorageServer(TrackerServer trackerServer, String groupName, String fileName);


    /**
     * list tracker server groups
     *
     * @param trackerServer tracker server
     * @return List<GroupStorageState>
     */
    List<GroupStorageState> listGroups(TrackerServer trackerServer);


    List<StorageState> listStorageServers(TrackerServer trackerServer, String groupName);


    List<StorageState> listStorageServers(TrackerServer trackerServer, String groupName, String storageIp);


    boolean deleteStorage(TrackerServer trackerServer, String groupName, String storageIp);
}
