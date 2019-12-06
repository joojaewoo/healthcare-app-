package com.cookandroid.healthcare;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class exercise extends YouTubeBaseActivity {
        public static final String API_KEY = "AIzaSyD4u3Vij9fkLSUpshIK80GJ5Ov8NLDWALc";//사용자가 얻은 API Key을 입력하면 된다.(개발자 콘솔에 얻은 것.)
        private YouTubePlayerView youtubeViewer;
        YouTubePlayer youTubePlayer;
        TextView textView;
        public static String VIDEO_ID = "";
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
                                textView.setText("가장 널리 알려진 대흉근 운동이다. \n" +
                                        "대흉근뿐만 아니라 상완삼두근과 전면 삼각근 발달에도 도움이 되며 초보자들에게는 안전하고 효과적으로 상체를 단련할 수 있는 최고의 운동이다. \n" +
                                        "의자나 상자 위에 다리를 올려놓고 실시하면 조금 더 큰 힘을 발휘해야 하므로 대흉근 발달에는 더욱 효과적이다.\n" +
                                        "\n" +
                                        "주의 사항\n" +
                                        "손목이 많이 꺾이지 않도록 한다.\n" +
                                        "여성의 경우 푹신한 쿠션에 무릎을 꿇어 실시하도록 한다.\n" +
                                        "\n" +
                                        "운동팁\n" +
                                        "어깨너비보다 약간 좁게 실시하면, 상완삼두근의 발달에 효과적일 뿐 아니라 가슴 근육에 다른 자극을 줄 수 있다.\n" +
                                        "다리를 벤치 위에 올려놓고 실시하면 부하가 증대되어 가슴 상부의 발달에 더 큰 효과가 있다.");
                                VIDEO_ID="aoH7qNedO8k";
                                playVideo(VIDEO_ID);
                        }
                        else if(position==1){
                                textView.setText("대표적인 다리 운동 중 하나로 허벅지와 엉덩이에 탄력을 주며 하체 근력을 강화하는 운동이다. \n" +
                                        "자신의 체중을 이용해 실시하더라도 충분한 자극을 느낄 수 있지만, 더 강한 운동 효과를 원한다면 덤벨이나 바벨을 이용하여 천천히 운동하는 것이 좋다.\n" +
                                        "\n" +
                                        "주의 사항\n" +
                                        "앞으로 내민 무릎이 발끝을 벗어나지 않도록 한다.\n" +
                                        "허리가 앞으로 숙여지지 않도록 한다.\n" +
                                        "\n" +
                                        "운동팁\n" +
                                        "뒤에 있는 발의 엄지발가락에 힘을 주고 일어난다.\n");
                                VIDEO_ID="7erin-2cpRo";
                                playVideo(VIDEO_ID);
                        }
                        else if(position==2){
                                textView.setText("복직근 중 상부를 강화하는 운동이다. 허리 부분이 바닥에서 떨어지지 않는다는 것이 싯업과 다른 점이다. \n" +
                                        "근육을 수축시킬 때뿐만 아니라 이완될 때도 복부에 긴장을 유지하는 것이 중요하다.\n" +
                                        "\n" +
                                        "주의 사항\n" +
                                        "동작 간 복부의 긴장이 풀어지지 않도록 한다.\n" +
                                        "\n" +
                                        "운동팁\n" +
                                        "상체를 올리는 동작에서 호흡을 내쉬며 근육을 짜는 듯한 느낌을 느껴야 한다.\n");
                                VIDEO_ID="083jyzCaBMw";
                                playVideo(VIDEO_ID);
                        }
                        else {
                                textView.setText("다리, 엉덩이, 허벅지 안쪽을 다양하게 자극하는 스쿼트이다.\n" +
                                        "이 동작은 특히 여성들에게 추천하는 운동으로 허벅지 안쪽과 엉덩이 옆 라인을 탄력적으로 다듬는 데 효과적이다.\n" +
                                        "\n" +
                                        "주의 사항\n" +
                                        "허리가 앞으로 숙여지거나 뒤로 젖혀지지 않도록 한다.\n" +
                                        "\n" +
                                        "운동팁\n" +
                                        "무릎을 구부릴 때는 발끝이 바깥쪽을 향하게 한다.\n" +
                                        "무릎을 구부려 아래로 내려갈 때 다리 안쪽 근육이 늘어나는 것을 충분히 느끼고, \n" +
                                        "올라올 때는 엉덩이 옆쪽이 자극되는 것을 느끼면서 천천히 실시하면 효과를 더 크게 볼 수 있다.");
                                VIDEO_ID="zxP5s-pONPM";
                                playVideo(VIDEO_ID);
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