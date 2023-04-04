package me.minikuma.item07.optional;

import java.nio.file.OpenOption;
import java.util.Optional;

public class Channel {
    private int numOfSubscriber;

    public Optional<MemberShip> defaultMemberShip() {
        if (this.numOfSubscriber > 200) {
            return Optional.empty();
        } else {
            return Optional.of(new MemberShip());
        }
    }
}
