package com.example.parolgenerator;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
//        EditText passwordLength = findViewById(R.id.passwordLength);
//        passwordLength.setInputType(InputType.TYPE_CLASS_NUMBER);

        NumberPicker lengthNumberPicker = (NumberPicker) findViewById(R.id.lengthOfPasswordPicker);
        TextView chosenLength = (TextView) findViewById(R.id.chosenLength);
        Button continueButton = (Button) findViewById(R.id.continueButton);

        continueButton.setEnabled(false);
        lengthNumberPicker.setMinValue(8);
        lengthNumberPicker.setMaxValue(15);
        lengthNumberPicker.setValue(8);
        Intent intent = new Intent(MainActivity.this, GettingPassword.class);
        lengthNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
               chosenLength.setText(String.format("Длина пароля: %s", newValue));
               continueButton.setEnabled(true);
               intent.putExtra("length", newValue);
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int length = (int) lengthNumberPicker.getValue();
                startActivity(intent);
                }
        });



        //numPasswordGenerator newPassword = new PasswordGenerator(length);



    }
}