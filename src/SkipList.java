public class SkipList {
    private SkipListInt lower;
    private SkipListInt upper;
    private int heightMax;

    //---------------------- CONSTRUCTOR 1
    public SkipList() {
        this.lower     = new SkipListInt();
        this.upper    = new SkipListInt();

        this.lower.setRight(this.upper);
        this.upper.setLeft(this.lower);

        this.heightMax      = 1;
    }

    //------------------------ METHODS
    public SkipListInt searchElementInt(SkipListInt inSkipList, int element) {

        SkipListInt result;

        if (inSkipList != null) {

            if (element < inSkipList.getRight().getElement()) {
                result = searchElementInt(inSkipList.getBottom(), element);

            } else if (element > inSkipList.getRight().getElement()) {
                result = searchElementInt(inSkipList.getRight(), element);

            } else {
                result = inSkipList.getRight();
            }

        } else {
            result =  inSkipList.getLeft();
        }

        return result;
    }
}
