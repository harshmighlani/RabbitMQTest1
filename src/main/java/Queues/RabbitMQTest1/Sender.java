package Queues.RabbitMQTest1;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


public class Sender {

	  private final static String QUEUE_NAME = "Events";

	  public static void main(String[] args) throws IOException, TimeoutException {
	
		  
		  ConnectionFactory connectionFactory = new ConnectionFactory();
		  connectionFactory.setHost("localhost");
		  
		  Connection connection = connectionFactory.newConnection();
		  
		  Channel channel =  connection.createChannel();
		  
		  channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		  
		  String message = "Hello world";
		  
		  channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		  
		  System.out.println("Sent");
		  
		  channel.close();
		  
		  connection.close();
	}
	  
}
