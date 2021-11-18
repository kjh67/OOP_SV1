/*
 * Copyright 2021 K.J. Hawkins <kjh67@cam.ac.uk>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.kjh67.q14;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.google.common.truth.Truth.assertThat;

@RunWith(JUnit4.class)
public class Vector2DTests {

    @Test
    public void vector2D_additionWorksCorrectly() {
        // ARRANGE
        Vector2D v1 = new Vector2D(1.0,1.0);
        Vector2D v2 = new Vector2D(2.0,3.0);

        // ACT
        v1.add(v2);

        // ASSERT
        assertThat(v1.toString()).isEqualTo("(3.0,4.0)");
    }

    @Test
    public void vector2D_scalarProductCalculatedCorrectly() {
        // ARRANGE
        Vector2D v1 = new Vector2D(1.0,2.0);
        Vector2D v2 = new Vector2D(0.0,5.0);

        // ACT
        double result = v1.scalarProduct(v2);

        // ASSERT
        assertThat(result).isWithin(1E-7).of(10.0);
    }

    @Test
    public void vector2D_magnitudeIsCorrect() {
        // ARRANGE
        Vector2D v1 = new Vector2D(3.0,4.0);

        // ACT
        double result = v1.magnitude();

        // ASSERT
        assertThat(result).isWithin(1E-7).of(5.0);
    }

    @Test
    public void vector2D_normalisesCorrectly() {
        // ARRANGE
        Vector2D v1 = new Vector2D(1.0,3.0);

        // ACT
        v1.normalise();

        // ASSERT
        assertThat(v1.magnitude()).isWithin(1E-7).of(1.0);
    }
}
