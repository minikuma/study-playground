package me.minikuma.member;

public class MeberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MeberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = new MemoryMemberRepository();
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
