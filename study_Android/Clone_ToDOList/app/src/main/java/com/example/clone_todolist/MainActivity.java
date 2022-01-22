package com.example.clone_todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    Fragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = new MainFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,mainFragment).commit();
        //FrameLayout에 fragment_main.xml이 추가되도록 설정

        Button saveButton = findViewById(R.id.saveButton);

        //저장 버튼 정의
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                saveToDo();

                Toast.makeText(getApplicationContext(), "추가되었어요", Toast.LENGTH_SHORT).show();
            }
        });
    }
}