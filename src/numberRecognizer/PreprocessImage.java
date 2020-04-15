/*
 * @Author: Xiaoli Zhou
 * @Date: 2020-04-12 20:05:29
 * @LastEditTime: 2020-04-12 20:48:45
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: src/numberRecognize/PreprocessImage.java
 */
package numberRecognizer;

import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


public class PreprocessImage {
	
	//load opencv library
	static {
		String opencvpath = "/Users/zhouxiaoli/Desktop/opencv-3.4.10/share/OpenCV/java/libopencv_java3410.dylib";
		System.load(opencvpath);
		//System.out.println(Core.VERSION);	
	}
	
	public static void preprocess() {
		
	      //read image from its folder
			Mat originalImg = Imgcodecs.imread("src/numberRecognizer/" + "1.png");//"src/numberRecognizer/" + count + ".png"
	       //resize the original image to 28*28 pixels
	        Imgproc.resize(originalImg, originalImg, new Size(28,28));
		
			//change resized image to gray image
		  Imgproc.cvtColor(originalImg, originalImg, Imgproc.COLOR_BGR2GRAY);
		  
		  //threshold the gray image
		  //Mat target = new Mat();
	     //Imgproc.threshold(originalImg, originalImg, 200, 255, Imgproc.THRESH_BINARY|Imgproc.THRESH_OTSU);
	      //System.out.println("channel:"+originalImg.channels());//channel 1 represents gray image
//	      // 保存二值化后图片
	      Imgcodecs.imwrite("src/numberRecognizer/" + "11.png", originalImg);
	    
		  
	}
	
//	
//	public static void main(String[] args) {
//		PreprocessImage img = new PreprocessImage();
//		img.preprocess();
//	}
}