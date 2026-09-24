package designpatterns.creational.singleton;

public class SingletonExample {
    static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);

    }
}
