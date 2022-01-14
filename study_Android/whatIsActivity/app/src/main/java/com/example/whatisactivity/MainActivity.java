package com.example.whatisactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //디자인 변수 선언
    Button startActivity;
    Button startActivityResult;

    //onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //메인 레이아웃 매핑
        setContentView(R.layout.activity_main);

        //버튼 매핑
        startActivity = findViewById(R.id.start_ac);
        startActivityResult = findViewById(R.id.start_AFR);

        //버튼 클릭 이벤트 정의
        startActivity.setOnClickListener(this);
        startActivityResult.setOnClickListener(this);
    }

    //버튼 이벤트 정의
    @Override
    public void onClick(View v){
        switch (v.getId()){
            //startActivity()
            case R.id.start_ac:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
            //startActivityForResult()
            case R.id.start_AFR:
                Intent intent2 = new Intent(this, SecondActivity.class);
                startActivityForResult(intent2, 1000);
                break;
        }
    }

    //startActivityForResult 결과 return
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        //requestCode가 1000인 경우
        if(requestCode == 1000){
            //OK
            if(resultCode == RESULT_OK){
                String resultMSG = data.getStringExtra("ResultMSG");
                Toast.makeText(this, "RESULT_OK: " + resultMSG, Toast.LENGTH_SHORT).show();
            }
            //cancel
            else if(resultCode == RESULT_CANCELED){
                String resultMSG = data.getStringExtra("ResultMSG");
                Toast.makeText(this, "RESULT_CANCELED: " + resultMSG, Toast.LENGTH_SHORT).show();

            }
        }
    }
}