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

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ActionTest {

    private static final String FOO_SHARE1 = "Foo Share 1";
    private static final String FOO_SHARE2 = "Foo Share 2";
    private static final HashMap<Jour, Double> COUR = new HashMap<>();


    @Test
    void testGetLibelleReturnConstructorParameter() {
        final Action action = new ActionImpl(FOO_SHARE1);
        final String result = action.getLibelle();

        Assertions.assertEquals(FOO_SHARE1, result,
                "Property Libelle value should be the same as the parameter used for construction");
    }

    @Test
    void testToStringReturnConstructorParameter() {
        final Action action = new ActionImpl(FOO_SHARE1);
        final String result = action.toString();

        Assertions.assertEquals(FOO_SHARE1, result,
                "Property Libelle value should be the same as the parameter used for construction");
    }

    @Test
    void testEqualsWithSameObject() {
        final Action action = new ActionImpl(FOO_SHARE1);
        boolean rs = action.equals(action);
        Assertions.assertEquals(true, rs);
    }

    @Test
    void testEqualsWithSimilarObject() {
        final Action action1 = new ActionImpl(FOO_SHARE1);
        final Action action2 = new ActionImpl(FOO_SHARE1);

        boolean rs = action1.equals(action2);
        Assertions.assertEquals(true, rs);
    }

    @Test
    void testEqualsWithDifferentObject() {
        final Action action1 = new ActionImpl(FOO_SHARE1);
        final Action action2 = new ActionImpl(FOO_SHARE2);

        boolean rs = action1.equals(action2);
        Assertions.assertEquals(false, rs);
    }

    @Test
    void testEqualsWithNullObject() {
        final Action action1 = new ActionImpl(FOO_SHARE1);
        final Action action2 = null;

        boolean rs = action1.equals(action2);
        Assertions.assertEquals(false, rs);
    }

    @Test
    void testEqualsWithObjectFromOtherClass() {
        final Action action1 = new ActionImpl(FOO_SHARE1);
        final Integer action2 = 0;

        boolean rs = action1.equals(action2);
        Assertions.assertEquals(false, rs);
    }

    @Test
    void testHashCode() {
        final Action action = new ActionImpl(FOO_SHARE1);
        Assertions.assertDoesNotThrow(action::hashCode, "hashcode must always provide a value");
    }

    @Test
    void testGetHashMap() {
        final Action action = new ActionImpl(FOO_SHARE1);
        Map<Jour, Double> result = action.getMapCours();

        assertEquals(COUR, result);
    }

    private static class ActionImpl extends Action {

        public ActionImpl(final String aLabel) {
            super(aLabel,COUR);
        }

    }

}
