package designpatterns.creational.singleton.holder;

public class Singleton {
    private Singleton() {}
    private static class Holder {
        private static final Singleton instance = new Singleton();
    }
    public static Singleton getInstance() {
        return Holder.instance;
    }
}