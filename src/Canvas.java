
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
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
public class Canvas extends JPanel {

    Shape ballPos;
    JPanel leftPaddel;
    JPanel rightPaddel;
    String message;
    String scoresString;
    boolean shouldRepaintBall;
    
    int canvasWidth;
    int canvasHeight;

    public Canvas(int width, int height) {
        canvasHeight = height;
        canvasWidth = width;
        
        super.setBounds(0, 0, width, height);
        super.setBackground(Color.BLACK);
        super.setLayout(null);
        this.ballPos = new Shape(width / 2, 60);
        this.ballPos.color = Color.ORANGE;

        leftPaddel = new JPanel();
        leftPaddel.setBounds(50, 100, 20, 150);
        leftPaddel.setBackground(Color.YELLOW);
        leftPaddel.setVisible(true);
        super.add(leftPaddel);

        rightPaddel = new JPanel();
        rightPaddel.setBounds(width - 100 - 20, 50, 20, 150);
        rightPaddel.setBounds(width - 50 - 20, 100, 20, 150);
        rightPaddel.setBackground(Color.CYAN);
        rightPaddel.setVisible(true);
        super.add(rightPaddel);

        message = "";
        scoresString = ":";
        shouldRepaintBall = true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(ballPos.color);
        if (shouldRepaintBall) {
            g.fillOval(ballPos.x, ballPos.y, 20, 20);
        }

        g.setFont(new Font("Segoe UI", 10, 45));
        g.drawString(message, 400, 250);

        g.setFont(new Font("Segoe UI", 10, 45));
        g.drawString(scoresString, 500, 50);

    }

    public void setScoresString(String scoresString) {
        this.scoresString = scoresString;
    }
    
    public void resetBallPosition(){
        ballPos.setX(canvasWidth / 2);
        ballPos.setY(60);
    }

    Color getRandomColor() {
        return new Color((int) (Math.random() * 255 + 0), (int) (Math.random() * 255 + 0), (int) (Math.random() * 255 + 0));
    }
}
