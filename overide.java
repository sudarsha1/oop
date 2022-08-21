//Shape class
public class shape{
	private String color;
	public void setColor(String color) {
		this.color = color;
	}
	
	public void displayshape() {
		System.out.println("Color: "+color);
	}
}
//Circle class
public class circle extends shape {
	private int radius;
	public void setradius(int radius) {
		this.radius = radius;
	}
	
	public void getradius() {
		System.out.println("Radius: "+radius);
	}
	

}

//Main

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		circle c1 = new circle();
		circle c2 = new circle();
		
		c1.setColor("Red");
		c1.setradius(10);
		c2.setColor("Blue");
		c2.setradius(15);
		
		c1.getradius();
		c1.displayshape();
		c2.getradius();
		c2.displayshape();

	}

}

// Method overide

//Shape class
public class shape{
	protected String color;
	public void setColor(String color) {
		this.color = color;
	}
	
	public void displayshape() {
		System.out.println("Displaying shape");
	}
}
//Circle class
public class circle extends shape {
	private int radius;
	public void setradius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public void displayshape() {
		System.out.println("Radius:"+radius);
		System.out.println("Color: "+color);
	}
	

}

//Main
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		circle c1 = new circle();
		circle c2 = new circle();
		
		c1.setColor("Red");
		c1.setradius(10);
		c2.setColor("Blue");
		c2.setradius(15);
		

		c1.displayshape();
		c2.displayshape();

	}

}
