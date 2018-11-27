package ru.rsreu.nikolaev0211.model.mob.move;

public enum MoveDirectionType {
    UP() {
        @Override
        public MoveDirection getMoveDirection() {
            return new MoveDirection(0, 1);
        }
    },
    DOWN() {
        @Override
        public MoveDirection getMoveDirection() {
            return new MoveDirection(0, -1);
        }
    },
    LEFT() {
        @Override
        public MoveDirection getMoveDirection() {
            return new MoveDirection(-1, 0);
        }
    },
    RIGHT() {
        @Override
        public MoveDirection getMoveDirection() {
            return new MoveDirection(1, 0);
        }
    },
    NONE() {
        @Override
        public MoveDirection getMoveDirection() {
            return new MoveDirection(0, 0);
        }
    };

    MoveDirectionType() {

    }

    public abstract MoveDirection getMoveDirection();
}
