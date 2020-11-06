public class SkipList {
    private SkipList top, right, bottom, left;
    private int heightMax;

    private boolean isEmpty;

    private int elementSkipList;

    //---------------------- CONSTRUCTOR ------------------------
    public SkipList(int elementSkipList, int heightMax) {
        this.elementSkipList    = elementSkipList;

        this.heightMax          = heightMax;

        this.isEmpty            = false;

        this.top                = null;
        this.right              = null;
        this.bottom             = null;
        this.left               = null;

    }

    public SkipList() {
        this.elementSkipList    = Integer.MIN_VALUE;

        this.heightMax          = 1;

        this.isEmpty            = false;

        this.top                = null;
        this.right              = null;
        this.bottom             = null;
        this.left               = null;

        this.initialiserSkipList();
    }

    private void initialiserSkipList() {

        SkipList upper = new SkipList(Integer.MAX_VALUE, 1);

        this.right = upper;
        upper.setLeft(this);
    }

    //----------------------- ACCESSORS ------------------------
    public boolean isEmpty() {
        return this.right.getElementSkipList() == Integer.MAX_VALUE && this.bottom == null;
    }

    public int getElementSkipList() {
        return elementSkipList;
    }

    public SkipList getTop() {
        return top;
    }

    public SkipList getRight() {
        return right;
    }

    public SkipList getBottom() {
        return bottom;
    }

    public SkipList getLeft() {
        return left;
    }

    public void setTop(SkipList top) {
        this.top = top;
    }

    public void setRight(SkipList right) {
        this.right = right;
    }

    public void setBottom(SkipList bottom) {
        this.bottom = bottom;
    }

    public void setLeft(SkipList left) {
        this.left = left;
    }

    public boolean isMaxBound() {
        return this.getElementSkipList() == Integer.MAX_VALUE;
    }

    //------------------------ METHODS ------------------------

    // ----------------------- GET LEVEL
    public SkipList getLevelZeroElement(SkipList element) {
        if (element.getBottom() != null) {
            return getLevelZeroElement(element.getBottom());
        } else {
            return element;
        }
    }

    // ----------------------- INSERT
    /** @role : Insere un élément dans une skip list. On part de la borne minimal du niveau le plus haut de la skip list en parametre.
     *  @param Sk
     *  @param skElement */
    public void insert(SkipList Sk, SkipListInt skElement ){
        //Variable
        SkipListInt predecessor, memory;

        //Begin
        if(!Sk.isEmpty()){
            predecessor = searchElementInt(Sk.getLower(),skElement.getElement());
            memory = predecessor.getRight();
            predecessor.setRight(skElement);
            skElement.setRight(memory);
            Sk.setNumberElements()++;

        }
    }

    // ----------------------- SEARCH

    public SkipList searchElementInt(int findElement) {
        return searchElementInt(this, findElement);
    }
    public SkipList searchElementInt(SkipList inSkipList, int findElement) {
        //Variable
        SkipList result;

        //Begin
        if (!inSkipList.isEmpty()) {
            if (findElement < inSkipList.getElementSkipList()) {
                if (inSkipList.getBottom() != null) {
                    result = searchElementInt(inSkipList.getBottom(), findElement);
                } else {
                    result = inSkipList;
                }

            } else if (findElement > inSkipList.getElementSkipList()) {
                if (!inSkipList.getRight().isMaxBound()) {
                    result = searchElementInt(inSkipList.getRight(), findElement);
                } else {
                    result = inSkipList;
                }

            } else {
                result = inSkipList.getRight();
            }

        } else {
            result =  inSkipList;
        }

        result = getLevelZeroElement(result);
        return result;
    }



    //------------------------ CONCATENATION
    public void concatenationSkipList(SkipList secondSkipList) {
        SkipListInt skiplist1Upper = this.upper;
        SkipListInt skipList2Lower = getLevelZeroElement(secondSkipList.getLower());

        concatenationSkipList(skiplist1Upper, skipList2Lower);
    }

    //----------
    public void concatenationSkipList(SkipListInt skiplist1Upper, SkipListInt skipList2Lower) {

        if (skiplist1Upper.getTop() != null && skipList2Lower.getTop() != null) {
            SkipListInt previousUpperSkipList1 = skiplist1Upper.getLeft();
            SkipListInt nextLowerSkipList2 = skipList2Lower.getRight();

            previousUpperSkipList1.setRight(nextLowerSkipList2);
            nextLowerSkipList2.setLeft(previousUpperSkipList1);

            concatenationSkipList(skiplist1Upper.getTop(), skipList2Lower.getTop());
        } else if (skiplist1Upper.getTop() == null && skipList2Lower.getTop() != null) {

        } else if (skipList2Lower.getTop() != null && skipList2Lower.getTop() == null) {

        } else {
            SkipListInt previousUpperSkipList1 = skiplist1Upper.getLeft();
            SkipListInt nextLowerSkipList2 = skipList2Lower.getRight();

            previousUpperSkipList1.setRight(nextLowerSkipList2);
            nextLowerSkipList2.setLeft(previousUpperSkipList1);
        }
    }


}
