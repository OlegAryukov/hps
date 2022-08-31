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
        int valueHashCode = hashFun(value);
        int firstStep = valueHashCode + step;
        if (slots[valueHashCode] == null)
            return valueHashCode;
        if (firstStep < slots.length && slots[firstStep] == null)
            return firstStep;
        while (firstStep != valueHashCode) {
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

    public int put(String value) {
        int indexForValue = seekSlot(value);
        if (indexForValue != -1) {
            slots[indexForValue] = value;
            return indexForValue;
        }

        // записываем значение по хэш-функции

        // возвращается индекс слота или -1
        // если из-за коллизий элемент не удаётся разместить
        return -1;
    }

    public int find(String value) {
        int indexForValue = hashFun(value);
        if (slots[indexForValue] != null && slots[indexForValue].equalsIgnoreCase(value))
            return indexForValue;
        int firstCode = indexForValue;
        indexForValue += step;
        while (indexForValue != firstCode) {
            if (indexForValue < slots.length && slots[indexForValue] != null && slots[indexForValue].equalsIgnoreCase(value))
                return indexForValue;
            if (indexForValue + step < slots.length) {
                indexForValue += step;
            } else {
                indexForValue = indexForValue - slots.length + step;
            }
        }
        // находит индекс слота со значением, или -1
        return -1;
    }
}

