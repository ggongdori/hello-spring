package hello.hellospring.controller;


import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    //필드 주입, 별로임, 바꿀 수 있는 방법이 없다
    @Autowired
    private MemberService memberService;


        //Dependency Injection 3가지 -> 생성자 주입
//    @Autowired
//    public MemberController(MemberService memberService) {
//
//        this.memberService = memberService;
//    }
}
