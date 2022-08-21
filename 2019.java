listing 1
//q1 - a

//PrintThread.java
public class PrintThread extends Thread{
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(i+1);
		}
	}
}

//SLIITThread.java
public class SLIITThread implements Runnable{
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println("SLIIT");
		}
	}
}

//ThreadMain.java
public class ThreadMain {
	public static void main(String[] args) {
		PrintThread t1 = new PrintThread();
		Thread t2 = new Thread(new SLIITThread());
		
		t1.start();
		t2.start();
	}
}

listing 2
//q1 - b

//NumbersThread.java
public class NumbersThread extends Thread{
	public void run() {
		System.out.println(Thread.currentThread().getName());
	
		for(int i = 0; i < 100; i++) {
			System.out.println(i + 1);
		}
	}	
}

//ThreadBase.java
public class ThreadBase {
	public static void main(String[] args) {
		NumbersThread t1 = new NumbersThread();
		NumbersThread t2 = new NumbersThread();
		NumbersThread t3 = new NumbersThread();
		
		t1.setName("Red");
		t2.setName("Green");
		t3.setName("Blue");
		
		t1.start();
		t2.start();
		t3.start();
		
		for(int i = 0; i < 100; i++) {
			System.out.println("SLIIT");
		}
		
		if(t1.isAlive()) {
			System.out.println(t1.getState());
		}
	}
}

listing 3
//q1 - c

//Calculation.java
public class Calculation {
	private int total;
	
	public void sum(int start, int end) {
		for(int i = start; i <= end; i++) {
			total = total + i;
		}
	}
	
	public int getTotal() {
		return total;
	}
}

//TClass.java
public class TClass extends Thread{
	private Calculation c;
	private int start;
	private int end;
	
	public TClass(Calculation c, int start, int end) {
		super();
		this.c = c;
		this.start = start;
		this.end = end;
	}

	public void run() {
		c.sum(start, end);
	}
}

//ParallelThread.java
public class ParallelThread {
	public static void main(String[] args){
		Calculation c1 = new Calculation();
		
		TClass t1 = new TClass(c1, 1, 50000);
		TClass t2 = new TClass(c1, 50001, 100000);
		
		try {
			t1.start();
			t1.join();
			
			t2.start();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Total : " +c1.getTotal());
	}
}

listing 4
//q2 - a

//Login.java
public class Login {
	private static Login uniqueInstance;
	
	private Login() {
		
	}
	
	public static Login getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new Login();
		}
		return uniqueInstance;
	}
	
	public boolean validateUser(String user, String password) {
		if(user.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
}

//MainClass.java
public class MainClass {
	public static void main(String args[]) {
		Login l = Login.getInstance();
		
		System.out.println("" +l.validateUser("Manju", "Manju"));
	}
}

listing 5
//q2 - b

//MobilePhone.java
public abstract class MobilePhone {
	private String model;
	private float price;
	
	public MobilePhone(String model, float price) {
		super();
		this.model = model;
		this.price = price;
	}

	public abstract void display();
}

//A10.java
public class A10 extends MobilePhone{
	public A10(String model, float price) {
		super(model, price);
	}

	public void display() {
		System.out.println("Mobile phone model : A10");
	}
}

//X25.java
public class X25 extends MobilePhone{
	public X25(String model, float price) {
		super(model, price);
	}

	public void display() {
		System.out.println("Mobile phone model : X25");
	}
}

//T25.java
public class T25 extends MobilePhone{
	public T25(String model, float price) {
		super(model, price);
	}

	public void display() {
		System.out.println("Mobile phone model : T25");
	}
}

//TV.java
public abstract class TV {
	private String model;
	private String size;
	
	public TV(String model, String size) {
		super();
		this.model = model;
		this.size = size;
	}
	
	public abstract void display();
}

//Alpha40.java
public class Alpha40 extends TV{
	public Alpha40(String model, String size) {
		super(model, size);
	}
	
	public void display() {
		System.out.println("TV model : Alpha 40");
	}
}

//Gamma50.java
public class Gamma50 extends TV{
	public Gamma50(String model, String size) {
		super(model, size);
	}
	
	public void display() {
		System.out.println("TV model : Gamma 50");
	}
}

//Theta65.java
public class Theta65 extends TV{
	public Theta65(String model, String size) {
		super(model, size);
	}
	
	public void display() {
		System.out.println("TV model : Theta 65");
	}
}

//AbstractFactory.java
public abstract class AbstractFactory {
	public abstract MobilePhone getMobilePhone(String type);
	public abstract TV getTV(String type);
}

//MobileFactory.java
public class MobileFactory extends AbstractFactory{
	
	public MobilePhone getMobilePhone(String type) {
		if(type.equalsIgnoreCase("A10")) {
			return new A10("A10", 20000);
		}
		else if(type.equalsIgnoreCase("T25")) {
			return new T25("T25", 30000);
		}
		else if(type.equalsIgnoreCase("X25")) {
			return new X25("X25", 40000);
		}
		else {
			return null;
		}
	}

	
	public TV getTV(String type) {
		return null;
	}
}

//TVFactory.java
public class TVFactory extends AbstractFactory{

	public TV getTV(String type) {
		if(type.equalsIgnoreCase("ALPHA40")) {
			return new Alpha40("Alpha40", "21\'7\"");
		}
		else if(type.equalsIgnoreCase("GAMMA50")) {
			return new Gamma50("Gamma50", "22\"\5'");
		}
		else if(type.equalsIgnoreCase("THETA65")) {
			return new Theta65("Theta65", "23\"7\'");
		}
		else {
			return null;
		}
	}

	public MobilePhone getMobilePhone(String type) {
		return null;
	}
}

//FactoryProducer.java
public class FactoryProducer {

	public static AbstractFactory getFactory(String type) {
		if(type.equalsIgnoreCase("MOBILEPHONE")) {
			return new MobileFactory();
		}
		else if(type.equalsIgnoreCase("TV")) {
			return new TVFactory();
		}
		else {
			return null;
		}
	}
}

//FactoryDemo.java
public class FactoryDemo {

	public static void main(String[] args) {
		AbstractFactory af = FactoryProducer.getFactory("mobilephone");
		MobilePhone mp = af.getMobilePhone("a10");
		mp.display();
		
		FactoryProducer.getFactory("mobilephone").getMobilePhone("t25").display();
		FactoryProducer.getFactory("mobilephone").getMobilePhone("x25").display();
		
		FactoryProducer.getFactory("tv").getTV("alpha40").display();
		FactoryProducer.getFactory("tv").getTV("gamma50").display();
		FactoryProducer.getFactory("tv").getTV("theta65").display();
	}
}

listing 6
//q3

//InsufficientBalanceException.java
public class InsufficientBalanceException extends Exception{
	private double balance;

	public InsufficientBalanceException(double balance) {
		super();
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
}

//Account.java
public class Account {
	private int accountNo;
	private double balance;
	
	public Account(int accountNo) {
		super();
		this.accountNo = accountNo;
	}
	
	public void display() {
		System.out.println("Account no. : " +accountNo);
		System.out.println("Existing balance : " +balance);
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	public void withdraw(double amount) throws InsufficientBalanceException {
		if(amount > balance) {
			throw new InsufficientBalanceException(balance);
		}
		else {
			balance = balance - amount;
		}
	}
	
	public double getBalance() {
		return balance;
	}
}

//BankDemo.java
public class BankDemo {

	public static void main(String[] args) {
		Account account = new Account(123);
		
//		System.out.println("Depositing Rs. 10,000");
//		account.deposit(10000);
//		
//		try {
//			System.out.println("Withdrawing Rs. 6,000");
//			account.withdraw(6000);
//		
//			System.out.println("Withdrawing Rs. 8,000");
//			account.withdraw(8000);
//		
//		} catch (InsufficientBalanceException e) {
//			System.out.println("Sorry, your account remain only Rs. " +e.getBalance());
//			e.printStackTrace();
//		}
		
		Scanner sc = new Scanner(System.in);
		double withdrawAmount;
		String response = "yes";
		
		do {
			System.out.println("Depositing Rs. 10,000");
			account.deposit(10000);
				
			try {
				while(true) {
					System.out.print("Please enter amount to be withdrawn : ");
					withdrawAmount = sc.nextDouble();
					
					account.withdraw(withdrawAmount);
					System.out.println("Withdrawing Rs. " +withdrawAmount);
					
					System.out.println("Existing balance : " +account.getBalance());
					System.out.println();
				}
					
			}catch(InsufficientBalanceException e) {
				System.out.println("Sorry, your account remain only Rs. " +e.getBalance());
				e.printStackTrace();
			}
					
			finally {
				System.out.print("Do you wish to continue ?");
				response = sc.next();
				System.out.println();		
			}	
						
		}while(response.equalsIgnoreCase("yes"));
	}
}

listing 7
//q4

//Vehicle.java
public abstract class Vehicle {
	private int speed;
	public double regularPrice = 10000.00;
	private String colour;
	
	public Vehicle(int speed, double regularPrice, String colour) {
		super();
		this.speed = speed;
		this.regularPrice = regularPrice;
		this.colour = colour;
	}

	public Vehicle(int speed, String colour) {
		super();
		this.speed = speed;
		this.colour = colour;
	}
	
	public double getRegularPrice() {
		return regularPrice;
	}
	
	public abstract double getSalePrice();
}

//Truck.java
public class Truck extends Vehicle{
	private double weight;

	public Truck(int speed, String colour, double weight) {
		super(speed, colour);
		this.weight = weight;
	}
	
	public double getSalePrice() {
		if(weight > 2000) {
			return super.regularPrice * 90 / 100;
		}
		else {
			return super.regularPrice * 80 / 100;
		} 
	}
}

//Bus.java
public class Bus extends Vehicle{
	private int year;
	private double manufacturerDiscount;
	
	public Bus(int speed, String colour, int year, double manufacturerDiscount) {
		super(speed, colour);
		this.year = year;
		this.manufacturerDiscount = manufacturerDiscount;
	}
	
	public double getSalePrice() {
		return super.regularPrice * (100 - manufacturerDiscount) / 100;
	}
}

//MyOwnAutoShop.java
public class MyOwnAutoShop {

	public static void main(String[] args) {
		Vehicle v1 = new Truck(150, "Blue", 1000);
		System.out.println(v1.getSalePrice());
		
		Vehicle v2 = new Bus(250, "White", 2017, 40);
		System.out.println(v2.getSalePrice());
	}
}