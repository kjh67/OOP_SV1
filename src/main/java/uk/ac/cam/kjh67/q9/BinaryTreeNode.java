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

public class BinaryTreeNode {
    private int mValue;
    private BinaryTreeNode mRight;
    private BinaryTreeNode mLeft;

    // Public constructor
    public BinaryTreeNode(int value) {
        this.mValue = value;
        this.mLeft = null;
        this.mRight = null;
    }

    public int getValue() { return mValue; }

    public void setValue(int value) { this.mValue = value; }

    public BinaryTreeNode getLeft() { return this.mLeft; }

    public BinaryTreeNode getRight() { return this.mRight; }

    public void setLeft(BinaryTreeNode left) { this.mLeft = left; }

    public void setRight(BinaryTreeNode right) { this.mRight = right; }

    @Override
    public String toString() {
        if (mLeft == null && mRight == null) {
            return String.valueOf(mValue);
        }
        else if (mLeft == null) {
            return mValue + "," + mRight;
        }
        else if (mRight == null) {
            return mLeft + "," + mValue;
        }
        return mLeft + "," + mValue + "," + mRight;
    }
}
