package the_life_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements Runnable {
    JFrame frame;
    Box[][] boxes;

    @Override
    public void run() {
        initFrame();
        initBoxes();
        initTimer();
    }

    void initFrame() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setSize(GameParams.SIZE * GameParams.WIDTH, GameParams.SIZE * GameParams.HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Life Game");
    }

    void initBoxes() {
        boxes = new Box[GameParams.WIDTH][GameParams.HEIGHT];
        for (int x = 0; x < GameParams.WIDTH; x++) {
            for (int y = 0; y < GameParams.HEIGHT; y++) {
                boxes[x][y] = new Box(x, y);
                frame.add(boxes[x][y]);
                boxes[x][y].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }
        }
        for (int x = 0; x < GameParams.WIDTH; x++) {
            for (int y = 0; y < GameParams.HEIGHT; y++) {
                for (int sx = -1; sx <= 1; sx++) {
                    for (int sy = -1; sy <= 1; sy++) {
                        if (!(sx == 0 && sy == 0)) {
                            boxes[x][y].cell.addNear(boxes
                                    [(x + sx + GameParams.WIDTH) % GameParams.WIDTH]
                                    [(y + sy + GameParams.HEIGHT) % GameParams.HEIGHT].cell);
                        }
                    }
                }
            }
        }
    }

    private void initTimer() {
        TimerListener tl = new TimerListener();
        Timer timer = new Timer(GameParams.SLEEPMS, tl);
        timer.start();
    }

    private class TimerListener implements ActionListener {
        boolean flop = false;

        @Override
        public void actionPerformed(ActionEvent e) {
            flop = !flop;
            for (int x = 0; x < GameParams.WIDTH; x++) {
                for (int y = 0; y < GameParams.HEIGHT; y++) {
                    if (flop) {
                        boxes[x][y].prepare();
                    } else {
                        boxes[x][y].replace();
                    }
                }
            }
        }
    }
}