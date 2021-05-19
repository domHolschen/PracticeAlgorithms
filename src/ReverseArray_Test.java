import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
public class ReverseArray_Test {
    @Test
    public void reverseArray_test1() {
        int[] expectedResult = new int[]{3, 8, -7, 5};
        assertArrayEquals(Challenges.reverseArray(new int[]{5, -7, 8, 3}), (expectedResult));

    }

    @Test
    public void reverseArray_test2() {
        assertArrayEquals(Challenges.reverseArray(new int[0]), (new int[0]));
    }

    @Test
    public void reverseArray_test3() {
        assertArrayEquals(Challenges.reverseArray(new int[]{1,2,3,4,5}), (new int[]{5,4,3,2,1}));
    }
}
