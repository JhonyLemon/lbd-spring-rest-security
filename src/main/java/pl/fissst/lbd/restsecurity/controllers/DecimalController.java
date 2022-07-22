package pl.fissst.lbd.restsecurity.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.fissst.lbd.restsecurity.services.MessageService;

@RestController
@RequestMapping("/api/decimal")
public class DecimalController {

    private final MessageService messageService;

    public DecimalController(MessageService messageService) {
        this.messageService = messageService;
    }


    @PutMapping("/{decimal}")
    public ResponseEntity<Void> setDecimal(@PathVariable("decimal") Integer decimal){
        messageService.setDecimalPlaces(decimal);
        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority(" +
            "T(pl.fissst.lbd.restsecurity.security.Permissions).DECIMAL_READ.name()," +
            "T(pl.fissst.lbd.restsecurity.security.Permissions).ACCESS_ALL.name()" +
            ")"
    )
    public ResponseEntity<Integer> getDecimal(){
        return ResponseEntity
                .ok()
                .body(messageService.getDecimalPlaces());
    }

}
