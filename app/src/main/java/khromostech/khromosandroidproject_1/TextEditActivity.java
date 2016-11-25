package khromostech.khromosandroidproject_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class TextEditActivity extends AppCompatActivity {

    ArrayList<ConstructorTitleField> arrayTitle;
    ArrayList<ConstructorContentField> constructorContentField;

    EditText title, content;
    Button applyText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        title = (EditText) findViewById(R.id.editText_title);
        content = (EditText) findViewById(R.id.editText_content);
        applyText = (Button) findViewById(R.id.btn_applyText);

    }

    public void addTextToForm(View view){

        if (title.getText().toString().equals("")){
            Toast.makeText(this, "Hey, did your post have any title? Fill it! Hurry up!", Toast.LENGTH_SHORT).show();
        }else if (content.getText().toString().equals("")){
            Toast.makeText(this, "C´mon! You have to write something, dude!", Toast.LENGTH_SHORT).show();
        }

        Bundle textFieldBundle = new Bundle();
        textFieldBundle.putString("Title", title.getText().toString());
        textFieldBundle.putString("Content", content.getText().toString());

        Intent intent = new Intent(this, FirstPageActivity.class);
        intent.putExtras(textFieldBundle);
        Log.d("SENDTEXT", "Text sended" + textFieldBundle);

        startActivity(intent);
    }
}
