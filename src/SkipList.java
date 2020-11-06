public class SkipList<key,value> {
    private Node lower;
    private Node upper;

    private int MaxHeight;
    private int actuelHeight;
    private int numberElement;

    //---------------------- CONSTRUCTOR ------------------------
    public SkipList(int MaxHeight) {

        this.lower      = new Node();
        this.upper      = this.lower.getRight();

        this.MaxHeight  = MaxHeight;
        this.actuelHeight = 1;
        this.numberElement    = 0;

    }

    //----------------------- ACCESSORS ------------------------
    public boolean isEmpty() {
        return this.numberElement == 0;
    }

    public Node getLower() {
        return lower;
    }

    public Node getUpper() {
        return upper;
    }

    public int getMaxHeight() {
        return MaxHeight;
    }

    public int getNumberElement() {
        return numberElement;
    }

    public void setMaxHeight(int maxHeight) {
        MaxHeight = maxHeight;
    }

    //------------------------ METHODS ------------------------

    // ----------------------- GET LEVEL
    public Node getLevelZeroElement(Node element) {
        if (element.getBottom() != null) {
            return getLevelZeroElement(element.getBottom());
        } else {
            return element;
        }
    }

    public Node getLevelMaxElement(Node element) {
        if (element.getTop() != null) {
            return getLevelZeroElement(element.getTop());
        } else {
            return element;
        }
    }

    // ----------------------- INSERT
    /** @role : Insere un élément dans une skip list. On part de la borne minimal du niveau le plus haut de la skip list en parametre.
     *  @param
     *  @param skElement */
    public void insertElement(Node skElement ){
        //Variable
        Node predecessor, memory;

        //Begin
        predecessor = this.searchElementInt(skElement.getElement()); //Predecessor prends la valeur du noeud precedent celui a inserer
        memory = predecessor.getRight();
        predecessor.setRight(skElement);//On ajoute le noeud a inserer a droite du precedent
        skElement.setLeft(memory); //L'ancien noed de droite prendre comme precendent notre nouveau noeud
        this.numberElement++;

        //if ieazhfsjqc
        this.toPLace(skElement);

    }

    /** @role :
     * @param element */
    private void toPLace( Node element ) {
        //Variable
        int level = element.getHeight();

        //Begin
        if (level > this.getMaxHeight()){
            element.setHeight(this.getMaxHeight());
        level = element.getHeight();
        }

        while( level > 0) {

            level--;
        }
    }


    // ----------------------- SEARCH
    public Node searchElementInt(int soughtElement) {
        if (!this.isEmpty()) {
            return searchElementInt(this.lower, soughtElement);
        }else {
            return this.lower;
        }
    }
    private Node searchElementInt(Node inSkipList, int soughtElement) {
        //Variable
        Node result;

        //Begin
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

        result = getLevelZeroElement(result);
        return result;
    }


    //------------------------ CONCATENATION
    public void concatenationSkipList(SkipList secondSkipList) {
        Node skiplist1Upper = getLevelZeroElement(this.upper);
        Node skipList2Lower = getLevelZeroElement(secondSkipList.getLower());

        if (this.MaxHeight < secondSkipList.getMaxHeight()) {
            this.MaxHeight = secondSkipList.getMaxHeight();
        } else {
            secondSkipList.setMaxHeight(this.MaxHeight);
        }

        concatenationSkipList(skiplist1Upper, skipList2Lower, secondSkipList);
    }

    //----------
    public void concatenationSkipList(Node skiplist1Upper, Node skipList2Lower, SkipList secondSkipList) {

        if (skiplist1Upper.getTop() != null && skipList2Lower.getTop() != null) {
            Node previousUpperSkipList1 = skiplist1Upper.getLeft();
            Node nextLowerSkipList2 = skipList2Lower.getRight();

            previousUpperSkipList1.setRight(nextLowerSkipList2);
            nextLowerSkipList2.setLeft(previousUpperSkipList1);

            concatenationSkipList(skiplist1Upper.getTop(), skipList2Lower.getTop(), secondSkipList);
        } else if (skiplist1Upper.getTop() == null && skipList2Lower.getTop() != null) {
            this.newLevel();
            concatenationSkipList(skiplist1Upper.getTop(), skipList2Lower.getTop(), secondSkipList);
        } else if (skipList2Lower.getTop() != null && skipList2Lower.getTop() == null) {
            secondSkipList.newLevel();
            concatenationSkipList(skiplist1Upper.getTop(), skipList2Lower.getTop(), secondSkipList);
        } else {
            Node previousUpperSkipList1 = skiplist1Upper.getLeft();
            Node nextLowerSkipList2 = skipList2Lower.getRight();

            previousUpperSkipList1.setRight(nextLowerSkipList2);
            nextLowerSkipList2.setLeft(previousUpperSkipList1);
        }
    }

    private boolean newLevel() {
        if (this.actuelHeight != this.MaxHeight) {
            Node newLower = new Node();
            Node newUpper = newLower.getRight();

            Node UpperMax = this.getLevelMaxElement(this.upper);

            newLower.setBottom(this.lower);
            this.lower.setTop(newLower);

            newUpper.setBottom(UpperMax);
            UpperMax.setTop(newUpper);

            return true;
        } else {
            return false;
        }
    }


}