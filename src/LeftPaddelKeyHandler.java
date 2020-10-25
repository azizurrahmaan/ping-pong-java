
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
public class LeftPaddelKeyHandler implements KeyListener {

    GameArena gameArena;
    int speed;

    public LeftPaddelKeyHandler(GameArena g) {
        this.gameArena = g;
        speed = 8;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        moveBar(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    void moveBar(int keyCode) {
        switch (keyCode) {
            //left bar up W
            case 87: {

                gameArena.canvas.leftPaddel.setFocusable(true);
                if (gameArena.canvas.leftPaddel.getY() >= speed) {
                    gameArena.canvas.leftPaddel.setLocation(gameArena.canvas.leftPaddel.getX(), gameArena.canvas.leftPaddel.getY() - speed);
                }
                break;
            }
            //left bar down S
            case 83: {

                gameArena.canvas.leftPaddel.setFocusable(true);
                if (gameArena.canvas.leftPaddel.getY() + gameArena.canvas.leftPaddel.getHeight() <= gameArena.canvas.getHeight() - 30) {
                    gameArena.canvas.leftPaddel.setLocation(gameArena.canvas.leftPaddel.getX(), gameArena.canvas.leftPaddel.getY() + speed);
                }
                break;
            }
            //right bar up arrow
            case 38: {
                gameArena.canvas.rightPaddel.setFocusable(true);
                if (gameArena.canvas.rightPaddel.getY() >= speed) {
                    gameArena.canvas.rightPaddel.setLocation(gameArena.canvas.rightPaddel.getX(), gameArena.canvas.rightPaddel.getY() - speed);
                }
                break;
            }
            //right bar DOWN Arrow
            case 40: {
                gameArena.canvas.rightPaddel.setFocusable(true);
                if (gameArena.canvas.rightPaddel.getY() + gameArena.canvas.rightPaddel.getHeight() <= gameArena.canvas.getHeight() - 30) {
                    gameArena.canvas.rightPaddel.setLocation(gameArena.canvas.rightPaddel.getX(), gameArena.canvas.rightPaddel.getY() + speed);
                }
                break;
            }
            case 32: {
                gameArena.ballCtrl.isBallPause = !gameArena.ballCtrl.isBallPause;
                if (gameArena.ballCtrl.isBallPause) {
                    gameArena.canvas.message = "Game Paused";
                }else{
                    gameArena.canvas.message = "";
                }
                break;
            }
        }
    }
}
