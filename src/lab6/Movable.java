import java.util.Scanner;
class Main{
    public static void main(String[] args) {
        int x1,x2;
        int y1,y2;
        int x3,y3;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите координаты первой точки ");
        x1 = sc.nextInt();
        y1 = sc.nextInt();
        System.out.println("Введите координаты второй точки ");
        x2 = sc.nextInt();
        y2 = sc.nextInt();
        System.out.println("Введите насколько подвинуть по оси X ");
        x3 = sc.nextInt();
        System.out.println("Введите насколько подвинуть по оси Y ");
        y3 = sc.nextInt();
        Rectangle1 rectangle = new Rectangle1(x2-x1,y2-y1);
    }
}
public interface Movable {
    void moveUp();
    void moveDown();
    void moveRight();
    void moveLeft();
}
class Rectangle1  {
    public Rectangle1(int a,int b){ this.a=a; this.b=b;}
    int a;
    int b;
    void CalcArea(){
        System.out.println("Area of Rectangle = " + a * b);
    }
}
class MobablePoint implements Movable{
    int x;
    int y;
    int xSpeed;
    int ySpeed;
    public MobablePoint(int x,int y,int xSpeed,int ySpeed){
        this.x=x;
        this.y=y;
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    @Override
    public void moveUp() {
        y++;
    }
    @Override
    public void moveDown() {
        y--;
    }
    @Override
    public void moveRight() {
        x++;
    }
    @Override
    public void moveLeft() {
        x--;
    }
}
class MovableRectangle<centerX, centerY> implements Movable{
    int centerX;
    int centerY;
    int a,b;
    int x,y,xSpeed,ySpeed;
    public MovableRectangle(int x,int y,int xSpeed,int ySpeed,int a,int b){
        this.x=x;
        this.y=y;
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
        this.a=a;
        this.b=b;
    }
    centerX = a/2;
    centerY = b/2;
    @Override
    public void moveUp() {
        centerY++;
    }
    @Override
    public void moveDown() {
        centerY--;
    }
    @Override
    public void moveRight() {
        centerX++;
    }
    @Override
    public void moveLeft() {
        centerX--;
    }
}*/
