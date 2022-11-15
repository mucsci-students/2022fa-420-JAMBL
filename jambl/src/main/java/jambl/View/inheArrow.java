package jambl.View;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

import jambl.View.jamblPanel.MyFrame;

import java.awt.Polygon;
import java.awt.BasicStroke;
import java.awt.Color;

public class inheArrow implements Arrow {

    private static final BasicStroke s = new BasicStroke(3.0f);

     
    /**
     * realArrow - draws a graphical inheritance relationship arrow
     * @param g2d - provides graphics to the function
     * @param x1,y1 - proviees the x and y cordinate of origin class
     * @param x2,y2 - proviees the x and y cordinate of destination class
     */
    @Override
    public void arrow(Graphics2D g2d, int x1, int y1, int x2, int y2, MyFrame destination) {
        x2 = destination.getX();
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
    
}
