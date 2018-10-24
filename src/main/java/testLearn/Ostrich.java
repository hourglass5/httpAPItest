package testLearn;

public class Ostrich extends Bird{

    // 子类方法前面加上@Override能编译通过，表明是方法的重写
    @Override
    public void fly(){
    System.out.println("可怜的鸵鸟不会飞");
    }
    // 如果需要在子类方法中调用父类被覆盖的实例方法，可以用super来调用
    public void birdFly(){
        super.fly();
    }
    // 父类中的sayHi方法是私有方法，子类无法访问，这里的sayHi只是重新定义了一个方法，与父类无关
    // @Override
    public void sayHi(){
        System.out.println("子类用他优雅的姿势say hi");
    }

    public static void main(String [] args){
         Ostrich bird = new Ostrich();
        // 调用鸵鸟自己的飞翔方法
        bird.fly();
        // 调用父类的通用的飞翔方法
        bird.birdFly();
    }
}

class Bird {
    public void fly(){
        System.out.println("一般的鸟都会在天上飞");
    }
    private void sayHi(){
        System.out.println("父类用他优雅的姿态say hi");
    }
}
