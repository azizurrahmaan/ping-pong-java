
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;

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
    int frameWidth;
    int frameHeight;

    public GameArena() {
        frameWidth = (int)(Toolkit.getDefaultToolkit().getScreenSize().width * 0.8);
        frameHeight = (int)(Toolkit.getDefaultToolkit().getScreenSize().height * 0.7);
        initGUI();
    }

    private void initGUI() {
        fr = new JFrame("Ping Pong");
        fr.setLayout(null);
        
        canvas = new Canvas(frameWidth, frameHeight);
        canvas.setVisible(true);
        
        canvas.leftPaddel.setFocusable(true);
        canvas.leftPaddel.addKeyListener(new LeftPaddelKeyHandler(this));
        
        canvas.rightPaddel.setFocusable(true);
        canvas.rightPaddel.addKeyListener(new RightPaddelKeyHandler(canvas));
        
        
        fr.add(canvas);
        
        
        fr.setSize(frameWidth, frameHeight);
        fr.setLocation(0, 0);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
        fr.setResizable(false);

        ballCtrl = new BallMovementCtrl(canvas);
        Thread t1 = new Thread(ballCtrl);
        t1.start();

    }
    

}
