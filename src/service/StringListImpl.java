package service;

import exception.ElementNotFoundException;
import exception.NullPointerException;
import exception.WrongIndexException;
import exception.WrongSizeOfMassiveException;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private int length;
    private final String[] stringArray;


    public StringListImpl(int length){
        this.length = length;
        this.stringArray = new String[length];
    }

    @Override
    public String add(String item) {
        wrongMassiveException();
        nullPointerException(item);
        stringArray[length++]=item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        wrongMassiveException();
        nullPointerException(item);
        wrongIndexException(index);

        if (index == length) {
            stringArray[length++]=item;
        }
        System.arraycopy(stringArray, index, stringArray, index+1, length-index);
        return item;
    }

    @Override
    public String set(int index, String item) {
        wrongIndexException(index);
        nullPointerException(item);
        stringArray[index-1] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        nullPointerException(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        if (index != length) {
            System.arraycopy(stringArray, index+1, stringArray, index, length-index);
        }
        length--;
        return item;
    }
    @Override
    public String remove(int index) {
        wrongIndexException(index);
        String item = stringArray[index];
        if (index != length) {
            System.arraycopy(stringArray, index+1, stringArray, index, length-index);
        }
        length--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < length; i++)
            if (stringArray[i].equals(item)){
                return i+1;
            }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {

        for (int i = length-1; i >= 0; i--)
            if (stringArray[i].equals(item)){
            return i+1;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        wrongIndexException(index);
        return stringArray[index - 1];
    }

    @Override
    public boolean equals(StringList otherList) {
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
    public String[] toArray() {
        return  Arrays.copyOf(stringArray, stringArray.length);
    }

    private void nullPointerException(String item) {

            if (item == null) {
                throw new NullPointerException();
            }
    }

    private void wrongMassiveException() {
        if (length == stringArray.length) {
            throw new WrongSizeOfMassiveException();
        }
    }

    private void wrongIndexException(int index) {
        if (index < 0 || index > length) {
            throw new WrongIndexException();
        }
    }

}


