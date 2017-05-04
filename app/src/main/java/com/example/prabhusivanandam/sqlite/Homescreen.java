package com.example.prabhusivanandam.sqlite;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Prabhu Sivanandam on 12-Mar-17.
 */

public class Homescreen extends Activity {
    TextView tv,tvv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
        String username=getIntent().getStringExtra("username");
        tv=(TextView)findViewById(R.id.tv);
        tvv=(TextView)findViewById(R.id.tvv);
        tvv.setText(username);
    }
}
