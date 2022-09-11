package net.softsociety.review0801.service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.review0801.dao.MemberDAO;
import net.softsociety.review0801.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Boolean searchId(String searchID) {
        Member member = memberDAO.searchId(searchID);
        log.info("member: {}",member);
        return member == null;
    }

    @Override
    public int insertMember(Member member) {
        String encodedPW = passwordEncoder.encode(member.getPassword());
        member.setMemberpw(encodedPW);

        return memberDAO.insertMember(member);
    }

    @Override
    public Member searchMember(String getId) {
        return memberDAO.searchId(getId);
    }

    @Override
    public int updateMember(Member member) {
        String updatePW = member.getPassword();

        // null 값이 인코딩돼지 않도록 if문으로 막기
        if (updatePW != null && updatePW.length() != 0) {
            // 비밀번호 암호화
            String encodedPW = passwordEncoder.encode(updatePW);
            member.setMemberpw(encodedPW);
        }
        
        return memberDAO.updateMember(member);
    }
}
