package com.example.mycalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    Button button0,
            button1,
            button2,
            button3,
            button4,
            button5,
            button6,
            button7,
            button8,
            button9,
            buttonPlus,
            buttonMinus,
            buttonDivide,
            buttonTimes,
            buttonClear,
            buttonEqual,
            buttonDOT;

    TextView textView;

    Float value1, value2;

    boolean plus, minus, times, division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("My Calculator");

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonTimes = (Button) findViewById(R.id.buttonTimes);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        textView = (TextView) findViewById(R.id.textView);

    }
    public void hitButton1(View view){
        textView.setText(textView.getText() + "1");
    }

    public void hitButton2(View view){
        textView.setText(textView.getText() + "2");
    }

    public void hitButton3(View view){
        textView.setText(textView.getText() + "3");
    }

    public void hitButton4(View view){
        textView.setText(textView.getText() + "4");
    }

    public void hitButton5(View view){
        textView.setText(textView.getText() + "5");
    }

    public void hitButton6(View view){
        textView.setText(textView.getText()+"6");
    }

    public void hitButton7(View view){
        textView.setText(textView.getText()+"7");
    }

    public void hitButton8(View view){
        textView.setText(textView.getText()+"8");
    }

    public void hitButton9(View view){
        textView.setText(textView.getText()+"9");
    }

    public void hitButton0(View view){
        textView.setText(textView.getText()+"0");
    }

    public void hitButtonPlus(View view){
        if (textView.getText().length() != 0) {
            if (value1 != null){
                value2 = Float.parseFloat(textView.getText()+"");
                plus = true;
                textView.setText(value1+value2+"");
            }
                value1 = Float.parseFloat(textView.getText() + "");
                plus = true;
                textView.setText(null);

        }
    }

    public void hitButtonMinus(View view) {
        if (textView.getText().length() != 0) {
            value1 = Float.parseFloat(textView.getText() + "");
            minus = true;
            textView.setText(null);
        }
    }


    public void hitButtonTimes(View view){
        if (textView.getText().length() != 0) {
            value1 = Float.parseFloat(textView.getText() + "");
            times = true;
            textView.setText(null);
        }
    }

    public void hitButtonDivision(View view){
        if (textView.getText().length() != 0){
        value1 = Float.parseFloat(textView.getText() + "");
        division = true;
        textView.setText(null);
    }
        }

    public  void hitButtonEqual(View view){

        if (textView.getText().length() != 0){
            if (textView.getText().equals(".")) {
                textView.setText("0");
            } else {
                value2 = Float.parseFloat(textView.getText() + "");
            }


            if (plus == true) {
                textView.setText(value1 + value2 +"");
                plus = false;
            }

            else if (minus == true) {
                textView.setText(value1 - value2 + "");
                minus = false;
            }

            else if (times == true) {
                textView.setText(value1 * value2 + "");
                times = false;
            }

            else if (division == true) {
                textView.setText(value1 / value2 + "");
                division = false;
            } else {
                textView.setText(("0"));
            }
        }

    }
    public void hitButtonClear(View view){
        textView.setText("");
    }

    public void hitButtonDot(View view){

        if (textView.getText().equals(".")){

        } else {
            textView.setText(textView.getText() + ".");
        }
        }

}
