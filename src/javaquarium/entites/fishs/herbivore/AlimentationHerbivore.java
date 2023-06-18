package javaquarium.entites.fishs.herbivore;

import javaquarium.Aquarium;
import javaquarium.Rapport;
import javaquarium.entites.algues.Algue;
import javaquarium.entites.fishs.Alimentation;
import javaquarium.entites.fishs.Poisson;

import java.io.Serializable;

public class AlimentationHerbivore implements Alimentation, Serializable {

    @Override
    public void manger(Poisson poisson, Aquarium aquarium) {

        if (aquarium.alguesMortes()) {
            Rapport.info("Toutes les algues sont mortes, les poissons herbivores ne peuvent plus manger");

        } else {

            int algueIndex;
            Algue algueChoisi;

            do {
                algueIndex = aquarium.getRandom().nextInt(aquarium.getAlgues().size());
                algueChoisi = aquarium.getAlgues().get(algueIndex);

            } while (algueChoisi.estMort());

            poisson.ajouterPV(3);
            algueChoisi.retirerPV(2);

            Rapport.info("Le poisson " + poisson.getNom() + " a mangé l'algue n°" + algueIndex + " (" + algueChoisi.getPV() + " PV restant)");
        }

    }

}
