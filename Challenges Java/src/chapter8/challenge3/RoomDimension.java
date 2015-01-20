package chapter8.challenge3;

public class RoomDimension {
	private Double heigth;
	private Double width;
	
	public RoomDimension (Double pheigth, Double pwidth) {
		this.heigth = pheigth;
		this.width = pwidth;
	}
	public Double calculateDimension () {
		return (this.width * this.heigth); 
	}
	public Double getHeigth() {
		return heigth;
	}
	public void setHeigth(Double heigth) {
		this.heigth = heigth;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
}
