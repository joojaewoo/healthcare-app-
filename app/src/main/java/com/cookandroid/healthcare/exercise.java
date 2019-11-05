package com.cookandroid.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class exercise extends YouTubeBaseActivity {
        public static final String API_KEY = "AIzaSyD4u3Vij9fkLSUpshIK80GJ5Ov8NLDWALc";//사용자가 얻은 API Key을 입력하면 된다.(개발자 콘솔에 얻은 것.)
        private YouTubePlayerView youtubeViewer;
        Button btn1, btn2, btn3, btn4;
        public static String VIDEO_ID = "eJCn1mylqSk";
        YouTubePlayer.OnInitializedListener listener;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                /** attaching layout xml **/
                setContentView(R.layout.activity_exercise);
                /** Initializing YouTube player view **/
                youtubeViewer= (YouTubePlayerView) findViewById(R.id.youtubeViewer);
                listener = new YouTubePlayer.OnInitializedListener() {
                        @Override
                        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                                youTubePlayer.loadVideo(VIDEO_ID);
                        }
                        @Override
                        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                                Toast.makeText(exercise.this, "재생 실패", Toast.LENGTH_LONG).show();
                        }
                };
                youtubeViewer.initialize(API_KEY,listener);
                btn1 = findViewById(R.id.playBtn1);
                btn2 = findViewById(R.id.playBtn2);
                btn3 = findViewById(R.id.playBtn3);
                btn4 = findViewById(R.id.playBtn4);
                btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                VIDEO_ID="F9H1VjTa5is";
                                youtubeViewer.initialize(API_KEY,listener);
                        }
                });

        }
}