package com.fasteat.server.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

public class CodeUtil {
    /**
     37      只传入项目店铺ID 根据ID生成二维码名称
            二维码生成在D:\code\下
     44      */
    public static String createQrCode(int id) throws WriterException, IOException{
                    //设置二维码纠错级别ＭＡＰ
        File file = new File("D:\\code\\");
        if(!file.exists()){
            file.mkdirs();
        }
       File dp = new File("D:\\code\\"+id+".jpg");
        if(!dp.exists()){
            dp.createNewFile();
            System.out.println(dp.getName());
        }
        OutputStream outputStream =new FileOutputStream(dp);
        int qrCodeSize =1200;
         String imageFormat ="jpg";
        String content="http://120.78.184.134:8080/restaurant?rid="+id;
                    Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
                  hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);  // 矫错级别
                     QRCodeWriter qrCodeWriter = new QRCodeWriter();
                     //创建比特矩阵(位矩阵)的QR码编码的字符串
                     BitMatrix byteMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, qrCodeSize, qrCodeSize, hintMap);
                    // 使BufferedImage勾画QRCode  (matrixWidth 是行二维码像素点)
                    int matrixWidth = byteMatrix.getWidth();
                   BufferedImage image = new BufferedImage(matrixWidth-200, matrixWidth-200, BufferedImage.TYPE_INT_RGB);
                     image.createGraphics();
                     Graphics2D graphics = (Graphics2D) image.getGraphics();
                     graphics.setColor(Color.WHITE);
                     graphics.fillRect(0, 0, matrixWidth, matrixWidth);
                     // 使用比特矩阵画并保存图像
                     graphics.setColor(Color.BLACK);
                     for (int i = 0; i < matrixWidth; i++){
                             for (int j = 0; j < matrixWidth; j++){
                                     if (byteMatrix.get(i, j)){
                                             graphics.fillRect(i-100, j-100, 1, 1);
                                         }
                                 }
                         }

                      ImageIO.write(image, imageFormat, outputStream);
                    return dp.getCanonicalPath();
             }

             /**
       * 读二维码并输出携带的信息
       */
             /*public static void readQrCode(InputStream inputStream) throws IOException{
                 //从输入流中获取字符串信息
                 BufferedImage image = ImageIO.read(inputStream);
                 //将图像转换为二进制位图源
                 LuminanceSource source = new BufferedImageLuminanceSource(image);
                 BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                 QRCodeReader reader = new QRCodeReader();
                 Result result = null ;
                 try {
                      result = reader.decode(bitmap);
                     } catch (ReaderException e) {
                         e.printStackTrace();
                     }
                 System.out.println(result.getText());
             }
     *//**
 90      * 测试代码
 91      * @throws WriterException
 92      *//*
             public static void main(String[] args) throws IOException, WriterException {

                 createQrCode(new FileOutputStream(new File("d:\\qrcode.jpg")),"WE1231238239128sASDASDSADSDWEWWREWRERWSDFDFSDSDF123123123123213123",900,"JPEG");
                 readQrCode(new FileInputStream(new File("d:\\qrcode.jpg")));
             }
*/
         }