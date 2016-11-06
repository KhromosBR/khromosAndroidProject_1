package khromostech.khromosandroidproject_1;

import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        StartAnimation(); //Starting the animation

    }

    private void StartAnimation(){

        //calling the animation in xml files.
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        animation.reset();

        //starting the animation of linearLayout
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_main);
        if (linearLayout != null){
            linearLayout.clearAnimation();
            linearLayout.startAnimation(animation);
        }
        //loading the animation from anim xml folder, file translate.
        animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        animation.reset();

        //Animation of the Imageview which the logo is located
        ImageView imageView = (ImageView)findViewById(R.id.imageView2);
        if (imageView != null){
            imageView.clearAnimation();
            imageView.startAnimation(animation);
        }

        int SPLASH_DISPLAY_LENGTH = 3500;
        //using handler to do the next activity.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*Create an Intent that will start the Menu-activity*/
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                MainActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
