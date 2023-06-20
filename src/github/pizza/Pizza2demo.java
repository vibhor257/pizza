package github.pizza;

import java.util.*;
/*
 * /*
 Define a class called Pizza that has member variables to track the type of pizza (either deep dish, hand tossed, or pan) along 
 //with the size (either small, medium, or large) and the number of toppings. You can use constants to represent the type and size.
  *  Include setters and getter functions for your class. Create a display function to give the textual description of the pizza object.
Also include a function, computePrice( ), that computes the cost of the pizza and returns it according to the following rules:
Small pizza = $10 + $2 per topping
Medium pizza = $14 + $2 per topping
Large pizza = $17 + $2 per topping
OPTIONAL HARD Problem :Give a 10% discount on the first 3 pizzas costing more than 10$
Create and output a description and price of various pizza objects.
HINT: Use class variables and class methods wherever deemed fit.
 */
class Pizza2{ 
	String type;
	String size;
	int toppings;
	double price;
	static int couponCount = 3;
	
	
	static String[] pizzaType = {"deep dish","hand tossed","pan"};
	static String[] pizzaSize = {"small","medium","large"};
	static int [] pizzaPrice = {10,14,17};
	
	public Pizza2(String type, String size, int toppings) {
		this.type = type;
		this.size = size;
		this.toppings = toppings;
		calculatePrice();
		
	}
	
	public void calculatePrice() {
		for(int i = 0; i < pizzaSize.length; i++) {
			if(pizzaSize[i].equals(size)) {
				price = pizzaPrice[i] + 2 * toppings;
				break;
			}
		}
		if(price > 10 && couponCount > 0) {
			discount();
			couponCount--;
		}
		
	}
	public void discount() {
		price = 0.9 * price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getToppings() {
		return toppings;
	}

	public void setToppings(int toppings) {
		this.toppings = toppings;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Pizza2 [type=" + type + ", size=" + size + ", toppings=" + toppings + ", price=" + price + "]";
	}
	
	
}

public class Pizza2demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter how many pizzas needed");
		int n = sc.nextInt();
		Pizza2 []pi = new Pizza2[n];
		for(int i = 0; i < pi.length; i++) {
			System.out.println("no. \t size \t price");
			for(int j = 0; j < Pizza2.pizzaType.length; j++) {
				System.out.println((j+1)+"\t"+ Pizza2.pizzaSize[j] + "\t" + Pizza2.pizzaPrice[j]);
			}
			
			int s = sc.nextInt()-1;
			System.out.println("select type");
			System.out.println("1 for deep dish \n 2 for hand tossed \n 3 for pan");
			int t = sc.nextInt() - 1;
			System.out.println("enter no.of toppings");
			int no = sc.nextInt();
			pi[i] = new Pizza2( Pizza2.pizzaType[t],Pizza2.pizzaSize[s], no);
 		}
		for(int  k = 0; k < pi.length; k++) {
			System.out.println(pi[k]);
		}

	}

}
