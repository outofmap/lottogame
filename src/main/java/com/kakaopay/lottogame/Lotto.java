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
    private boolean isRandom;

    public Lotto() {
        this.isRandom = true;
        this.lottoNumbers= generateRandomLottoNumbers();
    }

    public Lotto(boolean isRandom, HashSet<LottoNumber> selectedLottoNumbers) {
        this.lottoNumbers = new HashSet<>();
        this.isRandom = isRandom;
        this.lottoNumbers = getLottoNumbers(isRandom, selectedLottoNumbers);
    }

    private Set<LottoNumber> getLottoNumbers(boolean isRandom, HashSet<LottoNumber> selectedLottoNumbers) {
        if(isRandom){
            return generateRandomLottoNumbers();
        }
        return selectedLottoNumbers;
    }

    private Set<LottoNumber> generateRandomLottoNumbers() {
        return RandomNumberGenerator.generateRandomLottoNumbers(TOTAL_COUNT)
                                                 .stream()
                                                 .map(LottoNumber::new)
                                                 .collect(Collectors.toSet());
    }

    public Set<LottoNumber> getNumbers() {
        return this.lottoNumbers;
    }
}
