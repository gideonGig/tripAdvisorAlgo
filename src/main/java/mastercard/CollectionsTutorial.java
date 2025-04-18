package mastercard;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class CollectionsTutorial {

    public CollectionsTutorial() {
    }

    public void usingHashMap() {
        Map testMap = new HashMap<>();
        Map<Element,String> enumMap = new EnumMap<>(Element.class);
        enumMap.put(Element.HELIUM, "test heliumEnums");
        enumMap.put(Element.MAGNESIUM, "test magnesium");

        Map<Integer,String> hashMap = new HashMap<Integer,String>();

    }
}
