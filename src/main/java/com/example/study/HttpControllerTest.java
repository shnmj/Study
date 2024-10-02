package com.example.study;

import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest : ";

    @GetMapping("/http/lombok")
    public String lombokTest() {
        // Member m1 = new Member(id, username, password, email) -> 순서대로 넣어야 하는 단점
        Member m = Member.builder().username("shin").password("1234").email("shin@gmail.com").build();
        System.out.println(TAG + "getter:" + m.getUsername());
        m.setUsername("kim");
        System.out.println(TAG + "setter:" + m.getUsername());
        return "lombok test 완료";
    }

    @GetMapping("/http/get") // -> query string만 가능 : Param
    // http://localhost:8080/http/get?id=1&username=shin&password=1234&email=shin@naver.com
    public String getTest(Member m) {
        return "get 요청:" + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
    }

    // body에 담음
    // x-www-form-urlencoded : <form> <input type=""> </form> 방식
    @PostMapping("/http/post")
    public String postTest(@RequestBody Member m) { // 이렇게하면 파싱해서 오브젝트에 넣어줌 -> MessageConvert가 해줌 (get도 동일)
        return "post 요청:" + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
    }

//    @PostMapping("/http/post")
//    public String postTest(@RequestBody String text){ // raw 데이터로 전송 = mime type이 text/plain
//        return "post 요청:" + text;
//    }

    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m) {
        return "put 요청:" + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
    }

    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }


}
