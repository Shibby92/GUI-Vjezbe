import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Geometry {
	private int directionX,directionY;
	private int radius;
	public Circle(int positionX, int positionY, int radius, Color color) {
		super(positionX, positionY, color);
		this.radius = radius;
		//stavlja nasumican smjer krugu
		if(Math.random()<0.5)
			this.directionX=-1;
		else
			this.directionX=1;
		if(Math.random()<0.5)
			this.directionY=-1;
		else
			this.directionY=1;
		
	}
	public void draw(Graphics g, int frame){
			g.setColor(super.getColor());
			g.fillOval(super.getPositionX(), super.getPositionY(), this.radius, this.radius);
	}
	// odbijanje od okvir prozora
	@Override
	public void move (int frame){
		if (getPositionX() == 580 ){
			directionX = -1;
			}
		if(getPositionX() == 1)
			directionX=1;
		setPositionX(getPositionX()+directionX);
		if (getPositionY() == 360)
			directionY = -1;
		if(getPositionY() == 1)
			directionY=1;
		setPositionY(getPositionY()+directionY);
	}

}
