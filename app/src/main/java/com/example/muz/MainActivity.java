package com.example.muz;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    /**
     * Кнопка запуска проигрывателя
     */
    private Button buttonPlay;

    /**
     * Кнопка следующей композиции
     */
    private Button buttonNext;

    /**
     * Аудио проигрыватель
     */
    private MediaPlayer player;

    /**
     * Название произведения
     */
    private TextView titleMusic;

    /**
     * Массив названий песен
     */
    private String[] arraySong = new String[] {"Кукла колдуна - Король и Шут", "Ганста Бит - Из игры GTA San Andreas", "GTA San Andreas — Young Maylay Theme"};

    /**
     * Массив музыкальных файлов
     */
    private int[] arrayMusicFile = new int[] {R.raw.kukla_kolduna, R.raw.gangsta_gangsta, R.raw.young_maylay};

    /**
     * Переменная хранит текущий номер файла, который воспроизводится
     */
    private int numberMusic; // = 0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlay = findViewById(R.id.buttonPlay);
        buttonNext = findViewById(R.id.buttonNext);
        titleMusic = findViewById(R.id.titleMusic);

        buttonPlay.setOnClickListener(listener -> {
            play();
        });

        buttonNext.setOnClickListener(listener -> {
            numberMusic++;

            player.stop();

            play();

        });
    }

    /**
     * Метод запуска музыкального произведения
     */
    private void play() {
        player = MediaPlayer.create(this, arrayMusicFile[numberMusic]);
        player.start();

        titleMusic.setText(arraySong[numberMusic]);
    }

}