package ru.stqa.pft.sandbox;

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
		System.out.println("Расстояние между двумя точками = " + first.distance(second));

	}

	public static void hello(String somebody) {
		System.out.println("Hello, " +somebody + "!");
	}

}


