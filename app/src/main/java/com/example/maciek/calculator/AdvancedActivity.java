package com.example.maciek.calculator;

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

public class AdvancedActivity extends AppCompatActivity {

    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    private Button btnAdd, btnSubtract, btnDivide, btnMultiply, btnEquals, btnPlusMinus, btnDecimal, btnC, btnAC, btnBksp;
    private Button btnOpen, btnClose, btnPi, btnSinus, btnCosinus, btnTangens, btnLn, btnLog, btnPow2, btnPowY, btnSqrt, btnPercent;
    private TextView tvInput, tvResult;
    private String expression;
    private final int numberLength = 28;
    private boolean alreadyDecimal, usedOperator, clickedC;
    private ScriptEngine engine;
    private int len;


    public void setNumber(int number){
        if(tvInput.getText().toString().equals("0")) {
            tvInput.setText(String.valueOf(number));
            expression=String.valueOf(number);
        }
        else {
            if (tvInput.getText().length() < numberLength)
                tvInput.append(String.valueOf(number));
                expression=expression +(String.valueOf(number));
        }
        usedOperator=false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_advanced);
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
            expression = "";
            btnOpen = findViewById(R.id.btnOpen);
            btnClose = findViewById(R.id.btnClose);
            btnSinus = findViewById(R.id.btnSinus);
            btnCosinus = findViewById(R.id.btnCosinus);
            btnTangens = findViewById(R.id.btnTangens);
            btnLn = findViewById(R.id.btnLn);
            btnLog = findViewById(R.id.btnLog);
            btnPi = findViewById(R.id.btnPi);
            btnPow2 = findViewById(R.id.btnPow2);
            btnPowY = findViewById(R.id.btnPowY);
            btnSqrt=findViewById(R.id.btnSqrt);
            btnPercent=findViewById(R.id.btnPercent);


            //0         0           0           0
            btnZero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tvInput.getText().toString().equals("0") || tvInput.getText().toString().equals("") || tvInput.getText() == null) {
                        tvInput.setText("0");
                        expression = "0";
                    } else {
                        if (tvInput.getText().length() < numberLength)
                            expression = expression + "0";
                            tvInput.append("0");
                    }
                    usedOperator = false;
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
                    if (!tvInput.getText().toString().equals("") && usedOperator == false) {
                        tvInput.append("+");
                        expression = expression + "+";
                        alreadyDecimal = false;
                        usedOperator = true;
                    }
                }
            });

            //-            -           -           -           -
            btnSubtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!tvInput.getText().toString().equals("") && usedOperator == false) {
                        tvInput.append("-");
                        expression = expression + "-";
                        alreadyDecimal = false;
                        usedOperator = true;
                    }
                }
            });

            //*         *        *          *           *
            btnMultiply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!tvInput.getText().toString().equals("") && usedOperator == false) {
                        tvInput.append("*");
                        expression = expression + "*";
                        alreadyDecimal = false;
                        usedOperator = true;
                    }
                }
            });

            // /            /           /           /
            btnDivide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!tvInput.getText().toString().equals("") && usedOperator == false) {
                        tvInput.append("/");
                        expression = expression + "/";
                        alreadyDecimal = false;
                        usedOperator = true;
                    }
                }
            });

            //=         =           =           =
            btnEquals.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tvInput.getText() == null || tvInput.getText().length() < 1) {
                        Toast.makeText(getBaseContext(), "Użyto niepoprawnego formatu", Toast.LENGTH_SHORT).show();
                    } else {
                        try {
                            // Evaluate the expression
                            Object result = engine.eval(expression);
                            if (result.toString().charAt(result.toString().length() - 1) == '0' && result.toString().charAt(result.toString().length() - 2) == '.')
                                result = result.toString().substring(0, result.toString().length() - 2);
                            if (result.toString().equals("Infinity") && expression.contains("/"))
                                Toast.makeText(getBaseContext(), "Nie można dzielić przez 0", Toast.LENGTH_SHORT).show();
                            if (result.toString().equals("NaN") && expression.contains("Math.log"))
                                Toast.makeText(getBaseContext(), "Logarytm z liczby ujemnej nie istnieje", Toast.LENGTH_SHORT).show();
                            else if (result.toString().equals("NaN") && tvInput.getText().toString().contains("√"))
                                Toast.makeText(getBaseContext(), "Pierwiastek z liczby ujemnej nie istnieje", Toast.LENGTH_SHORT).show();
                            else tvResult.setText(result.toString());
                        } catch (ScriptException e) {
                            // Something went wrong
                            Toast.makeText(getBaseContext(), "Użyto niepoprawnego formatu", Toast.LENGTH_SHORT).show();
                        }
                    }

                    alreadyDecimal = false;
                    tvInput.setText("");
                    expression = "";
                }
            });

            //C     C       C       C       C
            btnC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //tvResult.setText("");
                    if (clickedC == false) {
                        tvInput.setText("");
                        expression = "";
                        alreadyDecimal = false;
                        clickedC = true;
                    } else {
                        tvInput.setText("");
                        expression = "";
                        tvResult.setText("");
                        alreadyDecimal = false;
                        clickedC = false;
                    }
                }
            });

            btnAC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tvInput.setText("");
                    tvResult.setText("");
                    expression = "";
                    alreadyDecimal = false;
                }
            });

            //BACKSPACE         BACKSPACE
            btnBksp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tvInput.getText() != null && tvInput.getText().length() > 0) {
                        // . musi ustawic zmienna bool alreadyDecimal na false i skasowac
                        if (tvInput.getText().toString().charAt(tvInput.getText().length() - 1) == '.') {
                            alreadyDecimal = false;
                            tvInput.setText(tvInput.getText().toString().substring(0, tvInput.getText().length() - 1));
                            expression = expression.substring(0, expression.length() - 1);
                        }
                        //musi ustawic zmienna bool usedOperator na false i skasowac
                        else if (tvInput.getText().toString().charAt(tvInput.getText().toString().length() - 1) == '+' || tvInput.getText().toString().charAt(tvInput.getText().toString().length() - 1) == '-' ||
                                tvInput.getText().toString().charAt(tvInput.getText().toString().length() - 1) == '*' || tvInput.getText().toString().charAt(tvInput.getText().toString().length() - 1) == '/') {
                            usedOperator = false;
                            tvInput.setText(tvInput.getText().toString().substring(0, tvInput.getText().length() - 1));
                            expression = expression.substring(0, expression.length() - 1);
                        }
                        //musi kasowac cale wyrazenie sin/cos
                        else if (tvInput.getText().toString().charAt(tvInput.getText().length() - 1) == 'n' || tvInput.getText().toString().charAt(tvInput.getText().length() - 1) == 's'){
                            //ln
                            if (tvInput.getText().toString().charAt(tvInput.getText().length() - 2) == 'l'){
                                tvInput.setText(tvInput.getText().toString().substring(0, tvInput.getText().length() - 2));
                                expression = expression.substring(0, expression.length() - "Math.log".length());
                                Log.d("expression", expression);
                            }//sin / cos
                            else {
                                tvInput.setText(tvInput.getText().toString().substring(0, tvInput.getText().length() - 3));
                                expression = expression.substring(0, expression.length() - "Math.sin".length());
                                Log.d("expression", expression);
                            }
                        }
                        else if (tvInput.getText().toString().charAt(tvInput.getText().length() - 1) == '√'){
                            tvInput.setText(tvInput.getText().toString().substring(0, tvInput.getText().length() - 1));
                            expression = expression.substring(0, expression.length() - "Math.sqrt".length());
                            Log.d("expression", expression);
                        }
                        else if (tvInput.getText().toString().charAt(tvInput.getText().length() - 1) == 'π'){
                            tvInput.setText(tvInput.getText().toString().substring(0, tvInput.getText().length() - 1));
                            expression = expression.substring(0, expression.length() - 7);
                            Log.d("expression", expression);
                        }
                        //potega
                        else if (expression.charAt(expression.length()-1) == ',') {
                            for (int i = expression.length() - 1; i > 0; i--) {
                                if (expression.charAt(i) == '(') {
                                    len = i;
                                    break;
                                }
                                len=i;
                            }
                                expression = expression.substring(0, len  -"Math.pow".length())  + expression.substring(len+1 , expression.length()-1);
                                tvInput.setText(tvInput.getText().toString().substring(0, tvInput.getText().length()-2));

                                Log.d("expression", expression);
                            }


                        //pozostale przypadki - kasowanie 1 znaku
                        else {
                            tvInput.setText(tvInput.getText().toString().substring(0, tvInput.getText().length() - 1));
                            expression = expression.substring(0, expression.length() - 1);
                        }
                    }
                }
            });

            //.            .           .           .
            btnDecimal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (alreadyDecimal == false) {
                        tvInput.append(".");
                        expression = expression + ".";
                        alreadyDecimal = true;
                    }
                }
            });

            //+-            +-          +-          +-
            btnPlusMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!tvInput.getText().toString().equals("")) {
                        try {
                            // Evaluate the expression
                            Object result = engine.eval("(" + tvInput.getText().toString() + ")*(-1)");
                            if (result.toString().charAt(result.toString().length() - 1) == '0' && result.toString().charAt(result.toString().length() - 2) == '.')
                                result = result.toString().substring(0, result.toString().length() - 2);
                            tvInput.setText(result.toString());
                            expression = result.toString();
                        } catch (ScriptException e) {
                            // Something went wrong
                            Toast.makeText(getBaseContext(), "Użyto niepoprawnego formatu", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

            //(
            btnOpen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tvInput.append("(");
                    expression = expression + "(";
                }
            });
            //)
            btnClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tvInput.append(")");
                    expression = expression + ")";
                }
            });

            //sin
            btnSinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    expression = expression + "Math.sin(";
                    tvInput.append("sin(");
                }
            });

            //cos
            btnCosinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    expression = expression + "Math.cos(";
                    tvInput.append("cos(");
                }
            });

            //ln
            btnLn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    expression = expression + "Math.log(";
                    tvInput.append("ln(");
                }
            });

            //log
            btnLog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    expression = expression + "Math.log10(";
                    tvInput.append("log(");
                }
            });


            //sqrt
            btnSqrt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    expression = expression + "Math.sqrt(";
                    tvInput.append("√(");
                }
            });

            //pi
            btnPi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tvInput.append("π");
                    expression = expression  + "Math.PI";
                }
            });

            //%
            btnPercent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tvInput.append("%");
                    expression = expression + "*0.01";
                }
            });

            btnPowY.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (expression.contains("-") || expression.contains("+") || expression.contains("*") || expression.contains("/")) {
                        for (int i = expression.length() - 1; i > 0; i--) {
                            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/') {
                                len = i;
                                break;
                            }
                            len = i;
                        }
                            expression = expression.substring(0, len+1) + "Math.pow(" + expression.substring(len + 1, expression.length()) + ",";
                            tvInput.append("^(");
                            Log.d("expression", expression);

                    } else {
                        tvInput.append("^(");
                        expression = "Math.pow(" + expression + ",";
                        Log.d("expression", expression);
                    }
                }
            });

            //x^2
            btnPow2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (expression.contains("-") || expression.contains("+") || expression.contains("*") || expression.contains("/")) {
                        for (int i = expression.length() - 1; i > 0; i--) {
                            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/') {
                                len = i;
                                break;
                            }
                            len = i;
                        }
                        expression = expression.substring(0, len+1) + "Math.pow(" + expression.substring(len + 1, expression.length()) + ",2)";
                        tvInput.append("^(2)");
                        Log.d("expression", expression);

                    } else {
                        tvInput.append("^(2)");
                        expression = "Math.pow(" + expression + ",2)";
                        Log.d("expression", expression);
                    }
                }
            });

        }catch (Exception e){
            Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("savedInput", tvInput.getText().toString());
        savedInstanceState.putString("savedExpression", expression);
        savedInstanceState.putString("savedResult", tvResult.getText().toString());

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        tvResult.setText(savedInstanceState.getString("savedResult"));
        tvInput.setText(savedInstanceState.getString("savedInput"));
        expression = savedInstanceState.getString("savedExpression");
     }

}


