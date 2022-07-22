package pl.fissst.lbd.restsecurity.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fissst.lbd.restsecurity.dtos.CalculatedValuesDto;
import pl.fissst.lbd.restsecurity.services.MessageService;

@RestController
@RequestMapping("/api/number")
public class NumberController {

    private final MessageService messageService;

    public NumberController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<CalculatedValuesDto> getCalculatedValues(){
        return ResponseEntity
                .ok()
                .body(messageService.getCalculatedValues());
    }

}
