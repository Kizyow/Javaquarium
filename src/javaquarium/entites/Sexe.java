package javaquarium.entites;

import java.io.Serializable;
import java.util.Random;

public enum Sexe implements Serializable {

    MALE("male"),
    FEMELLE("femelle");

    private String nom;

    Sexe(String nom) {
        this.nom = nom;
    }

    /**
     * Choisir une sexualité au hasard
     *
     * @return Sexe
     */
    public static Sexe random() {
        Random random = new Random();
        int selected = random.nextInt(values().length);
        return values()[selected];
    }

    public static Sexe changerSexualite(Sexe sexe) {
        if (sexe == MALE) {
            return FEMELLE;
        } else {
            return MALE;
        }
    }

}
