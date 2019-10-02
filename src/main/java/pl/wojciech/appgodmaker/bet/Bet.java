package pl.wojciech.appgodmaker.bet;

import org.hibernate.validator.constraints.Range;
import pl.wojciech.appgodmaker.match.Match;
import pl.wojciech.appgodmaker.user.User;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Podaj prawidłowe dane")
    @Min(value = 1, message = "Podaj prawidłową kwotę")
    private Double cashDeposit;

    @ManyToOne(fetch = FetchType.EAGER)//niebezpieczne
    private User user;

    @NotNull(message = "Podaj prawidłowe dane")
    @ManyToOne(fetch = FetchType.EAGER)//niebezpieczne
    private Match match;

    @NotNull(message = "Podaj prawidłowe dane")
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

    @Override
    public String toString() {
        return "Bet{" +
                "cashDeposit=" + cashDeposit +
                ", user=" + user.getUsername() +
                ", match=" + match +
                '}';
    }
}
