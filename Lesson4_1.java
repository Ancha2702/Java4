//Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

import java.util.LinkedList;

public class Lesson4_1 {
    public static void main(String[] args) {
        LinkedList<String> someList =new LinkedList<String>();
        someList.add("zero");
        someList.add("one");
        someList.add("two");
        someList.add("three");
        System.out.println("Элементы до реверса:" + someList );

        LinkedList<String> revLinkedList = new LinkedList<String>();
        for (int i = someList.size()-1; i >=0; i--) {
            revLinkedList.add(someList.get(i));
        }
        System.out.println("Элементы после реверса" + revLinkedList);
    }
}