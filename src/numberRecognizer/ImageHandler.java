/*
 * @Author: your name
 * @Date: 2020-04-07 15:49:06
 * @LastEditTime: 2020-04-12 14:02:47
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /maven-hello-world/src/main/java/numberRecognizer/ImageHandler.java
 */
package numberRecognizer;

import java.io.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

import javax.imageio.ImageIO;

//import javafx.scene.image.Image;

public class ImageHandler {
    private static final String folderPath = "src/numberRecognizer/11.png";
    private static float[][] rgbArr;
//    private File imageFile = new File(folderPath);
//    private File[] imageList = imageFile.listFiles();

    /**
     * @description: if the image folder is not empty, read the last image file from
     *               the folder
     * @param none
     * @return: BufferedImage
     */
    private static BufferedImage getImage() {
            try {
                InputStream input = new FileInputStream(new File(folderPath));
                BufferedImage img = ImageIO.read(input);
                return img;
            } catch (FileNotFoundException e1) {
                // TODO: handle exception
            } catch (IOException e2) {
                // TODO: handle exception
            }
        return null;
    }

    /**
     * @description: transform a BufferedImage to 2-dimentional float array
     * @param none
     * @return: float[][]
     */
    
    public static float[][] convertImageToArray() {
    	BufferedImage image = getImage();
    	Raster ra = image.getData();
    	  // 获取图片宽度和高度
    	  int width = image.getWidth();
    	  int height = image.getHeight();
//    	  // 将图片sRGB数据写入一维数组
//    	  int[] data = new int[width*height];
//    	  image.getRGB(0, 0, width, height, data, 0, width);
    	  int pixels[] = new int[width * height];
  		pixels = ra.getPixels(0, 0, width, height, pixels); //获得图片每个点的像素
    	  
//    	  // 将一维数组转换为为二维数组
//    	  int[][] rgbArray = new int[1][width*height];
//    	 
//    	   for(int j = 0; j < width; j++) {
//    	    rgbArray[0][j] = data[j];
//    	    }
  		float[] temp = new float[width * height];
  		for(int i = 0; i < pixels.length; i++) {//(255-x)*1.0/255.0
       	    temp[i] = (255-pixels[i])*1.0f/255.0f;
  			//System.out.print(pixels[i]+", ");
       	    }
    	   
    	   //convert float array to 2-dimentional float arry
    	   rgbArr = new float[1][width*height];
    	   for(int i = 0; i < width*height; i++) {//(255-x)*1.0/255.0
       	    rgbArr[0][i] = temp[i];
       	    }
    	   return rgbArr;
    	   }

//     public String arrayToString(float[] arr) {
//         // TODO Auto-generated method stub
//         String s = "[";
//         for (float x : arr) {
//             s += x + ", ";
//         }
//        return s + "]";
//     }

//     public static void main(String[] args) {
//    	 ImageHandler ihd = new ImageHandler();
//    	 float[][] a = ihd.convertImageToArray();
//    	 System.out.println(a[0].length);
//    	System.out.println(ihd.arrayToString(a[0]));
//     }
}