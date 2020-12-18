public class Human {
    private String name;
    private String сonstitution;
    public String getName() {
        return name;
    }
    public String getСonstitution() {
        return сonstitution;
    }
    public Human(String name, String сonstitution){
        this.name=name; this.сonstitution=сonstitution;
    }
    public void info(){
        System.out.println("Имя: " + name + " Коституция: " + сonstitution);
    }

}
class HumanTest{
    public static void main(String[] args) {

       // Human person1 = new Human("Liza", "slim");
        Head head = new Head ("Liza", "slim" ,"oval");
        head.info();
        Leg leg = new Leg ("Liza", "slim" ,5);
        leg.info();
        Hand hand = new Hand ("Liza", "slim" ,5);
        hand.info();
       // person1.info();
        /*String firstName = person1.getName();
        System.out.println(firstName);*/
    }
}
class Head extends Human{
    private String shape;
    public Head(String name, String сonstitution, String shape) {
        super(name, сonstitution); this.shape=shape;
    }
    public void info(){
        super.info(); System.out.println("Форма: " + shape);
    }
}
class Leg extends Human{
    private int number_of_fingers;
    public Leg(String name, String сonstitution, int number_of_fingers) {
        super(name, сonstitution); this.number_of_fingers=number_of_fingers;
    }
    public void info(){
        super.info(); System.out.println("Кол-во пальцев на ноге:)  " + number_of_fingers);
    }
}
class Hand extends Human{
    private int number_of_fingers;
    public Hand(String name, String сonstitution, int number_of_fingers) {
        super(name, сonstitution); this.number_of_fingers=number_of_fingers;
    }
    public void info(){
        super.info(); System.out.println("Кол-во пальцев на руке:)  " + number_of_fingers);
    }
}
