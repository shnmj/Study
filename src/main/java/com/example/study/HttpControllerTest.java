package com.example.study;

import org.springframework.web.bind.annotation.*;

@RestController
public class HttpControllerTest {

    @GetMapping("/http/get") // -> query stirng 방법만
    // http://localhost:8080/http/get?id=1&username=shin&password=1234&email=shin@naver.com
    public String getTest(Member m) {
        return "get 요청:" + m.getId() + "," + m.getUsername() + "," + m.getPassword()+ "," + m.getEmail();
    }

    @PostMapping("/http/post")
    public String postTest(@RequestBody Member m){ // 이렇게하면 파싱해서 오브젝트에 넣어줌 -> MessageConvert가 해줌 (get도 동일)
        return "post 요청:" + m.getId() + "," + m.getUsername() + "," + m.getPassword()+ "," + m.getEmail();
    }

//    @PostMapping("/http/post")
//    public String postTest(@RequestBody String text){ // raw 데이터로 전송 = mime type이 text/plain
//        return "post 요청:" + text;
//    }

    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m){
        return "put 요청:" + m.getId() + "," + m.getUsername() + "," + m.getPassword()+ "," + m.getEmail();
    }

    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete 요청";
    }


}
