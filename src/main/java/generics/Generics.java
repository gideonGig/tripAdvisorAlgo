package generics;

import neecode_150.BasicAlgo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Generics<T> {
    public Generics() {
    }

    public static <T, G> List<G> convertArr(T[] arr, Function<T,G> mapperFunc) {
        return Arrays.stream(arr).map(mapperFunc).collect(Collectors.toList());
    }

    public void testUpperBound(Generics<? extends BasicAlgo> genric) {

    }

    public <T extends TestInterface & BoundContext> void tryExtendsMultiple(T element) {

    }

    public static interface TestInterface {

    }
}
