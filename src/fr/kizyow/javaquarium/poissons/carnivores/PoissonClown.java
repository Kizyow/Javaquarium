package fr.kizyow.javaquarium.poissons.carnivores;

import fr.kizyow.javaquarium.entities.Race;
import fr.kizyow.javaquarium.entities.Sex;
import fr.kizyow.javaquarium.entities.SexType;

public class PoissonClown extends Carnivore {

    public PoissonClown(String name, Sex sex, int age) {
        super(name, sex, SexType.OPPORTUNISTE, age, Race.CLOWN);
    }

}
