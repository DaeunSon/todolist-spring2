package todolist.todolistspring.repository;
import todolist.todolistspring.domain.Member;

import java.util.Optional;
import java.util.List;

public interface MemberRepository {
    Member save (Member member);
    Optional<Member> findByEmail(String Email);
    Optional<Member> findBynickname(String nickname);
    Optional<Member> findBypassword(String password);
    List<Member> findAll();


}
