package casus.pensioenpot.service;

import casus.pensioenpot.object.Belegging;
import casus.pensioenpot.object.BeleggingResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class BeleggingsService {
    private static final Float CURRENT_VALUE = 100000F;
    private static final Logger log = LoggerFactory.getLogger(BeleggingsService.class);
    @Value("${BeleggingsService.baseUrl}")
    private String BASE_URL = "localhost";

    private final RestClient client;

    public BeleggingsService(){
        // Using a builder, when this is a real external service, we want to configure headers here.
        this.client = RestClient.builder()
                .baseUrl(BASE_URL)
                .defaultHeader("Some-header", "some value")
                .build();
    }

    // For ease of use
    public Float getCurrentValue(String rekeningNummer) {
        return CURRENT_VALUE;
    }

    public Float getValue(String rekeningNummer) {
        BeleggingResponse beleggingResponse = client.get()
                .uri("/huidige-waarde/{rekeningNummer}", rekeningNummer)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::isError, (request, response) -> log.error("Here we want to do some error handling, given that this is being mocked, I will not be expanding this"))
                .body(BeleggingResponse.class);
        return calculateTotal(beleggingResponse);
    }

    private Float calculateTotal(BeleggingResponse beleggingResponse) {
        Float total = 0F;
        if (beleggingResponse != null){
            for (Belegging belegging : beleggingResponse.getBeleggingen()) {
                total = total + belegging.getWaarde();
            }
        }
        return total;
    }

}
