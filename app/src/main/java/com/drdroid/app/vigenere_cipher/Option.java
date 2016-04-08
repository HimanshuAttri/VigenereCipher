package com.drdroid.app.vigenere_cipher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import android.app.Activity;
import android.widget.Toast;


/**
 * Created by himanshu-sys on 8/4/16.
 *
 */

public class Option extends Activity {
    Button Eb,Db;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.option);


        try {
            InputStream is = getAssets().open("vig");


            int size = is.available();


            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();


            String text = new String(buffer);


            TextView tv = (TextView)findViewById(R.id.txop);
            tv.setMovementMethod(new ScrollingMovementMethod());
            tv.setText(text);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }

        Eb=(Button) findViewById(R.id.encry);
        Db=(Button) findViewById(R.id.decry);

        Eb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Option Activity Starts Here
                Intent i = new Intent(getBaseContext(), MainActivity.class);


                startActivity(i);

            }
        });

        Db.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                //Option Activity Starts Here
                Intent i = new Intent(getBaseContext(), MainActivity.class);

                startActivity(i);

            }
        });
    }
}

