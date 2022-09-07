import java.lang.reflect.Array;

public class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;
    private int step;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        step = 3;
    }

    public static NativeDictionary withCustomStepSize(int sz, Class clazz, int step) {
        NativeDictionary nativeDictionary = new NativeDictionary(sz, clazz);
        nativeDictionary.step = step;
        return nativeDictionary;
    }
    public int hashFun(String key) {
        return key.hashCode() & (size - 1);
        // всегда возвращает корректный индекс слота
    }

    public boolean isKey(String key) {
        int indexForKey = find(key);
        if (indexForKey == -1)
            return false;
        if (slots[indexForKey] != null && slots[indexForKey].equals(key))
            return true;
        // возвращает true если ключ имеется,
        // иначе false
        return false;
    }

    public void put(String key, T value) {
        if (isKey(key)) {
            int indexForKey = find(key);
            values[indexForKey] = value;
        } else {
            int indexForKey = seekSlot(key);
            slots[indexForKey] = key;
            values[indexForKey] = value;
        }
        // гарантированно записываем
        // значение value по ключу key
    }

    public T get(String key) {
        if (isKey(key))
            return values[find(key)];
        // возвращает value для key,
        // или null если ключ не найден
        return null;
    }

    private int seekSlot(String value) {
        int code = hashFun(value);
        int firstStep = code + step;
        if (slots[code] == null)
            return code;
        if (firstStep < slots.length && slots[firstStep] == null)
            return firstStep;
        while (firstStep != code) {
            if (firstStep + step < slots.length) {
                firstStep += step;
            } else {
                firstStep = firstStep - slots.length + step;
            }
            if (slots[firstStep] == null)
                return firstStep;
        }
        // находит индекс пустого слота для значения, или -1
        return -1;
    }

    private int find(String value) {
        int firstFindSlot = hashFun(value);
        if (slots[firstFindSlot] != null && slots[firstFindSlot].equalsIgnoreCase(value))
            return firstFindSlot;
        int nextSlot = firstFindSlot + step;
        while (nextSlot != firstFindSlot) {
            if (nextSlot < slots.length && slots[nextSlot] != null && slots[nextSlot].equalsIgnoreCase(value))
                return nextSlot;
            if (nextSlot + step < slots.length) {
                nextSlot += step;
            } else {
                nextSlot = nextSlot - slots.length + step;
            }
        }
        // находит индекс слота со значением, или -1
        return -1;
    }
}

