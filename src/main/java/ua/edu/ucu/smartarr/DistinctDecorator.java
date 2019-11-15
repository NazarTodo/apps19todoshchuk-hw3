package ua.edu.ucu.smartarr;

import ua.edu.ucu.Student;


// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {


    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        removeRepetitions();

    }


    private boolean compareStudent(Student st1, Student st2) {
        final double MINI = Double.MIN_VALUE;
        return st1.getSurname().equals(st2.getSurname())
                && st1.getName().equals(st2.getName())
                && Math.abs(st1.getYear() - st2.getYear()) < MINI
                && Math.abs(st1.getGPA() - st2.getGPA()) < MINI;
    }

    private void removeRepetitions() {
        Object[] newArray = smartArray.toArray();
        for (int i = 0; i < newArray.length - 1; i++) {
            for (int j = i + 1; j < newArray.length; j++) {
                try {
                    if (newArray[i].equals(newArray[j])) {
                        newArray[j] = null;
                    }
                    if (newArray[i] instanceof Student && newArray[j]
                            instanceof Student &&
                            compareStudent((Student) newArray[i],
                                    (Student) newArray[j])) {
                        newArray[j] = null;
                    }


                } catch (NullPointerException ignore) {
                    System.out.println("Equals can not work with null values");
                }
            }
        }

    }


    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "DistinctDecorator";
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }

}
