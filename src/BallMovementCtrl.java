
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
    boolean isBallPause;

    int rightPlayerScore;
    int leftPlayerScore;

    public BallMovementCtrl(Canvas canvas) {
        this.canvas = canvas;
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int) screen.getWidth();
        screenHeight = (int) screen.getHeight();
        minY = 0;
        minX = 0;
        maxX = screenWidth - 20;
        maxY = screenHeight - 70;
        isBallPause = false;
        leftPlayerScore = 0;
        rightPlayerScore = 0;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(isBallPause);
            if (isBallPause) {
                continue;
            }
            if (right && (canvas.ballPos.getY() >= canvas.leftPaddel.getY())
                    && (canvas.ballPos.getY() + 20 <= canvas.leftPaddel.getY() + canvas.leftPaddel.getHeight())
                    && (canvas.ballPos.getX() <= canvas.leftPaddel.getX() + 20)) {

                xSpeed = -xSpeed;
                right = false;
                left = true;

            } else if (right && (canvas.ballPos.getY() >= canvas.leftPaddel.getY())
                    && (canvas.ballPos.getY() + 20 <= canvas.leftPaddel.getY() + canvas.leftPaddel.getHeight())
                    && (canvas.ballPos.getX() + 20 <= canvas.leftPaddel.getX())) {

                xSpeed = -xSpeed;
                right = false;
                left = true;
            } else if (left && (canvas.ballPos.getY() >= canvas.rightPaddel.getY())
                    && (canvas.ballPos.getY() + 20 <= canvas.rightPaddel.getY() + canvas.rightPaddel.getHeight())
                    && (canvas.ballPos.getX() + 20 >= canvas.rightPaddel.getX())) {

                xSpeed = -xSpeed;
                left = false;
                right = true;
            }

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
                    leftPlayerScore++;
                    canvas.resetBallPosition();
                    canvas.message="Right Player Scored!";
                    isBallPause = true;

                    xSpeed = -xSpeed;
                    right = false;
                    left = true;
                }
            }
            if (left) {
                if (canvas.ballPos.getX() >= maxX) {
                    rightPlayerScore++;
                    canvas.resetBallPosition();
                    canvas.message="Left Player Scored!";
                    isBallPause = true;

                    xSpeed = -xSpeed;
                    left = false;
                    right = true;
                }
            }

            maxX = canvas.getSize().width - 20;
            maxY = canvas.getSize().height - 50;

            canvas.ballPos.setX(canvas.ballPos.getX() + xSpeed);
            canvas.ballPos.setY(canvas.ballPos.getY() + ySpeed);

            canvas.setScoresString(rightPlayerScore + " : " + leftPlayerScore);
            if (rightPlayerScore <= 5 && leftPlayerScore <= 5) {
                canvas.shouldRepaintBall = true;
            } else {
                canvas.shouldRepaintBall = false;
            }
            canvas.repaint();
            canvas.revalidate();

            try {
                Thread.sleep(2);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
