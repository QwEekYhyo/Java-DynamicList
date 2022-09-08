package fr.puceaulytech;

public class Main {
    public static void main(String[] args) {
        DynamicList array = new DynamicList(3);
        for (int i = 0; i<10; i++) {
            System.out.println(array.toString());
            array.append((i - 3) * (i - 3));
        }
        System.out.println(array.toString());
        array.insert(69, 5);
        System.out.println(array.toString());
        array.sort();
        System.out.println(array.toString());
    }
}
