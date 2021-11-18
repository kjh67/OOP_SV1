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

@RunWith(JUnit4.class)
public class SearchSetTests {
    @Test
    public void searchSet_insertsOneItem() {
        // ARRANGE
        SearchSet searchSet = new SearchSet();

        // ACT
        searchSet.insert(1);

        // ASSERT
        assertThat(searchSet.toString()).isEqualTo("{1}");
    }

    @Test
    public void searchSet_insertsTwoItems() {
        // ARRANGE
        SearchSet searchSet = new SearchSet();

        // ACT
        searchSet.insert(5);
        searchSet.insert(3);

        // ASSERT
        assertThat(searchSet.toString()).isEqualTo("{3,5}");
    }

    @Test
    public void searchSet_insertsFiveItems() {
        // ARRANGE
        SearchSet searchSet = new SearchSet();

        // ACT
        searchSet.insert(5);
        searchSet.insert(3);
        searchSet.insert(1);
        searchSet.insert(7);
        searchSet.insert(6);

        // ASSERT
        assertThat(searchSet.toString()).isEqualTo("{1,3,5,6,7}");
    }

    @Test
    public void searchSet_searchingInEmptySet_ReturnsFalse() {
        // ARRANGE
        SearchSet empty = new SearchSet();

        // ACT
        boolean found = empty.contains(5);

        // ASSERT
        assertThat(found).isFalse();
    }

    @Test
    public void searchSet_searchingForSetMember_returnsTrue() {
        // ARRANGE
        SearchSet searchSet = new SearchSet();

        // ACT
        searchSet.insert(5);
        boolean found = searchSet.contains(5);

        // ASSERT
        assertThat(found).isTrue();
    }

    @Test
    public void searchSet_avoidsDuplication() {
        // ARRANGE
        SearchSet searchSet = new SearchSet();

        // ACT
        searchSet.insert(3);
        searchSet.insert(1);
        searchSet.insert(3);
        searchSet.insert(1);

        // ASSERT
        assertThat(searchSet.toString()).isEqualTo("{1,3}");
    }

    @Test
    public void searchSet_elementCount_isCorrectNoDuplication() {
        // ARRANGE
        SearchSet searchSet = new SearchSet();

        // ACT
        searchSet.insert(4);
        searchSet.insert(3);
        searchSet.insert(2);
        searchSet.insert(1);

        // ASSERT
        assertThat(searchSet.getNumberElements()).isEqualTo(4);
    }

    @Test
    public void searchSet_elementCount_isCorrectWithAttemptedDuplication() {
        // ARRANGE
        SearchSet searchSet = new SearchSet();

        // ACT
        searchSet.insert(4);
        searchSet.insert(3);
        searchSet.insert(4);
        searchSet.insert(1);

        // ASSERT
        assertThat(searchSet.getNumberElements()).isEqualTo(3);
    }
}
