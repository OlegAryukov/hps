import java.lang.reflect.Array;

public class NativeCache<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;
    private int step;
    private int count;

    public NativeCache(int sz, Class clazz) {
        count = 0;
        size = sz;
        hits = new int[sz];
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
        return (slots[slot] != null && slots[slot].equals(key));
    }

    public void put(String key, T value) {
        final boolean isKey = isKey(key);
        if (count < size && !isKey) {
            int slot = seekSlot(key);
            slots[slot] = key;
            values[slot] = value;
            hits[slot] = 0;
        } else if (!isKey) {
            int min = 0;
            for (int i = 0; i < hits.length; i++) {
                min = Math.min(min, hits[i]);
            }
            slots[min] = null;
            values[min] = null;
            hits[min] = 0;
            int slot = seekSlot(key);
            slots[slot] = key;
            values[slot] = value;
        }
    }

    public T get(String key) {
        if (isKey(key)) {
            int i = find(key);
            hits[i] += 1;
            return values[i];
        }
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
        return -1;
    }

    private int find(String value) {
        int slot = hashFun(value);
        if (slots[slot] != null && slots[slot].equalsIgnoreCase(value))
            return slot;
        int nextSlot = slot + step;
        while (nextSlot != slot) {
            if (nextSlot < slots.length && slots[nextSlot] != null && slots[nextSlot].equalsIgnoreCase(value))
                return nextSlot;
            if (nextSlot + step < slots.length) {
                nextSlot += step;
            } else {
                nextSlot = nextSlot - slots.length + step;
            }
        }
        return -1;
    }
}
