public class SkipList {
    private SkipListInt lower;
    private SkipListInt upper;
    private int heightMax;

    private int numberElements;

    //---------------------- CONSTRUCTOR 1
    public SkipList() {
        this.lower     = new SkipListInt(Integer.MIN_VALUE, true, false);
        this.upper    = new SkipListInt(Integer.MAX_VALUE, false, true);

        this.lower.setRight(this.upper);
        this.upper.setLeft(this.lower);

        this.heightMax      = 1;

        this.numberElements = 0;
    }

    //------------------------ METHODS
    public SkipListInt searchElementInt(SkipListInt inSkipList, int element) {

        SkipListInt result;

        if (!this.isEmpty()) {
            if (element < inSkipList.getRight().getElement()) {
                if (inSkipList.getBottom() != null) {
                    result = searchElementInt(inSkipList.getBottom(), element);
                } else {
                    result = inSkipList;
                }

            } else if (element > inSkipList.getRight().getElement()) {
                if (!inSkipList.getRight().isMaxBound()) {
                    result = searchElementInt(inSkipList.getRight(), element);
                } else {
                    result = inSkipList;
                }

            } else {
                result = inSkipList.getRight();
            }

        } else {
            result =  this.lower;
        }

        result = getLevelZeroElement(result);

        return result;
    }

    public SkipListInt getLevelZeroElement(SkipListInt element) {
        if (element.getBottom() != null) {
            return getLevelZeroElement(element.getBottom());
        } else {
            return element;
        }
    }

    public boolean isEmpty() {
        return this.numberElements == 0;
    }

    public SkipListInt getLower() {
        return lower;
    }
}
