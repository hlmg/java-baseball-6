package baseball.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {
    @Nested
    class GenerateUniqueNumbers {
        @DisplayName("중복되지 않는 숫자를 생성할 수 있다")
        @Test
        void SuccessGenerateUniqueNumbers() {
            int startInclusive = 1;
            int endInclusive = 3;
            int digit = 3;

            List<Integer> generatedNumbers = NumberGenerator.generateUniqueNumbers(startInclusive, endInclusive, digit);

            Set<Integer> uniqueNumbers = new HashSet<>(generatedNumbers);
            assertThat(uniqueNumbers.size()).isEqualTo(digit);
        }

        @DisplayName("범위가 너무 작으면 예외가 발생한다")
        @Test
        void ThrowExceptionIfToSmallRange() {
            int startInclusive = 1;
            int endInclusive = 2;
            int digit = 3;

            assertThatIllegalArgumentException()
                    .isThrownBy(() -> NumberGenerator.generateUniqueNumbers(startInclusive, endInclusive, digit));
        }
    }
}
