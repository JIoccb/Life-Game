package the_life_game;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Box extends JPanel {
    Cell cell;

    public Box(int x, int y) {
        super();
        cell = new Cell();
        setBounds(x * GameParams.SIZE, y * GameParams.SIZE, GameParams.SIZE, GameParams.SIZE);
        setBackground(GameParams.getColor(Status.NONE));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                cell.turn();
            }
        });
    }

    public void setColor() {
        setBackground(GameParams.getColor(cell.status));
    }

    void prepare() {
        cell.prepare();
        setColor();
    }

    void replace() {
        cell.replace();
        setColor();
    }
}
