public class SkipList<key,value> {
    private SkipList top, right, bottom, left;
    private int heightMax;

    private boolean isEmpty;

    private int element;

    //---------------------- CONSTRUCTOR ------------------------
    public SkipList(int element, int heightMax) {
        this.element            = element;

        this.heightMax          = heightMax;

        this.isEmpty            = false;

        this.top                = null;
        this.right              = null;
        this.bottom             = null;
        this.left               = null;

    }

    public SkipList() {
        this.element            = Integer.MIN_VALUE;

        this.heightMax          = 1;

        this.isEmpty            = true;

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
        return this.isEmpty;
    }

    public int getElement() {
        return element;
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
        return this.getElement() == Integer.MAX_VALUE;
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
    public void insert(int skElement ){
        //Variable
        SkipList predecessor, memory;

        //Begin
        if(!this.isEmpty()){
            predecessor = this.searchElementInt(skElement);
            SkipList newSkipList = new SkipList(skElement, )
            memory = predecessor.getRight();
            predecessor.setRight(skElement);
            skElement.setRight(memory);
            Sk.setNumberElements(getNumberElements()+1);
        } else {
            //Sk.setR
        }
    }

    // ----------------------- SEARCH

    public SkipList searchElementInt(int soughtElement) {
        return searchElementInt(this, soughtElement);
    }
    private SkipList searchElementInt(SkipList inSkipList, int soughtElement) {
        //Variable
        SkipList result;

        //Begin
        if (!inSkipList.isEmpty()) {
            if (soughtElement < inSkipList.getElement()) {
                if (inSkipList.getBottom() != null) {
                    result = searchElementInt(inSkipList.getBottom(), soughtElement);
                } else {
                    result = inSkipList;
                }

            } else if (soughtElement > inSkipList.getElement()) {
                if (!inSkipList.getRight().isMaxBound()) {
                    result = searchElementInt(inSkipList.getRight(), soughtElement);
                } else {
                    result = searchElementInt(inSkipList.getBottom(), soughtElement);
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
        //Node skiplist1Upper = this.upper;
       //Node skipList2Lower = getLevelZeroElement(secondSkipList.getLower());

       //concatenationSkipList(skiplist1Upper, skipList2Lower);
    }

    //----------
    public void concatenationSkipList(Node skiplist1Upper, Node skipList2Lower) {

        if (skiplist1Upper.getTop() != null && skipList2Lower.getTop() != null) {
            Node previousUpperSkipList1 = skiplist1Upper.getLeft();
            Node nextLowerSkipList2 = skipList2Lower.getRight();

            previousUpperSkipList1.setRight(nextLowerSkipList2);
            nextLowerSkipList2.setLeft(previousUpperSkipList1);

            concatenationSkipList(skiplist1Upper.getTop(), skipList2Lower.getTop());
        } else if (skiplist1Upper.getTop() == null && skipList2Lower.getTop() != null) {

        } else if (skipList2Lower.getTop() != null && skipList2Lower.getTop() == null) {

        } else {
            Node previousUpperSkipList1 = skiplist1Upper.getLeft();
            Node nextLowerSkipList2 = skipList2Lower.getRight();

            previousUpperSkipList1.setRight(nextLowerSkipList2);
            nextLowerSkipList2.setLeft(previousUpperSkipList1);
        }
    }


}
