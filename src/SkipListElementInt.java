import java.util.Random;

public class SkipListElementInt extends SkipListBound{
    private final int element;
    private int height;



    public SkipListElementInt(int element) {
        super();
        this.element = element;
        this.height = this.calculateHeight();

    }

    //------------------------ ACCESSORS
    public int getElement() {
        return this.element;
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

