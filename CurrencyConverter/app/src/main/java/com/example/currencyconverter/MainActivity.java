package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    List<CurrencyModel> items;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDEL, btnCE, btnDot;
    ImageView imageOne, imageTwo;
    StringBuilder s1, s2;
    TextView textOne, textTwo;
    Spinner spinnerOne, spinnerTwo;
    final double USD = 1,  VND = 23440, RUP = 74.54, EURO = 0.92, POUND = 0.8;
    DecimalFormat format;
    boolean first = false, second = false;
    double rateOne = USD, rateTwo = USD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>();
        items.add(new CurrencyModel("United States - Dollar", R.drawable.dollar,USD));
        items.add(new CurrencyModel("Vietnam - Dong", R.drawable.vnd, VND));
        items.add(new CurrencyModel("Europe - Euro", R.drawable.euro,EURO));
        items.add(new CurrencyModel("Russia - Rouble", R.drawable.rup,RUP));
        items.add(new CurrencyModel("United Kingdom - Pound", R.drawable.pound,POUND));
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(items);
        spinnerOne = findViewById(R.id.spinnerOne);
        spinnerTwo = findViewById(R.id.spinnerTwo);
        spinnerOne.setAdapter(spinnerAdapter);
        spinnerTwo.setAdapter(spinnerAdapter);
        spinnerOne.setOnItemSelectedListener(this);
        spinnerTwo.setOnItemSelectedListener(this);

        imageOne = findViewById(R.id.imgOne);
        imageTwo = findViewById(R.id.imgTwo);
        textOne = findViewById(R.id.textOne);
        textTwo = findViewById(R.id.textTwo);
        textOne.setOnClickListener(this);
        textTwo.setOnClickListener(this);
        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btn_del).setOnClickListener(this);
        findViewById(R.id.btn_ce).setOnClickListener(this);
        findViewById(R.id.btn_dot).setOnClickListener(this);

        format = new DecimalFormat("###,###,###.###");
        s1 = new StringBuilder();
        s2 = new StringBuilder();

        textOne.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().equals("") && first == true){
                    double valueTwo = Double.parseDouble(s.toString()) * rateTwo / rateOne;
                    textTwo.setText(format.format(String.valueOf(valueTwo)));
                }
            }
        });
        textTwo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().equals("") && second == true){
                    double valueOne = Double.parseDouble(s.toString()) * rateOne / rateTwo;
                    textOne.setText(format.format(String.valueOf(valueOne)));
                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinnerOne){
            imageOne.setImageResource(items.get(position).getCurrencySymbol());
            rateOne = items.get(position).getCurrencyRate();
        }else{
            imageTwo.setImageResource(items.get(position).getCurrencySymbol());
            rateTwo = items.get(position).getCurrencyRate();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.textOne){
            first = true;
            second = false;
            textOne.setTypeface(Typeface.DEFAULT_BOLD);
            textTwo.setTypeface(Typeface.DEFAULT);
        }else if (id == R.id.textTwo){
            textTwo.setTypeface(Typeface.DEFAULT_BOLD);
            textOne.setTypeface(Typeface.DEFAULT);
            first = false;
            second = true;
        }

        if (first) {
            if (!s1.toString().equals("")) {
                if (id == R.id.btn_ce) {
                    s1.delete(0, s1.length());
                }
                if (id == R.id.btn_del) {
                    s1.deleteCharAt(s1.length() - 1);
                }
                textOne.setText(s1.toString());
            }
            if ((id == R.id.btn0)) {
                s1.append('0');
                textOne.setText(s1.toString());
            } else if (id == R.id.btn1) {
                s1.append('1');
                textOne.setText(s1.toString());
            } else if (id == R.id.btn2) {
                s1.append('2');
                textOne.setText(s1.toString());
            } else if (id == R.id.btn3) {
                s1.append('3');
                textOne.setText(s1.toString());
            } else if (id == R.id.btn4) {
                s1.append('4');
                textOne.setText(s1.toString());
            } else if (id == R.id.btn5) {
                s1.append('5');
                textOne.setText(s1.toString());
            } else if (id == R.id.btn6) {
                s1.append('6');
                textOne.setText(s1.toString());
            } else if (id == R.id.btn7) {
                s1.append('7');
                textOne.setText(s1.toString());
            } else if (id == R.id.btn8) {
                s1.append('8');
                textOne.setText(s1.toString());
            } else if (id == R.id.btn9) {
                s1.append('9');
                textOne.setText(s1.toString());
            } else if (id == R.id.btn_dot) {
                s1.append('.');
                textOne.setText(s1.toString());
            }
        } else if (second) {
            if (!s2.toString().equals("")) {
                if (id == R.id.btn_ce) {
                    s2.delete(0, s2.length());
                }
                if (id == R.id.btn_del) {
                    s2.deleteCharAt(s2.length() - 1);
                }
                textTwo.setText(s2.toString());

            }
            if (id == R.id.btn0) {
                s2.append('0');
                textTwo.setText(s2.toString());
            } else if (id == R.id.btn1) {
                s2.append('1');
                textTwo.setText(s2.toString());
            } else if (id == R.id.btn2) {
                s2.append('2');
                textTwo.setText(s2.toString());
            } else if (id == R.id.btn3) {
                s2.append('3');
                textTwo.setText(s2.toString());
            } else if (id == R.id.btn4) {
                s2.append('4');
                textTwo.setText(s2.toString());
            } else if (id == R.id.btn5) {
                s2.append('5');
                textTwo.setText(s2.toString());
            } else if (id == R.id.btn6) {
                s2.append('6');
                textTwo.setText(s2.toString());
            } else if (id == R.id.btn7) {
                s2.append('7');
                textTwo.setText(s2.toString());
            } else if (id == R.id.btn8) {
                s2.append('8');
                textTwo.setText(s2.toString());
            } else if (id == R.id.btn9) {
                s2.append('9');
                textTwo.setText(s2.toString());
            } else if (id == R.id.btn_dot) {
                s2.append('.');
                textTwo.setText(s2.toString());
            }


        }

    }
}
