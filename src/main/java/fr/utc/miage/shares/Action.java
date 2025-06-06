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
import java.util.Objects;

/**
 * This class embeds thecommon behavior of any Action object.
 *
 * @author David Navarre &lt;David.Navarre at irit.fr&gt;
 */
public abstract class Action {

    private String libelle;
    private final Map<Jour, Double> mapCours;

    /**
     * 
     * @return le tabeau du cours de l'action
     */
    public Map<Jour, Double> getMapCours() {
        return mapCours;
    }

    /**
     * Get the value of libelle
     *
     * @return the value of libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Modifier le nom de l'action
     * @param libelleS nouveau nom pour l'action
     */
    public void setLibelle(String libelleS){
        this.libelle=libelleS;
    }

    /**
     * Builds an Action object from a string parameter.
     * @param libelle le nom de l'action 
     * @param cour le tableau des cours
     */
    protected Action(final String libelle, final HashMap<Jour,Double> cour) {
        this.libelle = libelle;
        this.mapCours = cour;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.libelle);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Action other = (Action) obj;
        return Objects.equals(this.libelle, other.libelle);
    }

    @Override
    public String toString() {
        return this.getLibelle();
    }
}
