package interfaces.defaultmethods;

public class CreatureExample {
    static void main(String[] args) {
        Speak s =  new Creature();
        s.say("Hello");
        s.shout();
        Speak.describe();
    }
}
