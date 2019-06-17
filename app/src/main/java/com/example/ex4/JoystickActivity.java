package com.example.ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class JoystickActivity extends AppCompatActivity implements JoystickView.JoystickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joystick);
        setTitle("Joystick");

        Intent intent = getIntent();
        String ip = intent.getStringExtra("ip");
        int port = Integer.parseInt(intent.getStringExtra("port"));

        // Creates the tcp client instance, and runs the connect method.
        TcpClient.Instance().connect(ip, port);
    }

    public void onJoystickMoved(float xPercent, float yPercent, int id) {
        System.out.println("Working...");
        String command = "Test";
        TcpClient.Instance().sendCommand(command);
    }
}
