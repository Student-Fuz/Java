package OOP.Junior.ObjectClass;

public class ObjectClass {
    public static void main(String[] args){
        Monster mon = new Monster("Zuogho",20.0);

        System.out.println(mon.toString());
    }
}

/*cltr + B 查看JDK源码*/
class Monster extends Object {
    String name;
    double height;

    Monster(String name,  double height){
        this.name = name;
        this.height = height;
    }

    // 重写toString方法, 输出对象的属性
    // alt + insert -> toString
    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}