package com.example.clone_messenger;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {

    private List<Chat> chatList;
    private String name;

    //MainActivity.java에서 이 클래스를 쓸 수 있도록 ChatAdapter 메서드를 만들어 줌
    public ChatAdapter(List<Chat> chatData, String name){
        //MainActivity.java에서 받은 데이터들을 저장
        chatList = chatData;
        this.name = name;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nameText;
        public TextView msgText;
        public View rootView;
        public LinearLayout msgLinear;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.nameText);
            msgText = itemView.findViewById(R.id.msgText);
            rootView = itemView;
            msgLinear = itemView.findViewById(R.id.msgLinea);

            itemView.setEnabled(true);  //뷰 활성화
            itemView.setClickable(true);//클릭 허용
        }
    }

    @NonNull
    @Override
    public ChatAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
        //인플레이션

        MyViewHolder myViewHolder = new MyViewHolder(linearLayout);
        //객체를 새로 만듦

        return myViewHolder;
    }//ViewHolder가 실행될 때 진행되고 설정함

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.MyViewHolder holder, int position) {

        Chat chat = chatList.get(position);

        holder.nameText.setText(chat.getName());
        holder.msgText.setText(chat.getMsg());
        
        if(chat.getName().equals(this.name)){   //사용자 이름 == 데이터베이스에 저장된 이름(본인 채팅)
            holder.nameText.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            holder.msgText.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            
            holder.msgLinear.setGravity(Gravity.RIGHT);
        } else {                                //사용자 이름 != 데이터베이스에 저장된 이름(타인 채팅)
            holder.nameText.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
            holder.msgText.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);

            holder.msgLinear.setGravity(Gravity.LEFT);
        }

    }

    @Override
    public int getItemCount() {
        return chatList == null ? 0: chatList.size();
    }

    public void addChat(Chat chat){
        chatList.add(chat);
        notifyItemInserted(chatList.size()-1);
    }




}
