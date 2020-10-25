
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author azizu
 */
public class BallMovementCtrl implements Runnable {

    enum Side {
        Right, Left, Bottom, Top
    }
    Canvas canvas;
    int minX;
    int minY;
    int maxX;
    int maxY;
    Dimension screen;
    int screenWidth;
    int screenHeight;
    boolean right = false, left = true, up = false, down = true;
    int xSpeed = 1;
    int ySpeed = 1;

    public BallMovementCtrl(Canvas canvas) {
        this.canvas = canvas;
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int) screen.getWidth();
        screenHeight = (int) screen.getHeight();
        minY = 0;
        minX = 0;
        maxX = screenWidth - 20;
        maxY = screenHeight - 70;
    }

    @Override
    public void run() {
        while (true) {
            
            

            if (isCollidedWithLeftBar(Side.Right)) {
                xSpeed = -xSpeed;
                left = false;
                right = true;

                System.out.println("yes");
            } else {
                System.out.println("no");
            }/*else if(canvas.ballPos.x  + 20 >= canvas.rightBar.getX()){
                System.out.println("ball sajjay gai a...");
            }else{
                System.out.println("ball wich kaar a");
            }*/
            
            if (down) {
                if (canvas.ballPos.getY() >= maxY) {
                    ySpeed = -ySpeed;
                    up = true;
                    down = false;
                }
            }
            if (up) {
                if (canvas.ballPos.getY() <= minY) {
                    ySpeed = -ySpeed;
                    up = false;
                    down = true;
                }
            }
            if (right) {
                if (canvas.ballPos.getX() <= minX) {
                    xSpeed = -xSpeed;
                    right = false;
                    left = true;
                }
            }
            if (left) {
                if (canvas.ballPos.getX() >= maxX) {
                    xSpeed = -xSpeed;
                    left = false;
                    right = true;
                }
            }

            maxX = canvas.getSize().width - 20;
            maxY = canvas.getSize().height - 20;

            canvas.ballPos.setX(canvas.ballPos.getX() + xSpeed);
            canvas.ballPos.setY(canvas.ballPos.getY() + ySpeed);
            canvas.repaint();
            canvas.revalidate();

            try {
                Thread.sleep(5);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    boolean isCollidedWithLeftBar(Side side) {
        if (side == Side.Right) {
            return ((canvas.ballPos.x <= canvas.leftBar.getX() + 50) && ((canvas.ballPos.y + 10 >= canvas.leftBar.y) && (canvas.ballPos.y <= canvas.leftBar.y + 200)));
        }
        return false;
    }
}
