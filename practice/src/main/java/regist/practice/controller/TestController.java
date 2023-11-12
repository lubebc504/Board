//package regist.practice.controller;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import regist.practice.User_info;
//import regist.practice.service.TestService;
//import java.util.List;
//@Controller
//@Slf4j
//@RequiredArgsConstructor
//public class TestController {
//    private final TestService service; //테스트 서비스 객체 생성
//    @GetMapping(value = "/")
//    public String HI( ){ //테이블에 값을 넣는 함수
////        User_info u = new User_info(); //새로운 유저객체선언
////        u.setA("sada"); //유저객체에 값 삽입
////        u.setB("dfd");
////        u.setC("wss");
////        service.serviceTest(u);
//       List<User_info> a =  service.serviceGetData("sada"); //user id가 'sada'인 행을 찾아서 보여준다.
//       for(int i = 0; i< a.size();i++) {
//           System.out.println("www: "+a.get(i).getA()+a.get(i).getB());
//       }
//        return "hello";
//    }
//}
