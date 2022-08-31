import java.util.HashMap;
import java.util.Map;

public class PowerSet {
    Map<String, String> src;

    public PowerSet() {
        this.src = new HashMap<>();
    }

    public int size() {
        // количество элементов в множестве
        return src.size();
    }


    public void put(String value) {
        boolean contains = src.containsKey(value);
        if (!contains)
            src.put(value, value);
        // всегда срабатывает
    }

    public boolean get(String value) {

        // возвращает true если value имеется в множестве,
        // иначе false
        return src.containsKey(value);
    }

    public boolean remove(String value) {
        return src.remove(value, value);
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet intersection = new PowerSet();
        src.keySet().stream().filter(key1 -> set2.src.containsKey(key1)).forEach(keyUnion -> intersection.put(keyUnion));
        // пересечение текущего множества и set2
        return intersection;
    }

    public PowerSet union(PowerSet set2) {
        PowerSet union = new PowerSet();
        union.src.putAll(this.src);
        set2.src.keySet().forEach(union::put);
        // объединение текущего множества и set2
        return union;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet diff = new PowerSet();
        this.src.keySet().stream().filter(key1-> !set2.src.containsKey(key1)).forEach(diff::put);
        // разница текущего множества и set2
        return diff;
    }

    public boolean isSubset(PowerSet set2) {

        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        return this.src.keySet().containsAll(set2.src.keySet());
    }
}
