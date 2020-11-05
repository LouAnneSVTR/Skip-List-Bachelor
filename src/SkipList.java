public class SkipList {
    private SkipListInt lower;
    private SkipListInt upper;
    private int heightMax;

    private SkipListInt test;

    //---------------------- CONSTRUCTOR 1
    public SkipList() {
        this.lower     = new SkipListInt(Integer.MIN_VALUE, true, false);
        this.upper    = new SkipListInt(Integer.MAX_VALUE, false, true);

        this.test       = new SkipListInt(3, 1);

        this.lower.setRight(this.test);
        this.test.setLeft(this.lower);
        this.test.setRight(this.upper);
        this.upper.setLeft(this.test);

        this.heightMax      = 1;
    }

    //------------------------ METHODS
    public SkipListInt searchElementInt(SkipListInt inSkipList, int element) {

        SkipListInt result;

        if (!inSkipList.isMaxBound()) {
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
            result =  null;
        }

        return result;
    }

    public SkipListInt getLower() {
        return lower;
    }
}
