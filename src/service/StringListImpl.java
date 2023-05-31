package service;

import exception.ElementNotFoundException;
import exception.NullPointerException;
import exception.WrongSizeOfMassiveException;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private final int length;
    private final String[] stringArray;


    public StringListImpl(int length){
        this.length = length;
        this.stringArray = new String[length];
    }

    @Override
    public String add(String item) {
        nullPointerException(item);
        for (int i = 0; i < length-1; i++) {
            stringArray[i] = item;
        }
        return item;
    }

    @Override
    public String add(int index, String item) {
        nullPointerException(item);
        try {
            if (index-1 <= length) {
                stringArray[index-1] = item;
            } else {
                throw new WrongSizeOfMassiveException();
            }
        } catch (WrongSizeOfMassiveException e) {
            return "Индекс превышает размер массива";
        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        nullPointerException(item);
        try {
            if (index <= length) {
                for (int i = 0; i < length; i++) {
                    if (i == index-1) {
                        stringArray[i] = item;
                    }
                }
            } else {
                throw new WrongSizeOfMassiveException();
            }
        } catch (WrongSizeOfMassiveException e) {
            return "Индекс превышает размер массива";
        }
        return item;
    }

    @Override
    public String remove(String item) {
        nullPointerException(item);
        for (int i = 0; i < length; i++)
            try {
            if (item.equals(stringArray[i])) {
                stringArray[i] = stringArray[i + 1];

            } else {
                    throw new ElementNotFoundException();
            }
        } catch(ElementNotFoundException e){
            return "Элемент не найден";
        }
        return item;
    }
    @Override
    public String remove(int index) {
        for (int i = 0; i < length; i++)
            try {
                if (index-1==i) {
                    stringArray[i] = stringArray[i + 1];
                } else {
                    throw new ElementNotFoundException();
                }
            } catch(ElementNotFoundException e){
                return "Элемент не найден";
            }
        return stringArray[index];
    }

    @Override
    public boolean contains(String item) {
        nullPointerException(item);
        for (int i = 0; i < length; i++)
            if (stringArray[i].equals(item)){
                return true;
        }
         return false;
    }

    @Override
    public int indexOf(String item) {
        nullPointerException(item);
        for (int i = 0; i < length; i++)
            if (stringArray[i].equals(item)){
                return i+1;
            }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        nullPointerException(item);
        for (int i = length-1; i >= 0; i--)
            if (stringArray[i].equals(item)){
            return i+1;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        try {
            if (index-1 <= length) {
                return stringArray[index - 1];
            } else {
                throw new WrongSizeOfMassiveException();
            }
        } catch (WrongSizeOfMassiveException e) {
            return "Индекс превышает размер массива";
        }
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(stringArray, new StringList[]{otherList});
    }

    @Override
    public int size() {
        return stringArray.length;
    }

    @Override
    public boolean isEmpty() {
        if (stringArray.length == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            stringArray[i] = null;
        }
    }

    @Override
    public String[] toArray() {
        String[] toArray;
        return  toArray = Arrays.copyOf(stringArray, stringArray.length);
    }

    public String nullPointerException(String item) {
        try {
            if (item == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            return "Параметр не может быть равно null";
        }
        return item;
    }

}


