package ru.voronyuk.model;

public class DateEnter {
    private int numberOne;
    private int numberTwo;
    private String operation;
    private ValueFormat format;

    public DateEnter(int numberOne, int numberTwo, String operation, ValueFormat format) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.operation = operation;
        this.format = format;
    }

    @Override
    public String toString() {
        return "DateEnter{" +
                "numberOne=" + numberOne +
                ", numberTwo=" + numberTwo +
                ", operation='" + operation + '\'' +
                ", format=" + format +
                '}';
    }

    public int getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(int numberOne) {
        this.numberOne = numberOne;
    }

    public int getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(int numberTwo) {
        this.numberTwo = numberTwo;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public ValueFormat getFormat() {
        return format;
    }

    public void setFormat(ValueFormat format) {
        this.format = format;
    }
}
