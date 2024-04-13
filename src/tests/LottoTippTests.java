package tests;

import collections.LottoTipp;

import static collections.LottoTipp.*;

public class LottoTippTests extends Thread{
    @Override
    public void run() {
        LottoTipp lottoTipp = new LottoTipp();
        System.out.println("lottoTipp = " + lottoTipp);
        System.out.println("createLottoTipps(5) = " + createLottoTipps(5));
        printCalcGewinn(10);
    }
}
