package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction func;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.func = func;
        array = map();
    }

    private Object[] map() {
        Object[] newArr = Arrays.copyOf(smartArray.toArray(), smartArray.size());
        Object[] finalArr = new Object[newArr.length];
        for (int i = 0; i < newArr.length; i++) {
            finalArr[i] = func.apply(newArr[i]);
        }
        return finalArr;
    }

    @Override
    public Object[] toArray() {
        if (Arrays.equals(array, smartArray.toArray())) {
            return array;
        } else {
            array = map();
            return array;
        }
    }

    @Override
    public String operationDescription() {
        return this.smartArray.operationDescription() + " + MapDecorator";
    }

    @Override
    public int size() {
        return array.length;
    }
}
