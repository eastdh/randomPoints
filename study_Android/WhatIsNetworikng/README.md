[6장 네트워킹](https://wikidocs.net/105965 "WikiDocs")   

소켓
====
소켓은 네트워크에서 데이터를 송수신 가능하게 하도록 TCP/IP수준의 통신 방식을 제공함.   
안드로이드 스튜디오에서 소켓을 사용하기 위해선 자바SDK에서 제공하는 API를 사용해 만들 수 있다.   
   
Volley
======
웹 서버와 데이터를 주고 받을 때는 요청과 응답에 필요한 코드의 양이 많음. 이를 관리하는 가장 대표적인 라이브러리가 Volley.   
Volley는 앱의 네트워킹을 더 쉽고 빠르게 하는 HTTP 라이브러리.   
### Volley의 사용 순서
1. 간단한 요청을 보냄
2. RequestQueue를 설정함.
3. 표준 요청을 실행함
4. 맞춤 요청을 구현함

### Volley의 장점
- 네트워크 요청의 자동 예약.
- 여러 개의 동시 네트워크 연결 가능
- 사용자에게 맞게 설정 가능
- 필요한 기능들이 기본 제공


JSON
=====
JavaScript Object Notation   
네트워크를 통해 데이터를 주고 받을 때 사용할 수 있도록 데이터를 구조적인 문자열로 표현한 데이터 형식.   
    
    {
        "속성 이름" : "속성 값",
        "속성 이름" : "속성 값",
        "속성 이름" : "속성 값"
    }

GSON
======
GSON은 웹에서 받은 JSON결과물을 처리하기 위해서 사용한다. JSON문자열을 객체로 변환하여 자바 객체로 만듦.   
