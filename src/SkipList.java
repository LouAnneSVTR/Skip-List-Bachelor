public class SkipList {
    private SkipListElementInt lower;
    private SkipListElementInt upper;

    private int heightMax;

    public SkipList() {
        this.lower      = new SkipListElementInt(Integer.MIN_VALUE);
        this.upper      = new SkipListElementInt(Integer.MAX_VALUE);

        //this.lower.getRight() = this.upper;

        this.heightMax  = 1;
    }

    public SkipListElementInt searchElementInt(SkipListElementInt inSkipList, int element) {

        if (inSkipList == null) {
            return null;
        } else if (element != inSkipList.getElement()) {
            if (inSkipList.getRight().getElement() < element) {
                return searchElementInt(inSkipList.getRight(), element);
            } else if (inSkipList.getBottom() != null) {
                return searchElementInt(inSkipList.getBottom(), element);
            } else {
                return inSkipList;
            }
        } else {
            return inSkipList;
        }
    }
}
