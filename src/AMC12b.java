import java.lang.reflect.Array;
import java.util.Arrays;

public class AMC12b
{
    public static void main(String [] args) {
        int[] array = new int[6];

        for (int w = 0; w < 10000; w++) {
            first:
            {
                for (int i = 0; i < 1000000; i++) {
                    for (int j = 0; j < 6; j++) {
                        array[j] = (int) (Math.random() * 10) + 91;
                        if (array[j] == 95)
                        {
                            array[j] = (int) (Math.random() * 10) + 91;
                        }
                    }

                    if ((array[0] + array[1]) / 2.0 == (array[0] + array[1]) / 2) {
                        if ((array[0] + array[1] + array[2]) / 3.0 == (array[0] + array[1] + array[2]) / 3) {
                            if ((array[0] + array[1] + array[2] + array[3]) / 4.0 == (array[0] + array[1] + array[2] + array[3]) / 4) {
                                if ((array[0] + array[1] + array[2] + array[3] + array[4]) / 5.0 == (array[0] + array[1] + array[2] + array[3] + array[4]) / 5) {
                                    if ((array[0] + array[1] + array[2] + array[3] + array[4] + array[5]) / 6.0 == (array[0] + array[1] + array[2] + array[3] + array[4] + array[5]) / 6) {
                                        if ((array[0] + array[1] + array[2] + array[3] + array[4] + array[5] + 95) / 7.0 == (array[0] + array[1] + array[2] + array[3] + array[4] + array[5] + 95) / 7) {
                                            if (array[5] == 100)
                                                break first;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(Arrays.toString(array));
        }
    }
}
