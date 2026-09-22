package nestedclasses.innerclasses;

public class MyOuterDriver {
    static void main(String[] args) {
       MyOuter outer = new MyOuter(2);
       MyOuter.MyInner inner  = outer.new MyInner();
       //MyOuter.MyInner inner = new MyOuter(5).new MyInner();
        outer.funcOuter();
        inner.funcInner();
    }
}
