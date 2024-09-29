package OOP.Junior.Encapsulation;

public class Encapsulation {
    public static void main(String[] args){
        Person p = new Person("Zheng", 23);

        // 私有变量禁止直接访问
//        System.out.println(p.name);
//        System.out.println(p.age);

        // 私有变量可使用公用方法访问
        System.out.println("Access private variable by public method");
        System.out.println("name: " + p.getName());
        System.out.println("age: " + p.getAge());

        System.out.println("Verify results");
        p.displayInfo();
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void displayInfo() {
        System.out.println("姓名： " + name + ", 年龄: " + age);
    }
}