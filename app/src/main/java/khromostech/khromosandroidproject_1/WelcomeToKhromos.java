package khromostech.khromosandroidproject_1;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class WelcomeToKhromos extends Activity{

    ImageView welcome, logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_new_users1);

        welcomeAnimation();
    }


    public void welcomeAnimation(){

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        animation.reset();

        LinearLayout welcome_linearLayout = (LinearLayout) findViewById(R.id.welcome_to_layout);
        if (welcome_linearLayout != null){
            welcome_linearLayout.clearAnimation();
            welcome_linearLayout.startAnimation(animation);
        }

        animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        animation.reset();

        ImageView welcome_imageView = (ImageView) findViewById(R.id.welcome_to);
        if (welcome_imageView != null){
            welcome_imageView.clearAnimation();
            welcome_imageView.startAnimation(animation);
        }

        ImageView logo_imageView = (ImageView) findViewById(R.id.logo);
        if (logo_imageView != null){
            logo_imageView.clearAnimation();
            logo_imageView.startAnimation(animation);
        }


        final int SPLASH_DISPLAY_LENGTH = 3500;

        /*Will finish the animation and enter automatically in the first page*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeToKhromos.this , FirstPageActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                WelcomeToKhromos.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
