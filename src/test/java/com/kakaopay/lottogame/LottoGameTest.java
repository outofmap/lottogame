package com.kakaopay.lottogame;

import org.junit.Assert;

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
        List<Lotto> lottos = game.buyLottos(500);
    }

    @org.junit.Test
    public void 한개사기() {
        LottoGame game = new LottoGame();
        // Buy
        List<Lotto> lottos = game.buyLottos(1000);
        Assert.assertEquals(1, lottos.size());
    }

    // 구현한 다음에 테스트 케이스를 추가해버림. ㅠㅠ
    @org.junit.Test
    public void 애매하게한개사기() {
        LottoGame game = new LottoGame();
        // Buy
        List<Lotto> lottos = game.buyLottos(1500);
        Assert.assertEquals(1, lottos.size());
    }

    @org.junit.Test
    public void 두개사기() {
        LottoGame game = new LottoGame();
        // Buy
        List<Lotto> lottos = game.buyLottos(2000);
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
        Assert.assertEquals(6, lottoWinningSet.getWinningNumbers().size());
    }

    @org.junit.Test
    public void 보너스번호알기() {
        Assert.assertTrue( new LottoWinningSet().getBonusNumber() != null);
    }
}
