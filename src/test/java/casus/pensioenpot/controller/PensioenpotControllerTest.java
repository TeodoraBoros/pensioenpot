package casus.pensioenpot.controller;

import casus.pensioenpot.service.PensioenpotService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PensioenpotControllerTest {
    @Mock
    PensioenpotService pensioenpotService;

    @InjectMocks
    PensioenpotController controller;

    @Test
    void getpensioenpot() {
        when(pensioenpotService.getPensioenpotForPerson(any(), anyInt()))
                .thenReturn(12345.67F);
        String expected = "Waarde op pensioenleeftijd: 12345.67";
        String result = controller.getpensioenpot(1L, 70);
        assert result.equals(expected);
    }
}