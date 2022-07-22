package pl.fissst.lbd.restsecurity.services;

import org.springframework.stereotype.Service;
import pl.fissst.lbd.restsecurity.dtos.CalculatedValuesDto;
import pl.fissst.lbd.restsecurity.dtos.MessageServiceNumbersDto;

import java.util.Random;

@Service
public class MessageService {

    private Double valueOne;
    private Double valueTwo;
    private Integer decimalPlaces;
    private Integer multiplier;

    private Random ranGen;

    public MessageService(){
        this.ranGen = new Random();
        this.decimalPlaces=2;
        this.multiplier=1;
    }

    private void calculateValues(){
        valueOne = Double
                .parseDouble(String
                        .format("%."+decimalPlaces.toString()+"f", (ranGen.nextDouble()*multiplier)).replaceAll(",","."));
        valueTwo = Double
                .parseDouble(String
                        .format("%."+decimalPlaces.toString()+"f", (ranGen.nextDouble()*multiplier)).replaceAll(",","."));
    }

    public MessageServiceNumbersDto getValues(){
        calculateValues();
        return new MessageServiceNumbersDto(valueOne,valueTwo,decimalPlaces,multiplier);
    }

    public Integer getDecimalPlaces() {
        return decimalPlaces;
    }

    public Integer setDecimalPlaces(Integer decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
        return this.decimalPlaces;
    }

    public Integer getMultiplier() {
        return multiplier;
    }

    public Integer setMultiplier(Integer multiplier) {
        this.multiplier = multiplier;
        return this.multiplier;
    }

    public CalculatedValuesDto getCalculatedValues() {
        calculateValues();
        return new CalculatedValuesDto(valueOne,valueTwo);
    }


}
