
import java.util.*;
/*Задание на практическую работу №7-8
1.Создайте класс Employee, определяющий сотрудника. Необходимые поля
– Фамилия, Имя, фиксированная часть зарплаты(оклад), должность(см пункт 2).
2. Создайте интерфейс EmployeePosition, определяющий должность.
Определите в нем метод String getJobTitle(), возвращающий название занимаемой
должности, и double calcSalary(double baseSalary), возвращающий зарплату сотрудника,
в соответствии с фиксированным окладом.
3.Создайте классы, определяющие должности сотрудников. Все они должны реализовывать
интерфейс EmployeePosition
a. Manager — зарплата складывается из фиксированной части и бонуса в виде 5% от
заработанных для компании денег. Количество заработанных денег для компании
генерируйте случайным образом от 115 000 до 140 000 рублей.
b. TopManager — зарплата складывается из фиксированной части и бонуса в виде 150%
от заработной платы, если доход компании более 10 млн рублей.
c. Operator — зарплата складывается только из фиксированной части.
4. Создайте класс компании Company, содержащий сотрудников и реализующей методы:
· найм одного сотрудника — hire(),
· найм списка сотрудников – hireAll(),
· увольнение сотрудника – fire(),
· получение значения дохода компании – getIncome().
Аргументы и возвращаемое значение методов выберите на основании логики работы
вашего приложения.
Создайте два метода, возвращающие список указанной длины (count). Они должны
содержать сотрудников, отсортированных по убыванию и возрастанию заработной платы:
· List<Employee> getTopSalaryStaff(int count),
· List<Employee> getLowestSalaryStaff(int count).
Аргументы и возвращаемое значение метода выберите в соответствии с
логикой начисления зарплат.*/

public class main {
    public static void main(String[] args) {
        Company city = new Company();

        for (int i = 0; i < 180; i++){
            Operator operator = new Operator("Operator"," " + i);
            city.hire(operator);
        }

        for (int i = 0; i < 80; i++){
            Manager manager = new Manager("Manager", "    " + i);
            city.hire(manager);
        }

        for (int i = 0; i < 10; i++){
            TopManager topManager = new TopManager("TopManager", " "+i, city);
            city.hire(topManager);
        }

        System.out.println("Самые высокие запрлаты в компании:");
        List<Employee> list = city.getTopSalaryStaff(10);
        for (int i = 0; i < list.size(); i++)
            System.out.println(i+1 +" "+ list.get(i));
        System.out.println();

        list = city.getLowestSalary(30);
        System.out.println("Самые низкие запрлаты в компании:");
        for (int i = 0; i < 30; i++)
            System.out.println(i+1 +" "+list.get(i));
        System.out.println();

        System.out.println("произошло увольнение сотрудников... ");
        for (int i = (city.getAllEmployeesSize() - 1); i >= 0; i-=2){
            city.fire(i);
        }

        System.out.println("Самые высокие запрлаты в компании:");
        list = city.getTopSalaryStaff(10);
        for (int i = 0; i < 10; i++)
            System.out.println(i+1 +" "+list.get(i));
        System.out.println();

        System.out.println("Самые низкие запрлаты в компании:");
        list = city.getLowestSalary(30);
        for (int i = 0; i < 30; i++)
            System.out.println(i+1 +" "+list.get(i));
    }
}

interface EmployeePosition {
    public String getJobTitle();
    public double calcSalary();
}

abstract class Employee implements Comparable<Employee> {
    protected String name;
    protected String surname;
    protected double fixSalary;
    protected String jobTitle;
    protected double employeeIncome;
    protected double salary;

    public double getHisIncome(){
        return employeeIncome;
    }

    public String toString(){
        return name + " " + surname + " " + (int) salary;
    }

}

class Manager extends Employee implements EmployeePosition{
    public Manager(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.jobTitle = "Manager";

        Random random = new Random();
        employeeIncome = random.nextInt(180000 - 100000) + 100000;
        fixSalary = random.nextInt(180000 - 150000) + 150000;
        salary = calcSalary();
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public double calcSalary() {
        return fixSalary + 0.05 * employeeIncome;
    }

    @Override
    public int compareTo(Employee emp) {
        return (int) (emp.salary - this.salary);
    }
}

class TopManager extends Employee implements EmployeePosition{
    private double income;
    Company comp;
    public TopManager(String name, String lastName, Company comp){
        this.name = name;
        this.surname = lastName;
        this.jobTitle = "TopManager";
        this.comp = comp;

        Random random = new Random();
        employeeIncome = 0;
        fixSalary = random.nextInt(140000 - 115000) + 150000;

        income = comp.getIncome();
        salary = calcSalary();
    }

    public void setIncome(double income) {
        this.income = income;
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public double calcSalary() {
        //найти прибыль компании
        if (income > 10000000)
            return 2.5 * fixSalary;
        return fixSalary;
    }

    @Override
    public int compareTo(Employee emp) {
        return (int) (emp.salary - this.salary);
    }
}

class Operator extends Employee implements EmployeePosition{
    public Operator(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.jobTitle = "Operator";

        Random random = new Random();
        employeeIncome = 0;
        fixSalary = random.nextInt(120000 - 100000) + 100000;
        salary = calcSalary();
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public double calcSalary() {
        return fixSalary;
    }

    @Override
    public int compareTo(Employee emp) {
        return (int) (emp.salary - this.salary);
    }
}

class Company{
    private ArrayList<Employee> allEmployees= new ArrayList<>();

    List<Employee> getTopSalaryStaff(int count){
        if (count > 0 && count < allEmployees.size()) {
            ArrayList<Employee> list1 = allEmployees;
            Collections.sort(list1);
            ArrayList<Employee> list2 = new ArrayList<>();
            for (int i = 0; i < count; i++)
                list2.add(list1.get(i));
            return list2;
        }
        return null;
    }

    List<Employee> getLowestSalary(int count){
        if (count > 0 && count < allEmployees.size()) {
            ArrayList<Employee> list1 = allEmployees;
            Collections.sort(list1, Collections.reverseOrder());
            ArrayList<Employee> list2 = new ArrayList<>();
            for (int i = 0; i < count; i++)
                list2.add(list1.get(i));
            return list2;
        }
        return null;
    }

    void hire(Employee man) {
        allEmployees.add(man);
    }

    void hireAll(List<Employee> emplo){
        for (Employee empl : emplo)
            allEmployees.add(empl);
    }

    void fire(int emp){
        for (int i = 0; i < allEmployees.size(); i++){
            if (i == emp)
                allEmployees.remove(i);
        }
    }

    int getAllEmployeesSize(){
        return allEmployees.size();
    }

    List <Employee> getAllEmployees(){
        return allEmployees;
    }

    public double getIncome(){
        int income = 0;
        for (Employee man : allEmployees)
            income += man.getHisIncome();
        return income;
    }
}


© 2020 GitHub, Inc.
Terms
Privacy
Security
Status
Help
Contact GitHub
Pricing
API
Training
Blog
About
