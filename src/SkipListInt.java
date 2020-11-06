import java.util.Random;

public class SkipListInt{
    private final int element;
    private int height;

    private final boolean minBound;
    private final boolean maxBound;

    private SkipListInt top, right, bottom, left;

    //---------------------- CONSTRUCTOR 1
    public SkipListInt(int element, int height) {
        this.minBound   = false;
        this.maxBound   = false;

        this.element    = element;
        this.height     = height;
    }

    //---------------------- CONSTRUCTOR 2
    public SkipListInt(int element, boolean minBound, boolean maxBound) {
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

    public SkipListInt getTop() {
        return this.top;
    }

    public void setTop(SkipListInt top) {
        this.top = top;
    }

    public SkipListInt getRight() {
        return this.right;
    }

    public void setRight(SkipListInt right) {
        this.right = right;
    }

    public SkipListInt getBottom() {
        return this.bottom;
    }

    public void setBottom(SkipListInt bottom) {
        this.bottom = bottom;
    }

    public SkipListInt getLeft() {
        return this.left;
    }

    public void setLeft(SkipListInt left) {
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

