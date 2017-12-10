package com.fasteat.server.util;


import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

public class FastDFSUtils {

    /**
     *
     * @param local_filename
     * @param file_ext_name
     * @return img httpURl
     * @throws IOException
     * @throws MyException
     */
    public static String testFast(String local_filename , String file_ext_name) {
        try {
            ClientGlobal.init("client.conf");
            //创建跟踪器的客户端对象
            TrackerClient trackerClient = new TrackerClient();
            //创建跟踪器的服务端对象
            TrackerServer connection = trackerClient.getConnection();
            //声明一个存储器的服务端对象
            StorageServer storageServer = null;
            //创建存储器的客户端对象
            StorageClient storageClient = new StorageClient(connection, storageServer);
            //调用存储器客户端对象的上传方法
            String[] strings = storageClient.upload_file(local_filename,file_ext_name,null);
            //路径拼接
            String url ="http://120.78.184.134:88/"+strings[0]+"/"+strings[1];
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }
}
