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

    public LottoWinningSet() {
    }

    public LottoWinningSet(Set<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void pick() {
        Set<LottoNumber> picked = RandomNumberGenerator.generateRandomLottoNumbers(WIN_TOTAL_COUNT)
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        LottoNumber bonusNumber = picked.stream().findAny().get();
        picked.remove(bonusNumber);
        this.bonusNumber = bonusNumber;
        this.winningNumbers = picked;
    }

    public Set<LottoNumber> getWinningNumbers() {
        return this.winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return this.bonusNumber;
    }

    public void showWinningSet() {
        System.out.println("당첨번호: " + this.winningNumbers);
        System.out.println("보너스번호: " + this.bonusNumber.toString());
    }
}
