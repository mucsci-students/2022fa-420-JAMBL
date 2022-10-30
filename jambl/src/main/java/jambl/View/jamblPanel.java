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

import java.awt.RenderingHints;

/** @see http://stackoverflow.com/questions/3951383 */
public class jamblPanel extends JDesktopPane {

    private HashSet<MyFrame> frames = new HashSet<MyFrame>();
    private static final Stroke s = new BasicStroke(4.0f);
    private static final Stroke dash = new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 3.0f, new float[] { 7.0f, 5.0f }, 0.0f);
    //private MyFrame one = new MyFrame("One", 100, 100);
    //private MyFrame two = new MyFrame("Two", 400, 240);

    public jamblPanel() {
        this.setPreferredSize(new Dimension(640, 480));
        //this.add(one);
        //this.add(two);
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


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        //g2d.setColor(Color.lightGray);
        //g2d.fillRect(0, 0, getWidth(), getHeight());
        //g2d.setColor(Color.blue);
        //g2d.setStroke(s);
        //int x1 = one.getX() + one.getWidth() / 2;
        //int y1 = one.getY() + one.getHeight() / 2;
        //int x2 = two.getX() + two.getWidth() / 2;
        //int y2 = two.getY() + two.getHeight() / 2;
        //g2d.drawLine(x1, y1, x2, y2);
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

     // aggregation relationship arrow
    public Graphics2D  aggrArrow (Graphics2D g2d,  int x1, int y1, int x2, int y2) {
        g2d.setColor(Color.black);
        Polygon poly = new Polygon();
        poly.addPoint(x2-32, y2);
        poly.addPoint(x2-15, y2+10);
        poly.addPoint(x2, y2);
        poly.addPoint(x2-15, y2 -10);
        g2d.drawPolygon(poly);
        g2d.setStroke(s);
        g2d.draw(new Line2D.Double(x1, y1, x2-32, y2));    
        return  g2d;
    }

    //composition relationship arrow
    public Graphics2D  compArrow(Graphics2D g2d,  int x1, int y1, int x2, int y2) {
        g2d.setColor(Color.black);
        Polygon poly = new Polygon();
        poly.addPoint(x2-32, y2);
        poly.addPoint(x2-15, y2+10);
        poly.addPoint(x2, y2);
        poly.addPoint(x2-15, y2 -10);
        g2d.fillPolygon(poly);
        g2d.setStroke(s);
        g2d.draw(new Line2D.Double(x1, y1, x2-32, y2));    
        return  g2d;
    }

    // inheritance relationship arrow
    public void  inheArrow (Graphics2D g2d,  int x1, int y1, int x2, int y2) {
        g2d.setColor(Color.black);
        Polygon poly = new Polygon();
        poly.addPoint(x2-20, y2+10);
        poly.addPoint(x2, y2);
        poly.addPoint(x2-20, y2-10);
        g2d.fillPolygon(poly);
        g2d.setStroke(s);
        g2d.draw(new Line2D.Double(x1, y1, x2-20, y2));
     
    }

    // realization relationship arrow
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

    //method that returns the frame with the name passed as parameter. null if not found.
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

    //method to choose which arrow type is drawn
    public void drawArrow (Graphics2D g2d, MyFrame origin, MyFrame destination, Relationship.Type type) {
        if (type.toString().equals("AGGR")) {
            aggrArrow(g2d, origin.getX(), origin.getY(), destination.getX(), destination.getY());
        }
        if (type.toString().equals("COMP")) {
            compArrow(g2d, origin.getX(), origin.getY(), destination.getX(), destination.getY());
        }
        if (type.toString().equals("INHE")) {
            inheArrow(g2d, origin.getX(), origin.getY(), destination.getX(), destination.getY());
        } 
        if (type.toString().equals("REAL")) {
            realArrow(g2d, origin.getX(), origin.getY(), destination.getX(), destination.getY());
        }
    }
}