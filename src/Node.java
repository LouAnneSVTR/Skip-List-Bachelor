import java.util.Random;

public class Node{
    private Node top, right, bottom, left;
    private int height;

    private int element;

    private Node (int element, int height) {
        this.element            = element;

        this.height             = height;

        this.top                = null;
        this.right              = null;
        this.bottom             = null;
        this.left               = null;
    }

    public Node (int element) {
        this.element            = element;

        this.height             = this.calculateHeight();

        this.top                = null;
        this.right              = null;
        this.bottom             = null;
        this.left               = null;
    }

    public Node() {
        this.element            = Integer.MIN_VALUE;

        this.height          = 1;

        this.top                = null;
        this.right              = null;
        this.bottom             = null;
        this.left               = null;

        this.initialiserNode();
    }

    private void initialiserNode() {

        Node upper = new Node(Integer.MAX_VALUE, 1);

        this.right = upper;
        upper.setLeft(this);
    }

    public int getElement() {
        return element;
    }
    public Node getTop() {
        return top;
    }
    public Node getRight() {
        return right;
    }
    public Node getBottom() {
        return bottom;
    }
    public Node getLeft() {
        return left;
    }
    public int getHeight() {
        return this.height;
    }

    public void setTop(Node top) {
        this.top = top;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public void setBottom(Node bottom) {
        this.bottom = bottom;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isMaxBound() {
        return this.getElement() == Integer.MAX_VALUE;
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

