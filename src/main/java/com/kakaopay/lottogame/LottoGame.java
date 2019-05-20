package com.kakaopay.lottogame;

import java.util.ArrayList;
import java.util.List;

/**
 * @author david.chung
 * @since 2019-05-20
 */
public class LottoGame {
    private static final int MIN_BUY_AMOUNT = 1000;
    public List<Lotto> buyLottos(int amount) {
        if(amount < MIN_BUY_AMOUNT) {
            throw new IllegalArgumentException();
        }
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < getTotalLottoCount(amount); i++) {
            result.add(new Lotto());
        }
        return result;
    }

    private int getTotalLottoCount(int amount) {
        return amount / 1000;
    }
}
