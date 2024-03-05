package todolist.todolistspring.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import todolist.todolistspring.domain.Member;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static todolist.todolistspring.repository.MemoryMemberRepository.store;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
}

    @Test
    public void save(){
        Member member = new Member();
        member.setNickname("spring");

        repository.save(member);

        Member result = repository.findByEmail(member.getEmail()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByNickname(){
        Member member1 = new Member();
        member1.setNickname("spring1");
        repository.save(member1);

        Member member2= new Member();
        member2.setNickname("spring2");
        repository.save(member2);

       Member result = repository.findBynickname("spring1").get();

       assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1= new Member();
        member1.setNickname("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setNickname("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
