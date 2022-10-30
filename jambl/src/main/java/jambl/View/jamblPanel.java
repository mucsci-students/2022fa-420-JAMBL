package jambl.View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.Polygon;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;

import jambl.Model.Relationship;
import jambl.Model.draggableBox;




public class jamblPanel extends JDesktopPane {

    private HashSet<MyFrame> frames = new HashSet<MyFrame>();
    private static final Stroke s = new BasicStroke(3.0f);
    private static final Stroke dash = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 3.0f, new float[] { 7.0f, 5.0f }, 0.0f);
    

    public jamblPanel() {
        this.setPreferredSize(new Dimension(640, 480));
        
    }

    public void  addNewFrame(MyFrame frm/*String name, JTextArea stuff*/){
        frames.add(frm);
        add(frm);
        /*MyFrame newF = new MyFrame(name, 100, 100);
        newF.add(stuff);
        add(newF);
        frames.add(newF);*/
        revalidate();
        repaint();
    }

    public void removeBox(MyFrame frm){
        Iterator<MyFrame> itr = frames.iterator();
        while(itr.hasNext()){
            MyFrame ele = itr.next();
            if(ele.getName().equals(frm.getName())){
                ele.dispose();
                itr.remove();
                remove(ele);
                revalidate();
                repaint();
            }
        }
    }

    //gets the set of frames
    public HashSet<MyFrame> getFrames() {
        return frames;
    }

    /**
     * PaintCompinent - draws all graphical components
     */

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        
        for (MyFrame frm: frames) { //loops thru all frames to interpret the relInfo to draw the arrows
            if (frm.relInfo != null) {
                for (int i = 0; i < frm.relInfo.size(); i += 2) {
                    MyFrame dest = getThisFrame((frm.relInfo.get(i)));
                    Relationship.Type type = Relationship.Type.valueOf(frm.relInfo.get(i + 1));
                    drawArrow(g2d, frm, dest, type);
                }
            }
        }
    }  

    /**
     * MyFrame - creates the frame box for each class
     */

    public final class MyFrame extends JInternalFrame {
        String className;
        ArrayList<String> relInfo = new ArrayList<String>(); //list of strings that contain the destination and type for all relationships of that class [dest1,type1,dest2,type2,...]

        public MyFrame(String name, ArrayList<String> relInfo, int x, int y) {
            super(name);
            this.className = name;
            this.relInfo = relInfo;
            this.setSize(160, 100);
            this.setLocation(x, y);
            this.setVisible(true);
            this.resizable = true;
            
            this.addComponentListener(new ComponentAdapter() {
    
                @Override
                public void componentMoved(ComponentEvent e) {
                    jamblPanel.this.repaint();
                }
            });
        }

        public String getName() {
            return className;
        }
    }

     /**
     * realArrow - draws a graphical aggregation relationship arrow
     * @param g2d - provides graphics to the function
     * @param x1,y1 - proviees the x and y cordinate of origin class
     * @param x2,y2 - proviees the x and y cordinate of destination class
     */

    public Graphics2D  aggrArrow (Graphics2D g2d,  int x1, int y1, int x2, int y2) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.black);
        Polygon poly = new Polygon();
        g2d.setStroke(s);
        poly.addPoint(x2-32, y2);
        poly.addPoint(x2-15, y2+10);
        poly.addPoint(x2, y2);
        poly.addPoint(x2-15, y2 -10);
        g2d.drawPolygon(poly);
        g2d.draw(new Line2D.Double(x1, y1, x2-33, y2));    
        return  g2d;
    }

    /**
     * realArrow - draws a graphical composition relationship arrow
     * @param g2d - provides graphics to the function
     * @param x1,y1 - proviees the x and y cordinate of origin class
     * @param x2,y2 - proviees the x and y cordinate of destination class
     */
    
    public Graphics2D  compArrow(Graphics2D g2d,  int x1, int y1, int x2, int y2) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.black);
        Polygon poly = new Polygon();
        poly.addPoint(x2-32, y2);
        poly.addPoint(x2-15, y2+10);
        poly.addPoint(x2, y2);
        poly.addPoint(x2-15, y2 -10);
        g2d.fillPolygon(poly);
        g2d.setStroke(s);
        g2d.draw(new Line2D.Double(x1, y1, x2-31, y2));    
        return  g2d;
    }
    
    /**
     * realArrow - draws a graphical inheritance relationship arrow
     * @param g2d - provides graphics to the function
     * @param x1,y1 - proviees the x and y cordinate of origin class
     * @param x2,y2 - proviees the x and y cordinate of destination class
     */
    
    public void  inheArrow (Graphics2D g2d,  int x1, int y1, int x2, int y2) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.black);
        Polygon poly = new Polygon();
        poly.addPoint(x2-20, y2+10);
        poly.addPoint(x2, y2);
        poly.addPoint(x2-20, y2-10);
        g2d.fillPolygon(poly);
        g2d.setStroke(s);
        g2d.draw(new Line2D.Double(x1, y1, x2-20, y2));
     
    }

    /**
     * realArrow - draws a graphical realization relationship arrow
     * @param g2d - provides graphics to the function
     * @param x1,y1 - proviees the x and y cordinate of origin class
     * @param x2,y2 - proviees the x and y cordinate of destination class
     */
     
    public void  realArrow (Graphics2D g2d,  int x1, int y1, int x2, int y2) {
 
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.black);
        Polygon poly = new Polygon();
        poly.addPoint(x2-20, y2+10);
        poly.addPoint(x2, y2);
        poly.addPoint(x2-20, y2-10);
        g2d.fillPolygon(poly);
        g2d.setStroke(dash);
        g2d.draw(new Line2D.Double(x1, y1, x2-20, y2));
    
    }
    /**
     * getThisFrame - gets the frame of a class from sets of frmaes by name
     * @param name - the name of the frame 
     * @return -  frame of a class , null if not found.
     */

    public MyFrame getThisFrame (String name) {
        Iterator<MyFrame> itr = frames.iterator();
        while (itr.hasNext()) {
            MyFrame frm = itr.next();
            if (frm.getName().equals(name)) {
                return frm;
            }
        }
        return null;
    }

    /**
     * drawArrow - choose which relationship type arrow is drawn
     * @param g2d - provides  the method graphics to draw the arrow
     * @param origin - origin class that the line will be starting from 
     * @param destination - destination class that the line will be drawn to
     * @param type - relationship type
     */
    
    public void drawArrow (Graphics2D g2d, MyFrame origin, MyFrame destination, Relationship.Type type) {

        int x1 = origin.getX() + origin.getWidth()/2;
        int y1 = origin.getY() + origin.getHeight()/2;
        int y2 = destination.getY() + destination.getHeight()/2; 

        if (type.toString().equals("AGGR")) {
            aggrArrow(g2d, x1, y1, destination.getX(), y2);
        }
        if (type.toString().equals("COMP")) {
            compArrow(g2d, x1, y1, destination.getX(), y2);
        }
        if (type.toString().equals("INHE")) {
            inheArrow(g2d, x1, y1, destination.getX(), y2);
        } 
        if (type.toString().equals("REAL")) {
            realArrow(g2d, x1, y1, destination.getX(), y2);
        }
    }
}