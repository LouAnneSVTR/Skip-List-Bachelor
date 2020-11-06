public class Main {

    public static void main(String[] args) {
        //Variable
        SkipList s = new SkipList();

        //Begin
        System.out.println(Integer.MIN_VALUE + " / " + Integer.MAX_VALUE);
        System.out.println(s.searchElementInt(s.getLower(), 4).getElement());

    }
}
