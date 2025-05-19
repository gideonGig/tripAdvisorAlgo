package neecode_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicAlgo {

    public static boolean canSum(int target, int[] arr) {
        return checkCanSum(target, arr, new HashMap<Integer, Boolean>());
    }

    private static boolean checkCanSum(int target, int[] arr, Map<Integer,Boolean> hashMap) {
        if (hashMap.containsKey(target)) {
            return hashMap.get(target);
        }

        if (target == 0) {
            return true;
        }

        if (target < 0) {
            return false;
        }


        for (int value : arr) {
            int remainder = target - value;
            if (checkCanSum(remainder, arr, hashMap)) {
                hashMap.put(target, true);
                return true;
            }

        }

        hashMap.put(target, false);
        return false;
    }

    public static List<List<Integer>> howSum(int target, int[] arr) {

        Map<Integer, List<List<Integer>>> hashMap = new HashMap<>();
        return getHowSum(target, arr, hashMap);
    }

    private static List<List<Integer>> getHowSum(int target, int[] arr, Map<Integer, List<List<Integer>>> hashMap) {

        if (target == 0) {
            List<Integer> baseList = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            result.add(baseList);
            return result;
        }

        if (target < 0) {
            return new ArrayList<>();
        }

        if (hashMap.containsKey(target)) {
            return hashMap.get(target);
        }

        List<List<Integer>> allPaths = new ArrayList<>();


        for (int value : arr) {
            int remainder = target - value;
            var subPath = getHowSum(remainder, arr, hashMap);
            for (List<Integer> path : subPath) {
                List<Integer> newPath = new ArrayList<>();
                newPath.add(value);
                newPath.addAll(path);
                allPaths.add(newPath);
            }
        }

        hashMap.put(target, allPaths);
        return allPaths;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        int target = 8;
        List<List<Integer>> paths = howSum(target, nums);

        System.out.println("All unique paths to reach target sum:");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }


}
