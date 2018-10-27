package QuadPackage;
/*This class handles interactions with the user about the quadratic formula
 * @author Daric Zhou
 * @version 10/9/2018
 */

import java.util.*; //for scanner to function

public class QuadraticClient {
	public static void main(String[] args) {
		boolean quit = false;
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to the Quadratic Describer \nProvide values for coefficients a, b, and c");
		System.out.println();
		while(quit == false) { //when the user still wants to use the client
			System.out.print("a: ");
			double a = console.nextDouble();
			System.out.print("b: ");
			double b = console.nextDouble();
			System.out.print("c: ");
			double c = console.nextDouble();
			
			
			System.out.println("Description of the graph of");
			System.out.println("y = " + a + "x^2 " + " + " + b + "x" + " + " + c);
			System.out.println();
			System.out.println(Quadratic.quadrDescriber(a, b, c));//call to method implements the math needed
			System.out.println();
			System.out.println("Do you want to keep going? Type \"quit\" to end");
			String str = console.next();
			if(str.equals("quit")) {
				quit = true;
			}
			else {
				quit = false;
			}
		}
		console.close();
	}
}
