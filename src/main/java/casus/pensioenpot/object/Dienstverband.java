package casus.pensioenpot.object;

import casus.pensioenpot.repository.InternalDienstverband;

public class Dienstverband {
    Long id;
    Float franchise;
    Boolean inDienst;
    Float parttimePercentage;
    Float salaris;
    String rekeningNummer;

    public Dienstverband(Long id, Float franchise, Boolean inDienst, Float partimePercentage, Float salaris, String rekeningNummer) {
        this.id = id;
        this.franchise = franchise;
        this.inDienst = inDienst;
        this.parttimePercentage = partimePercentage;
        this.salaris = salaris;
        this.rekeningNummer = rekeningNummer;
    }

    public InternalDienstverband toInternal() {
        return new InternalDienstverband(inDienst, parttimePercentage, salaris, rekeningNummer);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getInDienst() {
        return inDienst;
    }

    public void setInDienst(Boolean inDienst) {
        this.inDienst = inDienst;
    }

    public double getParttimePercentage() {
        return parttimePercentage;
    }

    public void setParttimePercentage(Float parttimePercentage) {
        this.parttimePercentage = parttimePercentage;
    }

    public Float getSalaris() {
        return salaris;
    }

    public void setSalaris(Float salaris) {
        this.salaris = salaris;
    }

    public String getRekeningNummer() {
        return rekeningNummer;
    }

    public void setRekeningNummer(String rekeningNummer) {
        this.rekeningNummer = rekeningNummer;
    }

    public Float getFranchise() {
        return franchise;
    }

    public void setFranchise(Float franchise) {
        this.franchise = franchise;
    }

}
