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

package uk.ac.cam.kjh67.q9;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

@RunWith(JUnit4.class)
public class FunctionalArrayTests {

    @Test
    public void functionalArray_throwsIllegalArgumentException_forNegativeLength() {
        // ASSERT
        assertThrows(IllegalArgumentException.class, () -> new FunctionalArray(-1));
    }

    @Test
    public void functionalArray_constructedCorrectly_forLength0() {
        // ARRANGE
        FunctionalArray funArray = new FunctionalArray(0);

        // ASSERT
        assertThat(funArray.toString()).isEqualTo("[]");
    }

    @Test
    public void functionalArray_constructedCorrectly_forLength1() {
        // ARRANGE
        FunctionalArray funArray = new FunctionalArray(1);

        // ASSERT
        assertThat(funArray.toString()).isEqualTo("[0]");
    }

    @Test
    public void functionalArray_constructedCorrectly_forLength5() {
        // ARRANGE
        FunctionalArray funArray = new FunctionalArray(5);

        // ASSERT
        assertThat(funArray.toString()).isEqualTo("[0,0,0,0,0]");
    }

    @Test
    public void functionalArray_setsValidIndex() {
        // ARRANGE
        FunctionalArray funArray = new FunctionalArray(3);

        // ACT
        funArray.set(2, 1);

        // ASSERT
        assertThat(funArray.toString()).isEqualTo("[0,0,1]");
    }

    @Test
    public void functionalArray_setThrowsIllegalArgumentException_forNegativeIndex() {
        // ARRANGE
        FunctionalArray funArray = new FunctionalArray(5);

        // ASSERT
        assertThrows(IllegalArgumentException.class, () -> funArray.set(-1, 1));
    }

    @Test
    public void functionalArray_setThrowsIllegalArgumentException_forIndexAboveUpperBound() {
        // ARRANGE
        FunctionalArray funArray = new FunctionalArray(5);

        // ASSERT
        assertThrows(IllegalArgumentException.class, () -> funArray.set(5, 1));
    }

    @Test
    public void functionalArray_getsForValidIndex() {
        // ARRANGE
        FunctionalArray funArray = new FunctionalArray(3);

        // ACT
        funArray.set(2, 5);
        int result = funArray.get(2);

        // ASSERT
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void functionalArray_getThrowsIllegalArgumentException_forNegativeIndex() {
        // ARRANGE
        FunctionalArray funArray = new FunctionalArray(5);

        // ASSERT
        assertThrows(IllegalArgumentException.class, () -> funArray.get(-1));
    }

    @Test
    public void functionalArray_getThrowsIllegalArgumentException_forIndexAboveUpperBound() {
        // ARRANGE
        FunctionalArray funArray = new FunctionalArray(5);

        // ASSERT
        assertThrows(IllegalArgumentException.class, () -> funArray.get(5));
    }

}
