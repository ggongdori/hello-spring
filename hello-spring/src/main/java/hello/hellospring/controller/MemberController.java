package hello.hellospring.controller;


import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

//    //필드 주입, 별로임, 바꿀 수 있는 방법이 없다
//    @Autowired
//    private MemberService memberService;
//
//    //setter 주입, 단점: 누군가가 호출했을 때 public으로 열려있어야함
//    //바꿀 일은 없지만 어쨌든 public으로 노출이 되어야 함, 잘못 바꾸면 문제
//   @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }
    private final MemberService memberService;
    //Dependency Injection 3가지 중 -> 생성자 주입, 가장 추천
    @Autowired
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){

        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";

    }
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }



}
