import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class DrawCanvas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DrawPanel extends JPanel 
{
    public static int counter = 0;
    GameStart GS = new GameStart();
    
    //Graphics for all stages of the project. Includes the main menu graphics, the tower graphics,
    //the rings graphics, and the winning screen graphics
    public void paintComponent(Graphics g)
    {
        if(counter == 0 )//main menu
        {
            g.setColor(Color.WHITE);
            g.fillRect(0,0,1000,500);
            Graphics2D g2d = (Graphics2D) g;
            g.setColor(Color.BLACK);
            g.setFont(new Font("Verdana", Font.BOLD, 40));
            g.drawString("TOWERS", 400, 100);
            g.drawString("OF", 470, 140);
            g.drawString("HANOI", 420, 180);
            g.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(3));
            g2d.drawLine(400, 168, 590, 168);
            g.setFont(new Font("Verdana", Font.BOLD, 40));
            g.setColor(Color.BLACK);
            g.drawString("HERMANN", 380, 215);   
        }
        else if(counter == 1)//in-game
        {

            g.setColor(Color.WHITE);
            g.fillRect(0,0,1000,500);
            Color towerBrown = new Color(139,69,19);
            g.setColor(towerBrown);
            g.fillRect(100,350, 200, 50);
            g.fillRect(400,350,200,50);
            g.fillRect(700,350,200,50);
            g.fillRect(195,100,10,300);
            g.fillRect(495,100,10,300);
            g.fillRect(795,100,10,300);
       
            for(int i = 0; i < 3; i++)
            {
                for(int j = 0; j < GS.getUserRings(); j++)
                {
                    Color ringRed = new Color(178, 34, 34);             
                    g.setColor(ringRed);
                    g.fillRoundRect(200 + 300 * i - (GS.tower[i][j].getHeight()/2), GS.tower[i][j].getY(), 
                        GS.tower[i][j].getHeight(), GS.tower[i][j].getWidth(), GS.tower[i][j].getAH(), GS.tower[i][j].getAW());
                    g.setColor(Color.BLACK);
                    g.drawRoundRect(200 + 300 * i- (GS.tower[i][j].getHeight()/2), GS.tower[i][j].getY(), GS.tower[i][j].getHeight(),
                        GS.tower[i][j].getWidth(), GS.tower[i][j].getAH(), GS.tower[i][j].getAW());
                }
            }
        }
        else if(counter == 2)//winning screen
        {
            g.setColor(Color.RED);
            g.fillRect(0, 0, 1000, 500);
            g.setColor(Color.BLUE);
            g.setFont(new Font("Verdana", Font.BOLD, 100));
            g.drawString("You Win", 250, 250);
        }
        else if(counter == 3)//instructions
        {
            g.setColor(Color.WHITE);
            g.fillRect(0,0,1000,500);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Verdana", Font.BOLD, 50));
            g.drawString("Instructions", 330, 100);
            g.setFont(new Font("Verdana", Font.BOLD, 20));
            g.drawString("The objective of the game is to move all the rings from the left-most tower", 100, 175);
            g.drawString("to the right-most tower. However a smaller sized ring can never be", 100, 195);
            g.drawString("underneath a larger sized ring.", 100, 215);
        }
        else if(counter == 4)//controls
        {
            g.setColor(Color.WHITE);
            g.fillRect(0,0,1000,500);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Verdana", Font.BOLD, 50));
            g.drawString("Controls", 375, 100);
            g.setFont(new Font("Verdana", Font.BOLD, 20));
            g.drawString("In order to move the rings, you must first click on a tower to pick up the ", 100, 175);
            g.drawString("ring at the highest position at that tower. Then click on another tower to", 100, 195);
            g.drawString("place the picked up ring at the new tower if the move is allowed. The ring ", 100, 215);
            g.drawString("must be smaller than the ring below it if placed. If you attempt to pick ", 100, 235);
            g.drawString("up a ring at a tower that does not have any rings on it, then the click will", 100, 255);
            g.drawString("be ignored and the following click will pick a ring up at a tower that has", 100, 275);
            g.drawString("rings on it.", 100, 295);
        }
        

    }


}