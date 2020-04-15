package numberRecognizer;


import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.sun.prism.BasicStroke;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/*
 * @Author: Xiaoli Zhou
 * @Date: 2020-03-31 16:07:01
 * @LastEditTime: 2020-04-06 14:46:27
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /maven-hello-world/src/main/java/numberRecognizer/NumberRecognizerGUI.java
 */

/**
 * @see another user interface，inherit Stage，use VBox as main layout，
 *      contains 2 buttons and a canvas which allows users to draw a number.
 * @version 2.0
 * @author Xiaoli Zhou
 */
public class DrawingGUI extends Stage {
    // create VBox as root node
    private VBox root;
    // create a HBox to contain buttons
    private HBox buttonBOX;
    // create a canvas to draw numbers
    private Canvas canvas;
    // create a graphicsContext
    private GraphicsContext graphicsContext;
    
    public DrawingGUI() {
    	
    }

    public DrawingGUI(int width,int height) {
        root = new VBox();
        buttonBOX = new HBox();
        setScene(new Scene(root, width, height, Color.WHITE));
        setTitle("Canvas");
        initUI();
        show();
    }

    private void initUI() {
        canvas = new Canvas(400, 400);
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setLineWidth(8.0);
        //graphicsContext.setImageSmoothing(true);
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, 400, 400);
        Button clear = new Button("Clear");
        Button save = new Button("Save");
        // set all margins
        VBox.setMargin(canvas, new Insets(0, 0, 0, 0));
        HBox.setMargin(clear, new Insets(10, 30, 15, 0));
        HBox.setMargin(save, new Insets(10, 0, 15, 30));

        // set buttons' font color
        clear.setTextFill(Paint.valueOf("#fffafa"));
        save.setTextFill(Paint.valueOf("#fffafa"));
        // set buttons' background color
        clear.setStyle(" -fx-background-color: #87ceeb;");
        save.setStyle(" -fx-background-color: #87ceeb;");
        // set all font size
        clear.setFont(Font.font(null, FontWeight.BOLD, 15));
        save.setFont(Font.font(null, FontWeight.BOLD, 15));
        // set buttons in the center of hbox
        buttonBOX.setAlignment(Pos.CENTER);

        // add all child nodes to its parent node
        buttonBOX.getChildren().addAll(clear, save);
        root.getChildren().addAll(canvas, buttonBOX);
        // add event listeners to mouse to record mouse's moving path
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent event) -> {
        	
            graphicsContext.beginPath();
            graphicsContext.moveTo(event.getX(), event.getY());
            graphicsContext.stroke();
        });

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, (MouseEvent event) -> {
            graphicsContext.lineTo(event.getX(), event.getY());
            graphicsContext.stroke();
        });

        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent event) -> {
            // DO NOTHING
        });

        // add a event listener to clear button to reset canvas
        clear.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            graphicsContext.clearRect(0, 0, graphicsContext.getCanvas().getWidth(),
                    graphicsContext.getCanvas().getHeight());
            graphicsContext.setFill(Color.WHITE);
            graphicsContext.fillRect(0, 0, 400, 400);

        });

        // add an event listener to save button to save the canvas as png image file and
        // modify the image
        save.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            // save the canvas as png image file
            //count++;
            File file = new File("src/numberRecognizer/" + "1.png");
            try {
                WritableImage image = canvas.snapshot(new SnapshotParameters(), null);
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
                //process the original image
                PreprocessImage.preprocess();   
            } catch (IOException ex) {
                // do nothing
            }
        });
    }

//    public int getCount() {
//        return count;
//    }
//    public static void main(String[] args) {
//    	System.out.println("success");
//    }
    
}
