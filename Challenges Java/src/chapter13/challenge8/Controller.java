package chapter13.challenge8;

import java.util.ArrayList;

public class Controller {

	private static ArrayList<Conference> conferenceArray = new ArrayList<>();
	private static ArrayList<Admition> admitionArray = new ArrayList<>();
		
	public static Conference findConference (String name) {
		int codeToFind = name.hashCode();
		for (Conference c : conferenceArray) {
			if(c.getCode() == codeToFind) 
				return c;
		}
		return null;
	}
	
	public static Admition findAdmition (String name) {
		int codeToFind = name.hashCode();
		for (Admition a : admitionArray) {
			if(a.getCode() == codeToFind) 
				return a;
		}
		return null;
	}
	
	public static void addConference (Conference conference) {
		conferenceArray.add(conference);
	}
	public static void addAdmition(Admition admition) {
		admitionArray.add(admition);
	}

	public static ArrayList<Conference> getConferenceArray() {
		return conferenceArray;
	}

	public static ArrayList<Admition> getAdmitionArray() {
		return admitionArray;
	}
	
}
