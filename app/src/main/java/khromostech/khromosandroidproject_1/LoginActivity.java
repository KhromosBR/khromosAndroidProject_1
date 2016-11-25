package khromostech.khromosandroidproject_1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static khromostech.khromosandroidproject_1.R.id.login_field;
import static khromostech.khromosandroidproject_1.R.id.password_field;


public class LoginActivity extends AppCompatActivity {

    EditText login;
    EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_login);

        login = (EditText) findViewById(login_field);
        password = (EditText) findViewById(R.id.password_field);
    }

    public void ButtonSignIn(View view){

        if (login.getText().equals("") || password.getText().toString().equals("")){
            Toast.makeText(this, "Are you sure you have a log in? Try again!", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this, FirstPageActivity.class);
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();

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
        }
    }

    public void ButtonRegister(View view){

            Intent intent  = new Intent(this, RegisterActivity.class);
            Toast.makeText(this, "Fill the form!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
    }
}
