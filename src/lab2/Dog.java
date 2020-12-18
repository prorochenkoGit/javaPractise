
import java.util.Scanner;

public class Dog {
    private String nickname;
    private int age;
    private int chel_age;

    public Dog(String nickname, int age) {
        this.nickname = nickname;
        this.age = age;

    }

    public String getNick() {
        return nickname;
    }

    public void setNick(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int transfer() {
        chel_age = age * 7;
        return chel_age;
    }

    void ToString() {
        System.out.println(nickname + " ");
        System.out.print(age + " ");
        System.out.println(chel_age + " ");

    }
}

 class KennelDogTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dog[] one = new Dog[10];
        int age, n;
        String nick;
        System.out.println("Кол-во собак ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("кличка собаки");
            nick = sc.next();
            System.out.println("возраст собаки");
            age = sc.nextInt();
            one[i] = new Dog(nick,age);
            one[i].transfer();

        }

        for (int i = 0; i < n; i++) {
            one[i].ToString();
        }
    }
}
