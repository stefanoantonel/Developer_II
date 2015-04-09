package chapter13.challenge3;

import java.util.ArrayList;

public class Controller {

	private static ArrayList<Dorm> dormsArray = new ArrayList<>();
	private static ArrayList<MealPlan> mealArray = new ArrayList<>();
	
	public static Dorm findDorms (String name) {
		int codeToFind = name.hashCode();

		for (Dorm d : dormsArray) {
			
			if(d.getName().hashCode() == codeToFind) {
				return d;
			}
		}
		return null;
	}
	
	public static MealPlan findMealPlan (String name) {
		int codeToFind = name.hashCode();
		for (MealPlan m : mealArray) {
			
			if(m.getName().hashCode() == codeToFind) {
				return m;
			}
		}
		return null;
	}
	
	public static void addDorm (Dorm dorm) {
		dormsArray.add(dorm);
	}
	
	public static void addMeal (MealPlan meal) {
		mealArray.add(meal);
	}
}
