package com.example.ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class JoystickActivity extends AppCompatActivity implements JoystickView.JoystickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joystick);
        setTitle("Joystick");
    }

    public void onJoystickMoved(float xPercent, float yPercent, int id) {
        System.out.println("Working...");
    }
}
