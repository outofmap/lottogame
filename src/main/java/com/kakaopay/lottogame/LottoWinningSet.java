package com.kakaopay.lottogame;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author david.chung
 * @since 2019-05-20
 */
public class LottoWinningSet {
    public static final int WIN_TOTAL_COUNT = 7;
    private Set<LottoNumber> winningNumbers;
    private LottoNumber bonusNumber;

    public void pick() {
        this.winningNumbers = RandomNumberGenerator.generateRandomLottoNumbers(WIN_TOTAL_COUNT)
                                                   .stream()
                                                   .map(LottoNumber::new)
                                                   .collect(Collectors.toSet());
    }

    public Set<LottoNumber> getWinningNumbers() {
        return this.winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return null;
    }
}
