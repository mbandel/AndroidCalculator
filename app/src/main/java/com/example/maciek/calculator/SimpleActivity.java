package com.example.maciek.calculator;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SimpleActivity extends AppCompatActivity {

    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    private Button btnAdd, btnSubtract, btnDivide, btnMultiply, btnEquals, btnPlusMinus, btnDecimal, btnC, btnBksp;
    private TextView tvInput, tvResult;
    private double leftSide, rightSide, result;
    private String operation = "noOperation";
    private final int numberLength = 14;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);

        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnDivide = findViewById(R.id.btnDivide);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnEquals = findViewById(R.id.btnEquals);
        btnPlusMinus = findViewById(R.id.btnPlusMinus);
        btnDecimal = findViewById(R.id.btnDecimal);
        btnC = findViewById(R.id.btnC);
        btnBksp = findViewById(R.id.btnBksp);

        tvInput = findViewById(R.id.tvInput);
        tvResult = findViewById(R.id.tvResult);

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(tvInput.getText().toString()) == 0 || tvInput.getText()==null);
                    tvInput.setText("0");
                if(tvInput.getText().length() < numberLength)
                    tvInput.append("0");
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvInput.getText().length() < numberLength)
                    tvInput.append("1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvInput.getText().length() < numberLength)
                    tvInput.append("2");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvInput.getText().length() < numberLength)
                    tvInput.append("3");
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvInput.getText().length() < numberLength)
                    tvInput.append("4");
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvInput.getText().length() < numberLength)
                    tvInput.append("5");
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvInput.getText().length() < numberLength)
                    tvInput.append("6");
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvInput.getText().length() < numberLength)
                    tvInput.append("7");
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvInput.getText().length() < numberLength)
                    tvInput.append("8");
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvInput.getText().length() < numberLength)
                    tvInput.append("9");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText() != null) {
                    leftSide = Double.parseDouble(tvInput.getText().toString());
                    operation = "add";
                    tvInput.setText("");
                }
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText() != null) {
                    leftSide = Double.parseDouble(tvInput.getText().toString());
                    operation = "subtract";
                    tvInput.setText("");
                }
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText()==null) {
                    alertDialog = new AlertDialog.Builder(SimpleActivity.this).create();
                    alertDialog.setTitle("Alert Dialog");
                    alertDialog.setMessage("Użyto nieprawidłowego formatu");
                    alertDialog.show();
                }
                switch (operation){
                    case "add":
                        result = leftSide + Double.parseDouble(tvInput.getText().toString());
                        tvResult.setText(String.valueOf(result));
                        operation="noOperation";
                        break;
                    case "subtract":
                        result = leftSide - Double.parseDouble(tvInput.getText().toString());
                        tvResult.setText(String.valueOf(result));
                        operation="noOperation";
                        break;
                }
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("");
                tvInput.setText("");
            }
        });

        btnBksp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText()!=null && tvInput.getText().length() > 0){
                    tvInput.setText(tvInput.getText().toString().substring(0, tvInput.getText().length()-1));
                }
            }
        });



    }
}
