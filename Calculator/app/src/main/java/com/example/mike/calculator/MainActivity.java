package com.example.mike.calculator;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String[] operators = {"+", "-", "/", "*"};
    Random rnd = new Random();
    int operand1 = rnd.nextInt(100);
    int operand2 = rnd.nextInt(100);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner Ops = (Spinner)findViewById(R.id.DropDownOps);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,operators);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Ops.setAdapter(aa);

        TextView Op1 = (TextView)findViewById(R.id.Op1);
        TextView Op2 = (TextView)findViewById(R.id.Op2);

        Op1.setText(Integer.toString(operand1));
        Op2.setText(Integer.toString(operand2));
    }

    public void check(View v){
        Spinner Ops = (Spinner)findViewById(R.id.DropDownOps);
        String operator = Ops.getSelectedItem().toString();
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        int answer = 0;
        if (operator.equals("+")) {
            answer = operand1 + operand2;
        }
        else if(operator.equals("-")){
            answer = operand1 - operand2;
        }
        else if(operator.equals("/")){
            answer = operand1 / operand2;
        }
        else if(operator.equals("*")){
            answer = operand1 * operand2;
        }

        EditText input = (EditText)findViewById(R.id.TextAnswer);
        int userAnswer = Integer.parseInt(input.getText().toString());

        if (userAnswer == answer){
            dialog.setMessage("You are correct!");
            dialog.show();
        }
        else{
            dialog.setMessage("You are wrong!");
            dialog.show();
        }
    }


}
