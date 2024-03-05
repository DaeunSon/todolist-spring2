package todolist.todolistspring.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import todolist.todolistspring.domain.Member;
import todolist.todolistspring.repository.MemoryMemberRepository;
import todolist.todolistspring.repository.MemoryMemberRepositoryTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService ;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
     memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setNickname("hello");
        //when
        String saveEmail = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveEmail).get();
        assertThat(member.getEmail()).isEqualTo(findMember.getEmail());
    }
    @Test
    public void 중복_회원_예외(){
        //given
            Member member1 = new Member();
            member1.setNickname("spring");

            Member member2 = new Member();
            member2.setNickname("spring");
        //when
            memberService.join(member1);
            try{
                memberService.join(member1);
                fail("예외가 발생해야 합니다.");
            }catch (IllegalStateException e){
                assertThat(e.getMessage()).isEqualTo("중복된 이메일입니다.");;
            }
        //then

    }
    @Test
    void findMembers() {

    }

    @Test
    void findOne(){

    }
}