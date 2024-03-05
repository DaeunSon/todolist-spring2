package todolist.todolistspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todolist.todolistspring.domain.Member;
import todolist.todolistspring.repository.MemberRepository;
import todolist.todolistspring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     *
     *
     */
    public String join(Member member){

        validateDuplicateMember(member);//중복 이메일 검증

        memberRepository.save(member);
        return member.getEmail();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByEmail(member.getEmail())
            .ifPresent(m ->{
            throw new IllegalStateException("중복된 이메일입니다.");
             });
    }

    /**
     * 전체회원조회
     *
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member>findOne(String memberEmail){
        return memberRepository.findByEmail(memberEmail);
    }


}
