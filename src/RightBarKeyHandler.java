
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author azizu
 */
public class RightBarKeyHandler implements KeyListener {

    Canvas canvas;
    int speed;

    public RightBarKeyHandler(Canvas canvas) {
        this.canvas = canvas;
        speed = 25;
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }


    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyCode());
        moveBar(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    void moveBar(int keyCode) {
        switch (keyCode) {
            //right bar up W
            case 87: {
                if (canvas.leftBar.getY() > 0) {
                    canvas.leftBar.setY(canvas.leftBar.getY() - speed);
                }
                break;
            }
            //right bar down S
            case 83: {
                if (canvas.leftBar.getY() < canvas.getHeight() - 200) {
                    canvas.leftBar.setY(canvas.leftBar.getY() + speed);
                }
                break;
            }
            //leftBar up UP Arrow
            case 38: {
                if (canvas.rightBar.getY() > 0) {
                    canvas.rightBar.setY(canvas.rightBar.getY() - speed);
                }
                break;
            }
            //left bar down DOWN Arrow
            case 40: {
                if (canvas.rightBar.getY() < canvas.getHeight() - 200) {
                    canvas.rightBar.setY(canvas.rightBar.getY() + speed);
                }
                break;
            }
            case 27: {
                System.exit(0);
                break;
            }
        }
    }
}
