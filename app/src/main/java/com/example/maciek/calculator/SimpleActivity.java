package com.example.maciek.calculator;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleActivity extends AppCompatActivity {

    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    private Button btnAdd, btnSubtract, btnDivide, btnMultiply, btnEquals, btnPlusMinus, btnDecimal, btnC, btnBksp;
    private TextView tvInput, tvResult;
    private double leftSide, rightSide, result;
    private String operation = "noOperation";
    private final int numberLength = 14;
    private boolean alreadyDecimal, alreadyNegative;

    public void setNumber(int number){
        if(tvInput.getText().toString().equals("0"))
            tvInput.setText(String.valueOf(number));
        else {
            if (tvInput.getText().length() < numberLength)
                tvInput.append(String.valueOf(number));
        }
    }

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


        //0         0           0           0
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().equals("0") || tvInput.getText().toString().equals("") || tvInput.getText()==null)
                    tvInput.setText("0");
                else {
                    if (tvInput.getText().length() < numberLength)
                        tvInput.append("0");
                }
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(1);
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(2);
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(3);
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(4);
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               setNumber(5);
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(6);
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(7);
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(8);
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(9);
            }
        });

        //+         +           +           +           +
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!tvInput.getText().equals("")) {
                    leftSide = Double.parseDouble(tvInput.getText().toString());
                    operation = "add";
                    tvInput.setText("");
                    alreadyDecimal=false;
                    alreadyNegative=false;
                }
              /*  if (!operation.equals("noOperation")){
                    result = leftSide + Double.parseDouble(tvInput.getText().toString());
                    tvResult.setText(String.valueOf(result));
                    operation = "noOperation";
                }
                */
            }
        });

        // -            -           -           -           -
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().equals("") && alreadyNegative==false) {
                    tvInput.setText("-");
                    alreadyNegative=true;
                }
                else if (!tvInput.getText().equals("")) {
                    leftSide = Double.parseDouble(tvInput.getText().toString());
                    operation = "subtract";
                    tvInput.setText("");
                    alreadyDecimal=false;
                    alreadyNegative=false;
                }
            /*    if (!operation.equals("noOperation")){
                    result = leftSide - Double.parseDouble(tvInput.getText().toString());
                    tvResult.setText(String.valueOf(result));
                    operation = "noOperation";
                }
                */
            }
        });

        //=         =           =           =
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText() == null || tvInput.getText().length() < 1) {
                    Toast.makeText(getBaseContext(), "Użyto niepoprawnego formatu" , Toast.LENGTH_SHORT).show();
                } else {
                    switch (operation) {
                        case "add":
                            result = leftSide + Double.parseDouble(tvInput.getText().toString());
                            tvResult.setText(String.valueOf(result));
                            operation = "noOperation";
                            break;
                        case "subtract":
                            result = leftSide - Double.parseDouble(tvInput.getText().toString());
                            tvResult.setText(String.valueOf(result));
                            operation = "noOperation";
                            break;
                        case "noOperation":
                            Toast.makeText(getBaseContext(), "Użyto niepoprawnego formatu" , Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

                alreadyDecimal=false;
                alreadyNegative=false;
                tvInput.setText("");
            }
        });

        //C     C       C       C       C
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("");
                tvInput.setText("");
            }
        });

        //BACKSPACE         BACKSPACE
        btnBksp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText()!=null && tvInput.getText().length() > 0){
                    tvInput.setText(tvInput.getText().toString().substring(0, tvInput.getText().length()-1));
                }
            }
        });

        // .            .           .           .
        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(alreadyDecimal==false) {
                    tvInput.append(".");
                    alreadyDecimal = true;
                }
            }
        });

        //+-            +-          +-          +-
        btnPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!tvInput.getText().toString().equals("")) {
                    double temp = Double.parseDouble(tvInput.getText().toString());
                    temp = temp * (-1);
                    tvInput.setText(String.valueOf(temp));
                    alreadyDecimal=true;
                }
            }
        });

    }
/*
    @Override
    public void onSavedInstanceState(Bundle savedInstanceState){
        savedInstanceState.putString("savedInput", tvInput.getText().toString());
        super.OnSaveInstanceState(savedInstanceState);
    }
    */
}
