import android.os.Handler;
import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;

import com.drdroid.app.vigenere_cipher.MainActivity;
import com.drdroid.app.vigenere_cipher.R;


/**
 * Created by himanshu-sys on 4/4/16.
 */
public class Splash extends MainActivity {
    Animation myAnimation;
    TextView myText;
    ImageView LogoV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        myText = (TextView)findViewById(R.id.sptv);
        LogoV = (ImageView) findViewById(R.id.imgLogo);

        myAnimation = AnimationUtils.loadAnimation(this, R.anim.myani);

        myText.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                myText.startAnimation(myAnimation);
            }
        });
        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }


        LogoV.startAnimation(myAnimation);


        new android.os.Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, 5000);
    } }
