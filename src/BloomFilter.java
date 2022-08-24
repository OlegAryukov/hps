import java.util.BitSet;

public class BloomFilter {

    public int filter_len;
    public int hashMask;
    private int bit_array_size = Integer.SIZE;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        this.hashMask = (int) (1L << f_len) - 1;

        //размер битового массива
        this.bit_array_size = f_len;
        // создаём битовый массив длиной f_len ...
    }

    // хэш-функции
    public int hash1(String str1) {
        int res = 0;
        // 17
        for (int i = 0; i < str1.length(); i++) {
            int code = (res * 17 + (int) str1.charAt(i)) % filter_len;
            res = code;
        }
        // реализация ...
        return res;
    }

    public int hash2(String str1) {
        // 223
        int res = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (res * 223 + (int) str1.charAt(i)) % filter_len;
            res = code;
        }
        // реализация ...
        return res;
    }

    public void add(String str1) {
        int index = hash1(str1);
        setBit(index);
        index = hash2(str1);
        setBit(index);
        // добавляем строку str1 в фильтр
    }

    public boolean isValue(String str1) {
        // проверка, имеется ли строка str1 в фильтре
        int index1 = hash1(str1);
        int index2 = hash2(str1);
        if(getBit(index1) == 0 || getBit(index2) ==0 )
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
        this.filter_len = this.filter_len | (1 << index );
    }
}
