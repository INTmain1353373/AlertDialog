package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText userid;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1 = (Button) findViewById(R.id.bt1);
        Button bt2 = (Button) findViewById(R.id.bt2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog1 = new AlertDialog.Builder(MainActivity.this);
                dialog1.setTitle("这是一个提示对话框");
                dialog1.setMessage("hello word");
                dialog1.setCancelable(true);
                dialog1.show();
            }
        });



        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog2 = new AlertDialog.Builder(MainActivity.this);
                dialog2.setTitle("登录");
                LayoutInflater inflater = getLayoutInflater();
                final View layout = inflater.inflate(R.layout.alertdialog,
                        null);
                dialog2.setView(layout);

                userid = (EditText) layout.findViewById(R.id.userid);
                password = (EditText) layout.findViewById(R.id.password);
                dialog2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if(userid.getText().toString().equals("abc") && password.getText().toString().equals("123")){
                            Toast.makeText(MainActivity.this, "right", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                dialog2.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog2.show();
            }
        });
    }
}
