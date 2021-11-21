package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

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
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //돌면서 하나 찾으면 바로 반환, 끝까지 찾아서 없으면 null 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear(); //store를 싹 비움
    }
}
