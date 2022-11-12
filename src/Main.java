import TI.BoeBot;
import TI.PinMode;
import TI.Timer;

public class Main {
    public static void main(String[] args) {

    }

    private static void week1exercise2a() {
        boolean state = true;
        BoeBot.setMode(0, PinMode.Output);
        while (true) {
            BoeBot.digitalWrite(0, state);
            state = !state;
            BoeBot.wait(1000);
        }
    }

    private static void week1exercise2b() {
        BoeBot.setMode(0, PinMode.Output);
        while (true) {
            BoeBot.digitalWrite(0, true);
            BoeBot.wait(1000);
            BoeBot.digitalWrite(0, false);
            BoeBot.wait(2000);
        }
    }

    private static void week1exercise2c() {
        boolean state = true;
        BoeBot.setMode(0, PinMode.Output);
        while (true) {
            BoeBot.digitalWrite(0, state);
            state = !state;
            BoeBot.wait(100);
        }
    }

    private static void week1exercise2d() {
        boolean state = true;
        BoeBot.setMode(0, PinMode.Output);
        while (true) {
            BoeBot.digitalWrite(0, state);
            state = !state;
            BoeBot.wait(20);
        }
    }

    private static void week1exercise3a() {
        boolean state = true;
        BoeBot.setMode(0, PinMode.Output);
        BoeBot.setMode(1, PinMode.Output);
        while (true) {
            BoeBot.digitalWrite(0, state);
            BoeBot.digitalWrite(1, state);
            state = !state;
            BoeBot.wait(1000);
        }
    }

    private static void week1exercise3b() {
        boolean state = true;
        BoeBot.setMode(0, PinMode.Output);
        BoeBot.setMode(1, PinMode.Output);
        while (true) {
            BoeBot.digitalWrite(0, state);
            BoeBot.wait(1000);
            BoeBot.digitalWrite(0, !state);
            BoeBot.digitalWrite(1, state);
            BoeBot.wait(1000);
            BoeBot.digitalWrite(1, !state);
        }
    }

    private static void week1exercise3c() {
        boolean state = true;
        boolean state2 = true;
        Timer t1 = new Timer(1000);
        Timer t2 = new Timer(500);
        BoeBot.setMode(0, PinMode.Output);
        BoeBot.setMode(1, PinMode.Output);
        while (true) {
            if (t1.timeout()) {
                BoeBot.digitalWrite(0, state);
                t1.mark();
                state = !state;
            }
            if (t2.timeout()) {
                BoeBot.digitalWrite(1, state2);
                t2.mark();
                state2 = !state2;
            }
            BoeBot.wait(1);
        }
    }

    private static void week1exercise3d() {
        boolean state = true;
        boolean state2 = true;
        Timer t1 = new Timer(1300);
        Timer t2 = new Timer(700);
        BoeBot.setMode(0, PinMode.Output);
        BoeBot.setMode(1, PinMode.Output);
        while (true) {
            if (t1.timeout()) {
                BoeBot.digitalWrite(0, state);
                t1.mark();
                state = !state;
            }
            if (t2.timeout()) {
                BoeBot.digitalWrite(1, state2);
                t2.mark();
                state2 = !state2;
            }
            BoeBot.wait(1);
        }
    }

    private static void week1exercise3e() {
        boolean state = true;
        boolean state2 = true;
        Timer t1 = new Timer(1300);
        Timer t2 = new Timer(99999);
        Timer t3 = new Timer(800);
        Timer t4 = new Timer(99999);
        BoeBot.setMode(0, PinMode.Output);
        BoeBot.setMode(1, PinMode.Output);
        BoeBot.digitalWrite(0, state);
        BoeBot.digitalWrite(1, state);
        while (true) {
            if (t1.timeout()) {
                state = !state;
                BoeBot.digitalWrite(0, state);
                t1.setInterval(9999999);
                t2.setInterval(700);
            }
            if (t2.timeout()) {
                state = !state;
                BoeBot.digitalWrite(0, state);
                t2.setInterval(9999999);
                t1.setInterval(1300);
            }
            if (t3.timeout()) {
                state2 = !state2;
                BoeBot.digitalWrite(1, state2);
                t3.setInterval(999999);
                t4.setInterval(1700);
            }
            if (t4.timeout()) {
                state2 = !state2;
                BoeBot.digitalWrite(1, state2);
                t4.setInterval(999999);
                t3.setInterval(800);
            }
            BoeBot.wait(1);
        }
    }

    private static void week1exercise4a() {
        BoeBot.setMode(0, PinMode.Output);
        BoeBot.setMode(2, PinMode.Input);
        while (true) {
            BoeBot.digitalWrite(0, BoeBot.digitalRead(2));
        }
    }

    private static void week1exercise4b() {
        boolean state = true;
        BoeBot.setMode(0, PinMode.Output);
        BoeBot.setMode(2, PinMode.Input);
        while (true) {
            if (BoeBot.digitalRead(2)) {
                while (BoeBot.digitalRead(2)) {
                    BoeBot.digitalWrite(0, state);
                    state = !state;
                    BoeBot.wait(1000);
                }
            } else {
                BoeBot.digitalWrite(0, false);
            }
        }
    }

    private static void week1exercise4c() {
        boolean state = true;
        BoeBot.setMode(0, PinMode.Output);
        BoeBot.setMode(1, PinMode.Output);
        BoeBot.setMode(2, PinMode.Input);
        Timer t1 = new Timer(1300);
        Timer t2 = new Timer(9999999);
        while (true) {
            if (BoeBot.digitalRead(2)) {
                BoeBot.digitalWrite(1, false);
                t1.mark();
                t2.mark();
                while (BoeBot.digitalRead(2)) {
                    if (t1.timeout()) {
                        state = !state;
                        BoeBot.digitalWrite(0, state);
                        t1.setInterval(9999999);
                        t2.setInterval(700);
                    }
                    if (t2.timeout()) {
                        state = !state;
                        BoeBot.digitalWrite(0, state);
                        t2.setInterval(9999999);
                        t1.setInterval(1300);
                    }
                    BoeBot.wait(1);
                }
            } else {
                BoeBot.digitalWrite(0, false);
                BoeBot.digitalWrite(1, true);
            }
        }
    }

    private static void week1exercise5c() {
        boolean state = true;
        boolean state2 = true;
        BoeBot.setMode(0, PinMode.Output);
        BoeBot.setMode(1, PinMode.Output);
        BoeBot.setMode(2, PinMode.Input);
        BoeBot.setMode(3, PinMode.Input);
        Timer t1 = new Timer(1000);
        Timer t2 = new Timer(700);
        while (true) {
            if (BoeBot.digitalRead(2)) {
                BoeBot.digitalWrite(1, false);
                t1.mark();
                t2.mark();
                while (BoeBot.digitalRead(2)) {
                    if (t1.timeout()) {
                        state = !state;
                        BoeBot.digitalWrite(0, state);
                        t1.mark();
                    }
                    BoeBot.wait(1);
                }
            }
            if (BoeBot.digitalRead(3)) {
                BoeBot.digitalWrite(0, false);
                t1.mark();
                t2.mark();
                while (BoeBot.digitalRead(3)) {
                    if (t2.timeout()) {
                        state = !state;
                        BoeBot.digitalWrite(1, state);
                        t2.mark();
                    }

                    BoeBot.wait(1);
                }
            }
        }
    }
}