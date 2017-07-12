package com.example.remyo.slaaskdemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.slaask.lib.controller.SLAASKManager;
import com.slaask.lib.model.SLAASKConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String token = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

        SLAASKConfig config = new SLAASKConfig(token);

        SLAASKManager.getInstance()
                .setContainerId(R.id.container)
                .setContainerActivity(this)
                .setConfig(config);

        setContentView(R.layout.activity_main);

        Button clickButton = (Button) findViewById(R.id.button);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SLAASKManager.getInstance().show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        SLAASKManager.getInstance().onActivityResult(requestCode, resultCode, data);
        Log.d("[RESULT]: ", "FINISH !!!");
    }
}

