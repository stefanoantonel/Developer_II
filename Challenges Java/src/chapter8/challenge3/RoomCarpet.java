package chapter8.challenge3;

public class RoomCarpet {
	private RoomDimension roomDimension;
	private Double cost;
	public RoomCarpet (RoomDimension roomDim, Double costCarpet) {
		this.roomDimension = roomDim;
		this.cost = costCarpet;
	}
	public Double calculatePrice () {
		return roomDimension.calculateDimension() * this.cost;
	}
}
