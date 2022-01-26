package com.example.clone_todolist;

import android.content.Context;
import android.database.Cursor;
import android.os.ConditionVariable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

public class MainFragment extends Fragment{
    private static final String TAG = "MainFragment";

    @Override
    //화면을 생성할 때가 아닌 구성할 때, 즉 생성된 이후에 호출되는 역할.
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
        //inflate() 매서드를 이용해 fragment_main.xml과 연결
        //이 상황을 인플레이션이라고 부름

        initUI(rootView);
        loadNoteListData();

        return rootView;
    }

    RecyclerView recyclerView;
    NoteAdapter adapter;

    //layoutManager와 어댑터를 이용해 리사이클러뷰를 사용하는 역할.
    private void initUI(ViewGroup rootView){
        recyclerView = rootView.findViewById(R.id.recyclerView);
        //fragment_main.xml에 만들었던 RecyclerView를 연결함.

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        //LinearLayout에 recyclerView를 붙임.
        //todo_item들이 세로로 하나하나 정렬하게하는 역할을 함

        adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);
        //어댑터들을 연결

    }

    Context context;
    //MainFragment 안 onCreateView에서 아이템을 보이게 할 메서드
    public int loadNoteListData(){
        String loadSQL = "select _id, TODO from " + NoteDatabase.TABLE_NOTE + " order by _id desc";
        //테이블에 있는 데이터를 가져오는 select문을 이용해 SQL문 생성

        int recordCount = -1;
        NoteDatabase database = NoteDatabase.getInstance(context);

        if(database != null){
            Cursor outCursor = database.rawQuery(loadSQL);

            recordCount = outCursor.getCount();

            ArrayList<Note> items = new ArrayList<>();

            for(int i = 0; i < recordCount; i++){
                outCursor.moveToNext();

                int _id = outCursor.getInt(0);
                String todo = outCursor.getString(1);
                items.add(new Note(_id, todo));
            }
            //for문으로 모든 아이템을 가져옴

            outCursor.close();

            adapter.setItems(items);
            adapter.notifyDataSetChanged();
            //변경점을 저장
        }
        return recordCount;
    }
}
