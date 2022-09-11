package net.softsociety.review0801.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {
    // 게시글
    @GetMapping("/boardlist")
    public String board() {
        //보드객체 가져와서 뿌리기
        
        
        return "/boardView/boardlist";
    }
    
    @GetMapping("/post")
    public String boardPost() {


        return "/boardView/post";
    }
}
