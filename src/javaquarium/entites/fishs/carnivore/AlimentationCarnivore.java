package javaquarium.entites.fishs.carnivore;

import javaquarium.Aquarium;
import javaquarium.Rapport;
import javaquarium.entites.fishs.Alimentation;
import javaquarium.entites.fishs.Poisson;

import java.io.Serializable;

public class AlimentationCarnivore implements Alimentation, Serializable {

    @Override
    public void manger(Poisson poisson, Aquarium aquarium) {

        int poissonIndex = aquarium.getRandom().nextInt(aquarium.getPoissons().size());
        Poisson poissonChoisi = aquarium.getPoissons().get(poissonIndex);

        if (poissonChoisi == poisson || poissonChoisi.getEspece().equals(poisson.getEspece()) || poissonChoisi.estMort()) {
            Rapport.info("Le poisson " + poisson.getNom() + " a essayé de manger " + poissonChoisi);
        } else {
            poisson.ajouterPV(5);
            poissonChoisi.retirerPV(4);

            Rapport.info("Le poisson " + poisson.getNom() + " a mangé le poisson " + poissonChoisi.getNom() + " (" + poissonChoisi.getPV() + " PV restant)");
        }


    }

}
