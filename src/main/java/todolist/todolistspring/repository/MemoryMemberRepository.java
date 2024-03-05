package todolist.todolistspring.repository;

import org.springframework.stereotype.Repository;
import todolist.todolistspring.domain.Member;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {
public static Map<String, Member> store = new HashMap<>();
private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setEmail(String.valueOf(++sequence));
        store.put(member.getEmail(), member);
        return member;
    }

    @Override
    public Optional<Member> findByEmail(String Email) {
        return Optional.ofNullable(store.get(Email));
    }

    @Override
    public Optional<Member> findBynickname(String nickname) {
        return store.values().stream()
                .filter(member -> member.getNickname().equals(nickname))
                .findAny();
    }

    @Override
    public Optional<Member> findBypassword(String password) {
        return store.values().stream()
                .filter(member -> member.getPassword().equals(password))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
