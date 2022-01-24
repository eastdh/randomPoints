package com.example.clone_todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private static final String TAG = "NoteAdapter";

    @NonNull
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //todo_item.xml을 인플레이션하는 코드
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.todo_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ViewHolder holder, int position) {
        Note item = items.get(position);
        holder.setItem(item);
        holder.setLayout();

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    ArrayList<Note> items = new ArrayList<Note>();

    static class ViewHolder extends RecyclerView.ViewHolder{
        //아이템을 가지고 있는 역할을 하는 것이 ViewHolder이기 때문에
        //이전에 todo_item.xml에서 만들었던 것들을 연결
        LinearLayout layoutTodo;
        CheckBox checkBox;
        Button deleteButton;

        public ViewHolder(View itemView){
            super(itemView);

            layoutTodo = itemView.findViewById(R.id.layoutTodo);
            checkBox = itemView.findViewById(R.id.checkBox);
            deleteButton = itemView.findViewById(R.id.deleteButton);

            //삭제버튼 정의
            deleteButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    String TODO = (String) checkBox.getText();
                    deleteToDo(TODO);
                    Toast.makeText(v.getContext(), "삭제되었습니다.", Toast.LENGTH_SHORT).show();
                }

                private void deleteToDo(String TODO){

                }
                //삭제 버튼을 누르면
                //삭제 버튼을 누른 아이템의 Text를 받아 Text와 같은 데이터베이스의 값을 삭제
                //그리고 Toast.makeText를 이용해 사용자에게 삭제됨을 알림

            });
        }


        //EditText에서 입력받은 checkBox의 텍스트를 checkBox의 Text에 넣을 수 있게 하는 메서드
        public void setItem(Note item){checkBox.setText(item.getTodo());}

        //아이템들을 담은 LinearLayout을 보여주게 하는 메서드
        public void setLayout(){layoutTodo.setVisibility(View.VISIBLE);}






    }

    //배열에 있는 item들을 가리키는 메서드
    public void setItems(ArrayList<Note> items){this.items = items;}



}
