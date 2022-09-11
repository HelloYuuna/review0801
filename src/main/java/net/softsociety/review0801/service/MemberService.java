package net.softsociety.review0801.service;

import net.softsociety.review0801.domain.Member;

public interface MemberService {
    // id 찾기
    Boolean searchId(String searchID);
    
    // 회원가입
    int insertMember(Member member);
    
    // id 값으로 멤버 객체 가져옴
    Member searchMember(String getId);
    
    // member 객체 수정
    int updateMember(Member member);
}
