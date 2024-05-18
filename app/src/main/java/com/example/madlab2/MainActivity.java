package com.example.madlab2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements InputFragment.OnFragmentSendDataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSendData(String outputtext) {
        OutputFragment fragment = (OutputFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentContainerView4);
        if (fragment != null)
            fragment.setEnteredText(outputtext);
    }
}