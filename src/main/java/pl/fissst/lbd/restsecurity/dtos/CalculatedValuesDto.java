package pl.fissst.lbd.restsecurity.dtos;

public class CalculatedValuesDto {

    private Double valueOne;
    private Double valueTwo;

    public Double getValueOne() {
        return valueOne;
    }

    public void setValueOne(Double valueOne) {
        this.valueOne = valueOne;
    }

    public Double getValueTwo() {
        return valueTwo;
    }

    public void setValueTwo(Double valueTwo) {
        this.valueTwo = valueTwo;
    }

    public CalculatedValuesDto(Double valueOne, Double valueTwo) {
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }
}
