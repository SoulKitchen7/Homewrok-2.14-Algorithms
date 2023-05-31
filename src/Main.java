import service.StringListImpl;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        StringListImpl stringList = new StringListImpl(10);


        System.out.println(stringList.add(1, "lemon"));
        System.out.println(stringList.add(2, "orange"));
        System.out.println(stringList.add(3, "apple"));
        System.out.println(stringList.add(4, "strawberry"));
        System.out.println(stringList.add(5, "coconut"));
        System.out.println(stringList.add(6, "blackberry"));
        System.out.println(stringList.add(7, "carrot"));
        System.out.println(stringList.add(8, "tomato"));
        System.out.println(stringList.add(9, "ginger"));
        System.out.println(stringList.add(10, "oregano"));
        System.out.println(stringList.set(9, "pineapple"));
        System.out.println(stringList.remove("apple"));
        System.out.println(stringList.remove(5));
        System.out.println(stringList.contains("tomato"));
        System.out.println(stringList.lastIndexOf("apple"));
        System.out.println(stringList.indexOf("carrot"));
        System.out.println(stringList.get(5));
        System.out.println(stringList.size());
        System.out.println(stringList.equals(new StringListImpl(10)));



    }

}