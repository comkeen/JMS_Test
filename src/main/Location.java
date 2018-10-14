package main;

import java.util.ArrayList;
import java.util.List;

public class Location {
		
	private String id;
	private String postfix;
	private List<Location> locations;
	
	private ActiveMQConsumer consumer;
	private ActiveMQProducer producer;
	
	public Location(String id, LocationType locationType) {
		this.id = id;
		this.postfix = locationType.postfix;

		this.producer = new ActiveMQProducer(Main.MQ_ADDRESS);
		this.consumer = new ActiveMQConsumer(Main.MQ_ADDRESS, this);
		consumer.setDestination(id+postfix);
		
		System.out.println("id+postfix Location created: " + id + postfix);
	}
	
	public String toString() {
		return id + postfix;
	}

	public void add(Location location) {
		if(locations == null) {
			locations = new ArrayList<Location>();
		}
		locations.add(location);
	}

	public void onMessage(String text) {
		System.out.println(id + postfix + " : received");
		if(locations != null) {
			for (Location location : locations) {
				producer.sendMessageTo(text, location.id+location.postfix);
			}
		}
	}
}
