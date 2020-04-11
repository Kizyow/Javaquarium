package fr.kizyow.javaquarium.poissons.herbivores;

import fr.kizyow.javaquarium.entities.*;
import fr.kizyow.javaquarium.poissons.Poisson;

public abstract class Herbivore extends Poisson {


    public Herbivore(String name, Sex sex, SexType sexType, int age, Race race) {
        super(name, sex, sexType, age, race);
    }

    @Override
    public void eat(Entity entity){

        if(entity instanceof Algue){
            entity.removeLife(2);
            this.giveLife(3);

        }

    }

}
