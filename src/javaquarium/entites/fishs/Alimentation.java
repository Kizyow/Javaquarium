package javaquarium.entites.fishs;

import javaquarium.Aquarium;

import java.io.Serializable;

/**
 * Patron de conception : Stratégie
 */
public interface Alimentation extends Serializable {

    /**
     * Permet de manger un poisson ou un algue ou les deux
     * @param poisson Le poisson qui va manger
     * @param aquarium L'aquarium afin de choisir l'entité à manger
     */
    void manger(Poisson poisson, Aquarium aquarium);

}
