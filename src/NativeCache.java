import java.lang.reflect.Array;

public class NativeCache<T> {
        public int size;
        public String [] slots;
        public T [] values;
        public int [] hits;
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
                if (slots[slot] != null && slots[slot].equals(key))
                        return true;
                // возвращает true если ключ имеется,
                // иначе false
                return false;
        }

        public void put(String key, T value) {
                if(count<size && !isKey(key)){
                        int slot = seekSlot(key);
                        slots[slot] = key;
                        values[slot] = value;
                        hits[slot] = 0;
                } else if(!isKey(key)) {
                        int min = 0;
                        for (int i = 0; i < hits.length; i++) {
                                min  = Math.min(min, hits[i]);
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
                if (isKey(key)){
                        int i = find(key);
                        hits[i] +=1;
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
                return -1;
        }
}
