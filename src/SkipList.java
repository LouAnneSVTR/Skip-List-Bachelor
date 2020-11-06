public class SkipList<key,value> {
    private Node lower;
    private Node upper;

    private int numberElement;

    //---------------------- CONSTRUCTOR ------------------------
    public SkipList() {

        this.lower      = new Node();
        this.upper      = this.lower.getRight();

        this.numberElement    = 0;

    }

    //----------------------- ACCESSORS ------------------------
    public boolean isEmpty() {
        return this.numberElement == 0;
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

    // ----------------------- INSERT
    /** @role : Insere un élément dans une skip list. On part de la borne minimal du niveau le plus haut de la skip list en parametre.
     *  @param
     *  @param skElement */
    public void insert(int skElement ){
        //Variable
        Node predecessor, memory;

        //Begin
        if(!this.isEmpty()){
            predecessor = this.searchElementInt(skElement);
            Node newSkipList = new Node(skElement);
            memory = predecessor.getRight();
            predecessor.setRight(newSkipList);
            newSkipList.setLeft(memory);
            this.numberElement++;
        } else {
            Node newSkipList = new Node(skElement);
            memory = this.lower.getRight();
            this.lower.setRight(newSkipList);
            newSkipList.setLeft(memory);
            this.numberElement++;
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
