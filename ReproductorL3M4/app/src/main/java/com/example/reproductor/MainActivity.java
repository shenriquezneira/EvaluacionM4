package com.example.reproductor;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnReproducir;
    private boolean isReproducir = false;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.riesling_kids);
        mediaPlayer.setLooping(true);

        btnReproducir = findViewById(R.id.btnReproducir);

        btnReproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reproducir();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    private void Reproducir() {
        isReproducir = !isReproducir;
        if (isReproducir) {
            mediaPlayer.start();
        } else if (!isReproducir) {
            mediaPlayer.pause();


        }
    }
}