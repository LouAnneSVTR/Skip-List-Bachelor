import java.util.Random;

public class SkipListElement {
    private final int element;
    private int height;

    private SkipListElement top, right, bottom, left;

    public SkipListElement(int element) {
        this.element = element;
        this.height = this.calculateHeight();

    }

    //------------------------ ACCESSORS
    public int getElement() {
        return this.element;
    }

    public SkipListElement getTop() {
        return this.top;
    }

    public void setTop(SkipListElement top) {
        this.top = top;
    }

    public SkipListElement getRight() {
        return this.right;
    }

    public void setRight(SkipListElement right) {
        this.right = right;
    }

    public SkipListElement getBottom() {
        return this.bottom;
    }

    public void setBottom(SkipListElement bottom) {
        this.bottom = bottom;
    }

    public SkipListElement getLeft() {
        return this.left;
    }

    public void setLeft(SkipListElement left) {
        this.left = left;
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

