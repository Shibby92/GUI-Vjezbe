import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Geometry {
	private int directionX=1,directionY = 1;

	private int radius;
	public Circle(int positionX, int positionY, int radius, Color color) {
		super(positionX, positionY, color);
		this.radius = radius;
	}
	public void draw(Graphics g, int frame){
			g.setColor(super.getColor());
			g.fillOval(super.getPositionX(), super.getPositionY(), this.radius, this.radius);
	}
	@Override
	public void move (int frame){
		if (getPositionX() == 579 ){
			directionX = -1;
			}
		if(getPositionX() == 1)
			directionX=1;
		setPositionX(getPositionX()+directionX);
		if (getPositionY() == 359)
			directionY = -1;
		if(getPositionY() == 1)
			directionY=1;
		setPositionY(getPositionY()+directionY);
	}

}
