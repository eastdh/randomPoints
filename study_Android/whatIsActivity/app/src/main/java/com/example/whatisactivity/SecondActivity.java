package com.example.whatisactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity implements View.OnClickListener{

    //디자인 변수 선언
    Button backActivity;
    Button backResultOK;
    Button backResultCANCEL;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //메인 레이아웃 매핑
        setContentView(R.layout.activity_second);

        //버튼 매핑
        backActivity = findViewById(R.id.backprocess);
        backResultOK = findViewById(R.id.onresultbackok);
        backResultCANCEL = findViewById(R.id.onresultbackcancel);

        //버튼 클릭 이벤트 정의
        backActivity.setOnClickListener(this);
        backResultOK.setOnClickListener(this);
        backResultCANCEL.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            //뒤로가기
            case R.id.backprocess:
                Intent intent3 = new Intent();
                setResult(9999999, intent3);
                finish();
                break;

            //OK 버튼
            case R.id.onresultbackok:
                Intent intent4 = new Intent();
                //ResultMSG: startActivityForResult 테스트 넘겨준다
                intent4.putExtra("ResultMSG", "startActivityForResult 테스트 오케이");
                setResult(RESULT_OK, intent4);
                finish();
                break;

            //CANCEL 버튼
            case R.id.onresultbackcancel:
                Intent intent5 = new Intent();
                //ResultMsg : startActivityForResult 테스트 넘겨준다
                intent5.putExtra("ResultMSG", "startActivityForResult 테스트 캔슬");
                setResult(RESULT_CANCELED, intent5);
                finish();
                break;
        }
    }
}
