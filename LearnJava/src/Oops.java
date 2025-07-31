class Animal {
    String name;
    public void barking(){
        System.out.println("Animal Barking");
    }
}

class Dog extends Animal {
    @Override
    public void barking(){
        System.out.println("Dog Barking");
    }
}

public class Oops {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.barking();
    }
}
