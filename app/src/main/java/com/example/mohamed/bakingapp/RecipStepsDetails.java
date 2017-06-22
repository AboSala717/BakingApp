package com.example.mohamed.bakingapp;

import android.app.ProgressDialog;
import android.net.Uri;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

public class RecipStepsDetails extends AppCompatActivity {
    ProgressDialog progressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recip_steps_details);

        TextView tv = (TextView)findViewById(R.id.textView4);
        final VideoView vv = (VideoView)findViewById(R.id.videoView);

        String descriptions = (String) getIntent().getExtras().get("description");
        tv.setText(descriptions);

        String videoUrl = (String) getIntent().getExtras().get("videoUrl");
        if(videoUrl.length() > 1){
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Buffering video");
            progressDialog.show();
            MediaController mediacontroller = new MediaController(RecipStepsDetails.this);
            mediacontroller.setAnchorView(vv);
            Uri uri = Uri.parse(videoUrl);
            vv.setVideoURI(uri);
            vv.start();
            vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    progressDialog.dismiss();
                    vv.start();
                }
            });
        }
        else
            Toast.makeText(getApplicationContext(),"there is no video",Toast.LENGTH_LONG).show();
    }
}
