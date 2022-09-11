package net.softsociety.review0801.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.review0801.domain.Member;
import net.softsociety.review0801.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 회원가입 폼
     *
     * @return join
     */
    @GetMapping("/join")
    public String joinPage(Model model) {
        model.addAttribute("member", new Member());
        return "/memberView/join";
    }

    @PostMapping("/join")
    public String joinPage(Member member) {
        log.debug("받아온 멤버객체: {}", member);

        int res = memberService.insertMember(member);

        if (res < 1) {
            log.debug("회원가입 실패");
        }

        return "redirect:/";
    }

    /**
     * 아이디 체크폼 이동
     *
     * @return id체크 폼
     */
    @GetMapping("/idChk")
    public String idChkForm() {

        return "/memberView/idChk";
    }

    /**
     * 아이디 존재유무 파악 후, 결과값을 받아옴
     * @param model result, searchID
     * @param searchID 검색한 아이디
     * @return id체크 폼
     */
    @PostMapping("/idChk")
    public String idChkForm(Model model, String searchID) {
        log.debug("searchID: " + searchID);

        Boolean result = memberService.searchId(searchID);
        if (Boolean.FALSE.equals(result)) {
            log.debug("존재하는 아이디");

        } else {
            log.debug("존재하지 않는 아이디");
        }

        log.debug("boolean : {} ", result);

        model.addAttribute("searchID", searchID);
        model.addAttribute("result", result);

        return "/memberView/idChk";
    }

    @GetMapping("/loginForm")
    public String loginForm() {

        return "/memberView/loginForm";
    }

    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal UserDetails user) {
        String getId = user.getUsername();
        Member member = memberService.searchMember(getId);
        log.debug("member: {}", member);

        model.addAttribute("member",member);
        return "/memberView/profile";
    }

    @PostMapping("/profile")
    public String profile(Member member, @AuthenticationPrincipal UserDetails user) {
        String getID = user.getUsername();
        log.debug("아이디: " + getID);

        member.setMemberid(getID);
        log.debug("받아온 객체와 아이디: {}", member);
        int res = memberService.updateMember(member);
        if(res < 1) {
            log.debug("수정 실패");
        }

        return "redirect:/";
    }
}
