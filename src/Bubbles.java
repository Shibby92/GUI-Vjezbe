import java.awt.Color;

public class Bubbles {
	private Circle[] bubbles;
	private static int counter = 0;
	static int numberOfCollisions = 0;

	public Bubbles(int numBubbles) {
		this.bubbles = new Circle[numBubbles];
		for (int i = 0; i < numBubbles; i++) {
			addBubble(this.bubbles, i);
			this.counter++;
		}

	}

	public Circle[] getBubbles() {
		return bubbles;
	}

	public void setBubbles(Circle[] bubbles) {
		this.bubbles = bubbles;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Bubbles.counter = counter;
	}

	public void addBubble(Circle[] bubb, int index) {
		bubb[index] = new Circle((int) (Math.random() * (600 - 100)),
				(int) (Math.random() * (400 - 100)), 20, Color.RED);
	}

	public void expandBubble() {
		Circle[] tmp = new Circle[this.bubbles.length + 1];
		for (int i = 0; i < tmp.length; i++) {
			if (i == tmp.length - 1) {
				addBubble(tmp, i);
			} else
				tmp[i] = this.bubbles[i];
			this.counter++;
		}
		this.bubbles = tmp;
	}

	// provjerava da li se dvije kuglice sudare
	public void checkCollision() {
		for (int i = 0; i < this.bubbles.length - 1; i++) {
			for (int j = i + 1; j < this.bubbles.length; j++) {
				if (this.getBubbles()[i].collision(this.getBubbles()[j])) {
					// ako se desio sudar, mijenja smjer
					this.getBubbles()[i].changeDirection();
					this.getBubbles()[j].changeDirection();
					// testiranje broja kolizija
					numberOfCollisions++;

					System.out.println(this.getBubbles()[i].getCentreX() - this.getBubbles()[j].getCentreX());
				}
			}
		}
	}

}
