package com.example.prabhusivanandam.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Databasehelper helper=new Databasehelper(this);
    EditText et1,et2;
    TextView tv1,tv2,tv3;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);
        btn1=(Button)findViewById(R.id.btn1);
    }
    public void OnloginClick(View view) {
        String username=et1.getText().toString();
        String password=et2.getText().toString();
        String tpass=helper.searchpass(username);
        if(password.isEmpty()||username.isEmpty())
        {
            Toast.makeText(this,"Please enter username and password",Toast.LENGTH_SHORT).show();
        }
        else if(tpass.equals(password))
        {
            Intent intent = new Intent(this, Homescreen.class);
            intent.putExtra("username",username);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,"Username and Password does not match...",Toast.LENGTH_SHORT).show();
        }
    }
    public void OnSignupClick(View view)
    {
        Intent i=new Intent(this,Register.class);
        startActivity(i);
    }
}
