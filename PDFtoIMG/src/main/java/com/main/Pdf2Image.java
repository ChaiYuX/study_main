package com.main;

import com.lowagie.text.pdf.PdfReader;
import com.util.ImageMergeUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pdf2Image {

    public static void main(String[] args) {
        String test = "D:\\workspace\\studyMain\\uploadTest\\文档.pdf";
        String test2 = test.substring(0, test.lastIndexOf(".")) + ".jpg";
        System.out.println(test2);
        File file = new File("D:\\workspace\\studyMain\\uploadTest\\文档.pdf");
        pdf2Image(file);
        System.out.println("测试");
    }

    private static File pdf2Image(File file) {

        /* dpi越大转换后越清晰，相对转换速度越慢 */
        int dpi = 300;
        PDDocument pdDocument; // 创建PDF文档
        try {
            pdDocument = PDDocument.load(file);
            PDFRenderer renderer = new PDFRenderer(pdDocument);
            int pages = pdDocument.getNumberOfPages(); // 获取 PDF 页数
            BufferedImage[] bufferedImages = new BufferedImage[pages];
            for (int i = 0; i < pages; i++) {
                BufferedImage image = renderer.renderImageWithDPI(i, dpi);
                bufferedImages[i] = image;
            }
            // PDF文件全部页数转PNG图片，若多张展示注释即可 工具类贴在下面
            File result = ImageMergeUtil.mergeImageToFile(bufferedImages, 2 , file.getAbsolutePath());
            System.out.println("PDF文档转PNG图片成功！");
            return result;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("pdf转图片失败！");
        }
    }

    private static void pdf2Image() {
        String dstImgFolder = "";
        String PdfFilePath = "";

        String relativelyPath = System.getProperty("user.dir");
        PdfFilePath = relativelyPath + "/uploadTest/" + "文档.pdf";
        dstImgFolder = relativelyPath + "/uploadTest/";
        /* dpi越大转换后越清晰，相对转换速度越慢 */
        int dpi = 300;
        File file = new File(PdfFilePath);
        PDDocument pdDocument; // 创建PDF文档
        try {
            String imgPDFPath = file.getParent();
            int dot = file.getName().lastIndexOf('.');
            String imagePDFName = file.getName().substring(0, dot); // 获取图片文件名
            String imgFolderPath = null;
            if (dstImgFolder.equals("")) {
                imgFolderPath = imgPDFPath + File.separator;// 获取图片存放的文件夹路径
            } else {
                imgFolderPath = dstImgFolder + File.separator;
            }
            if (createDirectory(imgFolderPath)) {
                pdDocument = PDDocument.load(file);
                PDFRenderer renderer = new PDFRenderer(pdDocument);
                PdfReader reader = new PdfReader(PdfFilePath);
                int pages = reader.getNumberOfPages();
                StringBuffer imgFilePath = null;
                BufferedImage[] bufferedImages = new BufferedImage[pages];
                for (int i = 0; i < pages; i++) {
                    String imgFilePathPrefix = imgFolderPath + File.separator;
                    imgFilePath = new StringBuffer();
                    imgFilePath.append(imgFilePathPrefix);
                    imgFilePath.append("_");
                    imgFilePath.append(i + 1);
                    imgFilePath.append(".png");
                    // File dstFile = new File(imgFilePath.toString());
                    BufferedImage image = renderer.renderImageWithDPI(i, dpi);
                    bufferedImages[i] = image;
                    // ImageIO.write(image, "png", dstFile);
                }
                dstImgFolder = dstImgFolder + imagePDFName + ".png";
                // PDF文件全部页数转PNG图片，若多张展示注释即可 工具类贴在下面
                ImageMergeUtil.mergeImage(bufferedImages, 2, dstImgFolder);
                System.out.println("PDF文档转PNG图片成功！");
            } else {
                System.out.println("PDF文档转PNG图片失败：" + "创建" + imgFolderPath + "失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean createDirectory(String folder) {
        File dir = new File(folder);
        if (dir.exists()) {
            return true;
        } else {
            return dir.mkdirs();
        }
    }


}
