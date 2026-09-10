package interfaces.polymorphism;

/** The main class for the Speak/GameCharacter example that
 * demonstrates polymorphism via interfaces.  */
public class Talking {
    static void main(String[] args) {
        Speaker speaker;
        speaker = new Philosopher();
        speaker.speak();
        speaker = new Dog();
        //((Philosopher)speaker).pontificate();
        speaker.speak();

       /*
        List<Speaker> speakers  = new ArrayList<>();
        speakers.add(new Dog());
        speakers.add(new Philosopher());
        speakers.add(new Dog());
        speakers.add(new Philosopher());
        speakers.add(new Philosopher());
        for (Speaker sp: speakers) {
            sp.speak();
        }

        */




       /* Philosopher phil = new Philosopher();
        phil.pontificate();

        */

        //speaker = new Philosopher();

        /* List<Speaker> speakers = new ArrayList<>();
        speakers.add(new Dog());
        speakers.add(new Philosopher());
         */


    }
}
