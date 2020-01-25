import akka.actor.typed.ActorSystem;
import helloworld.HelloWorldMain;

import java.util.Scanner;

/**
 * Created by ilkayaktas on 25.01.2020 at 20:50.
 */

public class App {
    public static void main(String[] args) {
        System.out.println("Enter integer:");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        switch (input){
            case 1:
                exp1();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + input);
        }

    }

    private static void exp1(){
        final ActorSystem<HelloWorldMain.Start> system =
                ActorSystem.create(HelloWorldMain.create(), "hello");

        system.tell(new HelloWorldMain.Start("World"));
        system.tell(new HelloWorldMain.Start("Akka"));

        system.terminate();
    }
}
