package com.example.clone_todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MainFragment extends Fragment{
    private static final String TAG = "MainFragment";

    RecyclerView recyclerView;
    NoteAdapter adapter;

    @Override
    //화면을 생성할 때가 아닌 구성할 때, 즉 생성된 이후에 호출되는 역할.
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
        //inflate() 매서드를 이용해 fragment_main.xml과 연결
        //이 상황을 인플레이션이라고 부름

        initUI(rootView);

        return rootView;
    }

    //layoutManager와 어댑터를 이용해 리사이클러뷰를 사용하는 역할.
    private void initUI(ViewGroup rootView){
        recyclerView = rootView.findViewById(R.id.recyclerView);
        //fragment_main.xml에 만들었던 RecyclerView를 연결함.

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManger(layoutManager);
        //LinearLayout에 recyclerView를 붙임.
        //todo_item들이 세로로 하나하나 정렬하게하는 역할을 함

        adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);
        //어댑터들을 연결

    }
}
