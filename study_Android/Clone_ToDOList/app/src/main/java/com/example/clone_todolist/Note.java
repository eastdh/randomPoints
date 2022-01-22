package com.example.clone_todolist;

public class Note {
    //Right Click -> Generate -> Setter and Getter 에서 다음과 같이 만들 수 있음
    //_id 는 데이터베이스를 만들 때 만든 _id 대로 정렬할 때 사용
    //todo 는 EditText 에 입력한 것들을 저장할 때 사용

    int _id;
    String todo;

    public Note(int _id, String todo){
        this._id = _id;
        this.todo = todo;
    }

    public int get_id(){
        return _id;
    }

    public void set_id(int _id){
        this._id = _id;
    }

    public String getTodo(){
        return todo;
    }

    public void setTodo(String todo){
        this.todo = todo;
    }
}
