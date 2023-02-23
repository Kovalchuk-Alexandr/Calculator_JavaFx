package com.itproger.calculator;

/**
 * Sample Skeleton for 'main-scene.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="clea_btn"
    private Button clea_btn; // Value injected by FXMLLoader

    @FXML // fx:id="comma_btn"
    private Button comma_btn; // Value injected by FXMLLoader

    @FXML // fx:id="divide_btn"
    private Button divide_btn; // Value injected by FXMLLoader

    @FXML // fx:id="equal_btn"
    private Button equal_btn; // Value injected by FXMLLoader

    @FXML // fx:id="label_res"
    private Label label_res; // Value injected by FXMLLoader

    @FXML // fx:id="minus_btn"
    private Button minus_btn; // Value injected by FXMLLoader

    @FXML // fx:id="minus_plus_btn"
    private Button minus_plus_btn; // Value injected by FXMLLoader

    @FXML // fx:id="multiple_btn"
    private Button multiple_btn; // Value injected by FXMLLoader

    @FXML // fx:id="percent_btn"
    private Button percent_btn; // Value injected by FXMLLoader

    @FXML // fx:id="plus_btn"
    private Button plus_btn; // Value injected by FXMLLoader

    String label_text = "";
    float first_num = 0f;
    char operation = '0';
    //float result = 0f;
    @FXML
    void addNumber(ActionEvent event) {
        label_text += ((Button) event.getSource()).getText();
        label_res.setText(label_text);

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        plus_btn.setOnAction(event -> {
            mathAction('+');
        });
        minus_btn.setOnAction(event -> {
            mathAction('-');
        });
        divide_btn.setOnAction(event -> {
            mathAction('/');
        });
        multiple_btn.setOnAction(event -> {
            mathAction('*');
        });
        comma_btn.setOnAction(event -> {
            if(!label_text.contains("."))
                label_text += ".";
            label_res.setText(label_text);
        });
        percent_btn.setOnAction(event -> {
            if(!label_text.equals("")) {    // Применяем процент, если строка не пустая
                float num = Float.parseFloat(label_text) * 0.1f;
                label_text = Float.toString(num);
                label_res.setText(label_text);
            }
        });
        minus_plus_btn.setOnAction(event -> {
            if(!label_text.equals("")) {    // Применяем реверс, если строка не пустая
                float num = Float.parseFloat(label_text) * -1f;
                label_text = Float.toString(num);
                label_res.setText(label_text);
            }
        });
        clea_btn.setOnAction(event ->{
            label_res.setText("0");
            label_text = "";
            operation = '0';
            first_num = 0f;
        });
        equal_btn.setOnAction(event -> {
            // Выполняем, только если установлен символ операции
            if (operation == '+' || operation == '-' || operation == '*' || operation == '/')
                equal_btn();
        });
    }

    private void equal_btn() {
        float result = 0f;
        switch (operation) {
            case '+':
                result = first_num + Float.parseFloat(label_text);
                break;
            case '-':
                result = first_num - Float.parseFloat(label_text);
                break;
            case '*':
                result = first_num * Float.parseFloat(label_text);
                break;
            case '/':
                float second_num = Float.parseFloat(label_text);
                if (second_num == 0)
                    result = 0;
                else
                    result = first_num /second_num;
                break;
        }
        label_res.setText(Float.toString(result));
        label_text = "";
        operation = '0';
        first_num = 0f;
    }

    private void mathAction(char action) {
        // Выполняем, если еще не введен символ операции
        if (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
            first_num = Float.parseFloat(label_text);   // Сохраняем введенное число
            label_res.setText(String.valueOf(action));  // Выводим мат. символ на экран
            label_text = "";                            // Строку с числами очищаем
            operation = action;                         // Сохраняем символ операции
        }
    }

}

