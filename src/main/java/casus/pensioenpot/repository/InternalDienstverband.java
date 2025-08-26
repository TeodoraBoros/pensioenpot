package casus.pensioenpot.repository;

import casus.pensioenpot.object.Dienstverband;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InternalDienstverband {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public Float getFranchise() {
        return franchise;
    }

    Float franchise = 15599F;
    Boolean inDienst;
    Float parttimePercentage;
    Float salaris;
    String rekeningNummer;

    public InternalDienstverband(){}


    public InternalDienstverband(Boolean inDienst, Float parttimePercentage, Float salaris, String rekeningNummer) {
        this.inDienst = inDienst;
        this.parttimePercentage = parttimePercentage;
        this.salaris = salaris;
        this.rekeningNummer = rekeningNummer;
    }

    public Dienstverband toExternal() {
        return new Dienstverband(id, franchise, inDienst, parttimePercentage, salaris, rekeningNummer);
    }

    public Boolean getInDienst() {
        return inDienst;
    }

    public Float getParttimePercentage() {
        return parttimePercentage;
    }

    public Float getSalaris() {
        return salaris;
    }

    public String getRekeningNummer() {
        return rekeningNummer;
    }
}
