package khromostech.khromosandroidproject_1;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CaptureActivity extends AppCompatActivity {


        public static final int MEDIA_TYPE_IMAGE = 1;
        public static final int MEDIA_TYPE_VIDEO = 2;
        public static final int REQUEST_CODE_IMAGE = 100;
        public static final int REQUEST_CODE_VIDEO = 200;

        ImageView imageFromCamera;
        //VideoView videoFromCamera;
        Uri fileUri;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_media_capure);
            imageFromCamera = (ImageView)findViewById(R.id.image_capture);
        }

        private boolean isIntentSafe(Intent cameraIntent) {

            PackageManager packageManager = getPackageManager();
            List activities = packageManager
                    .queryIntentActivities(
                            cameraIntent, PackageManager.MATCH_DEFAULT_ONLY
                    );
            return activities.size()>0;
        }

        public void takeAPicture(View view)
        {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);

            // Add this line to save file to storage, or remove it to received intent
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,fileUri);

            if(isIntentSafe(cameraIntent))
            {
                startActivityForResult(cameraIntent,REQUEST_CODE_IMAGE);
            }
            else
            {
                Toast.makeText(this,"No Camera App Found",Toast.LENGTH_SHORT).show();
            }
        }

        public void takeAVideo(View view)
        {
            Toast.makeText(this, "coming soon", Toast.LENGTH_SHORT).show();
            Intent cameraIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            fileUri = getOutputMediaFileUri(MEDIA_TYPE_VIDEO);
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
            if(isIntentSafe(cameraIntent))
            {
                startActivityForResult(cameraIntent, REQUEST_CODE_VIDEO);
            }
            else
            {
                Toast.makeText(this,"No Camera App Found",Toast.LENGTH_SHORT).show();
            }

        }

        public void takeAudio(View view){

            Intent intent = new Intent(this, AudioCaptureActivity.class);
            Toast.makeText(this, "coming soon", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }

        public void takeText(View view){
            Intent intent = new Intent (this, TextEditActivity.class);
            Log.d("#OPPENTEXT", "Text opened");
            Toast.makeText(this, "coming soon", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }


        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            Log.d("ACTIVITY_RESULT",requestCode + " "+resultCode);
            if(requestCode == REQUEST_CODE_IMAGE && resultCode==RESULT_OK /*&& data != null*/) {

                imageFromCamera.setImageURI(fileUri);
//                Toast.makeText(this,"Image saved to:\n"+fileUri,Toast.LENGTH_SHORT).show();

//                button.setVisibility(View.VISIBLE);
            }
            else if(requestCode == REQUEST_CODE_VIDEO && resultCode==RESULT_OK && data != null)
            {
                Toast.makeText(this,"Video saved to:\n"+data.getData(),Toast.LENGTH_SHORT).show();
            }
            else if(resultCode == RESULT_CANCELED)
            {
                Toast.makeText(this,"User Canceled",Toast.LENGTH_SHORT).show();
            }
        }

    public void done(View view){
        Intent intent = new Intent();
        intent.putExtra("imageUri", fileUri);
        Log.d("#IMAGE", "done: "+fileUri);

        setResult(RESULT_OK, intent);
        finish();
    }

        /** Create a file Uri for saving an image or video */
        private static Uri getOutputMediaFileUri(int type){
            return Uri.fromFile(getOutputMediaFile(type));
        }

        /** Create a File for saving an image or video */
        private static File getOutputMediaFile(int type){
            // To be safe, you should check that the SDCard is mounted
            // using Environment.getExternalStorageState() before doing this.
            File mediaStorageDir;
            if (type == MEDIA_TYPE_IMAGE) {
                mediaStorageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            }
            else
                mediaStorageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);


            // This location works best if you want the created images to be shared
            // between applications and persist after your app has been uninstalled.

            // Create the storage directory if it does not exist
            if (! mediaStorageDir.exists()){
                if (! mediaStorageDir.mkdirs()){
                    Log.d("MyCameraApp", "failed to create directory");
                    return null;
                }
            }

            // Create a media file name
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File mediaFile;
            if (type == MEDIA_TYPE_IMAGE){
                mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                        "IMG_"+ timeStamp + ".jpg");
            } else if(type == MEDIA_TYPE_VIDEO) {
                mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                        "VID_"+ timeStamp + ".mp4");
            } else {
                return null;
            }

            return mediaFile;
    }
}
