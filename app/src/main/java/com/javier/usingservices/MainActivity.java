package com.javier.usingservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import static android.R.attr.path;
import static android.R.attr.text;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         editText = (EditText)findViewById(R.id.main_et);
        textView = (TextView) findViewById(R.id.main_tv);
    }

    public void saveToFile(View view) {
       String stuff = editText.getText().toString();

        Intent intent = new Intent(MainActivity.this, MyIntentService.class);
        intent.putExtra("K", stuff );
        startService(intent);


    }


    public void loadFile(View view) {

//        Intent intent = new Intent(MainActivity.this, MyIntentService2.class);
//        intent.getStringExtra("Key");
//        startService(intent);
        FileInputStream is = null;
        try {
            is = openFileInput("JF");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        String entireFile = "";
        try {
            while((line = br.readLine()) != null) { // <--------- place readLine() inside loop
                entireFile += (line + "\n"); // <---------- add each line to entireFile
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        textView.setText(entireFile); // <------- assign entireFile to TextView




    }
}
