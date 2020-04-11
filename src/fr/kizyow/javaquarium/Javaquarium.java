package fr.kizyow.javaquarium;

import fr.kizyow.javaquarium.entities.Algue;
import fr.kizyow.javaquarium.entities.Entity;
import fr.kizyow.javaquarium.entities.Sex;
import fr.kizyow.javaquarium.poissons.Poisson;
import fr.kizyow.javaquarium.poissons.carnivores.Merou;
import fr.kizyow.javaquarium.poissons.carnivores.PoissonClown;
import fr.kizyow.javaquarium.poissons.herbivores.Bar;
import fr.kizyow.javaquarium.poissons.herbivores.Carpe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Javaquarium {

    private List<Entity> entities;
    private static int tour;

    public static void main(String[] args){
        Javaquarium javaquarium = new Javaquarium();
        javaquarium.addAlgue(new Algue(0));
        javaquarium.addPoisson(new Merou("jacquie", Sex.FEMALE, 0));
        javaquarium.addAlgue(new Algue(0));
        javaquarium.addPoisson(new Carpe("michel", Sex.MALE, 0));
        javaquarium.addPoisson(new Carpe("michelle", Sex.FEMALE, 0));
        javaquarium.addPoisson(new PoissonClown("anna", Sex.FEMALE, 0));
        javaquarium.addPoisson(new PoissonClown("ash", Sex.MALE, 0));
        javaquarium.addPoisson(new Bar("theo", Sex.FEMALE, 0));

        while(tour < 40) {
            javaquarium.tour();
            tour++;
        }

    }

    public Javaquarium(){
        this.entities = new ArrayList<>();

    }

    public void addPoisson(Poisson poisson){
        entities.add(poisson);

    }

    public void addAlgue(Algue algue){
        entities.add(algue);

    }

    public void tour(){

            grandir();
            sexpoisson();
            sexalgue();
            entities.stream().filter(entity -> entity instanceof Poisson).forEach(entity -> miam((Poisson) entity));
            nettoyage();
            System.out.println(entities.stream().filter(entity -> entity instanceof Algue).count());
            entities.stream().filter(entity -> entity instanceof Poisson).forEach(entity -> System.out.println(entity.toString()));

    }

    public void nettoyage(){
        List<Entity> entitiesDead = entities.stream().filter(Entity::isDead).collect(Collectors.toList());
        entitiesDead.forEach(entity -> System.out.println("une entité à perdu la vie, adieu " + entity));
        entitiesDead.forEach(entity -> entities.remove(entity));
    }

    public void miam(Poisson poisson){

        if(poisson.isDead() || poisson.getLife() > 5) return;

        Random random = new Random();
        int index = random.nextInt(entities.size());
        Entity entity = entities.get(index);

        while(poisson.equals(entity) || entity.isDead()){
            index = random.nextInt(entities.size());
            entity = entities.get(index);

        }

        poisson.eat(entity);
        System.out.println("miam de " + poisson + " à " + entity);

    }

    public void grandir(){

        entities.stream().filter(entity -> entity instanceof Algue).forEach(entity -> entity.giveLife(1));
        entities.stream().filter(entity -> entity instanceof Poisson).forEach(entity -> entity.removeLife(1));
        entities.forEach(Entity::growAge);

    }

    public void sexpoisson(){

        Random random = new Random();
        List<Entity> poissonList = entities.stream().filter(entity -> entity instanceof Poisson).collect(Collectors.toList());

        if(poissonList.isEmpty()) return;

        int index = random.nextInt(poissonList.size());
        Poisson entity = (Poisson) poissonList.get(index);

        index = random.nextInt(poissonList.size());
        Poisson entity2 = (Poisson) poissonList.get(index);

        Poisson baby = entity.sex(entity2);
        if(baby != null) entities.add(baby);

    }

    public void sexalgue(){

        List<Entity> algueList = entities.stream().filter(entity -> entity instanceof Algue).collect(Collectors.toList());
        for(Entity entity : algueList){
            Algue algue = (Algue) entity;
            Algue baby = algue.sex(null);
            if(baby != null) entities.add(baby);

        }

    }

}
