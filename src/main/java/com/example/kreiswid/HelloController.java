package com.example.kreiswid;

import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    BorderPane borderPane;
    @FXML
    Button counterButton;
    @FXML
    Rectangle rectangle;
    @FXML
    ColorPicker colorPicker;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        rectangle.fillProperty().bind(colorPicker.valueProperty());

        borderPane.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                if (event.getButton() == MouseButton.SECONDARY) {
                    Circle delete = (Circle) event.getTarget();
                    delete.setVisible(false);
                    counterButton.setText(String.valueOf(Integer.parseInt(counterButton.getText()) - 1));
                }
            } catch (Exception e) {
                System.out.println("Not a Circle");
            }
            if(event.getButton() == MouseButton.PRIMARY) {
                if(event.getTarget() instanceof Circle) {
                    Circle resize = (Circle) event.getTarget();
                    resize.setRadius(resize.getRadius() + 3);
                    return;
                }
                Circle circle = new Circle();
                circle.setCenterX(event.getX());
                circle.setCenterY(event.getY());
                circle.setRadius(10);
                circle.setFill(colorPicker.getValue());
                borderPane.getChildren().add(circle);
                counterButton.setText(String.valueOf(Integer.parseInt(counterButton.getText()) + 1));
            }
        });
    }
}