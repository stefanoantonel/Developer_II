package chapter8.challenge3;

public class RoomDimension {
	private float heigth;
	private float width;
	
	public RoomDimension (float pheigth, float pwidth) {
		this.heigth = pheigth;
		this.width = pwidth;
	}
	public float calculateDimension () {
		return (this.width * this.heigth); 
	}
	public float getHeigth() {
		return heigth;
	}
	public void setHeigth(float heigth) {
		this.heigth = heigth;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
}
