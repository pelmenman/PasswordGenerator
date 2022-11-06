package com.example.parolgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GettingPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        int length = getIntent().getIntExtra("length", 8);
        setContentView(R.layout.activity_getting_password);
        TextView passwordResult = findViewById(R.id.passwordResult);
        Button changePasswordButton = findViewById(R.id.changePasswordButton);
        Button copyPasswordButton = findViewById(R.id.copyPasswordButton);


        PasswordGenerator passwordGenerator = new PasswordGenerator(length);
        StringBuilder password = passwordGenerator.getPassword();
        passwordResult.setText(password);



        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PasswordGenerator passwordGenerator = new PasswordGenerator(length);
                StringBuilder password = passwordGenerator.getPassword();
                passwordResult.setText(password);
            }
        });

        copyPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("", passwordResult.getText());
                clipboard.setPrimaryClip(clip);
            }
        });
    }
}