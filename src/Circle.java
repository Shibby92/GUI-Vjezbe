import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Geometry {

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
		this.setPositionY(this.getPositionY()+frame);
	}

}
