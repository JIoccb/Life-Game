package the_life_game;

import java.awt.*;

public class GameParams {
    public static final int SIZE = 20;
    public static final int WIDTH = 80;
    public static final int HEIGHT = 60;
    public static final int SLEEPMS = 80;

    public static Color getColor(Status status) {
        return switch (status) {
            default -> Color.GRAY;
            case LIVE -> Color.WHITE;
        };
    }
}