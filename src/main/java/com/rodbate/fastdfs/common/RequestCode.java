package com.rodbate.fastdfs.common;





public class RequestCode {


    /**
     * fast dfs package body length
     */
    public static final byte FDFS_BODY_LENGTH = 8;

    /**
     *
     * group name max length
     */
    public static final int FDFS_GROUP_NAME_LEN = 16;

    /**
     * ip address length
     */
    public static final int FDFS_IPADDR_SIZE = 16;


    public static final byte FDFS_PROTO_CMD_QUIT = 82;
    public static final byte TRACKER_PROTO_CMD_SERVER_LIST_GROUP = 91;
    public static final byte TRACKER_PROTO_CMD_SERVER_LIST_STORAGE = 92;
    public static final byte TRACKER_PROTO_CMD_SERVER_DELETE_STORAGE = 93;

    /**
     * request code : query one storage server without group name from tracker server
     *
     */
    public static final byte TRACKER_PROTO_CMD_SERVICE_QUERY_STORE_WITHOUT_GROUP_ONE = 101;

    /**
     *
     * request code : query one storage server with group name from tracker server
     */
    public static final byte TRACKER_PROTO_CMD_SERVICE_QUERY_STORE_WITH_GROUP_ONE = 104;

    /**
     *
     * request code : query all valid storage servers without group name from tracker server
     */
    public static final byte TRACKER_PROTO_CMD_SERVICE_QUERY_STORE_WITHOUT_GROUP_ALL = 106;

    /**
     *
     * request code : query all valid storage servers with group name from tracker server
     */
    public static final byte TRACKER_PROTO_CMD_SERVICE_QUERY_STORE_WITH_GROUP_ALL = 107;


    public static final byte TRACKER_PROTO_CMD_SERVICE_QUERY_FETCH_ONE = 102;
    public static final byte TRACKER_PROTO_CMD_SERVICE_QUERY_UPDATE = 103;



    public static final byte TRACKER_PROTO_CMD_SERVICE_QUERY_FETCH_ALL = 105;


    /**
     *
     * response code : tracker and storage server send response code
     */
    public static final byte CMD_RESPONSE = 100;


    public static final byte FDFS_PROTO_CMD_ACTIVE_TEST = 111;
    public static final byte STORAGE_PROTO_CMD_UPLOAD_FILE = 11;
    public static final byte STORAGE_PROTO_CMD_DELETE_FILE = 12;
    public static final byte STORAGE_PROTO_CMD_SET_METADATA = 13;
    public static final byte STORAGE_PROTO_CMD_DOWNLOAD_FILE = 14;
    public static final byte STORAGE_PROTO_CMD_GET_METADATA = 15;
    public static final byte STORAGE_PROTO_CMD_UPLOAD_SLAVE_FILE = 21;
    public static final byte STORAGE_PROTO_CMD_QUERY_FILE_INFO = 22;
    public static final byte STORAGE_PROTO_CMD_UPLOAD_APPENDER_FILE = 23;
    public static final byte STORAGE_PROTO_CMD_APPEND_FILE = 24;
    public static final byte STORAGE_PROTO_CMD_MODIFY_FILE = 34;
    public static final byte STORAGE_PROTO_CMD_TRUNCATE_FILE = 36;
}
