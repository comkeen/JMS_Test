package main;

import java.util.concurrent.TimeUnit;

public class Main {
	
	public static final String MQ_ADDRESS = "vm://localhost";
	
	public Main() {
		Originator originator = new Originator();
		Location gu1 = new Location("1", LocationType.GU);
		gu1.add(new Location("11", LocationType.DONG));
		gu1.add(new Location("12", LocationType.DONG));
		
		try {
			originator.send("1구");
			TimeUnit.SECONDS.sleep(3);
			originator.send("11동");
			TimeUnit.SECONDS.sleep(3);
			originator.send("12동");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
