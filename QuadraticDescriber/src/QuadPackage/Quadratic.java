package QuadPackage;
/* This class will be responsible for all the calculations that take place in the QuadraticClient class
 * @author Daric Zhou
 * @version 9/6/2018
 */

public class Quadratic {
	//round for values that are irrational to let it have less space
	public static double round(double number) {
		if(number > 0) {
			number += 0.005; 
			}else if (number == 0) {
			number = 0;
		}else {
			number -= 0.005;
		}
		number *= 100;
		double round= (int)number;
		round /= 100;
		return round;
	}
	//States whether graph opens up or down
	public static String graphDes(double a) {
		if(a>0) {
			return "up"; 
		}
		else if(a < 0){
			return "down";
		}
		else if(a==0) {
			return "invalid domain";
		}
		return null;
	}		
	//find the axis of symmetry of the graph
	public static double symmetryDes(double a, double b) {
		double line = (-b)/(2*a);
		return line;
	}
	//finds the vertex of the described graph
	public static String vertexDes(double a, double b, double c) {
		double h = round((-b)/(2*a));
		double k = round((a * (h*h)) + (b * h) + c);
		return h + ", " + k;
	}
	//finds the x-intercepts
	//methods from Calculate so that quadForm can find the x-ints
	public static double discriminant(double a,double b, double c) {
		double dis;
		dis=(b*b)-4*(a*c);
		return dis;
	}
	public static double sqrt(double x) {
		double a=x;
		double error= (1e-3)*5; //tolerance of approximation
		x= a;
	     while ((x - a/x) > error*x) {
	            x = (a/x + x) / 2.0;
	            x= round(x);
	     }
		return x;
	}
	public static String quadForm(double a, double b, double c) {
		double quadratic;
		String output = null;
		if(a==0) {
			return null;
		}
			if(discriminant(a, b, c)<0) {//cannot have negative square roots
				System.out.println("no x-intercepts");
			}
			if(discriminant(a, b, c)==0) {
				quadratic=round(-b+sqrt(discriminant(a,b,c)))/(2*a); 
				output= String.valueOf(quadratic);//converts double to string
				return output;
			} 
			if(discriminant(a, b, c)>0) {
				double quadratic2;
				quadratic=round((-b+sqrt(discriminant(a,b,c)))/(2*a));
				quadratic2=round((-b-sqrt(discriminant(a,b,c)))/(2*a));
				return quadratic + " and " + quadratic2;
			}
			return output;
	}
	//finds y-intercept of graph
	public static double yintDes(double c) {
		return c;
	}
	//drives the rest of the methods so that it can be used in the client
	public static String quadrDescriber(double a, double b, double c) {
		return "Opens: " + graphDes(a) + "\n" + "Axis of Symmetry: " + symmetryDes(a, b) + "\n" + "Vertex: " + "(" + vertexDes(a, b, c) + ")" + "\n" + 
				"x-intercept(s): " + quadForm(a, b, c) + "\n" + "y-intercept: " + yintDes(c);
	}
}