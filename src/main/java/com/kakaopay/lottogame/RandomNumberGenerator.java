package com.kakaopay.lottogame;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author david.chung
 * @since 2019-05-20
 */
public class RandomNumberGenerator {

    public static Set<Integer> generateRandomLottoNumbers(int totalCount) {
        Set<Integer> result = new HashSet<>();
        while(result.size() != totalCount) {
            int number = new Random().nextInt(45) + 1;
            result.add(number);
        }
        return result;
    }
}
