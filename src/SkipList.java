public class SkipList {
    private SkipListElementInt lower;
    private SkipListElementInt upper;

    private int heightMax;

    public SkipList() {
        this.lower      = new SkipListElementInt(Integer.MIN_VALUE);
        this.upper      = new SkipListElementInt(Integer.MAX_VALUE);

        this.lower.setRight(this.upper);
        this.upper.setLeft(this.lower);

        this.heightMax  = 1;
    }

    public SkipListElementInt searchElementInt(SkipListElementInt inSkipList, int element) {

        SkipListElementInt result;

        if (inSkipList != null) {
            if (element < inSkipList.getElement()) {
                result = searchElementInt(inSkipList.getBottom(), element);
            } else if (element > inSkipList.getElement()) {
                result = searchElementInt(inSkipList.getRight(), element);
            } else {
                result = inSkipList;
            }
        } else {
            result =  inSkipList.getLeft();
        }

        return result;
    }
}
