package threadtutorials.DiningPhilospher;

import java.util.Random;

public class Philosopher implements Runnable {
    
	private int id;
	private Random random;
	private Chopstick leftStick;
	private Chopstick rightStick;
	private boolean full;

	public Philosopher(int id, Chopstick leftStick, Chopstick rightStick) {
		this.id = id;
		this.leftStick = leftStick;
		this.rightStick = rightStick;
		this.random = new Random();
	}

	@Override
	public void run() {
	}

	public void think() throws InterruptedException {
		System.out.println(this + "is thinking");
		Thread.sleep(random.nextInt(100));
	}

	public void eat() throws InterruptedException {
		System.out.println(this+ "is eating");
		Thread.sleep(random.nextInt(100));

	}

	public void setFull(boolean isFull) {
        this.full = isFull;
	}





	

	
    
}
