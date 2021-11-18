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

package uk.ac.cam.kjh67.q6;

public class Main {

    public static void main(String[] args) {
        long long1 = 3L;
        long long2 = 2L;
        System.out.println(lowestCommon(long1,long2));
    }

    public static int lowestCommon(Long long1, Long long2) {
        // iterate over the longs; use a counter up to 64
        // if 64 is reached, no set bits in common
        int position = -1;
        int i = 0;
        while (i < 64) {
            if (((long1 & 1) == 1) && ((long2 & 1) == 1)) {
                position = i;
                break;
            }
            long1 = long1 >> 1;
            long2 = long2 >> 1;
            i++;
        }
        return position;
    }
}
