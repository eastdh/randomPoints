package com.example.clone_weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView dateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        long now = System.currentTimeMillis();
        Date date = new Date(now);

        SimpleDateFormat simpleDateFormatDay = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm:ss");

        String getDay = simpleDateFormatDay.format(date);
        String getTime = simpleDateFormatTime.format(date);
        String getDate = getDay + "\n" + getTime;

        dateView = findViewById(R.id.dateView);

        //이미지 버튼을 누르면 시간이 나올 수 있도록 함
        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateView.setText(getDate);

            }
        });
    }

}