import java.awt.Color;
import java.awt.Graphics;


public class Geometry {

	private int positionX;
	private int positionY;
	private Color color;
	
	public Geometry(int positionX, int positionY, Color color){
		this.positionX = positionX;
		this.positionY = positionY;
		this.color = color;
	}

	
	public void draw(Graphics g, int frame) {
	
		return; // we just need this so the polymorphism works
	}

	
	public void move(int frame) {
		positionX += frame;
		positionY += frame;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
}
