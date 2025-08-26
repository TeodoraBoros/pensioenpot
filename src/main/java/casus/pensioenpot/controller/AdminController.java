package casus.pensioenpot.controller;

import casus.pensioenpot.object.Deelnemer;
import casus.pensioenpot.repository.DeelnemerRepository;
import casus.pensioenpot.repository.DienstverbandRepository;
import casus.pensioenpot.repository.InternalDeelnemer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    DeelnemerRepository deelnemerRepository;

    @Autowired
    DienstverbandRepository dienstverbandRepository;

    @PostMapping(path = "/add_user", consumes = "application/json")
    public Long addUser(@RequestBody Deelnemer deelnemer) {
        InternalDeelnemer internal = deelnemerRepository.save(deelnemer.toInternal());
        dienstverbandRepository.save(deelnemer.getDienstverband().toInternal());
        return internal.getId();
    }
    @GetMapping("/get_user")
    public Optional<Deelnemer> getDeelnemer(@RequestParam Long userId) {
        Optional<InternalDeelnemer> internal = deelnemerRepository.findById(userId);
        return internal.map(InternalDeelnemer::toExternal);
    }
}
