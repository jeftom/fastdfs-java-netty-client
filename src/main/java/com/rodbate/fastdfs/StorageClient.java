package com.rodbate.fastdfs;


import com.rodbate.fastdfs.common.Pair;

import java.util.List;



public interface StorageClient {




    List<String> uploadFile(String localFile, String fileExtName, List<Pair<String, String>> metaList);



    List<String> uploadFile(String groupName, String localFile, String fileExtName, List<Pair<String, String>> metaList);



    List<String> uploadAppendFile(String localFile, String fileExtName, List<Pair<String, String>> metaList);



    List<String> uploadAppendFile(String groupName, String localFile, String fileExtName, List<Pair<String, String>> metaList);


    int downloadFile(String groupName, String remoteFileName);


    FileInfo getFileInfo(String groupName, String remoteFileName);
}
