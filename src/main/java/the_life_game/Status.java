package the_life_game;

public enum Status {
    NONE,
    BORN,
    LIVE,
    DIED;

    public Status prepare(int around) {
        return switch (this) {
            case NONE -> (around == 3) ? BORN : NONE;
            case LIVE -> (around < 2 || around > 3) ? DIED : LIVE;
            default -> this;
        };

    }

    public Status replace() {
        return switch (this) {
            case BORN -> LIVE;
            case DIED -> NONE;
            default -> this;
        };
    }

    public boolean isCell() {
        return this == LIVE || this == DIED;
    }
}
