package com.example.storageinnerapp;

import android.os.FileObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private String filename = "myNote.txt";
    private static final int READ_BLOCK_SIZE =100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnSAVE(View view) {
        EditText edtInput =(EditText)findViewById(R.id.editText);
        String str = edtInput.getText().toString();

        try {
            FileOutputStream ops = openFileOutput(filename, MODE_PRIVATE);
            OutputStreamWriter opw = new OutputStreamWriter(ops);
            opw.write(str);
            opw.flush();
            opw.close();
            Toast.makeText(this, "Save 成功", Toast.LENGTH_LONG).show();
            edtInput.setText("");
        }catch (IOException e){
            e.printStackTrace();
        };

    }

    public void bntREAD(View view) {
        try{
            FileInputStream ips = openFileInput(filename);
            InputStreamReader ipr = new InputStreamReader(ips);
            char[]buffer = new char[READ_BLOCK_SIZE];
            String str = "";
            int count;
            while ((count=ipr.read(buffer))>0){
                String s = String.copyValueOf(buffer,0,count);
                str += s;
                buffer=new char[READ_BLOCK_SIZE];
            }
            ips.close();
            Toast.makeText(this, "Save 成功", Toast.LENGTH_LONG).show();
            TextView txvShow = (TextView)findViewById(R.id.textView2);
            txvShow.setText("Read 內容：\n" + str);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
