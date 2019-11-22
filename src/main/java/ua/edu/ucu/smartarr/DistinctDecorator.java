package ua.edu.ucu.smartarr;

import ua.edu.ucu.Student;

import java.util.Arrays;


// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {


    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        array = removeRepetitions();

    }


    private Object[] removeRepetitions() {
        Object[] newArray = Arrays.copyOf(smartArray.toArray(), smartArray.size());
        for (int i = 0; i < newArray.length - 1; i++) {
            for (int j = i + 1; j < newArray.length; j++) {
                try {

                    if (newArray[i].equals(newArray[j])) {
                        newArray[j] = null;
                    }


                } catch (NullPointerException ignore) {
//                    System.out.println("Equals can not work with null values");
                }
            }
        }

        int j = 0;
        for (int i = 0; i < newArray.length; i++) {

            if (newArray[i] != null) {

                newArray[j] = newArray[i];

                j += 1;
            }
        }
        newArray = Arrays.copyOf(newArray, j);

        return newArray;

    }


    @Override
    public Object[] toArray() {
        if (Arrays.equals(array, smartArray.toArray())) {
            return array;
        } else {
            array = removeRepetitions();
            return array;
        }

    }

    @Override
    public String operationDescription() {
        return this.smartArray.operationDescription() + " + DistinctDecorator";
    }

    @Override
    public int size() {
        return array.length;
    }

}
