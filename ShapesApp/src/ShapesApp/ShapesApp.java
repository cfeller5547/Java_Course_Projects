package ShapesApp;
import java.util.Scanner;
enum Shapes{ CIRCLE, SQUARE, RECTANGLE, UNKNOWN };

public class ShapesApp {

	static final double PI = 3.14159;
	
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String user_shape;
		Shapes type;
		int shapeLength, width, radius;
		double shapeCalcArea;
		
		System.out.println("Enter the shape");
		user_shape = input.nextLine();
		
		getShape(user_shape);//
										//do i need both these lines or only bottom one?????
		type = getShape(user_shape);//
		
		switch(type) {
		case CIRCLE: 
			System.out.println("Enter the radius");
			radius = input.nextInt();
			shapeCalcArea = area(radius);
			System.out.println( "Area of Circle is: " + shapeCalcArea );
			break;
		case RECTANGLE: 
			System.out.println("Enter the length");
			shapeLength = input.nextInt();
			System.out.println("Enter the width");
			width = input.nextInt();
			shapeCalcArea = area(shapeLength, width);
			System.out.println( "Area of rectangle is: " + shapeCalcArea );
			break;
		case SQUARE: 
			System.out.println("Enter the length");
			shapeLength = input.nextInt();
			shapeCalcArea = areaSquare(shapeLength);
			System.out.println( "Area of square is: " + shapeCalcArea );
			break;
		}
	}

	static Shapes getShape( String input ) {
		if ( input.equalsIgnoreCase( "Circle" )){
			return Shapes.CIRCLE;
		}
		else if ( input.equalsIgnoreCase( "Square" )){
			return Shapes.SQUARE;
		}
		else if ( input.equalsIgnoreCase( "Rectangle" )){
			return Shapes.RECTANGLE;
		}
		else {
			return Shapes.UNKNOWN;
		}
	}

	static double area( int radius ) {
		return (radius*PI);
	}
	
	static int area( int length, int width ) {
		return (length*width);
	}
	static int areaSquare( int length) {
		return (length*length);
	}
}

