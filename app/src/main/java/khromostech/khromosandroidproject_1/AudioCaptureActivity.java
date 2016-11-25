package khromostech.khromosandroidproject_1;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import android.app.Activity;
import android.view.MotionEvent;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.os.Bundle;
import android.os.Environment;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Context;
import android.util.Log;
import android.media.MediaRecorder;
import android.media.MediaPlayer;

import java.io.File;
import java.io.IOException;



public class AudioCaptureActivity extends AppCompatActivity {

    private static final String LOG_TAG = "AudioRecordTest";
    private static String mFileName = null;

    private MediaRecorder mRecorder = null;

    private MediaPlayer mediaPlayer = null;

    private ImageButton btn_play, btn_pause, btn_record;
    private String OUTPUT_FILE;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_audio_record);

        btn_play = (ImageButton) findViewById(R.id.btn_playAudio);
        btn_pause = (ImageButton) findViewById(R.id.btn_stopAudio);
        btn_record = (ImageButton) findViewById(R.id.btn_startRecord);
//        btn_Stop = (ImageButton) findViewById(R.id.btn_stopRecord);

        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "audiorecorder.3gp";
        Log.d("OUTPUT", "Output fine: " + mFileName);

        btn_record.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    try {
                        startRecording();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    stopRecording();
                }

                return false;
            }
        });
    }

//    private void startRecording() {
//        mRecorder = new MediaRecorder();
//        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
//        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
//        mRecorder.setOutputFile(mFileName);
//        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
//
//        try {
//            mRecorder.prepare();
//        } catch (IOException e) {
//            Log.e(LOG_TAG, "prepare() failed");
//        }
//
//        mRecorder.start();
//    }

    private void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }


    public void buttonTapped(View view){
        switch (view.getId()){
            case R.id.btn_startRecord:
                try{
                    startRecording();
                }catch (Exception e){
                    e.printStackTrace();
                }
                Log.d("STARTREC", "Recording: ");
                break;

            case R.id.btn_playAudio:
                try{
                    startPlaying();
                }catch (Exception e){
                    e.printStackTrace();
                }
                Log.d("PLAYAUDIO", "Play Audio: ");
                break;

            case R.id.btn_stopAudio:
                try{
                    stopPlaying();
                }catch (Exception e){
                    e.printStackTrace();
                }
                Log.d("STOPAUDIO", "Stop Audio: ");
                break;
        }
    }

    private void ditchMediaRecorder(){
        if (mRecorder != null){
            mRecorder.release();
        }
    }

    private void startRecording() throws IOException {
        //Setting up location
        ditchMediaRecorder();
        File outFile = new File(OUTPUT_FILE);
        if (outFile.exists())
            outFile.delete();

        //Setting up the output format and audio source
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mRecorder.setOutputFile(OUTPUT_FILE);
        mRecorder.prepare();
        mRecorder.start();
    }

//    private void stopRecording(){
//        if (mRecorder != null){
//            mRecorder.stop();
//        }
//    }

    private void startPlaying() throws IOException {
        ditchMediaPlayer();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(OUTPUT_FILE);
        mediaPlayer.prepare();
        mediaPlayer.start();

    }

    private void ditchMediaPlayer() {
        if (mediaPlayer != null){
            try{
                mediaPlayer.release();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void stopPlaying(){
        if (mediaPlayer != null){
            mediaPlayer.stop();
        }
    }
}
