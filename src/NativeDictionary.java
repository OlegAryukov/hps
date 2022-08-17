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

    public int hashFun(String key) {
        return key.hashCode() & (size - 1);
        // всегда возвращает корректный индекс слота
    }

    public boolean isKey(String key) {
        int slot = find(key);
        if (slot == -1)
            return false;
        if (slots[slot] != null && slots[slot].equals(key))
            return true;
        // возвращает true если ключ имеется,
        // иначе false
        return false;
    }

    public void put(String key, T value) {
        if (isKey(key)) {
            int i = find(key);
            values[i] = value;
        } else {
            int slot = seekSlot(key);
            slots[slot] = key;
            values[slot] = value;
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
        int slot = hashFun(value);
        if (slots[slot] != null && slots[slot].equalsIgnoreCase(value))
            return slot;
        int firstCode = slot;
        slot += step;
        while (slot != firstCode) {
            if (slot < slots.length && slots[slot] != null && slots[slot].equalsIgnoreCase(value))
                return slot;
            if (slot + step < slots.length) {
                slot += step;
            } else {
                slot = slot - slots.length + step;
            }
        }
        // находит индекс слота со значением, или -1
        return -1;
    }
}

