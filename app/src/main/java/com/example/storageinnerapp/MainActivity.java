package com.example.storageinnerapp;

import android.os.FileObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
}
