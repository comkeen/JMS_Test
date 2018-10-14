package main;

public class Originator {

	private ActiveMQProducer producer;
	
	public Originator() {
		this.producer = new ActiveMQProducer(Main.MQ_ADDRESS);
	}
	
	public void send(String destination) {
		System.out.println("send to : " + destination );
		producer.sendMessageTo(destination, destination);
	}

}
