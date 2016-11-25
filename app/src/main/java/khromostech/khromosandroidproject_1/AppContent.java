package khromostech.khromosandroidproject_1;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class AppContent extends AppCompatActivity {

    private TextView title, textContent;
    private RecyclerView video;
    private ImageView picture;
    private String text, content;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appcontent);

        title = (TextView) findViewById(R.id.mainPage_title);
        textContent = (TextView) findViewById(R.id.mainPage_content);
        video = (RecyclerView) findViewById(R.id.recycleview_video);
        picture = (ImageView) findViewById(R.id.recycleview_audio);

        Bundle extras = getIntent().getExtras();
        text = extras.getString("Title");
        content = extras.getString("Content");

        title.setText(text);
        textContent.setText(content);
    }



    public void toAppContent(View view){
        Intent intent = new Intent(this, AppContent.class);
        startActivity(intent);
    }


}
