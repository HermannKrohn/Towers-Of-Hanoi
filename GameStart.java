import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * Write a description of class GameStart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameStart extends JPanel
{
	JFrame f;
    int counter = 0;
    JButton game;
    JButton mainMenu;
    DrawPanel panel;
    JTextField numRings;
    JLabel numRingsOnTower;
    JButton instructions;
    JButton controls;

    static Ring [] [] tower = new Ring [3] [8];
    int mouseCounter = 1;
    int before = -1, after = -1;
    int secondClick = 0;
    int rightTowerCounter = 0;

    static int userRings = 3; 

    //creates frame and components used in frame such a JButtons, JLabel, and JTextField
    public void frame()
    {
        f = new JFrame();

        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setSize(1000, 500);
        f.setTitle("TOWERS OF HERMANN");
        f.setLocationRelativeTo(null);

        panel = new DrawPanel();
        panel.setLayout(null);

        game = new JButton("Play Game");
        game.addActionListener(new gBtn()); 
        game.setBounds(450,350, 100, 50);
        panel.add(game);

        instructions = new JButton("Instructions");
        instructions.addActionListener(new Instructions()); 
        instructions.setBounds(250, 350, 100, 50);
        panel.add(instructions);

        controls = new JButton("Controls");
        controls.addActionListener(new Controls()); 
        controls.setBounds(650, 350, 100, 50);
        panel.add(controls);

        mainMenu = new JButton("Main Menu");
        mainMenu.addActionListener(new mBtn());
        mainMenu.setBounds(50, 20, 100, 50);

        numRingsOnTower = new JLabel("Number of Rings on tower between 3 and 8:");
        numRingsOnTower.setBounds(325, 250, 300, 50);
        panel.add(numRingsOnTower);

        numRings = new JTextField();
        numRings.setBounds(610, 250, 50, 50);
        numRings.addActionListener(new NumberRings());
        panel.add(numRings);

        f.add(panel);

        f.setVisible(true);
        f.addMouseListener(new Mouse());

    }

    //returns the value of userRings which is the number of rings to preload onto the tower at the start of the game
    public int getUserRings()
    {
        return userRings;
    }

    //nested class with instructions on what to do when "play game" button is pressed. Switches graphics to in-game graphics, removes all buttons from the
    // panel, adds the main menu button to the panel, removes the Jlabel and the JTextField, and constructs the rings
    class gBtn implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            panel.remove(game);
            panel.remove(numRings);
            panel.remove(controls);
            panel.remove(instructions);
            panel.remove(numRingsOnTower);
            for(int i = 0; i < 3; i++)
            {
                for (int j = 0; j < userRings; j++)
                {
                    if(i == 0)
                    {
                        tower[i][j] = new Ring(200 - ((140-15*j)/2), 335-15*j, 140-15*j, 15, 20, 20);
                    }
                    else
                    {
                        tower[i][j] = new Ring(0, 0, 0, 0, 0, 0); 
                    }
                }
            }
            panel.counter = 1;
            panel.add(mainMenu);
            f.repaint();
        }
    }

    //Instructions for when the "main menu" button is pressed. Calls the main menu graphics, removes the main menu button from the panel, adds all buttons 
    //to the panel, adds the JLabel to the panel, and adds the JTextField to the panel
    class mBtn implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            panel.remove(mainMenu);
            panel.counter = 0;
            panel.add(game);
            panel.add(numRingsOnTower);
            panel.add(numRings);
            panel.add(controls);
            panel.add(instructions);
            f.repaint();
        }

    }

    //Understands user inputs from the JTextField and changes the value of userRings
    class NumberRings implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String text = numRings.getText();
            int textInt = 3;
            try
            {
                textInt = Integer.parseInt(text);
            }
            catch(NumberFormatException ev)
            {
               userRings = 3;
            }

            if(textInt >= 3 && textInt <= 8)
            {
                userRings = textInt;
            }
            else if (textInt < 3)
            {
                userRings = 3;
            }
            else if(textInt > 8)
            {
                userRings = 8;
            }

        }
    }
    
    //When the instructions button is clicked, the game, controls, and instructions buttons are removed, the JTextField and JLabel are removed, the main 
    //menu button is button is added to the panel, and the instruction graphics are uploaded onto the panel
    class Instructions implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            panel.remove(game);
            panel.remove(controls);
            panel.remove(numRingsOnTower);
            panel.remove(numRings);
            panel.remove(instructions);
            panel.counter = 3;
            panel.add(mainMenu);
            f.repaint();
        }
    }
    
    //When the controls button is clicked, the game, controls, and instructions buttons are removed, the JTextField and JLabel are removed, the main 
    //menu button is button is added to the panel, and the controls graphics are uploaded onto the panel
    class Controls implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            panel.remove(game);
            panel.remove(controls);
            panel.remove(numRingsOnTower);
            panel.remove(numRings);
            panel.remove(instructions);
            panel.counter = 4;
            panel.add(mainMenu);
            f.repaint();
        }
    }

    //Algorithm that allows movement of rings by understanding mouse inputs. This class is not abstract and cannot override abstract methods...
    //all methods created even though only one is used   
    class Mouse implements MouseListener
    {
        public void mouseEntered(MouseEvent e)
        {

        }

        public void mouseClicked(MouseEvent e)
        {
            if(panel.counter == 1)
            {

                if(mouseCounter % 2 != 0)
                {
                    if((int) (MouseInfo.getPointerInfo().getLocation().getX()) > 0 && (int) (MouseInfo.getPointerInfo().getLocation().getX()) < 486 && (int) (MouseInfo.getPointerInfo().getLocation().getY()) > 0 && (int) (MouseInfo.getPointerInfo().getLocation().getY()) < 650)
                    {
                        before = 0;
                        mouseCounter++;
                        secondClick++;

                    }
                    else if((int) (MouseInfo.getPointerInfo().getLocation().getX()) > 486 && (int) (MouseInfo.getPointerInfo().getLocation().getX()) < 790 && (int) (MouseInfo.getPointerInfo().getLocation().getY()) > 0 && (int) (MouseInfo.getPointerInfo().getLocation().getY()) < 650)
                    {
                        before = 1;
                        mouseCounter++;
                        secondClick++;

                    }
                    else if((int) (MouseInfo.getPointerInfo().getLocation().getX()) > 790 && (int) (MouseInfo.getPointerInfo().getLocation().getX()) < 1150 && (int) (MouseInfo.getPointerInfo().getLocation().getY()) > 0 && (int) (MouseInfo.getPointerInfo().getLocation().getY()) < 650)
                    {
                        before = 2;
                        mouseCounter++;
                        secondClick++;

                    }
                    if(tower[before][0].getY() == 0)
                    {
                        mouseCounter--;
                        secondClick--;
                        before = -1;
                    }
                }
                else if(mouseCounter % 2 == 0)
                {
                    if(before != -1 && (int) (MouseInfo.getPointerInfo().getLocation().getX()) > 0 && (int) (MouseInfo.getPointerInfo().getLocation().getX()) < 486 && (int) (MouseInfo.getPointerInfo().getLocation().getY()) > 188 && (int) (MouseInfo.getPointerInfo().getLocation().getY()) < 634)
                    {
                        after = 0;
                        mouseCounter++;
                        secondClick++;
                    }
                    else if(before != -1 && (int) (MouseInfo.getPointerInfo().getLocation().getX()) > 486 && (int) (MouseInfo.getPointerInfo().getLocation().getX()) < 790 && (int) (MouseInfo.getPointerInfo().getLocation().getY()) > 188 && (int) (MouseInfo.getPointerInfo().getLocation().getY()) < 634)
                    {
                        after = 1;
                        mouseCounter++;
                        secondClick++;
                    }
                    else if(before != -1 && (int) (MouseInfo.getPointerInfo().getLocation().getX()) > 790 && (int) (MouseInfo.getPointerInfo().getLocation().getX()) < 1106 && (int) (MouseInfo.getPointerInfo().getLocation().getY()) > 188 && (int) (MouseInfo.getPointerInfo().getLocation().getY()) < 634)
                    {
                        after = 2;
                        mouseCounter++;
                        secondClick++;
                    }
                }
            }

            if(secondClick == 2)
            {
                secondClick = 0;
                int index = -1;
                Ring temp = new Ring(0,0,0,0,0,0);
                if(before == after)
                {
                    before = -1;
                    after = -1;
                }
                else{
                    for(int i = userRings-1; i >= 0; i--)
                    {
                        if(tower[before][i].getY() != 0)
                        {
                            index = i;
                            temp = tower[before][i];
                            break;
                        }
                    }
                    if(index == -1)
                    {
                        before = -1;
                        after = -1;
                    }
                    else
                    {
                        for(int i = userRings-1; i >= -1; i--)
                        {
                            if(i == -1)
                            {
                                tower[before][index] = tower[after][i+1];
                                tower[after][i+1] = temp;
                                tower[after][i+1].yLocation += 15*(index-i-1);
                                before = -1;
                                after = -1;
                                index = -1;
                                break;
                            }
                            else if(tower[after][i].getHeight() != 0)
                            {
                                if(tower[before][index].getHeight() < tower[after][i].getHeight())
                                {
                                    tower[before][index] = tower[after][i+1];
                                    tower[after][i+1] = temp;
                                    tower[after][i+1].yLocation -= 15*(i - index+1);
                                    before = -1;
                                    after = -1;
                                    index = -1;
                                    break;
                                }
                                break;
                            }
                        }
                    }
                }

                if(tower[2][userRings-1].getY() != 0)
                {
                    panel.counter = 2;
                }
            }

            f.repaint();
        }

        public void mouseReleased(MouseEvent e)
        {

        }

        public void mousePressed(MouseEvent e)
        {

        }

        public void mouseExited(MouseEvent e)
        {

        }
    }

    //starts the game/program
    public static void main(String [] args)
    {
        GameStart run = new GameStart();

        run.frame();
    }
}
