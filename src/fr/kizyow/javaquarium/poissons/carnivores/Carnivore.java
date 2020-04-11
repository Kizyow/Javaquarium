package fr.kizyow.javaquarium.poissons.carnivores;

import fr.kizyow.javaquarium.entities.Entity;
import fr.kizyow.javaquarium.entities.Race;
import fr.kizyow.javaquarium.entities.Sex;
import fr.kizyow.javaquarium.entities.SexType;
import fr.kizyow.javaquarium.poissons.Poisson;

public abstract class Carnivore extends Poisson {

    public Carnivore(String name, Sex sex, SexType sexType, int age, Race race) {
        super(name, sex, sexType, age, race);
    }

    @Override
    public void eat(Entity entity){

        if(entity instanceof Poisson && ((Poisson) entity).getRace() != this.getRace()){
            entity.removeLife(4);
            this.giveLife(5);

        }

    }

}
