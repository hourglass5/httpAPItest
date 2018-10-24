package testLearn;

public class Wolf extends Animal{
    public Wolf(){
        super("我的路",7);
        System.out.println("Wolf无参数构造器");
    }
    public static void main(String [] args){
        new Wolf();
    }
}
class Animal extends Creature{
    public Animal(){

    }
    public Animal(String name){
        System.out.println("Animal带一个参数的构造器");
    }
    public Animal(String name, int age){
        this(name);
        System.out.println("Animal带两个参数的构造器");
    }
}

class Creature{
    public Creature(){
        System.out.println("Creature无参数构造器");
    }
}
