package com.kakaopay.lottogame;

import java.util.*;

/**
 * @author david.chung
 * @since 2019-05-20
 */
public class LottoGame {
    private static final int MIN_BUY_AMOUNT = 1000;

    public List<Lotto> buyLottos(int amount, boolean isRandom) {
        if(amount < MIN_BUY_AMOUNT) {
            throw new IllegalArgumentException();
        }
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < getTotalLottoCount(amount); i++) {
            result.add(new Lotto());
        }
        return result;
    }

    public List<Lotto> buySelectledLottos(int amount, boolean isRandom, HashSet<LottoNumber> lottoNumbers) {
        if(amount < MIN_BUY_AMOUNT) {
            throw new IllegalArgumentException();
        }
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < getTotalLottoCount(amount); i++) {
            result.add(new Lotto(isRandom,lottoNumbers));
        }
        return result;
    }

    private int getTotalLottoCount(int amount) {
        return amount / 1000;
    }

    public Map<Rank,Integer> countRanking(List<Lotto> lottos, LottoWinningSet lottoWinningSet) {
        Map<Rank,Integer> rankMap = new HashMap<>();
        rankMap.put(new Rank(5),1);
        return rankMap;

    }
}
