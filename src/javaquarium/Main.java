package javaquarium;

import java.util.Scanner;

public class Main {

    /**
     * javaquarium.Main program
     *
     * @param args
     */
    public static void main(String[] args) {

        if(args.length < 1){
            System.err.println("Usage: java Main <file>");
            System.exit(1);
        }

        Aquarium aquarium = new Aquarium();

        aquarium.chargerAquarium(args[0]);

        Scanner scanner = new Scanner(System.in);
        String line = "";

        while (!line.equals("STOP")) {
            aquarium.tourSuivant();
            line = scanner.nextLine();
        }

        aquarium.sauvegarderAquarium();
        Rapport.enregisterLogs();

    }

}