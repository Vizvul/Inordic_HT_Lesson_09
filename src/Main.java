public class Main {
    public static void main(String[] args) {
        SingleLinkedListGeneric test = new SingleLinkedListGeneric();
        test.add(11);
        test.add(22);
        test.add("tree tree");
        test.add(44);
        test.add(55);
        test.add(66);
        test.add(77);
        test.add(88);
        test.add(99);

        test.size();
        test.add(555);
        test.add(50, 5);
        test.replace(66, 7);
        test.removeByIndex(8);
        System.out.println(test.removeFirstByValue(55));
        System.out.println(test.contains(88));
        System.out.println(test.get(7));
        System.out.println(test);
        System.out.println(test.getPosition(11));
    }
}
