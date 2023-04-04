package me.minikuma.item07.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ChannelTest {

    @Test
    void npe() {
        Channel channel = new Channel();
//        MemberShip memberShip = channel.defaultMemberShip();
        Optional<MemberShip> memberShip = channel.defaultMemberShip();
        // NPE 발생 제거
        memberShip.ifPresent(MemberShip::hello);
    }
}