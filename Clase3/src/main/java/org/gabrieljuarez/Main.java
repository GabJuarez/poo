package org.gabrieljuarez;
import org.gabrieljuarez.models.*;

public class Main {
    public static void main(String[] args) {
        Student estudiante1 = new Student("Gabriel", "Ingenieria en sistemas", "127");
        System.out.println(estudiante1.toString());

        Student estudiante2 = new Student("Silvio", "Marketing2673786", "837487877");
        System.out.println(estudiante2.toString());

        Student estudiante3 = new Student("ANDreS", "Nutricion", "3233");
        System.out.println(estudiante3.toString());
    }
}