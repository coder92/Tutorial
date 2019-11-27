package com.tutorial.java.design_pattern.behavioralDP;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Observer Design Pattern</h1>
 * <p>observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. It is also referred to as the publish-subscribe pattern.</p>
 * <p>Example : FB, Twitter, followers , Java UI , message oriented applications.</p>
 * <p>Four Participants : Subject(Interface, abstract class), Concrete Subject class, Observer(Interface, abstract class), Concrete Observer </p>
 * <p> </p>
 * <p> </p>
 * @author Ankit.Dixit
 *
 */
public class ObserverDP {
	
	public static void main(String[] args) {
		Subject publisher = new MessagePublisher();
		
		Observer o1 = new MessageSubscriber1();
		Observer o2 = new MessageSubscriber2();
		
		publisher.attach(o1);
		
		publisher.attach(o2);
		
		Message msg = new Message();
		msg.setMessageContent("Hi this is my first msg");
		
		publisher.notifyUpdate(msg);
	}
}

interface Subject{
	public void attach(Observer o);
	public void detach(Observer o);
	public void notifyUpdate(Message m);
}

class MessagePublisher implements Subject{

	private List<Observer> observers = new ArrayList<Observer>();
	@Override
	public void attach(Observer o) {
		observers.add(o);
	}

	@Override
	public void detach(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyUpdate(Message m) {
		for(Observer observer: observers) {
			observer.update(m);
		}
	}
}

interface Observer{
	public void update(Message m);
}

class MessageSubscriber1 implements Observer{

	@Override
	public void update(Message m) {
		System.out.println("Message for MessageSubscriber1 = "+m.getMessageContent());
	}
}

class MessageSubscriber2 implements Observer{

	@Override
	public void update(Message m) {
		System.out.println("Message for MessageSubscriber2 = "+m.getMessageContent());
	}
}

class Message{
	String messageContent="";

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
}

