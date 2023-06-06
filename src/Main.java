import service.IntegerListImpl;

import java.util.Arrays;

public class Main {

    public static void main(Integer[] args) {

        IntegerListImpl IntegerList = new IntegerListImpl(10);


        System.out.println(IntegerList.add(1, 15));
        System.out.println(IntegerList.add(2, 25));
        System.out.println(IntegerList.add(3, 45));
        System.out.println(IntegerList.add(4, 41));
        System.out.println(IntegerList.add(5, 53));
        System.out.println(IntegerList.add(6, 78));
        System.out.println(IntegerList.add(7, 75));
        System.out.println(IntegerList.add(8, 110));
        System.out.println(IntegerList.add(9, 8));
        System.out.println(IntegerList.add(10, 3));

        System.out.println(IntegerList.get(5));
        System.out.println(IntegerList.size());
        System.out.println(IntegerList.equals(new IntegerListImpl(10)));



    }

}