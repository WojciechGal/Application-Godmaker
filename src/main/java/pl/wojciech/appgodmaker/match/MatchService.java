package pl.wojciech.appgodmaker.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wojciech.appgodmaker.bet.Bet;
import pl.wojciech.appgodmaker.bet.BetRepository;
import pl.wojciech.appgodmaker.user.User;
import pl.wojciech.appgodmaker.user.UserRepository;

import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private BetRepository betRepository;

    @Autowired
    private UserRepository userRepository;

    public void saveMatch(Match match) {
//        Calendar time = Calendar.getInstance();
//        time.setTime(match.getStartTime());
        Calendar cal = Calendar.getInstance();
//
        cal.setTime(match.getStartDate());
        cal.set(Calendar.HOUR_OF_DAY, 12);//żeby data podczas zapisania się nie cofnęła
//        cal.set(Calendar.MINUTE, time.get(Calendar.MINUTE));
//        cal.set(Calendar.SECOND, time.get(Calendar.SECOND));
//
        match.setStartDate(cal.getTime());
        /////////////////////////////////ZGODNA DATA////////////////////////////
        matchRepository.save(match);

    }

    public void saveMatchUp(Match match) {

        List<Bet> bets = betRepository.findAllByMatchId(match.getId());

        bets.forEach(bet -> {
            User user = bet.getUser();
            Double userCash = user.getCredit();
            if (bet.getKindOfBet() == 0) {
                if (match.getHomeGoals() > match.getAwayGoals()) {
                    Double cashToGet = bet.getCashDeposit() * match.getHomeCourse();
                    Double cashToGetRound = Math.round(cashToGet * 100.0) / 100.0;


                    user.setCredit(Math.round((userCash + cashToGetRound) * 100.0) / 100.0);
                    userRepository.save(user);

                    bet.setGain(Math.round((cashToGetRound - bet.getCashDeposit()) * 100.0) / 100.0);
                }
            } else if (bet.getKindOfBet() == 1) {
                if (match.getHomeGoals() == match.getAwayGoals()) {
                    Double cashToGet = bet.getCashDeposit() * match.getDrawCourse();
                    Double cashToGetRound = Math.round(cashToGet * 100.0) / 100.0;

                    user.setCredit(Math.round((userCash + cashToGetRound) * 100.0) / 100.0);
                    userRepository.save(user);

                    bet.setGain(Math.round((cashToGetRound - bet.getCashDeposit()) * 100.0) / 100.0);
                }
            } else {
                if (match.getHomeGoals() < match.getAwayGoals()) {
                    Double cashToGet = bet.getCashDeposit() * match.getAwayCourse();
                    Double cashToGetRound = Math.round(cashToGet * 100.0) / 100.0;

                    user.setCredit(Math.round((userCash + cashToGetRound) * 100.0) / 100.0);
                    userRepository.save(user);

                    bet.setGain(Math.round((cashToGetRound - bet.getCashDeposit()) * 100.0) / 100.0);
                }
            }

        });

        Calendar cal = Calendar.getInstance();
        cal.setTime(match.getStartDate());
        cal.set(Calendar.HOUR_OF_DAY, 12);
        match.setStartDate(cal.getTime());

        matchRepository.save(match);
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }

    public Match findMatchById(Long id) {
        Match match = matchRepository.findById(id).orElse(null);

//        Calendar cal = Calendar.getInstance();
//        cal.setTime(match.getStartDate());
//        cal.set(Calendar.HOUR_OF_DAY, 12);
//        match.setStartDate(cal.getTime());

        return match;
    }

    public List<Match> findMatchByRound(Long id) {
        return matchRepository.findAllByRoundId(id);
    }
}
