package com.example.prabhusivanandam.sqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Prabhu Sivanandam on 12-Mar-17.
 */

public class Register extends AppCompatActivity implements View.OnClickListener {
    EditText e3,e4,e5;
    Databasehelper helper=new Databasehelper(this);
    TextView tv4,tv5,tv6,tv7;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        e3=(EditText)findViewById(R.id.et3);
        e4=(EditText)findViewById(R.id.et4);
        e5=(EditText)findViewById(R.id.et5);
        tv4=(TextView)findViewById(R.id.tv4);
        tv5=(TextView)findViewById(R.id.tv5);
        tv6=(TextView)findViewById(R.id.tv6);
        tv7=(TextView)findViewById(R.id.tv7);
        btn2=(Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
    }
    public void OnBackClick(View view)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.btn2)
        {
            String username= e3.getText().toString();;
            String password=e4.getText().toString();
            String  cpassword= e5.getText().toString();
            if(username.equals("")||password.equals("")||cpassword.equals(""))
            {
                Toast t=Toast.makeText(Register.this,"Please enter username and password",Toast.LENGTH_SHORT);
                t.show();
            }
            else if(!password.equals(cpassword))
            {
                Toast.makeText(Register.this,"Passwords does not match",Toast.LENGTH_SHORT).show();
            }
            else {
                User user=new User();
                user.setUsername(username);
                user.setPassword(password);
                int flag=helper.searchuser(username);
                if(flag==1) {
                    helper.insertuser(user);
                    Toast.makeText(this, "Successful..Goto login..", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(this,"User already exists..",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
