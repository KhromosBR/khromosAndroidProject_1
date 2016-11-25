package khromostech.khromosandroidproject_1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {

    EditText email = null, confirmEmail = null, password = null, confirmPassword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = (EditText)findViewById(R.id.email_field);
        confirmEmail = (EditText) findViewById(R.id.confirm_email);
        password = (EditText) findViewById(R.id.password_field);
        confirmPassword = (EditText)findViewById(R.id.confirm_password);
    }

    public void btn_ToWelcome(View view){

        String compareEmail = email.getText().toString();
        String copareConfEmail = confirmEmail.getText().toString();
        String comparePassword = password.getText().toString();
        String compareConfPassword = confirmPassword.getText().toString();

        if (email.getText().toString().equals("") || confirmEmail.getText().toString().equals("") || password.getText().toString().equals("") || confirmPassword.getText().toString().equals("")) {
            Toast.makeText(this, "Did you forget something dude? Try again!", Toast.LENGTH_SHORT).show();
        }else if (compareEmail.equals(copareConfEmail) && comparePassword.equals(compareConfPassword)){
            Intent intent = new Intent(this, WelcomeToKhromos.class);

            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

            Notification notification = new NotificationCompat.Builder(this)
                    .setContentText("You´re Logged in! Enjoy, reporter!")
                    .setContentTitle("Welcome to Khromos!!")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentIntent(pendingIntent)
                    .build();

            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.notify(0, notification);

            startActivity(intent);
            Log.d("ButtonClick", "Click Welcome");
        }else{
            Toast.makeText(this, "Your email diferent is, fill to again you have to!", Toast.LENGTH_SHORT).show();
        }
    }

}


