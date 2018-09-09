package ru.stqa.pft.sandbox;
import ru.stqa.pft.sandbox.Point;
import static java.lang.Math.*;

public class MyFirstProgram {

	public static void main (String[] args)  {
	hello("world");
	hello("user");
	hello("Alexei");

		Square s = new Square(5);
		System.out.println("Площадь квадрата со стороной " + s.l + " = "  + s.area());

		Rectangle r = new Rectangle(4,6);
		System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

		Point first = new Point(3,2);
		Point second = new Point (2,3);
		System.out.printf("Расстояние между двумя точками = " + distance(first,second));
	}

	public static void hello(String somebody) {
		System.out.println("Hello, " +somebody + "!");
	}

	public static double distance(Point p1, Point p2)
	{
    return Math.sqrt(Math.pow(p2.GetX() - p1.GetX(),2) + Math.pow(p2.GetY() - p1.GetY(),2));
	}

}


