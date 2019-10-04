package pl.wojciech.appgodmaker.bet;

import org.hibernate.validator.constraints.Range;
import pl.wojciech.appgodmaker.match.Match;
import pl.wojciech.appgodmaker.user.User;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Pole nie może być puste")
    @Min(value = 1, message = "Musisz obstawić co najmniej 1 zł")
    private Double cashDeposit;

    @ManyToOne(fetch = FetchType.EAGER)//niebezpieczne
    private User user;

    @NotNull(message = "Pole nie może być puste")
    @ManyToOne(fetch = FetchType.EAGER)//niebezpieczne
    private Match match;

    @NotNull(message = "Pole nie może być puste")
    @Range(min = 0, max = 2)
    private Integer kindOfBet;


    private Double gain;

    public Double getGain() {
        return gain;
    }

    public void setGain(Double gain) {
        this.gain = gain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCashDeposit() {
        return cashDeposit;
    }

    public void setCashDeposit(Double cashDeposit) {
        this.cashDeposit = cashDeposit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Integer getKindOfBet() {
        return kindOfBet;
    }

    public void setKindOfBet(Integer kindOfBet) {
        this.kindOfBet = kindOfBet;
    }
}
