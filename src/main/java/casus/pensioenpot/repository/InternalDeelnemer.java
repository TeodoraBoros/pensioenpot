package casus.pensioenpot.repository;

import casus.pensioenpot.object.Deelnemer;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class InternalDeelnemer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String straatnaam;
    // huisNummer is a String to account for added letters example 3A
    private String huisNummer;
    private String postcode;
    private String woonplaats;
    private String email;

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    private LocalDate dateOfBirth;
    @OneToOne
    @JoinColumn(name = "id")
    private InternalDienstverband dienstverband;

    public InternalDeelnemer() {}

    public InternalDeelnemer(String name,
                             String straatnaam,
                             String huisNummer,
                             String postcode,
                             String woonplaats,
                             String email,
                             LocalDate dateOfBirth) {
        this.name = name;
        this.straatnaam = straatnaam;
        this.huisNummer = huisNummer;
        this.postcode = postcode;
        this.woonplaats = woonplaats;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public InternalDeelnemer(String name,
                             String straatnaam,
                             String huisNummer,
                             String postcode,
                             String woonplaats,
                             String email,
                             LocalDate dateOfBirth,
                             InternalDienstverband dienstverband) {
        this.name = name;
        this.straatnaam = straatnaam;
        this.huisNummer = huisNummer;
        this.postcode = postcode;
        this.woonplaats = woonplaats;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.dienstverband = dienstverband;
    }
    public Long getId() { return id; }
    public InternalDienstverband getDienstverband() {
        return dienstverband;
    }
    public Deelnemer toExternal() {
        return new Deelnemer(id, name, straatnaam, huisNummer, postcode, woonplaats, email, dateOfBirth, dienstverband.toExternal());
    }

}

