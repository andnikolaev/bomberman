package ru.rsreu.nikolaev0211.model.mob.monster.AI;

import ru.rsreu.nikolaev0211.model.mob.move.MoveDirectionType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MediumAI implements AI {
    private static final List<MoveDirectionType> VALUES =
            Collections.unmodifiableList(Arrays.asList(MoveDirectionType.values()));
    private static final Random RANDOM = new Random();


    @Override
    public MoveDirectionType calculateDirection() {
        return VALUES.get(RANDOM.nextInt(VALUES.size()));
    }
}
