import java.util.Random;

public class SkipListElementInt{
    private int element;
    private int height;

    private boolean bound;

    private SkipListElementInt top, right, bottom, left;



    public SkipListElementInt(int element) {
        this.element = element;
        this.height = this.calculateHeight();

        this.bound  = false;
    }

    public SkipListElementInt() {
        this.bound = true;
        this.element = 0;
    }

    //------------------------ ACCESSORS
    public int getElement() {
        return this.element;
    }

    public SkipListElementInt getTop() {
        return this.top;
    }

    public void setTop(SkipListElementInt top) {
        this.top = top;
    }

    public SkipListElementInt getRight() {
        return this.right;
    }

    public void setRight(SkipListElementInt right) {
        this.right = right;
    }

    public SkipListElementInt getBottom() {
        return this.bottom;
    }

    public void setBottom(SkipListElementInt bottom) {
        this.bottom = bottom;
    }

    public SkipListElementInt getLeft() {
        return this.left;
    }

    public void setLeft(SkipListElementInt left) {
        this.left = left;
    }

    public boolean isBound() {
        return bound;
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

