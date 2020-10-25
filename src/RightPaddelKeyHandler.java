
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
public class RightPaddelKeyHandler implements KeyListener {
    
    Canvas canvas;
    int speed;
    

    public RightPaddelKeyHandler(Canvas canvas) {
        this.canvas = canvas;
        speed = 4;
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        moveBar(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    void moveBar(int keyCode) {
        switch (keyCode) {
            //left bar up W
            case 87: {
                
                canvas.leftPaddel.setFocusable(true);
                if (canvas.leftPaddel.getY() >= speed) {
                    canvas.leftPaddel.setLocation(canvas.leftPaddel.getX(), canvas.leftPaddel.getY() - speed);
                }
                break;
            }
            //left bar down S
            case 83: {
                
                canvas.leftPaddel.setFocusable(true);
                if (canvas.leftPaddel.getY() + canvas.leftPaddel.getHeight() <= canvas.getHeight() - 30) {
                    canvas.leftPaddel.setLocation(canvas.leftPaddel.getX(), canvas.leftPaddel.getY() + speed);
                }
                break;
            }
            //right bar up UP Arrow
            case 38: {
                canvas.rightPaddel.setFocusable(true);
                if (canvas.rightPaddel.getY() >= speed) {
                    canvas.rightPaddel.setLocation(canvas.rightPaddel.getX(), canvas.rightPaddel.getY() - speed);
                }
                break;
            }
            //right bar down DOWN Arrow
            case 40: {
                canvas.rightPaddel.setFocusable(true);
                if (canvas.rightPaddel.getY() + canvas.rightPaddel.getHeight() <= canvas.getHeight() - 30) {
                    canvas.rightPaddel.setLocation(canvas.rightPaddel.getX(), canvas.rightPaddel.getY() + speed);
                }
                break;
            }
            //right bar down DOWN Arrow
            case 32: {
                
                break;
            }
        }
    }
}
