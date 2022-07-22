package pl.fissst.lbd.restsecurity.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.fissst.lbd.restsecurity.services.MessageService;

@RestController
@RequestMapping("/api/multiplier")
public class MultiplierController {

    private final MessageService messageService;

    public MultiplierController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PutMapping("{multiplier}")
    public ResponseEntity<Void> setMultiplier(@PathVariable("multiplier") Integer multiplier){
        messageService.setMultiplier(multiplier);
        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority(" +
            "T(pl.fissst.lbd.restsecurity.security.Permissions).MULTIPLIER_READ.name()," +
            "T(pl.fissst.lbd.restsecurity.security.Permissions).ACCESS_ALL.name()" +
            ")"
    )
    public ResponseEntity<Integer> getMultiplier(){
        return ResponseEntity
                .ok()
                .body(messageService.getMultiplier());
    }

}
