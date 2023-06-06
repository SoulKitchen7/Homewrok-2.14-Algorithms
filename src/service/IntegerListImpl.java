package service;

import exception.ElementNotFoundException;
import exception.NullPointerException;
import exception.WrongIndexException;
import exception.WrongSizeOfMassiveException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

    private int length;
    private final Integer[] IntegerArray;


    public IntegerListImpl(int length){
        this.length = length;
        this.IntegerArray = new Integer[length];
    }

    @Override
    public Integer add(Integer item) {
        wrongMassiveException();
        nullPointerException(item);
        IntegerArray[length++]=item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        wrongMassiveException();
        nullPointerException(item);
        wrongIndexException(index);

        if (index == length) {
            IntegerArray[length++]=item;
        }
        System.arraycopy(IntegerArray, index, IntegerArray, index+1, length-index);
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        wrongIndexException(index);
        nullPointerException(item);
        IntegerArray[index-1] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        nullPointerException(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        if (index != length) {
            System.arraycopy(IntegerArray, index+1, IntegerArray, index, length-index);
        }
        length--;
        return item;
    }
    @Override
    public Integer remove(int index) {
        wrongIndexException(index);
        Integer item = IntegerArray[index];
        if (index != length) {
            System.arraycopy(IntegerArray, index+1, IntegerArray, index, length-index);
        }
        length--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] arrayCopy = toArray();
        sort(arrayCopy);
        return binarySearch(arrayCopy, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < length; i++)
            if (IntegerArray[i].equals(item)){
                return i+1;
            }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {

        for (int i = length-1; i >= 0; i--)
            if (IntegerArray[i].equals(item)){
            return i+1;
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        wrongIndexException(index);
        return IntegerArray[index - 1];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {

        return length==0;
    }

    @Override
    public void clear() {
        length =0;
    }

    @Override
    public Integer[] toArray() {
        return  Arrays.copyOf(IntegerArray, IntegerArray.length);
    }

    private void nullPointerException(Integer item) {

            if (item == null) {
                throw new NullPointerException();
            }
    }

    private void wrongMassiveException() {
        if (length == IntegerArray.length) {
            throw new WrongSizeOfMassiveException();
        }
    }

    private void wrongIndexException(int index) {
        if (index < 0 || index > length) {
            throw new WrongIndexException();
        }
    }

    private void sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static boolean binarySearch (Integer [] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

}


