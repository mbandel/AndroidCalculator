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
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class SimpleActivity extends AppCompatActivity {

    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    private Button btnAdd, btnSubtract, btnDivide, btnMultiply, btnEquals, btnPlusMinus, btnDecimal, btnC, btnAC, btnBksp;
    private TextView tvInput, tvResult;
    private double leftSide, rightSide, result;
    private String operation = "noOperation";
    private final int numberLength = 28;
    private boolean alreadyDecimal, alreadyNegative, usedOperator, clickedC;
    private ScriptEngine engine;

    public void setNumber(int number){
        if(tvInput.getText().toString().equals("0"))
            tvInput.setText(String.valueOf(number));
        else {
            if (tvInput.getText().length() < numberLength)
                tvInput.append(String.valueOf(number));
        }
        usedOperator=false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        engine = new ScriptEngineManager().getEngineByExtension("js");
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
        btnAC = findViewById(R.id.btnAC);
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
                usedOperator=false;
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
                if (!tvInput.getText().toString().equals("") && usedOperator==false) {
                    tvInput.append("+");
                    alreadyDecimal=false;
                    usedOperator=true;
                }
            }
        });

        // -            -           -           -           -
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!tvInput.getText().toString().equals("") && usedOperator==false) {
                    tvInput.append("-");
                    alreadyDecimal=false;
                    usedOperator=true;
                }
            }
        });

        // *         *        *          *           *
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!tvInput.getText().toString().equals("") && usedOperator==false) {
                    tvInput.append("*");
                    alreadyDecimal=false;
                    usedOperator=true;
                }
            }
        });

        // /            /           /           /
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!tvInput.getText().toString().equals("") && usedOperator==false) {
                    tvInput.append("/");
                    alreadyDecimal=false;
                    usedOperator=true;
                }
            }
        });

        //=         =           =           =
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText() == null || tvInput.getText().length() < 1) {
                    Toast.makeText(getBaseContext(), "Użyto niepoprawnego formatu" , Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        // Evaluate the expression
                        Object result = engine.eval(tvInput.getText().toString());
                        if (result.toString().charAt(result.toString().length()-1) == '0' && result.toString().charAt(result.toString().length()-2) == '.')
                            result=result.toString().substring(0, result.toString().length()-2);
                        if (result.toString().equals("Infinity"))
                            Toast.makeText(getBaseContext(), "Nie można dzielić przez 0" , Toast.LENGTH_SHORT).show();
                        else tvResult.setText(result.toString());
                    }
                    catch (ScriptException e) {
                        // Something went wrong
                        Toast.makeText(getBaseContext(), "Użyto niepoprawnego formatu" , Toast.LENGTH_SHORT).show();
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
                //tvResult.setText("");
                if(clickedC==false) {
                    tvInput.setText("");
                    alreadyDecimal = false;
                    clickedC=true;
                }else{
                    tvInput.setText("");
                    tvResult.setText("");
                    alreadyDecimal = false;
                    clickedC=false;
                }
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvInput.setText("");
                tvResult.setText("");
                alreadyDecimal = false;
            }
        });

        //BACKSPACE         BACKSPACE
        btnBksp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText()!=null && tvInput.getText().length() > 0){
                    if (tvInput.getText().toString().charAt(tvInput.getText().length()-1)=='.')
                        alreadyDecimal=false;
                    if (tvInput.getText().toString().charAt(tvInput.getText().toString().length()-1) == '+' ||  tvInput.getText().toString().charAt(tvInput.getText().toString().length()-1) == '-' ||
                            tvInput.getText().toString().charAt(tvInput.getText().toString().length()-1) == '*' || tvInput.getText().toString().charAt(tvInput.getText().toString().length()-1) == '/')
                        usedOperator=false;
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
                    try {
                        // Evaluate the expression
                        Object result = engine.eval("("+tvInput.getText().toString()+")*(-1)");
                        if (result.toString().charAt(result.toString().length()-1) == '0' && result.toString().charAt(result.toString().length()-2) == '.')
                            result=result.toString().substring(0, result.toString().length()-2);
                        tvInput.setText(result.toString());
                    }
                    catch (ScriptException e) {
                        // Something went wrong
                        Toast.makeText(getBaseContext(), "Użyto niepoprawnego formatu" , Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("savedInput", tvInput.getText().toString());
        savedInstanceState.putString("savedResult", tvResult.getText().toString());

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        tvResult.setText(savedInstanceState.getString("savedResult"));
        tvInput.setText(savedInstanceState.getString("savedInput"));
    }

}
