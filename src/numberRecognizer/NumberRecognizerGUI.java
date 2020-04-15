package numberRecognizer;

/*
 * @Author: Xiaoli Zhou
 * @Date: 2020-03-31 16:07:01
 * @LastEditTime: 2020-04-10 21:04:42
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /maven-hello-world/src/main/java/numberRecognizer/NumberRecognizerGUI.java
 */

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * @see MainStage main user interface，inherit Stage，use VBox as main layout，
 *      contains 2 buttons and 6 labels
 * @version 1.0
 * @author Xiaoli Zhou
 */
public class NumberRecognizerGUI extends Stage {
    // use VBox as root node
    private VBox root;
    // buttons are contained in HBox
    private HBox buttonBOX;
    // create 6 labels
    private Label instructionLabel, instruction1, instruction2, instruction3, resultLabel, result;
    // create 2 buttons
    private Button draw, recognize;
    //create an int variable to store the model's result
    static int res;

    private NumberRecognizerGUI() {
        root = new VBox();
        buttonBOX = new HBox();
        setScene(new Scene(root, 400, 300, Color.WHITE));
        setTitle("Number Recognizer Application");
        initUI();
        show();
    }

    private static NumberRecognizerGUI instance = new NumberRecognizerGUI();

    public static NumberRecognizerGUI getInstance() {
        return instance;
    }

    private void initUI() {

        instructionLabel = new Label("Instruction: ");
        instruction1 = new Label("The number you drew is: ");
        instruction2 = new Label("The number you drew is: ");
        instruction3 = new Label("The number you drew is: ");

        resultLabel = new Label("The number you drew is: ");
        draw = new Button("Open Canvas");
        recognize = new Button("Recognize");
        result = new Label(" ");
        VBox.setMargin(instructionLabel, new Insets(10, 0, 10, 150));
        VBox.setMargin(instruction1, new Insets(5, 5, 5, 5));
        VBox.setMargin(instruction2, new Insets(5, 5, 5, 5));
        VBox.setMargin(instruction3, new Insets(5, 5, 20, 5));
        VBox.setMargin(resultLabel, new Insets(0, 5, 2, 5));
        VBox.setMargin(result, new Insets(10, 0, 3, 180));
        HBox.setMargin(draw, new Insets(10, 20, 15, 0));
        HBox.setMargin(recognize, new Insets(10, 0, 15, 20));

        // set buttons' font color
        draw.setTextFill(Paint.valueOf("#fffafa"));
        recognize.setTextFill(Paint.valueOf("#fffafa"));
        // set buttons' background color
        draw.setStyle(" -fx-background-color: #87ceeb;");
        recognize.setStyle(" -fx-background-color: #87ceeb;");
        // set all font size
        instructionLabel.setFont(Font.font(null, FontWeight.BOLD, 18));
        instruction1.setFont(Font.font(null, FontWeight.BOLD, 15));
        instruction2.setFont(Font.font(null, FontWeight.BOLD, 15));
        instruction3.setFont(Font.font(null, FontWeight.BOLD, 15));
        resultLabel.setFont(Font.font(null, FontWeight.BOLD, 15));
        result.setFont(Font.font(null, FontWeight.BOLD, 50));
        draw.setFont(Font.font(null, FontWeight.BOLD, 15));
        recognize.setFont(Font.font(null, FontWeight.BOLD, 15));
        // set buttons in the center of hbox
        buttonBOX.setAlignment(Pos.CENTER);

        // add all child nodes to its parent node
        buttonBOX.getChildren().addAll(draw, recognize);
        root.getChildren().addAll(instructionLabel, instruction1, instruction2, instruction3, buttonBOX, resultLabel,
                result);
        // add event listen to draw button to open a canvas
        draw.setOnMouseClicked(event -> {
            new DrawingGUI(400,500);
        });

        // add event listen to recognize button to show the recognition result
        recognize.setOnMouseClicked(event -> {
        	 //get the recognized result
        	 try {
				res = test123.getResult();
				result.setText(res+"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
        });
    }

}