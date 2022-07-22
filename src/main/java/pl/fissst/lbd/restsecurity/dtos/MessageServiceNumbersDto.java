package pl.fissst.lbd.restsecurity.dtos;

public class MessageServiceNumbersDto {

    private Double valueOne;
    private Double valueTwo;
    private Integer decimalPlaces;
    private Integer multiplier;

    public MessageServiceNumbersDto(Double valueOne, Double valueTwo, Integer decimalPlaces, Integer multiplier) {
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
        this.decimalPlaces = decimalPlaces;
        this.multiplier = multiplier;
    }

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

    public Integer getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setDecimalPlaces(Integer decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public Integer getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Integer multiplier) {
        this.multiplier = multiplier;
    }
}
