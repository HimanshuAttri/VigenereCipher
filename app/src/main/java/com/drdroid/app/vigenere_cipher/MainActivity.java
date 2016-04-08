package com.drdroid.app.vigenere_cipher;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.ClipboardManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {



    int i;
    String mode ="e";



    NotificationManager manager;
    Notification myNotication;
    String str1,str2,str3;

    EditText etk,etm;
    ImageView iabout;


    static String encrypt(String text, final String key) {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

    static String decrypt(String text, final String key) {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        final Animation myAnimation;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
          etm=(EditText) findViewById(R.id.m);
          etk=(EditText) findViewById(R.id.k);
        iabout=(ImageView)findViewById(R.id.about);

        fab.setBackgroundColor(R.color.fab);
        myAnimation = AnimationUtils.loadAnimation(this, R.anim.myani);
        iabout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This App is developed by Himanshu Attri         Under Graduate at NSIT COE branch.                    Contact : attri.him@gmail.com",
                        Toast.LENGTH_LONG).show();

                    iabout.startAnimation(myAnimation);




                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.himanshuattri.com"));
                startActivity(browserIntent);

            }
        });
        if(mode=="d")
        {


            fab.setImageResource(R.drawable.lock);
        }
        if(mode=="e")
        {


            fab.setImageResource(R.drawable.olock);

        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                str1= etm.getText().toString();
                str2=etk.getText().toString();
                str1=str1.toUpperCase();
                str2=str2.toUpperCase();

                if(mode=="d")
                {
                    str3=decrypt(str1,str2);
                }
                if(mode=="e")
                {
                    str3=encrypt(str1,str2);
                }


                Toast.makeText(getApplicationContext(),"Message: "+ str3,
                        Toast.LENGTH_LONG).show();

                int sdk = android.os.Build.VERSION.SDK_INT;
                if(sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                    android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    clipboard.setText(str3);
                } else {
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("text label",str3);
                    clipboard.setPrimaryClip(clip);
                }

                Toast.makeText(getApplicationContext(), "Message Has Been Copied To Clipboard. Hope You Remember The Key.",
                        Toast.LENGTH_LONG).show();

            }
                //

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
