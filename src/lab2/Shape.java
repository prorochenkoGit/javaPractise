

public class Shape {
    int size=5;
    String color="red";

    void GetInfo()
    {
        System.out.println(size);
        System.out.println(color);
    }
}

class ShapeTest{
    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.GetInfo();
    }
}
