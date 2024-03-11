package utilities;

import java.util.HashSet;

public class dev {

    public static int getDuplicate(int[] arr) {
        HashSet<Integer> set = new HashSet<Integer>();
        int res = -1;

        for (int n = 0; n < arr.length; n++) {

            if (set.contains(arr[n])) {
                res = arr[n];
                break;
            }

            set.add(arr[n]);

        }

        return res;

    }
}
