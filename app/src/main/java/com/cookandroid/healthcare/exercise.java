package com.cookandroid.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.lang.reflect.Array;

public class exercise extends YouTubeBaseActivity {
        public static final String API_KEY = "AIzaSyD4u3Vij9fkLSUpshIK80GJ5Ov8NLDWALc";//사용자가 얻은 API Key을 입력하면 된다.(개발자 콘솔에 얻은 것.)
        private YouTubePlayerView youtubeViewer;
        YouTubePlayer youTubePlayer;
        Button btn1;
        TextView textView;
        public static String VIDEO_ID = "eJCn1mylqSk";
        YouTubePlayer.OnInitializedListener listener;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                /** attaching layout xml **/
                setContentView(R.layout.activity_exercise);
                /** Initializing YouTube player view **/
                youtubeViewer = (YouTubePlayerView) findViewById(R.id.youtubeViewer);
                listener = new YouTubePlayer.OnInitializedListener() {
                        @Override
                        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
                                if (!wasRestored) {
                                        if (youTubePlayer == null) {
                                                youTubePlayer = player;
                                        }
                                                youTubePlayer.loadVideo(VIDEO_ID);
                                }
                        }
                        @Override
                        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                                Toast.makeText(exercise.this, "재생 실패", Toast.LENGTH_LONG).show();
                        }
                };
                youtubeViewer.initialize(API_KEY, listener);
                textView=findViewById(R.id.textView);
                textView.setText("");
                String[] str = getResources().getStringArray(R.array.my_array);
                ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.spinner,str);
                Spinner spinner = findViewById(R.id.spinner);
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position==0){
                                textView.setText("운동1");
                                //playVideo();
                        }
                        else if(position==1){
                                textView.setText("운동2");
                                //playVideo();
                        }
                        else if(position==2){
                                textView.setText("운동3");
                                //playVideo();
                        }
                        else {
                                textView.setText("운동4");
                                //playVideo();
                        }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                });
        }

        private void playVideo(String videoId) {
                if (youTubePlayer != null) {
                        youTubePlayer.loadVideo(videoId);
                }
        }
}