package khromostech.khromosandroidproject_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

public class WelcomeToKhromos extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_new_users1);
        welcomeAnimation();
    }


    public void welcomeAnimation(){

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        animation.reset();

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.welcome_linearlayout);
        if (linearLayout != null){
            linearLayout.clearAnimation();
            linearLayout.startAnimation(animation);
        }

        animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        animation.reset();

        final int SPLASH_DISPLAY_LENGTH = 3500;

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
