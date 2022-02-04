package com.example.clone_weather;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView dateView;
    TextView cityView;
    TextView weatherView;
    TextView tempView;

    static RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateView = findViewById(R.id.dateView);
        cityView = findViewById(R.id.cityView);
        weatherView = findViewById(R.id.weatherView);
        tempView = findViewById(R.id.tempView);

        //이미지 버튼을 누르면 시간이 나올 수 있도록 함
        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //시간 데이터와 날씨 데이터를 불러옴
               CurrentCall();

            }
        });

        //큐가 비어있을 때 새로운 큐를 생성해줌
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
    }

    private void CurrentCall() {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=seoul&appid=138fd1f7a3561c0c7a97a93ecc65c3dd";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(String response) {
                try {
                    //System 의 현재 시간(년,월,일,시,분,초까지)가져오고 Date 로 객체화함
                    long now = System.currentTimeMillis();
                    Date date = new Date(now);

                    //년, 월, 일 형식으로. 시,분,초 형식으로 객체화하여 String 에 형식대로 넣음
                    SimpleDateFormat simpleDateFormatDay = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm:ss");

                    String getDay = simpleDateFormatDay.format(date);
                    String getTime = simpleDateFormatTime.format(date);

                    //getDate에 개행을 포함한 형식들을 넣은 후 dateView에 text설정
                    String getDate = getDay + "\n" + getTime;
                    dateView.setText(getDate);

                    //API 로 받은 json 파일을 받아줄 JSONObject 객체 선언
                    JSONObject jsonObject = new JSONObject(response);

                    //도시 설정
                    String city = jsonObject.getString("name");
                    cityView.setText(city);

                    //날씨 설정
                    JSONArray weatherJson = jsonObject.getJSONArray("weather");
                    JSONObject weatherObj = weatherJson.getJSONObject(0);
                    String weather = weatherObj.getString("description");
                    weatherView.setText(weather);

                    //기온 설정
                    JSONObject tempK = new JSONObject(jsonObject.getString("main"));

                    //기온 받고 켈빈 온도를 섭씨로 변경
                    double tempDo =(Math.round((tempK.getDouble("temp")-273.15)*100)/100.0);
                    tempView.setText(tempDo + "°C");

                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){

            }

        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };

        request.setShouldCache(false);  //request 받기를 멈춤
        requestQueue.add(request);      //큐에 request 를 넣어 저장

    }

}