package com.fasteat.server;

import com.fasteat.server.util.CodeUtil;
import com.fasteat.server.util.FastDFSUtils;

public class test {

    public static void main(String[] args)throws Exception {
        String qrCode = CodeUtil.createQrCode(1);
        String s = FastDFSUtils.testFast(qrCode, "jpg");
        System.out.println(s);
    }
}
