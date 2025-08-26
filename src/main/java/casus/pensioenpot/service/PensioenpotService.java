package casus.pensioenpot.service;

import casus.pensioenpot.repository.DeelnemerRepository;
import casus.pensioenpot.repository.InternalDeelnemer;
import casus.pensioenpot.repository.InternalDienstverband;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PensioenpotService {
    private static final Long PREMIE_PERCENTAGE = 5L;
    private static final Long RENDEMENT = 3L;
    @Autowired
    BeleggingsService beleggingsService;
    @Autowired
    DeelnemerRepository deelnemerRepository;

    //Huidige waarde + Jaarlijkse premiestorting + (Huidige waarde + Jaarlijkse premiestorting/2) * rendement
    public Float getPensioenpotForPerson(Long userId, int pensioenLeeftijd) {
        InternalDeelnemer deelnemer = deelnemerRepository.findById(userId).orElseThrow();
        InternalDienstverband dienstverband = deelnemer.getDienstverband();
        int yearsTillPensioen = pensioenLeeftijd - (LocalDateTime.now().getYear() - deelnemer.getDateOfBirth().getYear());

        Float currentValue = beleggingsService.getCurrentValue(dienstverband.getRekeningNummer());
        Float jaarlijksePremie = 0F;
        if (dienstverband.getInDienst()){
            jaarlijksePremie =
                    (dienstverband.getSalaris() - dienstverband.getFranchise())
                            * dienstverband.getParttimePercentage() / 100
                            * PREMIE_PERCENTAGE / 100;
        }
        for (int i = 0; i < yearsTillPensioen; i++) {
            currentValue = currentValue + jaarlijksePremie + (currentValue + jaarlijksePremie / 2) * RENDEMENT / 100;
        }
        return currentValue;
    }
}
