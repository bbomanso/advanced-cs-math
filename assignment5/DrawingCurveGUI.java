/**
 * Name: Beatriz Ristau
 * Date: March 31, 2022
 * Course: CS 479
 * Assignment: Draw Curve
*/

package assignment5;

import java.util.function.DoubleUnaryOperator;
import static java.lang.Math.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DrawingCurveGUI extends Application {
    Stage window;
    Scene scene;
    Button button;
    VBox layout;
    ComboBox<String> comboBox;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Drawing Curve GUI");

        // create gridpane
        GridPane gridPane = new GridPane();

        // spacing rows and columns
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        // create button and add to gridpane
        button = new Button("Draw Curve");
        gridPane.add(button, 0, 2);

        // create canvas
        Canvas canvas = new Canvas(500,500);

        // create graph
        GraphicsContext graphic = canvas.getGraphicsContext2D();

        // creating combo box for user to select desired curve
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
            "Daisy",
            "Clover",
            "Cardioid",
            "Lissajous",
            "Tricuspoid"
        );

        comboBox.setPromptText("Select a Curve");

        // when user selects the desired curve and clicks the button it will display the graph curve
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                graphic.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                DoubleUnaryOperator x;
                DoubleUnaryOperator y;
                double start_t = 0;
                double end_t = 2 * PI;

                switch(comboBox.getSelectionModel().getSelectedIndex()) {
                    case 0:
                        x = t -> cos(6*t) * cos(t);
                        y = t -> cos(6*t) * sin(t);
                        drawCurve(graphic, x, y, start_t, end_t, 1, 1000);
                        break;
                    case 1:
                        x = t -> cos(2*t) * cos(t);
                        y = t -> cos(2*t) * sin(t);
                        drawCurve(graphic, x, y, start_t, end_t, 1, 1000);
                        break;
                    case 2:
                        x = t -> ((1 - sin(t)) * cos(t));
                        y = t -> ((1 - sin(t)) * sin(t));
                        drawCurve(graphic, x, y, start_t, end_t, 0.5, 1000);
                        break;
                    case 3: 
                        x = t -> 4 * sin(3 * t + 1);
                        y = t -> 3 * sin(t);
                        drawCurve(graphic, x, y, start_t, end_t, 0.25, 1000);
                        break;
                    case 4:
                        x = t -> (2 * cos(t) + cos(2*t));
                        y = t -> (2 * sin(t) - sin(2*t));
                        drawCurve(graphic, x, y, start_t, end_t, 0.25, 1000);
                        break;
                }
            }
        });

        // add combo box to grid pane
        gridPane.add(comboBox, 0, 1);
        // add canvas to grid pane
        gridPane.add(canvas, 0, 3);

        // set scene
        window.setScene(new Scene(gridPane));
        window.show();
    }

    // method to draw selected curve from the combo box
    private void drawCurve(GraphicsContext graphic, DoubleUnaryOperator paramX, DoubleUnaryOperator paramY, double start, double end, double scale_factor, int points) {
        // setting the x-coordinate and y-coordinate in the graph
        graphic.strokeLine(0, 250, 500, 250);
        graphic.strokeLine(250, 0, 250, 500);

        // setting the radius and offset
        double radius = 200;
        double offset = 250;

        double t1 = start;
        double t2, x1, y1, x2, y2;
        // rotation
        double dt = end / points;

        // will loop until reach the max number of points
        for (int i = 0; i < points; i++) {
            // calculate the first point
            x1 = radius * paramX.applyAsDouble(t1) * scale_factor + offset;
            y1 = - radius * paramY.applyAsDouble(t1) * scale_factor + offset;
            // calculate t2
            t2 = t1 + dt;
            // calculate the second point
            x2 = radius * paramX.applyAsDouble(t2) * scale_factor + offset;
            y2 = - radius * paramY.applyAsDouble(t2) * scale_factor + offset;
            // draw curve using the points calculated
            graphic.strokeLine(x1, y1, x2, y2);
            t1 = t2;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}