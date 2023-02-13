package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static final Map<Integer, String> map = new HashMap<>();

    static {
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");

        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "fifteen");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");

        map.put(20, "twenty");
        map.put(30, "thirty");
        map.put(40, "forty");
        map.put(50, "fifty");
        map.put(60, "sixty");
        map.put(70, "seventy");
        map.put(80, "eighty");
        map.put(90, "ninety");

        map.put(100, "hundred");
        map.put(1000, "thousand");
        map.put(1000000, "million");

    }

    public static String convertNumberToText(String number) {
        int num;
        try {
            num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return "Please input a valid number from 0 to 999 999 999";
        }

        if (num < 0 || num > 999999999) {
            return "Please input a valid number from 0 to 999 999 999";

        }

        String result = "";
        if (num == 0) {
            result = map.get(0);
            return result;
        }

        if (num < 1000) {
            return convertHelper(num);
        }
        if (num < 1000000) {
            return convertHelper(num / 1000) + " " + map.get(1000) + " " + convertHelper(num % 1000);
        }

        if (num < 1000000000) {
            String one = convertHelper(num / 1000000) + " " + map.get(1000000) + " ";
            num = num % 1000000;
            String two = "";
            if (num >= 1000 && num < 1000000) {
                two = convertHelper(num / 1000) + " " + map.get(1000) + " ";
            }
            String three = "";
            num = num % 1000;
            if (num > 0 && num < 1000) {
                three = convertHelper(num % 1000);
            }
            return one + two + three;
        }

        return result;
    }

    private static String convertHelper(int num) {
        String result = "";

        while (num > 0) {
            if (num < 20) {
                result += map.get(num);
                break;
            }
            if (num < 100) {
                result += map.get((num / 10) * 10) + " ";
                num = num % 10;
            }
            if (num >= 100 && num < 1000) {
                result += map.get(num / 100) + " " + map.get(100) + " ";
                num = num % 100;
            }
        }

        result = result.replaceAll("\\s{2,}", " ").trim();
        return result;
    }

    public void onClick(View view) {

        TextView text = (TextView) findViewById(R.id.textView);
        EditText number = (EditText) findViewById(R.id.editTextNumber);
        String s = number.getText().toString();

        TextView text2 = (TextView) findViewById(R.id.textView2);

        text2.setText(convertNumberToText(s));

    }
}