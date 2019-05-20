package com.kakaopay.lottogame;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author david.chung
 * @since 2019-05-20
 */
public class Lotto {
    public static final int TOTAL_COUNT = 6;
    private Set<LottoNumber> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new HashSet<>();
        generateRandomLottoNumbers();
    }

    private void generateRandomLottoNumbers() {
        this.lottoNumbers = RandomNumberGenerator.generateRandomLottoNumbers(TOTAL_COUNT)
                                                 .stream()
                                                 .map(LottoNumber::new)
                                                 .collect(Collectors.toSet());
    }

    public Set<LottoNumber> getNumbers() {
        return this.lottoNumbers;
    }
}
