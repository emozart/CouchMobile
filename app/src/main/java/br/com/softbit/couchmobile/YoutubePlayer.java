package br.com.softbit.couchmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubePlayer extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final String API_KEY = "AIzaSyCAkRUKqdKVRIwUDeAc1GQO-ZCH2XZaFC4";
    private String VIDEO_ID = "MM4ShEnKw3A";
    private YouTubePlayerView youTubePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player);

        youTubePlayer = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayer.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean loaded) {
        if(!loaded){
            youTubePlayer.cueVideo(VIDEO_ID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Erro: " + youTubeInitializationResult, Toast.LENGTH_LONG).show();
    }
}
