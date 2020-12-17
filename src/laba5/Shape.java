import java.util.Scanner;

public abstract class Shape {
    String name;
    double area;

    public abstract void CalcArea();

    public Shape() {
    }

    public Shape(String name, double area) {
        this.name = name;
        this.area = area;
    }

    static class Circle extends Shape{
        public Circle(double radius){ this.radius=radius;}
        double radius;
        public void CalcArea(){
            System.out.println("Area of Circle = " + Math.PI * Math.pow(radius,2));
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int a,b,c;
            double radius;
            System.out.println("Введите радиус ");
            radius = sc.nextInt();
            System.out.println("Введите стороны прямоугольника ");
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println("Введите сторону квадрата ");
            c = sc.nextInt();
            Circle circle = new Circle(radius);
            Rectangle rectangle = new Rectangle(a,b);
            Square square = new Square(c);
            circle.CalcArea();
            rectangle.CalcArea();
            square.CalcArea();
        }
    }

    static class Rectangle extends  Shape {
        public Rectangle(int a, int b) {
            this.a = a;
            this.b = b;
        }

        int a;
        int b;

        public void CalcArea() {
            System.out.println("Area of Rectangle = " + a * b);
        }

        public String toString() {
            return "Прямоугольник: " +
                    "Ширина: " + a +
                    "Длина: " + b;
        }
    }

    static class Square extends  Shape{
        public Square(int c){ this.c=c;}
        int c;
        public void CalcArea(){
            System.out.println("Area of Rectangle = " + c * c);
        }
    }
}
