
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author azizu
 */
public class GameArena {

    JFrame fr;
    Canvas canvas;
    BallMovementCtrl ballCtrl;

    public GameArena() {
        initGUI();
    }

    private void initGUI() {
        fr = new JFrame("Ping Pong");

        canvas = new Canvas();
        canvas.setVisible(true);

        fr.addKeyListener(new RightBarKeyHandler(this.canvas));
        
        fr.add(canvas);

        fr.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height - 200);
        fr.setLocation(0, 0);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
        fr.setResizable(false);

        ballCtrl = new BallMovementCtrl(canvas);
        Thread t1 = new Thread(ballCtrl);
        t1.start();

    }

}
