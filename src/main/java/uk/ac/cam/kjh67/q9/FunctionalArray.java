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

// Indexing is from 0, but internally index from 1 (so add 1 to indices passed as arguments)
public class FunctionalArray {
    private BinaryTreeNode head;

    public FunctionalArray (int length) {
        // insert n nodes into the tree
        if (length < 0) {
            throw new IllegalArgumentException();
        }

        this.head = null;
        if (length > 0) {
            for (int i = 1; i <= length; i++) {
                insert(i);
            }
        }
    }

    private void insert (int position) {
        BinaryTreeNode current = head;
        while (position > 3) {
            if (position % 2 == 0) {
                // go left
                current = head.getLeft();
            }
            else {
                // go right
                current = head.getRight();
            }
            position = position / 2;
        }
        // if position is 1, the head must be null
        if (position == 1) {
            head = new BinaryTreeNode(0);
        }
        else if (position == 2) {
            current.setLeft(new BinaryTreeNode(0));
        }
        else {
            current.setRight(new BinaryTreeNode(0));
        }
    }

    public void set(int index, int value) {
        // traverse the nodes; if we reach a null node, throw something
        if (index<0) {
            throw new IllegalArgumentException();
        }

        // translate to functional array indices
        int i = index + 1;
        BinaryTreeNode current = head;

        while (i >=1) {
            if (current == null) {
                throw new IllegalArgumentException();
            }
            if (i == 1) {
                current.setValue(value);
            }
            if (i % 2 == 0) {
                current = current.getLeft();
            }
            else {
                current = current.getRight();
            }
            i = i/2;
        }
    }

    public int get(int index) {
        if (index<0) {
            throw new IllegalArgumentException();
        }
        // translate to functional array indices
        int i = index + 1;
        BinaryTreeNode current = head;
        boolean found = false;
        while (i >=1 && !found) {
            if (current == null) {
                throw new IllegalArgumentException();
            }
            if (i == 1) {
                found = true;
            }
            else if (i % 2 == 0) {
                current = current.getLeft();
            }
            else {
                current = current.getRight();
            }
            i = i/2;
        }
        return current.getValue();
    }

    @Override
    public String toString() {
        return String.format("[%s]", head==null ? "" : head.toString());
    }
}
