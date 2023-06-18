package javaquarium.entites.fishs;

import javaquarium.entites.Sexe;
import javaquarium.entites.fishs.carnivore.Clown;
import javaquarium.entites.fishs.carnivore.Merou;
import javaquarium.entites.fishs.carnivore.Thon;
import javaquarium.entites.fishs.herbivore.Bar;
import javaquarium.entites.fishs.herbivore.Carpe;
import javaquarium.entites.fishs.herbivore.Sole;

public class PoissonFactory {

    public static Poisson creerPoisson(String nom, int age, Sexe sexe, String espece) {
        return switch (espece) {
            case "Poisson-clown" -> creerPoissonClown(nom, age, sexe);
            case "Merou" -> creerMerou(nom, age, sexe);
            case "Thon" -> creerThon(nom, age, sexe);
            case "Bar" -> creerBar(nom, age, sexe);
            case "Carpe" -> creerCarpe(nom, age, sexe);
            case "Sole" -> creerSole(nom, age, sexe);
            default -> throw new IllegalArgumentException("L'espece n'existe pas");
        };
    }

    public static Poisson creerPoissonClown(String nom, int age, Sexe sexe) {
        return new Clown(nom, age, sexe);
    }

    public static Poisson creerMerou(String nom, int age, Sexe sexe) {
        return new Merou(nom, age, sexe);
    }

    public static Poisson creerThon(String nom, int age, Sexe sexe) {
        return new Thon(nom, age, sexe);
    }

    public static Poisson creerBar(String nom, int age, Sexe sexe) {
        return new Bar(nom, age, sexe);
    }

    public static Poisson creerCarpe(String nom, int age, Sexe sexe) {
        return new Carpe(nom, age, sexe);
    }

    public static Poisson creerSole(String nom, int age, Sexe sexe) {
        return new Sole(nom, age, sexe);
    }

}
