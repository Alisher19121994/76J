package com.best.a76j;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textBtn);
        getData();
    }

    public void getData() {
        String text = "Please, visit this link https://github.com/AlisherDaminov1994";
        Spannable spannable = new SpannableString(text);
        Matcher pattern = Pattern.compile("((http?|https|ftp|file)://)?(([Ww]){3}.)?[a-zA-Z0-9]+\\.[a-zA-Z]+").matcher(text);
        while (pattern.find()) {
            spannable.setSpan(new ForegroundColorSpan(Color.BLUE), pattern.start(), pattern.end(), 0);
        }
        textView.setText(spannable);
    }
}
