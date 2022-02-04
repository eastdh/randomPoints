[실시간 시간 및 날씨 위젯 앱 만들기](https://wikidocs.net/107909 "WikiDocs")     

실시간 시간 및 날씨 위젯 앱 만들기
==============================
## 사용되는 개념
- ConstraintLayout
- Volley
- JSON
- Weather API
------------
2022-02-02   
[UI 만들기](https://wikidocs.net/111271)   
ConstraintLayout은 뷰의 연결점을 다른 뷰와 연결하여 이 뷰와 다른 뷰가 어떻게 연결 되는지 알려주는 제약 조건을 지님
> 따라서, 3개 이상의 점을 연결하지 않으면 오류가 발생, 뷰가 실행되지 않음 

### ConstraintLayout의 장점
- 뷰의 계층들을 간단하게 할 수 있어 유지보수가 좋음
    >어느 뷰가 어디랑 연결되어 있는지 등..
- RelativeLayout과 비슷하지만 더 유연하고 다양한 기능 제공
- 뷰의 비율 조절에 용이
----------------

2022-02-03   
UI 마무리   
[시스템 시간 활용하기](https://wikidocs.net/111284)   
System.currentTimeMillis()를 사용해 현재 시간을 밀리초 단위로 리턴 값을 받아온 후,  
Date 클래스를 이용해 객체화 시키고,   
SimpleDateFormat을 통해 다양한 형식으로 시간을 처리 함   