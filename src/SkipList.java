public class SkipList {
    private SkipListInt lower;
    private SkipListInt upper;
    private int heightMax;

    private int numberElements;

    //---------------------- CONSTRUCTOR ------------------------
    public SkipList() {
        this.lower     = new SkipListInt(Integer.MIN_VALUE, true, false);
        this.upper    = new SkipListInt(Integer.MAX_VALUE, false, true);

        this.lower.setRight(this.upper);
        this.upper.setLeft(this.lower);

        this.heightMax      = 1;

        this.numberElements = 0;
    }

    //----------------------- ACCESSORS ------------------------
    public boolean isEmpty() {
        return this.numberElements == 0;
    }

    public SkipListInt getLower() {
        return lower;
    }

    public SkipListInt getUpper() {
        return upper;
    }

    public int getHeightMax() {
        return heightMax;
    }

    public int getNumberElements() {
        return numberElements;
    }

    public void setLowerRight(SkipListInt upper) {
        this.lower.setRight(upper);
    }

    public void setUpperLeft(SkipListInt lower) {
        this.upper.setLeft(lower);
    }


    //------------------------ METHODS ------------------------

    // ----------------------- GET LEVEL
    public SkipListInt getLevelZeroElement(SkipListInt element) {
        if (element.getBottom() != null) {
            return getLevelZeroElement(element.getBottom());
        } else {
            return element;
        }
    }

    // ----------------------- INSERT
    /** @role : Insere un élément dans une skip list. On part de la borne minimal du niveau le plus haut de la skip list en parametre.
     *  @param Sk
     *  @param skElement
     */
    public void insert(SkipList Sk, SkipListInt skElement ){
        //Variable
        SkipListInt predecessor, memory;

        //Begin
        if(!Sk.isEmpty()){
            predecessor = searchElementInt(Sk.getLower(),skElement.getElement());
            memory = predecessor.getRight();
            predecessor.getRight() = skElement;
            skElement.getRight() = memory;
            Sk.getNumberElements()++;
            

        }
    }

    // ----------------------- SEARCH
    public SkipListInt searchElementInt(SkipListInt inSkipList, int element) {
        //Variable
        SkipListInt result;

        //Begin
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
