package casus.pensioenpot.object;

import casus.pensioenpot.repository.InternalDeelnemer;

import java.time.LocalDate;

public class Deelnemer {
    private Long id = null;
    private String name;
    private String straatnaam;
    // huisNummer is a String to account for added letters example 3A
    private String huisNummer;
    private String postcode;
    private String woonplaats;
    private String email;
    private LocalDate dateOfBirth;
    private Dienstverband dienstverband;
    public Deelnemer() {}
    public Deelnemer( Long id,
                      String name,
                      String straatnaam,
                      String huisNummer,
                      String postcode,
                      String woonplaats,
                      String email,
                      LocalDate dateOfBirth,
                      Dienstverband dienstverband) {
        this.id = id;
        this.name = name;
        this.straatnaam = straatnaam;
        this.huisNummer = huisNummer;
        this.postcode = postcode;
        this.woonplaats = woonplaats;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.dienstverband =dienstverband;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public String getHuisNummer() {
        return huisNummer;
    }

    public void setHuisNummer(String huisNummer) {
        this.huisNummer = huisNummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Dienstverband getDienstverband() {
        return dienstverband;
    }

    public void setDienstverband(Dienstverband dienstverband) {
        this.dienstverband = dienstverband;
    }


    public InternalDeelnemer toInternal() {
        return new InternalDeelnemer(name, straatnaam, huisNummer, postcode, woonplaats, email, dateOfBirth);
    }
}
