package lambdaExpression;
// Instead of creating separate classes for each behavior,
// lambda expression (denoted by ->) allows create behavior inline.
// Lambdas are wrapped inside new classes which are created during runtime.
public class BuildingUpToLambda {
    public static void main(String[] args) {
        // Using typical OOP to create behavior and call playAlarm()
        Clock clock = new Clock();
        play(clock);
        Watch watch = new Watch();
        play(watch);

        // Passing anonymous class object instead of creating classes like Clock and Watch
        play(new Alarm() {
            @Override
            public void playAlarm() {
                System.out.println("(Using anonymous class). Playing alarm on the phone");
            }
        });

        // Using lambda expression
        play(() -> {
            System.out.println("(Using lambda -> [anonymous function]). Playing alarm on the computer");
        });
    }

    public static void play(Alarm alarm) {
        alarm.playAlarm();
    }
}

@FunctionalInterface
interface Alarm {
    void playAlarm();
}

class Clock implements Alarm {
    @Override
    public void playAlarm() {
        System.out.println("Playing alarm on the clock");
    }
}

class Watch implements Alarm {
    @Override
    public void playAlarm() {
        System.out.println("Playing alarm on the watch");
    }
}