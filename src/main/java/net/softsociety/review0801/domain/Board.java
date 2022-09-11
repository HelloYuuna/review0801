package net.softsociety.review0801.domain;

import lombok.Data;

@Data
public class Board {
    private String boardnum;
    private String memberid;
    private String title;               // 게시판 제목
    private String textarea;            // 게시판 내용
    private String inputdate;           // 게시 날짜
    private int hits;                   // 조회수

    private String originalfile;        // 원 파일명
    private String savedfile;           // 저장된 파일명
}
