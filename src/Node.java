import java.util.Random;

public class Node{
    private final int element;
    private int height;

    private final boolean minBound;
    private final boolean maxBound;

    private Node top, right, bottom, left;

    //---------------------- CONSTRUCTOR 1
    public Node(int element, int height) {
        this.minBound   = false;
        this.maxBound   = false;

        this.element    = element;
        this.height     = height;
    }

    //---------------------- CONSTRUCTOR 2
    public Node(int element, boolean minBound, boolean maxBound) {
        this.minBound = minBound;
        this.maxBound = maxBound;

        this.element = element;

        this.top = null;
        this.right = null;
        this.bottom = null;
        this.left = null;
    }

    //------------------------ ACCESSORS
    public int getElement() {
        return this.element;
    }

    public Node getTop() {
        return this.top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public Node getRight() {
        return this.right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getBottom() {
        return this.bottom;
    }

    public void setBottom(Node bottom) {
        this.bottom = bottom;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public boolean isMinBound() {
        return minBound;
    }

    public boolean isMaxBound() {
        return maxBound;
    }

    //------------------------ METHODS
    public int calculateHeight() {
        Random random = new Random();
        int numberHeight = 0;

        while (random.nextBoolean()) {
            numberHeight++;
        }

        return numberHeight;
    }

}

