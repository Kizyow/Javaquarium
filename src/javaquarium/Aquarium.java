package javaquarium;

import javaquarium.entites.EtreVivant;
import javaquarium.entites.Sexe;
import javaquarium.entites.algues.Algue;
import javaquarium.entites.fishs.Poisson;
import javaquarium.entites.fishs.PoissonFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aquarium implements Serializable {

    private int tourCompteur = 1;
    private List<Poisson> poissons = new ArrayList<>();
    private List<Algue> algues = new ArrayList<>();
    private Random random;

    public Aquarium() {
        this.random = new Random();
    }

    /**
     * Ajouter un nouveau poisson dans l'aquarium
     *
     * @param poisson Le poisson a ajouter
     */
    public void ajouterPoisson(Poisson poisson) {
        Rapport.info("Ajout d'un nouveau poisson");
        poissons.add(poisson);
    }

    /**
     * Ajouter un nouvel algue dans l'aquarium
     */
    public Algue ajouterAlgue(int age) {
        Rapport.info("Ajout d'un nouvel algue");
        Algue algue = new Algue(age);
        algues.add(algue);
        return algue;
    }

    public void evoluerAquarium() {
        new ArrayList<>(algues).forEach(algue -> algue.evoluer(this));
        new ArrayList<>(poissons).forEach(poisson -> poisson.evoluer(this));
    }

    public void nettoyerAquarium() {
        poissons.removeIf(EtreVivant::estMort);
        algues.removeIf(EtreVivant::estMort);
    }

    public boolean alguesMortes() {
        for (Algue algue : algues) {
            if (!algue.estMort()) {
                return false;
            }
        }
        return true;
    }

    public boolean poissonsMorts() {
        for (Poisson poisson : poissons) {
            if (!poisson.estMort()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Passer au tour suivant dans l'aquarium
     */
    public void tourSuivant() {

        Rapport.info("--------------------[EVOLUTION]--------------------");

        this.evoluerAquarium();
        this.nettoyerAquarium();

        Rapport.info("--------------------[TOUR " + tourCompteur + "]--------------------");
        Rapport.info("Nombre de poissons : " + poissons.size());
        Rapport.info("Nombre d'algues : " + algues.size());
        tourCompteur++;
    }

    public void sauvegarderAquarium() {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("output.poisson");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void chargerAquarium(String file) {

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // STATE (1 = algue, 2 = poisson)
            int state = 1;
            String line = "";

            while ((line = bufferedReader.readLine()) != null) {

                if (line.isEmpty()) {
                    state++;
                    continue;
                }

                if (state == 1) {
                    String[] split = line.split(" ");
                    int nbAlgues = Integer.parseInt(split[0]);
                    int ageAlgue = Integer.parseInt(split[2]);

                    for (int i = 0; i < nbAlgues; i++) {
                        this.ajouterAlgue(ageAlgue);
                    }
                }

                if (state == 2) {
                    String[] split = line.split(", ");
                    String nom = split[0];
                    String race = split[1];
                    Sexe sexe = Sexe.random();
                    int agePoisson = Integer.parseInt(split[2].split(" ")[0]);

                    this.ajouterPoisson(PoissonFactory.creerPoisson(nom, agePoisson, sexe, race));
                }

            }

            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Poisson> getPoissons() {
        return poissons;
    }

    public List<Algue> getAlgues() {
        return algues;
    }

    public int getTourCompteur() {
        return tourCompteur;
    }

    public Random getRandom() {
        return random;
    }

}
