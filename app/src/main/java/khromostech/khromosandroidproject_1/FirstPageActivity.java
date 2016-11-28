package khromostech.khromosandroidproject_1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class FirstPageActivity extends Activity {


    public RecyclerView recyclerView;
    public MyAdapter adapter;
    public ArrayList<Constructor_media> mediaList;
    public LinearLayout buttons, header;
    public ImageButton btnSearch, btnAddMedia;
    private TextView title;
    private String text;



    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_firstpage);

            btnSearch = (ImageButton) findViewById(R.id.btn_search);
            btnAddMedia = (ImageButton) findViewById(R.id.btn_addMedia);
            title = (TextView) findViewById(R.id.title_news);

            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);

            mediaList = new ArrayList<>();

            adapter = new MyAdapter(this, mediaList);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);
        }

    public void buttonAddMedia(View view){
        Intent intent = new Intent(this, CaptureActivity.class);
        startActivityForResult(intent ,999);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //when is success capture
//        Bundle extras = getIntent().getExtras();
//        text = extras.getString("Title");
//        title.setText(text);

        if (requestCode == 999 && resultCode == RESULT_OK){

            Log.d("#IMAGE", "done: 2 "+data.getExtras().get("imageUri"));
            Log.d("#IMAGE", "done: 3 "+Uri.parse(data.getExtras().get("imageUri").toString()));

            mediaList.add(new Constructor_media(data.getExtras().get("imageUri").toString(), null, null, null));
            adapter.notifyDataSetChanged();
        }
    }
}
