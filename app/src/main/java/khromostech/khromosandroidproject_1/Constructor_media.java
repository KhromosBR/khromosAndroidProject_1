package khromostech.khromosandroidproject_1;

import android.support.v7.app.AppCompatActivity;


public class Constructor_media extends AppCompatActivity{

    public String imageUri;
    public String videoUri;
    public String audioUri;
    public String textUri;


    public Constructor_media(String imageUri, String videoUri, String audioUri, String textUri) {

        this.imageUri = imageUri;
        this.videoUri = videoUri;
        this.audioUri = audioUri;
        this.textUri = textUri;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }

    public String getAudioUri() {
        return audioUri;
    }

    public void setAudioUri(String audioUri) {
        this.audioUri = audioUri;
    }

    public String getTextUri() {
        return textUri;
    }

    public void setTextUri(String textUri) {
        this.textUri = textUri;
    }


}
