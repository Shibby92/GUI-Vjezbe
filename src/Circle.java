import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Geometry {

	private int directionX, directionY, centreX, centreY;;
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
		this.centreX = getPositionX() + (this.radius / 2);
		this.centreY = getPositionY() + (this.radius / 2);

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

	// da li se desio sudar
	public boolean collision(Circle other) {
		if (Math.abs((this.getPositionX() + this.radius / 2)
				- (other.getPositionX() + other.radius / 2)) == 20
				&& Math.abs((this.getPositionY() + this.radius / 2)
						- (other.getPositionY()+other.radius/2)) < 20) {
			System.out.println(this.getCentreX() - other.getCentreX());
			return true;
		}

		return false;
	}

	// mijenjanje smjera kuglice
	public void changeDirection() {
		this.setDirectionX(this.getDirectionX() * -1);
	}

	public int getCentreX() {
		return centreX;
	}

	public void setCentreX(int centreX) {
		this.centreX = centreX;
	}

	public int getCentreY() {
		return centreY;
	}

	public void setCentreY(int centreY) {
		this.centreY = centreY;
	}

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

}
