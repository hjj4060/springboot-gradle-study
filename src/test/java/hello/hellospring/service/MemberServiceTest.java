package hello.hellospring.service;

import hello.hellospring.domain.Member;
import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given 어떤 상황에서 뭔가가 주어졌는데
        Member member = new Member();
        member.setName("hello");

        //when 이걸 실행 했을때
        Long saveId = memberService.join(member);

        //then 이런 결과가 나와야한다.
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getId()).isEqualTo(findMember.getName());
    }

    //테스트는
    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member1.setName("spring1");

        memberService.join(member1);
        IllegalAccessException e = assertThrows(IllegalAccessException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*try {
            memberService.join(member2);
            fail("예외가 발생해야 합니다.");
        } catch (IllegalAccessError e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}