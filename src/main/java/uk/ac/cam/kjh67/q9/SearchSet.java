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

public class SearchSet {
    private int mElements;
    private BinaryTreeNode mHead;

    // Constructor
    SearchSet() { this.mElements = 0; this.mHead = null; }

    public void insert(int value) {
        if (mHead == null) {
            mHead = new BinaryTreeNode(value);
            mElements++;
            return;
        }
        boolean inserted = false;
        BinaryTreeNode current = mHead;
        while (!inserted) {
            if (value == current.getValue()) {
                // don't insert duplicate elements
                inserted = true;
            }
            else if (value < current.getValue()) {
                if (current.getLeft() == null) {
                    current.setLeft(new BinaryTreeNode(value));
                    inserted = true;
                    mElements++;
                }
                else {
                    current = current.getLeft();
                }
            }
            else {
                if (current.getRight() == null) {
                    current.setRight(new BinaryTreeNode(value));
                    inserted = true;
                    mElements++;
                }
                else {
                    current = current.getRight();
                }
            }
        }
    }

    public int getNumberElements() { return mElements; }

    public boolean contains (int value) {
        boolean found = false;
        BinaryTreeNode current = mHead;

        while (!found && current != null) {
            int currentValue = current.getValue();
            if (currentValue == value) {
                found = true;
            }
            else if (currentValue > value) {
                current = current.getLeft();
            }
            else {
                current = current.getRight();
            }
        }
        return found;
    }

    public static void main(String[] args) {
        // do stuff
    }

    @Override
    public String toString() {
        return String.format("{%s}", mHead==null ? "" : mHead.toString());
    }
}
