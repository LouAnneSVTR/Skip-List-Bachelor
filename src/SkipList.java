public class SkipList {
    private SkipListElementInt inSkipList;
    private SkipListElementInt outSkipList;

    private int heightMax;

    public SkipList() {
        this.inSkipList     = new SkipListElementInt();
        this.outSkipList    = new SkipListElementInt();

        this.heightMax      = 1;
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
