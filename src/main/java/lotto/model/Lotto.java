package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private final int LOTTO_LENGTH = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < LOTTO_LENGTH - 1; i++) {
            sb.append(numbers.get(i));
            sb.append(", ");
        }
        sb.append(numbers.get(LOTTO_LENGTH-1));
        sb.append("]");
        return sb.toString();
    }

    public WinningRank match(List<Integer> mainNumbers, Integer bonusNumber) {
        int matchedCount = mainNumbers.stream()
                .filter(numbers::contains)
                .toList()
                .size();
        boolean bonus = numbers.contains(bonusNumber);
        WinningRank of = WinningRank.of(matchedCount, bonus);
        return of;
    }
}
