package OOP.Junior.Polymorphism.PolyArray;

public class PolyArray {
    public static void main(String[] args){
        Person[] personMountainPersonSea = new Person[5];

        personMountainPersonSea[0] = new Person("Jack");
        personMountainPersonSea[1] = new Student("Mary", 100.0);
        personMountainPersonSea[2] = new Student("Jess", 78.0);
        personMountainPersonSea[3] = new Teacher("Smith", 9800);
        personMountainPersonSea[4] = new Teacher("Wade",27000);

        for (int i = 0; i < personMountainPersonSea.length; i++) {
            System.out.println(personMountainPersonSea[i].say());

            if(personMountainPersonSea[i] instanceof Student){
                System.out.println(
                        ((Student) personMountainPersonSea[i]).study()
                );

            }
            else if(personMountainPersonSea[i] instanceof Teacher){
                System.out.println(
                        ((Teacher) personMountainPersonSea[i]).teach()
                );
            }
            else if(personMountainPersonSea[i] instanceof Person){
                continue;
            }
            else{
                System.out.println("Pleas check the class of input to the list");
            }
        }
    }
}


class Person {
    String name;
    public Person() {}

    public Person(String name) {
        this.name = name;
    }
    public String say(){
        return "name: " + name;
    }
}

class Student extends Person{
    double score;
    public Student(String name, double score){
        super(name);
        this.name = name;
        this.score = score;
    }

    @Override
    public String say(){
        return super.say() + " " + "score: " + score;
    }

    public String study(){
        return "Student" + name + "studying...";
    }
}

class Teacher extends Person{
    double salary;
    public Teacher(String name, double score){
        super(name);
        this.name = name;
        salary = salary;
    }

    @Override
    public String say(){
        return super.say() + " " + "salary: " + salary;
    }

    public String teach(){
        return "Teacher" + name + "teaching...";
    }
}