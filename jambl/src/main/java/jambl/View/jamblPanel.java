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
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;

import jambl.Model.draggableBox;

import java.awt.RenderingHints;

/** @see http://stackoverflow.com/questions/3951383 */
public class jamblPanel extends JDesktopPane {

    private HashSet<MyFrame> frames = new HashSet<MyFrame>();
    //private static final Stroke s = new BasicStroke(4.0f);
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

    public HashSet<MyFrame> getFrames() {
        return frames;
    }


    /*@Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.lightGray);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(Color.blue);
        g2d.setStroke(s);
        int x1 = one.getX() + one.getWidth() / 2;
        int y1 = one.getY() + one.getHeight() / 2;
        int x2 = two.getX() + two.getWidth() / 2;
        int y2 = two.getY() + two.getHeight() / 2;
        g2d.drawLine(x1, y1, x2, y2);
    }*/
    

    public final class MyFrame extends JInternalFrame {
        String className;

        public MyFrame(String name, int x, int y) {
            super(name);
            this.className = name;
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
}