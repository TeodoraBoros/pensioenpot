package casus.pensioenpot.service;

import casus.pensioenpot.repository.DeelnemerRepository;
import casus.pensioenpot.repository.InternalDeelnemer;
import casus.pensioenpot.repository.InternalDienstverband;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PensioenpotServiceTest {
    @Mock
    BeleggingsService beleggingsService;
    @Mock
    DeelnemerRepository deelnemerRepository;
    @InjectMocks
    PensioenpotService pensioenpotService = new PensioenpotService();


    @Test
    void getPensioenpotForPerson() {
        InternalDienstverband dienstverband = new InternalDienstverband(true, 80F, 60000F, "IBAN");
        InternalDeelnemer deelnemer = new InternalDeelnemer(
                "Henk Henks", "Teststraat", "1A", "1234AB", "Testen", "test@example.com", LocalDate.now().minusYears(60), dienstverband);

        when(beleggingsService.getCurrentValue(anyString())).thenReturn(100000F);
        when(deelnemerRepository.findById(any())).thenReturn(Optional.of(deelnemer));

        Float result61 = pensioenpotService.getPensioenpotForPerson(1L, 61);
        Float result65 = pensioenpotService.getPensioenpotForPerson(1L, 65);
        assert result61.equals(104802.68F);
        assert result65.equals(125498.08F);
    }
}