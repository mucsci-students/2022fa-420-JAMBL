package jambl.Model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class RelationshipArrow extends JPanel {

	 
    draggableBox originClassBox;
    draggableBox destinationClassBox;
    Point originLocation;
    Point destinationLocation;
    Relationship.Type type;
    

    //constructor

    public RelationshipArrow() {
    	
    }
    
    public void setBox(draggableBox origin, draggableBox destination,  Relationship.Type type ) {
    	this.originClassBox = origin;
    	this.destinationClassBox = destination;
    	this.type = type;
    	originLocation = origin.getPosition();
    	destinationLocation = destination.getPosition();
    	
    }
    
  
public int[] getBoxLocation2( draggableBox originClassBox, draggableBox destinationClassBox) {
	  
	int[] loc = new int[4];
	   loc[0] = originClassBox.getX() + originClassBox.getWidth();
	   loc[1] = originClassBox.getY() + originClassBox.getHeight() / 2 ;
	   loc[2] = destinationClassBox.getX();
	   loc[3] = destinationClassBox.getY() + destinationClassBox.getHeight() / 2;
	return loc;
	
   }

public Point[] getBoxLocation (draggableBox classBox) {
		
	Point[] loc = new Point[2];
	loc[0].x = classBox.getPosition().x;
	loc[1].y = classBox.getPosition().y;
	return loc;
	
}


   protected void paintComponent(Graphics g) {
	   
	   
	   super.paintComponent(g);
	   Graphics2D g2d = (Graphics2D)g;
	   g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	   g2d.setColor(Color.BLACK);
	
		// int[] loc = getBoxLocation(originClassBox, destinationClassBox);
		
		  
		  if(type == Relationship.Type.AGGR) {
			  
			  g2d.setColor(Color.black);
			  g2d.setStroke(new BasicStroke(2.0f));
			  g2d.draw(new Line2D.Double(originClassBox.getX() ,originClassBox.getY(), destinationClassBox.getX(), destinationClassBox.getY()));
			  System.out.println(originClassBox.getPosition().x+"1x"+ originClassBox.getPosition().y+"1y"+ destinationClassBox.getPosition().x+"2x"+ destinationClassBox.getPosition().y+"2y");
			  
			  
			  /*
              g2d.setColor(Color.black);
			  g2d.setStroke(new BasicStroke(2.0f));
              g2d.draw(new Line2D.Double(loc[0], loc[1], loc[2]-125, loc[3]));
			  Polygon poly = new Polygon();
			  poly.addPoint(loc[2]-125, loc[3]);
			  poly.addPoint(loc[2]-100, loc[3]-20);
			  poly.addPoint(loc[2], loc[3]);
			  poly.addPoint(loc[2]-100, loc[3]+20);
			  g2d.drawPolygon(poly);*/
			  
		  }/* else  if(type == Relationship.Type.COMP) {
			  
			  int x = destinationLocation.x;
			  int y = destinationLocation.y;
			  g2d.setColor(Color.black);
			  g2d.setStroke( new BasicStroke(2.0f));
			  g2d.draw(new Line2D.Double(loc[0], loc[1], loc[0]+75, loc[1]));
			  Polygon poly = new Polygon();
			  poly.addPoint(x, y);
			  poly.addPoint(x+100, y-20);
			  poly.addPoint(x+125, y);
			  poly.addPoint(x+100, y+20);
			  g2d.fillPolygon(poly);
		  } else if (type == Relationship.Type.INHE) {
			  
			  int x = destinationLocation.x;
			  int y = destinationLocation.y;
			  g2d.setColor(Color.black);
			  g2d.setStroke( new BasicStroke(3.0f));
			  g2d.drawLine(loc[0], loc[1], loc[2], loc[3]);
			  g2d.draw(new Line2D.Double(loc[0], loc[1], loc[0]+75, loc[1]));
			  Polygon poly = new Polygon();
			  poly.addPoint(x+75, y-10);
			  poly.addPoint(x+100, y);
			  poly.addPoint(x+75, y+10);
			  g2d.fillPolygon(poly);
			  
		  }else {
			  
			  int x = destinationLocation.x;
			  int y = destinationLocation.y;
			  g2d.setColor(Color.black);
			  g2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, new float[] { 2.0f, 3.0f }, 0.0f));
			  g2d.draw(new Line2D.Double(loc[0], loc[1], loc[0]+75, loc[1]));
			  Polygon poly = new Polygon();
			  poly.addPoint(x+75, y);
			  poly.addPoint(x+100, y-20);
			  poly.addPoint(x+125, y);
			  poly.addPoint(x+100, y+20);
			  g2d.drawPolygon(poly);
			  g2d.fillPolygon(poly);
			  
			  
		  }*/
		   
   }
	   
   
	   public int[] getMidPoint(draggableBox class1) {
		   
		   int[] cl = new int[2];
		  cl[1] =  class1.getX() + class1.getWidth() / 2;
	      cl[2] = class1.getY() + class1.getHeight() / 2;
		return cl;
		   
	   }
	   public int[] boxLocation(draggableBox class1) {
		  
		  int[] cl = new int[2];
		  cl[0] = class1.getX();
		  cl[1] = class1.getY();
		return cl;
	   }
	 /*/  
	   public void  triangle(Graphics g) {
			 Graphics2D g2d = (Graphics2D) g;
			  int x = 200;
			  int y = 200;
			  g2d.setColor(Color.black);
			  Polygon poly = new Polygon();
			  poly.addPoint(x+75, y-10);
			  poly.addPoint(x+100, y);
			  poly.addPoint(x+75, y+10);
			  g2d.fillPolygon(poly);
			  g2d.setStroke(new BasicStroke(3.0f));
			  
			  g2d.draw(new Line2D.Double(x, y, x+75, y));
			  //addToPanel(g2d);
			  //return  g2d;
		 }*/
		 
	   

   


}
