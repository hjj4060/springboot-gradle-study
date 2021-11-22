package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

//Service 클래스는 비즈니스 의존적으로 설계를한다. 그래서 네이밍을 비즈니스적으로 지어야 한다.
public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        /*
            //같은 이름이 있는 중복 회원X
            //command + option + v 명령어로 반환받을 변수 만들어짐
            Optional<Member> result = memberRepository.findByName(member.getName());

            //ifPresent는 어떤 값이 있으면 동작을 한다. 과거에는 if null=! 이런식으로 코딩했지만 요즘에는 null로 반환될거 같으면 Optional로 감싼다
            result.ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
        */
        vaildateDupliateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    // ctrl + t 로 메서드 추출
    private void vaildateDupliateMember(Member member) {
        //Optional을 반환받지 않고 바로 사용 권장
        memberRepository.findByName(member.getName()).ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
