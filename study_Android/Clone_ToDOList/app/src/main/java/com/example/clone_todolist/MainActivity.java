package com.example.clone_todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        openDatabase(); //onCreate()메서드 안에 openDatabase()가 있음으로써 앱이 실행될 때 실행됨
    }

    EditText inputToDo;
    Context context;

    public void saveToDo(){
        inputToDo = findViewById(R.id.inputToDo);

        String todo = inputToDo.getText().toString();
        //EditText에 적힌 글을 String todo로 가져옴

        String sqlSave = "insert into " + NoteDatabase.TABLE_NOTE + " (TODO) values ("
                + "'" + todo + "')";
        //todo로 가져온 글을 sql문으로 만듦

        NoteDatabase database = NoteDatabase.getInstance(context);
        database.execSQL(sqlSave);
        //execSQL로 sql문 실행, 가져온 글을 저장

       inputToDo.setText("");//저장 후 빈 칸으로 만들기

    }

    //초기화
    public static NoteDatabase noteDatabase = null;

    //NoteDatabase.java에서 정의했던 open()과 close()가 여기서 쓰임.
    //데이터베이스를 열거나 없으면 만드는 역할!!
    public void openDatabase(){
        if (noteDatabase != null){
            noteDatabase.close();
            noteDatabase = null;
        }

        noteDatabase = NoteDatabase.getInstance(this);
        boolean isOpen = noteDatabase.open();
        if (isOpen){
            Log.d(TAG, "Note database is OPEN");
        }else{
            Log.d(TAG, "Note database is NOT OPEN");
        }

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        if(noteDatabase != null){
            noteDatabase.close();
            noteDatabase = null;
        }
    }
}