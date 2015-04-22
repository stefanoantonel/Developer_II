package chapter8.challenge3;

public class RoomCarpet {
	private RoomDimension roomDimension;
	private float cost;
	public RoomCarpet (RoomDimension roomDim, float costCarpet) {
		this.roomDimension = roomDim;
		this.cost = costCarpet;
	}
	public float calculatePrice () {
		return roomDimension.calculateDimension() * this.cost;
	}
}
