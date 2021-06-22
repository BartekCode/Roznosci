package loteria;

import java.util.List;

public class WynikiLoterii {
private List<Integer>userNumbers;
private List<Integer>lotteryNumbers;
private List<Integer> winNumbers;

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public void setUserNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public List<Integer> getLotteryNumbers() {
        return lotteryNumbers;
    }

    public void setLotteryNumbers(List<Integer> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public List<Integer> getWinNumbers() {
        return winNumbers;
    }

    public void setWinNumbers(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    public WynikiLoterii(List<Integer> userNumbers, List<Integer> lotteryNumbers, List<Integer> winNumbers) {
        this.userNumbers = userNumbers;
        this.lotteryNumbers = lotteryNumbers;
        this.winNumbers = winNumbers;
    }
}
