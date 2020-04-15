/*
 * @Author: Xiaoli Zhou
 * @Date: 2020-04-02 16:51:18
 * @LastEditTime: 2020-04-10 21:05:04
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /maven-hello-world/src/main/java/numberRecognizer/Main.java
 */
package numberRecognizer;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @see Main class, to enter the application
 * @version 2.0
 * @author Xiaoli Zhou
 */
public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
    	//singleton pattern
        NumberRecognizerGUI.getInstance();
    }

    public static void main(String args[]) {
        launch(args);
    }
}