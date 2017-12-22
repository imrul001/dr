package testsources.CaseConversationTest;

public class Animal {


    public void move(){
        System.out.println("i am moving");
    }

    public static void main(String[] args){
        Animal fluffy = new Dog();
        fluffy.move();
        SayHello sayHello = message -> System.out.println(message);
        sayHello.sayHello("hello");


        SayHello addTwoNumber = (text) -> {
            System.out.println("hello world");
        };

    }
}

class Dog extends Animal{

    public void move(){
        System.out.println("dog running");
    }

}
interface SayHello{
    void sayHello(String message);
}