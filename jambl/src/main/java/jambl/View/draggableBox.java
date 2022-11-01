/*
 * @projectDescription	A program to make UML diagrams
 * 
 * @author	John Shenk
 * @version 0.0.1
 * @dateLastModified October 21, 2022
 * 
 * @classDescription A draggable box to graphically represent a class
 */

package jambl.View;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import jambl.Model.Class;

import java.awt.Point;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class draggableBox extends JTextArea{
    /**
     * Not urgent, but maybe find a way to lock the boxes in place in view, hence this variable,
     *          for the sake of "robustness"
     * 
        //Whether or not this component is draggable
        private boolean draggable = true;
     */

    //Location of mouse pointer 
    protected Point anchor;
    //Cursor for dragging
    protected Cursor dragCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
    //The parent class. Used for setting x and y 
    public Class maker;
    //whether or not this box is used to represent a relationship; used when deleting box to remove arrows
    private boolean inRelationship; 

    private Point relPoint;
    
    /**
     * Creates a new Box
     * @param parent The class that created this box. Need this info to store x,y coordinates
     * @param name The name to give this box (usually the class name)
     * @param contents The contents of this box
     * @return n/a
     * @precondition The class creating this boc exists
     */
    public draggableBox(Class parent, String name, String contents){
        setText(contents);
        setName(name);
        setEditable(false);
		setEnabled(false);
		setFont(new Font("Tahoma", Font.BOLD, 15));
		setBounds(10, 10, 100, 100);
		setBorder(BorderFactory.createBevelBorder(0));
		setVisible(true);
		setOpaque(true);
        maker = parent;
        inRelationship = false;
    }

    /**
     * Adds drag listeners to this box
     */
    private void addDragListeners(){
        addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e){
                anchor = e.getPoint();
                setCursor(dragCursor);
            }

            public void mouseDragged(MouseEvent e){
                int x = anchor.x;
                int y = anchor.y;
                
                Point parentOnScreen = getParent().getLocationOnScreen();
                Point mouseOnScreen = e.getLocationOnScreen();
                Point newPosition = new Point(mouseOnScreen.x - parentOnScreen.x - 
                x, mouseOnScreen.y - parentOnScreen.y - y);
                setLocation(newPosition);
                
                maker.addX(newPosition.x);
                maker.addY(newPosition.y);

                //This code commented out as it is not needed for GUI. For debugging you are free to uncomment

                //System.out.println("Current position: " + position.x + "," + position.y);
                //System.out.println("Maker's's x and y changed to: " + maker.getX() + "," + maker.getY());
            }
        });
    }

    public void setRelStatus(boolean rel, int x, int y){
        inRelationship = rel;
        relPoint.setLocation(x, y);
    }

    //Returns whether or not this box is in a relationship
    public boolean isInRelationship(){
        return inRelationship;
        
    }

    public Point getRelationshipCoordinates(){
        return relPoint;
    }
}

