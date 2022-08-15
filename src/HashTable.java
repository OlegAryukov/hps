public class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        return value.hashCode() & (size - 1);
        // всегда возвращает корректный индекс слота
//        return 0;
    }

    public int seekSlot(String value) {
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
            if(slots[firstStep]==null)
                return firstStep;
        }
        // находит индекс пустого слота для значения, или -1
        return -1;
    }

    public int put(String value) {
        int slot = seekSlot(value);
        if(slot!=-1) {
            slots[slot] = value;
            return slot;
        }

        // записываем значение по хэш-функции

        // возвращается индекс слота или -1
        // если из-за коллизий элемент не удаётся разместить
        return -1;
    }

    public int find(String value) {
        int slot = hashFun(value);
        if(slots[slot].equalsIgnoreCase(value))
            return slot;
        int firstCode = slot;
        slot+=step;
        while (slot != firstCode) {
            if (slot < slots.length && slots[slot]!=null && slots[slot].equalsIgnoreCase(value))
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

