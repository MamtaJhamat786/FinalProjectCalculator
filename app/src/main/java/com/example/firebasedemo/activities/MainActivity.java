package com.example.firebasedemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.firebasedemo.databasestorage.FirebaseDatabase;
import com.example.firebasedemo.R;
import com.example.firebasedemo.allcalculations.CalculatorController;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    public ArrayList<String> arrayList = new ArrayList<>();
    public static final String SHARED_PREF = "sharedRef";
    public static final String History = "history";
    boolean isEqualPressed = false;
    String numberToPutInArrayList;
    Button btn_cos, btn_sin, btn_tan, btn_square, btn_cube;
    Button btn_factorial, btn_allClear, btn_power, btn_root, btn_clear;
    Button log, btn_7, btn_8, btn_9, btn_divide;
    Button ln, btn_4, btn_5, btn_6, btn_multiply;
    Button btn_pi, btn_1, btn_2, btn_3, btn_minus;
    Button btn_inverse, btn_0, btn_decimal, btn_equals, btn_plus;
    TextView result, input;
    double variable1, variable2;
    int var3;
    CalculatorController calc;
    String number1, number2, combined, plus;
    boolean add, subtract, multiply, divide, power, fact, root, sin, cos, tan, logvalue, lnValue;
    boolean square, cube, inverse;
    final int factorial = 1;
    FirebaseDatabase firebaseDatabase = new FirebaseDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calc = new CalculatorController();
        setContentView(R.layout.activity_main);
        loadData();
        btn_cos = findViewById(R.id.btn_cos);
        btn_sin = findViewById(R.id.btn_sin);
        btn_tan = findViewById(R.id.btn_tan);
        btn_square = findViewById(R.id.btn_sqaure);
        btn_cube = findViewById(R.id.btn_cube);
        btn_factorial = findViewById(R.id.btn_factorial);
        btn_allClear = findViewById(R.id.btn_allClear);
        btn_power = findViewById(R.id.btn_power);
        btn_root = findViewById(R.id.btn_root);
        btn_clear = findViewById(R.id.btn_clear);
        log = findViewById(R.id.log);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_divide = findViewById(R.id.btn_divide);
        ln = findViewById(R.id.ln);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_pi = findViewById(R.id.btn_pi);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_minus = findViewById(R.id.btn_minus);
        btn_inverse = findViewById(R.id.btn_inverse);
        btn_0 = findViewById(R.id.btn_0);
        btn_decimal = findViewById(R.id.btn_decimal);
        btn_equals = findViewById(R.id.btn_equals);
        btn_plus = findViewById(R.id.btn_plus);
        input = findViewById(R.id.input);
        result = findViewById(R.id.result);
        setButtonListeners();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.history, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.history) {
            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            intent.putExtra("array", arrayList);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setButtonListeners() {
        btn_allClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(null);
                input.setText(null);
                isEqualPressed = false;
                add = false;
                subtract = false;
                multiply = false;
                divide = false;
                power = false;
                fact = false;
                root = false;
                sin = false;
                cos = false;
                tan = false;
                logvalue = false;
                lnValue = false;
                square = false;
                cube = false;
                inverse = false;

            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = input.getText().toString();
                s = s.substring(0, s.length() - 1);
                input.setText(s);
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "1");

            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "3");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "6");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "9");
            }
        });
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "0");
            }
        });
        btn_decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + ".");
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().isEmpty()) {
                    result.setText(null);
                } else if (isEqualPressed && input.getText().toString().isEmpty()) {
                    return;
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && !add) {
                    input.setText(result.getText() + "");
                    result.setText(null);
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("ADDITION");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    number1 = number1.concat("+");
                    input.setText(number1);
                    add = true;
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && add) {
                    return;
                } else if (isEqualPressed == false && !add) {
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("ADDITION");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    number1 = number1.concat("+");
                    input.setText(number1);
                    add = true;
                } else if (isEqualPressed == false && add) {
                    return;
                } else {
                    return;
                }
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().isEmpty()) {
                    result.setText(null);
                } else if (isEqualPressed && input.getText().toString().isEmpty()) {
                    return;
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && !subtract) {
                    input.setText(result.getText() + "");
                    result.setText(null);
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("SUBTRACTION");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    number1 = number1.concat("-");
                    input.setText(number1);
                    subtract = true;
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && add) {
                    return;
                } else if (isEqualPressed == false && !subtract) {
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("SUBTRACTION");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    number1 = number1.concat("-");
                    input.setText(number1);
                    subtract = true;
                } else if (isEqualPressed == false && subtract) {
                    return;
                } else {
                    return;
                }
            }
        });
        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().isEmpty()) {
                    result.setText(null);
                } else if (isEqualPressed && input.getText().toString().isEmpty()) {
                    return;
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && !multiply) {
                    input.setText(result.getText() + "");
                    result.setText(null);
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("MULTIPLICATION");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    number1 = number1.concat("*");
                    input.setText(number1);
                    multiply = true;
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && multiply) {
                    return;
                } else if (isEqualPressed == false && !multiply) {
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("MULTIPLICATION");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    number1 = number1.concat("*");
                    input.setText(number1);
                    multiply = true;
                } else if (isEqualPressed == false && multiply) {
                    return;
                } else {
                    return;
                }
            }
        });
        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().isEmpty()) {
                    result.setText(null);
                } else if (isEqualPressed && input.getText().toString().isEmpty()) {
                    return;
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && !divide) {
                    input.setText(result.getText() + "");
                    result.setText(null);
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("DIVISION");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    number1 = number1.concat("/");
                    input.setText(number1);
                    divide = true;
                    result.setText(null);
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && divide) {
                    return;
                } else if (isEqualPressed == false && !divide) {
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("DIVISION");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    number1 = number1.concat("/");
                    input.setText(number1);
                    divide = true;
                    result.setText(null);
                } else if (isEqualPressed == false && divide) {
                    return;
                } else {
                    return;
                }

            }
        });
        btn_pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "3.14");
                variable1 = 3.14;
                calc.setNumberSecond(variable1);

            }
        });
        btn_inverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().isEmpty()) {
                    result.setText("Error" + "");
                } else if (isEqualPressed && input.getText().toString().isEmpty()) {
                    return;
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && !inverse) {
                    input.setText(result.getText() + "");
                    result.setText(null);
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("INVERSE");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    String one = "1/";
                    combined = one + " " + number1;// 1/ number
                    input.setText(combined);
                    inverse = true;
                    result.setText(null);
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && inverse) {
                    return;
                } else if (isEqualPressed == false && !inverse) {
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("INVERSE");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    String one = "1/";
                    combined = one + " " + number1;// 1/ number
                    input.setText(combined);
                    inverse = true;
                    result.setText(null);
                } else if (isEqualPressed == false && inverse) {
                    return;
                } else {
                    return;
                }
            }
        });

        btn_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().isEmpty()) {
                    result.setText("Error" + "");
                } else if (isEqualPressed && input.getText().toString().isEmpty()) {
                    return;
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && !power) {
                    input.setText(result.getText() + "");
                    result.setText(null);
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("POWER");
                    variable1 = Double.parseDouble(input.getText() + "");
                    //var3=Integer.parseInt(result.getText()+"");
                    number1 = String.valueOf(variable1);
                    number1 = number1.concat("^");
                    input.setText(number1);
                    power = true;
                    result.setText(null);
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && power) {
                    return;
                } else if (isEqualPressed == false && !power) {
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("POWER");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    number1 = number1.concat("^");
                    input.setText(number1);
                    power = true;
                    result.setText(null);
                } else if (isEqualPressed == false && power) {
                    return;
                } else {
                    return;
                }
            }
        });
        btn_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().isEmpty()) {
                    result.setText("Error" + "");
                } else if (isEqualPressed && input.getText().toString().isEmpty()) {
                    return;
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && !square) {
                    input.setText(result.getText() + "");
                    result.setText(null);
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("SQUARE");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    number1 = number1.concat("^2");
                    input.setText(number1);
                    square = true;
                    result.setText(null);
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && square) {
                    return;
                } else if (isEqualPressed == false && !square) {
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("SQUARE");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    number1 = number1.concat("^2");
                    input.setText(number1);
                    square = true;
                    result.setText(null);
                } else if (isEqualPressed == false && square) {
                    return;
                } else {
                    return;
                }
            }
        });
        btn_cube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().isEmpty()) {
                    result.setText("Error" + "");
                } else if (isEqualPressed && input.getText().toString().isEmpty()) {
                    return;
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && !cube) {
                    input.setText(result.getText() + "");
                    result.setText(null);
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("CUBE");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    number1 = number1.concat("^3");
                    input.setText(number1);
                    cube = true;
                    result.setText(null);
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && cube) {
                    return;
                } else if (isEqualPressed == false && !cube) {
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("CUBE");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    number1 = number1.concat("^3");
                    input.setText(number1);
                    cube = true;
                    result.setText(null);
                } else if (isEqualPressed == false && cube) {
                    return;
                } else {
                    return;
                }
            }
        });
        btn_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().isEmpty()) {
                    result.setText("Error" + "");
                } else if (isEqualPressed && input.getText().toString().isEmpty()) {
                    return;
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && !sin) {
                    input.setText(result.getText() + "");
                    result.setText(null);
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("SIN");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    String sin1 = "sin(";
                    combined = sin1 + " " + number1 + ")";// 1/ number
                    input.setText(combined);
                    sin = true;
                    result.setText(null);
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && sin) {
                    return;
                } else if (isEqualPressed == false && !sin) {
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("SIN");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    String sin1 = "sin(";
                    combined = sin1 + " " + number1 + ")";// 1/ number
                    input.setText(combined);
                    sin = true;
                    result.setText(null);
                } else if (isEqualPressed == false && sin) {
                    return;
                } else {
                    return;
                }
            }
        });
        btn_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().isEmpty()) {
                    result.setText("Error" + "");
                } else if (isEqualPressed && input.getText().toString().isEmpty()) {
                    return;
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && !cos) {
                    input.setText(result.getText() + "");
                    result.setText(null);
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("COS");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    String cos1 = "cos(";
                    combined = cos1 + " " + number1 + ")";
                    if (variable1 == 90) {
                        input.setText(combined);
                        String zero = "0";
                        result.setText(zero + "");
                    } else {
                        input.setText(combined);
                        cos = true;
                        result.setText(null);
                    }
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && cos) {
                    return;
                } else if (isEqualPressed == false && !cos) {
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("COS");
                    Log.i("myTag", input.getText() + "");

                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    String cos1 = "cos(";
                    combined = cos1 + " " + number1 + ")";
                    if (variable1 == 90) {
                        input.setText(combined);
                        String zero = "0";
                        result.setText(zero + "");
                    } else {
                        input.setText(combined);
                        cos = true;
                        result.setText(null);
                    }
                } else if (isEqualPressed == false && cos) {
                    return;
                } else {
                    return;
                }
            }
        });
        btn_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().isEmpty()) {
                    result.setText("Error" + "");
                } else if (isEqualPressed && input.getText().toString().isEmpty()) {
                    return;
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && !tan) {
                    input.setText(result.getText() + "");
                    result.setText(null);
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("TAN");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    String tan1 = "tan(";
                    combined = tan1 + " " + number1 + ")";
                    if (variable1 == 90) {
                        input.setText(combined);
                        String infinity = "infinity";
                        result.setText(infinity + "");
                    } else {
                        input.setText(combined);
                        tan = true;
                        result.setText(null);
                    }
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && tan) {
                    return;
                } else if (isEqualPressed == false && !tan) {
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("TAN");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    String tan1 = "tan(";
                    combined = tan1 + " " + number1 + ")";
                    if (variable1 == 90) {
                        input.setText(combined);
                        String infinity = "infinity";
                        result.setText(infinity + "");
                    } else {
                        input.setText(combined);
                        tan = true;
                        result.setText(null);
                    }
                } else if (isEqualPressed == false && tan) {
                    return;
                } else {
                    return;
                }
            }
        });
        btn_factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().isEmpty()) {
                    result.setText("Error" + "");
                } else if (isEqualPressed && input.getText().toString().isEmpty()) {
                    return;
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && !fact) {
                    input.setText(result.getText() + "");
                    result.setText(null);
                    var3 = Integer.parseInt(input.getText() + "");
                    number1 = String.valueOf(var3);
                    number1 = number1.concat("!");
                    input.setText(number1);
                    fact = true;
                    result.setText(null);
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && fact) {
                    return;
                } else if (isEqualPressed == false && !fact) {
                    var3 = Integer.parseInt(input.getText() + "");
                    number1 = String.valueOf(var3);
                    number1 = number1.concat("!");
                    input.setText(number1);
                    fact = true;
                    result.setText(null);
                } else if (isEqualPressed == false && fact) {
                    return;
                } else {
                    return;
                }
            }
        });
        btn_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().isEmpty()) {
                    result.setText("Error" + "");
                } else if (isEqualPressed && input.getText().toString().isEmpty()) {
                    return;
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && !root) {
                    input.setText(result.getText() + "");
                    result.setText(null);
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("UNDERROOT");
                    variable1 = Double.parseDouble(input.getText().toString() + "");
                    number1 = String.valueOf(variable1);
                    String underroot = "√" + number1;
                    input.setText(underroot);
                    root = true;
                    result.setText(null);
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && root) {
                    return;
                } else if (isEqualPressed == false && !root) {
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("UNDERROOT");
                    variable1 = Double.parseDouble(input.getText().toString() + "");
                    number1 = String.valueOf(variable1);
                    String underroot = "√" + number1;
                    input.setText(underroot);
                    root = true;
                    result.setText(null);
                } else if (isEqualPressed == false && root) {
                    return;
                } else {
                    return;
                }
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().isEmpty()) {
                    result.setText("Error" + "");
                } else if (isEqualPressed && input.getText().toString().isEmpty()) {
                    return;
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && !logvalue) {
                    input.setText(result.getText() + "");
                    result.setText(null);
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("LOG");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    String log = "log(";
                    combined = log + " " + number1 + ")";// 1/ number
                    input.setText(combined);
                    logvalue = true;
                    result.setText(null);
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && logvalue) {
                    return;
                } else if (isEqualPressed == false && !logvalue) {
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("LOG");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    String log = "log(";
                    combined = log + " " + number1 + ")";// 1/ number
                    input.setText(combined);
                    logvalue = true;
                    result.setText(null);
                } else if (isEqualPressed == false && logvalue) {
                    return;
                } else {
                    return;
                }
            }
        });
        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().isEmpty()) {
                    result.setText("Error" + "");
                } else if (isEqualPressed && input.getText().toString().isEmpty()) {
                    return;
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && !lnValue) {
                    input.setText(result.getText() + "");
                    result.setText(null);
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("LN");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    String ln = "ln(";
                    combined = ln + " " + number1 + ")";// 1/ number
                    input.setText(combined);
                    lnValue = true;
                    result.setText(null);
                } else if (isEqualPressed && !input.getText().toString().isEmpty() && lnValue) {
                    return;
                } else if (isEqualPressed == false && !lnValue) {
                    calc.setNumberFirst(Double.parseDouble(input.getText() + ""));
                    calc.setOperation("LN");
                    variable1 = Double.parseDouble(input.getText() + "");
                    number1 = String.valueOf(variable1);
                    String ln = "ln(";
                    combined = ln + " " + number1 + ")";// 1/ number
                    input.setText(combined);
                    lnValue = true;
                    result.setText(null);
                } else if (isEqualPressed == false && lnValue) {
                    return;
                } else {
                    return;
                }
            }
        });


        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (add == true) {
                    String string = input.getText() + "";
                    String[] parts = string.split("[+]");
                    String part1 = parts[0]; // 004
                    String part2 = parts[1];
                    String part3 = parts[1];
                    variable2 = Double.parseDouble(part2);
                    calc.setNumberSecond(variable2);
                    try {
                        calc.calculate();
                        result.setText(calc.printResults());
                        firebaseDatabase.saveDataToFirebase(calc.printEquation());
                        arrayList.add(calc.printEquation());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    add = false;
                    saveData();
                }
                if (subtract == true) {
                    String string = input.getText() + "";
                    String[] parts = string.split("[-]");
                    // String part1 = parts[0]; // 004
                    String part2 = parts[1];
                    // String part3 = parts[1];
                    variable2 = Double.parseDouble(part2);
                    calc.setNumberSecond(variable2);
                    try {
                        calc.calculate();
                        arrayList.add(calc.printEquation());
                        result.setText(calc.printResults());
                        firebaseDatabase.saveDataToFirebase(calc.printEquation());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    subtract = false;
                    saveData();
                }
                if (multiply == true) {
                    String string = input.getText() + "";
                    String[] parts = string.split("[*]");
                    String part2 = parts[1];
                    variable2 = Double.parseDouble(part2);
                    calc.setNumberSecond(variable2);
                    try {
                        calc.calculate();
                        arrayList.add(calc.printEquation());
                        result.setText(calc.printResults());
                        firebaseDatabase.saveDataToFirebase(calc.printEquation());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    multiply = false;
                    saveData();
                }
                if (divide == true) {
                    String string = input.getText() + "";
                    String[] parts = string.split("[/]");
                    // String part1 = parts[0]; // 004
                    String part2 = parts[1];
                    Log.i("myTag", part2);
                    // String part3 = parts[1];
                    variable2 = Double.parseDouble(part2);
                    calc.setNumberSecond(variable2);
                    try {
                        calc.calculate();
                        arrayList.add(calc.printEquation());
                        result.setText(calc.printResults());
                        firebaseDatabase.saveDataToFirebase(calc.printEquation());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    divide = false;
                    saveData();
                }
                if (power == true) {
                    String string = input.getText() + "";
                    String[] parts = string.split(Pattern.quote("^"));
                    // String part1 = parts[0]; // 004
                    String part2 = parts[1];
                    // String part3 = parts[1];
                    variable2 = Double.parseDouble(part2);
                    calc.setNumberSecond(variable2);

                    try {
                        calc.calculate();
                        arrayList.add(calc.printEquation());
                        result.setText(calc.printResults());
                        firebaseDatabase.saveDataToFirebase(calc.printEquation());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    power = false;
                    saveData();
                }
                if (root == true) {
                    try {
                        calc.calculate();
                        arrayList.add(calc.printEquation());
                        result.setText(calc.printResults());
                        firebaseDatabase.saveDataToFirebase(calc.printEquation());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    root = false;
                    saveData();
                }
                if (sin == true) {
                    try {
                        calc.calculate();
                        arrayList.add(calc.printEquation());
                        result.setText(calc.printResults());
                        firebaseDatabase.saveDataToFirebase(calc.printEquation());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    sin = false;
                    saveData();
                }
                if (cos == true) {

                    try {
                        calc.calculate();
                        arrayList.add(calc.printEquation());
                        result.setText(calc.printResults());
                        firebaseDatabase.saveDataToFirebase(calc.printEquation());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    cos = false;
                    saveData();
                }
                if (tan == true) {
                    try {
                        calc.calculate();
                        arrayList.add(calc.printEquation());
                        result.setText(calc.printResults());
                        firebaseDatabase.saveDataToFirebase(calc.printEquation());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    tan = false;
                    saveData();
                }
                if (logvalue == true) {

                    try {
                        calc.calculate();
                        arrayList.add(calc.printEquation());
                        result.setText(calc.printResults());
                        firebaseDatabase.saveDataToFirebase(calc.printEquation());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    logvalue = false;
                    saveData();
                }
                if (lnValue == true) {

                    try {
                        calc.calculate();
                        arrayList.add(calc.printEquation());
                        result.setText(calc.printResults());
                        firebaseDatabase.saveDataToFirebase(calc.printEquation());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    lnValue = false;
                    saveData();
                }
                if (square == true) {

                    try {
                        calc.calculate();
                        arrayList.add(calc.printEquation());
                        result.setText(calc.printResults());
                        firebaseDatabase.saveDataToFirebase(calc.printEquation());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    square = false;
                    saveData();
                }
                if (cube == true) {

                    try {
                        calc.calculate();
                        arrayList.add(calc.printEquation());
                        result.setText(calc.printResults());
                        firebaseDatabase.saveDataToFirebase(calc.printEquation());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    cube = false;
                    saveData();
                }
                if (inverse == true) {

                    try {
                        calc.calculate();
                        arrayList.add(calc.printEquation());
                        result.setText(calc.printResults());
                        firebaseDatabase.saveDataToFirebase(calc.printEquation());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    inverse = false;
                    saveData();
                }
                if (fact == true) {
                    int factorial = 1;
                    for (int i = 1; i <= var3; i++) {
                        factorial = factorial * i;
                    }
                    result.setText(factorial + "");
                    String resultInString = result.getText().toString();
                    numberToPutInArrayList = input.getText() + " + " + resultInString;
                    arrayList.add(numberToPutInArrayList);
                    firebaseDatabase.saveDataToFirebase(calc.printEquation());
                    fact = false;
                    saveData();
                }
                isEqualPressed = true;
            }
        });

    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        editor.putString(History, json);
        editor.apply();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(History, null);
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        if (gson.fromJson(json, type) == null) {
            arrayList = new ArrayList<>();
        } else {
            arrayList = gson.fromJson(json, type);
        }
    }
}