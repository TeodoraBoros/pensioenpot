package casus.pensioenpot.object;

import java.util.List;

public class BeleggingResponse {
    public List<Belegging> getBeleggingen() {
        return beleggingen;
    }

    List<Belegging> beleggingen;

    public BeleggingResponse(List<Belegging> beleggingen) {
        this.beleggingen = beleggingen;
    }
}
