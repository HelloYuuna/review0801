package net.softsociety.review0801.dao;

import net.softsociety.review0801.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {
    // id 찾기
    Member searchId(String searchID);
    
    // 회원가입
    int insertMember(Member member);
    
    // member객체 수정
    int updateMember(Member member);
}
