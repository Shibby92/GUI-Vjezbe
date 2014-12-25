import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Geometry {
	public int getDirectionX() {
		return directionX;
	}

	public void setDirectionX(int directionX) {
		this.directionX = directionX;
	}

	public int getDirectionY() {
		return directionY;
	}

	public void setDirectionY(int directionY) {
		this.directionY = directionY;
	}

	private int directionX, directionY;
	private int radius;

	public Circle(int positionX, int positionY, int radius, Color color) {
		super(positionX, positionY, color);
		this.radius = radius;
		// stavlja nasumican smjer krugu
		if (Math.random() < 0.5)
			this.directionX = -1;
		else
			this.directionX = 1;
		if (Math.random() < 0.5)
			this.directionY = -1;
		else
			this.directionY = 1;

	}

	public void draw(Graphics g, int frame) {
		g.setColor(super.getColor());
		g.fillOval(super.getPositionX(), super.getPositionY(), this.radius,
				this.radius);
	}

	// odbijanje od okvir prozora
	@Override
	public void move(int frame) {
		if (getPositionX() == 580) {
			directionX = -1;
		}
		if (getPositionX() == 1)
			directionX = 1;
		setPositionX(getPositionX() + directionX);
		if (getPositionY() == 360)
			directionY = -1;
		if (getPositionY() == 1)
			directionY = 1;
		setPositionY(getPositionY() + directionY);
	}

	public boolean collision(Circle other) {
		if ((( other.getPositionX ()<this.getPositionX() + 20 ) && ( other.getPositionX()>this.getPositionX() ))
				&& (( other.getPositionY()<this.getPositionY() + 20 )&&(other.getPositionY()>this.getPositionY())))
			{
			return true;
		}

		return false;
	}

	public void changeDirection() {
		this.setDirectionX(this.getDirectionX() * -1);
	}

}
