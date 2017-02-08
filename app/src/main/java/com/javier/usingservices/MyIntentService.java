package com.javier.usingservices;

import android.app.IntentService;
import android.content.Intent;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by User on 1/23/2017.
 */

public class MyIntentService extends IntentService {

   public MyIntentService(){
       super("MyIntentService");
   }



    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            FileOutputStream fos = openFileOutput("JF",MODE_PRIVATE);

            String dts =  intent.getStringExtra("K");
            StringBuilder sB = new StringBuilder();

            for (int i = 0; i <100 ; i++) {
               sB.append(dts+ " -  "+ i + "\n");

            }

            fos.write(sB.toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
