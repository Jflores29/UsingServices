package com.javier.usingservices;

import android.app.IntentService;
import android.content.Intent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by User on 1/23/2017.
 */

public class MyIntentService2 extends IntentService {



    public MyIntentService2() {
        super("MyIntentService2");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileInputStream fis = openFileInput("JF");
            Scanner obj = new Scanner(fis);

            while(obj.hasNextLine())
            {
                stringBuilder.append(obj);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
