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
	
	public static Object[] createConferenceByArray(String[] conferencesNames , float[] prices) {
//			List conferencesNames, List prices) {
			
		if(conferencesNames.length != prices.length) {
			return null;
		}
		
		int i = 0;
		ArrayList<String> arrayAux = new ArrayList<>();
		for(String conferenceName : conferencesNames) {
			Conference c = new Conference (conferenceName, prices[i]);
			arrayAux.add(c.getName());
			Controller.addConference(c);
			i++;
		}
		return arrayAux.toArray();
	}
	
	public static Object[] createAdmitionsByArray(String[] admitionsNames , float[] prices) {
		
	if(admitionsNames.length != prices.length) {
		return null;
	}
	
	int i = 0;
	ArrayList<String> arrayAux = new ArrayList<>();
	for(String admitionName : admitionsNames) {
		Admition a = new Admition (admitionName, prices[i]);
		arrayAux.add(a.getName());
		Controller.addAdmition(a);
		i++;
	}
	return arrayAux.toArray();
}
}
