package fr.puceaulytech;

public class Main {
    public static void main(String[] args) {
        DynamicList array = new DynamicList(3);
        for (int i = 0; i<10; i++) {
            System.out.println(array.toString());
            array.append((i - 3) * (i - 3));
        }
        System.out.println(array.toString());
        array.insert(5, 69);
        System.out.println(array.toString());
        array.sort();
        System.out.println(array.toString());
        System.out.println(array.get(8));
        array.set(8, 100);
        System.out.println(array.toString());
    }
}
