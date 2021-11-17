package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);

        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //null이 반환될 가능성이 있으면 Optional로 감싼다.
        return Optional.ofNullable(store.get(id));
    }

    //람다식 공부 필요
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
