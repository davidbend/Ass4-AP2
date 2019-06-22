package com.example.ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button connectBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Login");

        connectBtn = findViewById(R.id.connectBtn);
        connectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openJoystick();
            }
        });
    }

    /**
     * Runs the joystick.
     */
    public void openJoystick() {
        Intent intent = new Intent(this, JoystickActivity.class);

        EditText ipEditText = (EditText) findViewById(R.id.ipEditText);
        EditText portEditText = (EditText) findViewById(R.id.portEditText);

        intent.putExtra("ip", ipEditText.getText().toString());
        intent.putExtra("port", portEditText.getText().toString());

        startActivity(intent);
    }
}
