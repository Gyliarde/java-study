package org.optional.model;

import java.util.Optional;

public class Computer {

    private Optional<SoundCard> soundCard = Optional.empty();

    public Optional<SoundCard> getSoundCard() {
        return soundCard;
    }

    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = Optional.ofNullable(soundCard);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "soundCard=" + soundCard +
                '}';
    }
}
