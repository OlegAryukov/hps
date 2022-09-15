import java.util.BitSet;

public class BloomFilter {

    public int filter_len;
    public int hashMask;
    private int bit_array_size = Integer.SIZE;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        this.hashMask = (1 << f_len) - 1;

        //размер битового массива
        this.bit_array_size = f_len;
        // создаём битовый массив длиной f_len ...
    }

    // хэш-функции
    public int hash1(String str1) {
        int hashCodeOfInputValue = 0;
        // 17
        for (int i = 0; i < str1.length(); i++) {
            int innerCycleHashCode = (hashCodeOfInputValue * 17 + (int) str1.charAt(i)) % filter_len;
            hashCodeOfInputValue = innerCycleHashCode;
        }
        // реализация ...
        return hashCodeOfInputValue;
    }

    public int hash2(String str1) {
        // 223
        int hashCodeOfInputValue = 0;
        for (int i = 0; i < str1.length(); i++) {
            hashCodeOfInputValue = (hashCodeOfInputValue * 223 + (int) str1.charAt(i)) % filter_len;
        }
        // реализация ...
        return hashCodeOfInputValue;
    }

    public void add(String str1) {
        int indexOfBitPosition = hash1(str1);
        setBit(indexOfBitPosition);
        indexOfBitPosition = hash2(str1);
        setBit(indexOfBitPosition);
        // добавляем строку str1 в фильтр
    }

    public boolean isValue(String str1) {
        // проверка, имеется ли строка str1 в фильтре
        int indexOfBitPositionByFirstHashFunc = hash1(str1);
        int indexOfBitPositionBySecondHashFunc = hash2(str1);
        if (getBit(indexOfBitPositionByFirstHashFunc) == 0 || getBit(indexOfBitPositionBySecondHashFunc) == 0)
            return false;

        //иначе элемент вероятно есть
        return true;
    }

    public long getBit(int index) {
        //=битовая карта смещенная вправо на index мест (>>> пустые места справа заполняются 0)
        // & 01 - проверка только крайнего правого бита (все остальные игнорируются)
        return (this.filter_len >>> index) & 1;
    }

    public void setBit(int index) {
        //= битовая карта OR 1 смещенное влево на index
        this.filter_len = this.filter_len | (1 << index);
    }
}
