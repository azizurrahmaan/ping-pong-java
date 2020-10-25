
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azizu
 */
public class Canvas extends JPanel{
    Shape ballPos;
    Shape rightBar;
    Shape leftBar;

    public Canvas() {
        this.ballPos = new Shape(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2);
        this.ballPos.color = getRandomColor();
        
        this.leftBar = new Shape(50,100);
        this.leftBar.color = getRandomColor();
        
        this.rightBar = new Shape(1250,100);
        this.rightBar.color = getRandomColor();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(ballPos.color);
        g.fillOval(ballPos.x, ballPos.y, 20,20);
        
        g.setColor(rightBar.color);
        g.fillRect(rightBar.x, rightBar.y, 50, 200);
        
        g.setColor(leftBar.color);
        g.fillRect(leftBar.x, leftBar.y, 50, 200);
        
        
    }
    
    Color getRandomColor(){
        return new Color((int )(Math. random() * 255 + 0), (int )(Math. random() * 255 + 0), (int )(Math. random() * 255 + 0));
    }
}
