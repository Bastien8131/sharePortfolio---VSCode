/*
 * Copyright 2025 David Navarre &lt;David.Navarre at irit.fr&gt;.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.utc.miage.shares;

import java.util.HashMap;
import java.util.Map;

/**
 * Allows the creation of simple Action objects.
 *
 * @author David Navarre &lt;David.Navarre at irit.fr&gt;
 */
public class ActionSimple extends Action {

    /* Propriétées */
    private static final double DEFAULT_ACTION_VALUE = 0.01;
    private Map<Jour, Double> cour = new HashMap<>();

    /**
     * Constructeur
     * 
     * @param libelle le nom donnée à l'action
     * @param cour    le tableau des cours de l'action
     */
    public ActionSimple(final String libelle, final HashMap<Jour, Double> cour) {
        // Action simple initialisée comme 1 action
        super(libelle, cour);
    }

    /**
     * 
     * @return la valeur par défaut de l'action en double
     */
    public static double getDefaultActionValue() {
        return DEFAULT_ACTION_VALUE;
    }

    /**
     * Ajoute un cours au tableau de l'action
     * 
     * @param jour   le jour du cours
     * @param valeur la valeur du cours
     */
    public void ajouterCours(Jour jour, double valeur) {
        if (valeur <= 0.0) {
            throw new IllegalArgumentException("La valeur du cours doit être strictement positive.");
        }
        cour.put(jour, valeur);
    }


    /**
     * Recupère la valeur de l'action un jour donnée
     * 
     * @param jour le jour (année, jour)
     * @return la valeur de l'action un jour donnée
     */
    public double valeurActionSimpleDateDonnee(Jour jour) {
        return this.cour.get(jour);
    }

    /**
     * Modification des paramètre d'une action simple
     * 
     * @param libelle le nouveau nom de l'action
     * @param cour    le nouveau tableau
     */
    public void modifierActionSimple(String libelle, Map<Jour, Double> cour) {
        if (libelle == null || libelle.isBlank() || cour == null || cour.isEmpty()) {
            throw new IllegalArgumentException("Libellé ou cours invalide");
        }
        setCour(cour);
        setLibelle(libelle);
    }

    /**
     * 
     * @return le tableau des cours
     */
    public Map<Jour, Double> getCour() {
        return cour;
    }

    /**
     * Setter du tableau d'une action simple
     * 
     * @param cour un nouveau tableau
     */
    public void setCour(Map<Jour, Double> cour) {
        this.cour = cour;
    }
}
