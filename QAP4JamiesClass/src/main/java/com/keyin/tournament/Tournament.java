package com.keyin.tournament;

import jakarta.persistence.*;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tournaments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "start date")
    private String startDate;

    @Column(name = "end date")
    private String endDate;
    @Column(name = "location")
    private String location;
    @Column(name = "entryfee")
    private int entryFee;
    @Column(name = "prize")
    private int prize;

    protected Tournament() {}

    public Tournament(String startDate, String endDate, String location, int entryFee, int prize) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.prize = prize;
    }


    public Long getId() {return id;}
    public String getStartDate() {return this.startDate;}
    public String getEndDate() {return this.endDate;}
    public String getLocation() {return this.location;}
    public int getEntryFee() {return this.entryFee;}
    public int getPrize() {return this.prize;}


    public void setId(Long id) {this.id = id;}
    public void setStartDate(String startDate) {this.startDate = startDate;}
    public void setEndDate(String endDate) {this.endDate = endDate;}
    public void setPrize(int prize) {this.prize = prize;}
    public void setEntryFee(int entryFee) {this.entryFee = entryFee;}
    public void setLocation(String location) {this.location = location;}


}
