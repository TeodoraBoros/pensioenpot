package casus.pensioenpot.controller;

import casus.pensioenpot.service.PensioenpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PensioenpotController {

    @Autowired
    PensioenpotService pensioenpotService;

    @GetMapping("/getpensioenpot")
    public String getpensioenpot(@RequestParam Long userId, @RequestParam int pensioenleeftijd) {
        return "Waarde op pensioenleeftijd: " + pensioenpotService.getPensioenpotForPerson(userId, pensioenleeftijd);
    }
}
