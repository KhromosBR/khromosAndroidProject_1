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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class SecondRegisterActivity extends AppCompatActivity {

    EditText email, confirmEmail, password, confirmPassword, answerSecQuestion;
    Spinner securityQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        email = (EditText)findViewById(R.id.email_field);
        confirmEmail = (EditText) findViewById(R.id.confirm_email);
        password = (EditText) findViewById(R.id.password_field);
        confirmPassword = (EditText)findViewById(R.id.confirm_password);
        answerSecQuestion = (EditText)findViewById(R.id.answer_secQuestion);

        /*Spinner*/

        securityQuestion = (Spinner)findViewById(R.id.secQuestion);
        ArrayAdapter<CharSequence> adapterSecQuestion = ArrayAdapter.createFromResource(this, R.array.spin_securityquestion, android.R.layout.simple_spinner_item);
        adapterSecQuestion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        securityQuestion.setAdapter(adapterSecQuestion);
    }

    public void btn_ToWelcome(View view){
        Intent intent = new Intent(this, WelcomeToKhromos.class);
        Toast.makeText(this, "Welcome to Khromos", Toast.LENGTH_SHORT).show();

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
    }
}
