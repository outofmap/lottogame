package com.kakaopay.lottogame;

import org.junit.Assert;

import java.util.HashSet;
import java.util.List;

/**
 * @author david.chung
 * @since 2019-05-20
 */
public class LottoGameTest {
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void 천원미만으로사기() {
        LottoGame game = new LottoGame();
        // Buy
        List<Lotto> lottos = game.buyLottos(500,true);
    }

    @org.junit.Test
    public void 한개사기() {
        LottoGame game = new LottoGame();
        // Buy
        List<Lotto> lottos = game.buyLottos(1000,true);
        Assert.assertEquals(1, lottos.size());
    }

    // 구현한 다음에 테스트 케이스를 추가해버림. ㅠㅠ
    @org.junit.Test
    public void 애매하게한개사기() {
        LottoGame game = new LottoGame();
        // Buy
        List<Lotto> lottos = game.buyLottos(1500,true);
        Assert.assertEquals(1, lottos.size());
    }

    @org.junit.Test
    public void 두개사기() {
        LottoGame game = new LottoGame();
        // Buy
        List<Lotto> lottos = game.buyLottos(2000,true);
        Assert.assertEquals(2, lottos.size());
    }

    // 중복이 아님을 테스트하기 어렵다
    @org.junit.Test
    public void 각6개의숫자는랜덤이고중복없음() {
        for (int i = 0; i < 100000; i++) {
            Lotto lotto = new Lotto();
            Assert.assertEquals(6, lotto.getNumbers().size());
            Assert.assertEquals(6, lotto.getNumbers().stream().distinct().count());
        }
    }

    // 중복이 아님을 테스트하기 어렵다
    @org.junit.Test
    public void 당첨번호알기() {
        LottoWinningSet lottoWinningSet = new LottoWinningSet();
        lottoWinningSet.pick();
        lottoWinningSet.showWinningSet();
        Assert.assertEquals(6, lottoWinningSet.getWinningNumbers().size());
    }

    @org.junit.Test
    public void 보너스번호알기() {
        LottoWinningSet lottoWinningSet = new LottoWinningSet();
        lottoWinningSet.pick();
        lottoWinningSet.showWinningSet();
        Assert.assertTrue( lottoWinningSet.getBonusNumber() != null);
    }

    @org.junit.Test
    public void 보너스번호는당첨번호와불일치() {
        LottoWinningSet lottoWinningSet = new LottoWinningSet();
        lottoWinningSet.pick();
        Assert.assertFalse(lottoWinningSet.getWinningNumbers().contains(lottoWinningSet.getBonusNumber()));
    }

    @org.junit.Test
    public void 수익률알려주기_3개일치_5등_1개() {
        LottoGame game = new LottoGame();
        HashSet<LottoNumber> winningSet = new HashSet<>();
        winningSet.add(new LottoNumber(1));
        winningSet.add(new LottoNumber(2));
        winningSet.add(new LottoNumber(3));
        winningSet.add(new LottoNumber(10));
        winningSet.add(new LottoNumber(11));
        winningSet.add(new LottoNumber(12));


        LottoWinningSet lottoWinningSet = new LottoWinningSet(winningSet,new LottoNumber(20));

        HashSet<LottoNumber> lottoNumbers = new HashSet<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));

        // Buy
        List<Lotto> lottos = game.buySelectledLottos(1000,false, lottoNumbers);
        Assert.assertEquals(game.countRanking(lottos, lottoWinningSet).get(new Rank(5)), new Integer(1));
    }
//
//    @org.junit.Test
//    public void 수익률알려주기_4개일치() {
//        LottoGame game = new LottoGame();
//        LottoWinningSet lottoWinningSet = new LottoWinningSet();
//
//        // Buy
//        List<Lotto> lottos = game.buyLottos(2000);
//
//        Assert.assertFalse(game.calculateEarningRate(lottos,lottoWinningSet));
//    }
//
//    @org.junit.Test
//    public void 수익률알려주기_5개일치() {
//        LottoGame game = new LottoGame();
//        LottoWinningSet lottoWinningSet = new LottoWinningSet();
//
//        // Buy
//        List<Lotto> lottos = game.buyLottos(2000);
//
//        Assert.assertFalse(game.calculateEarningRate(lottos,lottoWinningSet));
//    }
//
//    @org.junit.Test
//    public void 수익률알려주기_5개일치보너스볼() {
//        LottoGame game = new LottoGame();
//        LottoWinningSet lottoWinningSet = new LottoWinningSet();
//
//        // Buy
//        List<Lotto> lottos = game.buyLottos(2000);
//
//        Assert.assertFalse(game.calculateEarningRate(lottos,lottoWinningSet));
//    }
//
//    @org.junit.Test
//    public void 수익률알려주기_6개일치() {
//        LottoGame game = new LottoGame();
//        LottoWinningSet lottoWinningSet = new LottoWinningSet();
//
//        // Buy
//        List<Lotto> lottos = game.buyLottos(2000);
//
//        Assert.assertFalse(game.calculateEarningRate(lottos,lottoWinningSet));
//    }
//
//    @org.junit.Test
//    public void 수익률알려주기_3개미만() {
//        LottoGame game = new LottoGame();
//        LottoWinningSet lottoWinningSet = new LottoWinningSet();
//
//        // Buy
//        List<Lotto> lottos = game.buyLottos(2000);
//
//        Assert.assertFalse(game.calculateEarningRate(lottos,lottoWinningSet));
//    }
}
