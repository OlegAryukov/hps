public class PowerSet {
    public PowerSet()
    {
        // ваша реализация хранилища
    }

    public int size()
    {
        // количество элементов в множестве
        return 0;
    }


    public void put(String value)
    {
        // всегда срабатывает
    }

    public boolean get(String value)
    {
        // возвращает true если value имеется в множестве,
        // иначе false
        return false;
    }

    public boolean remove(String value)
    {
        // возвращает true если value удалено
        // иначе false
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        // пересечение текущего множества и set2
        return null;
    }

    public PowerSet union(PowerSet set2)
    {
        // объединение текущего множества и set2
        return null;
    }

    public PowerSet difference(PowerSet set2)
    {
        // разница текущего множества и set2
        return null;
    }

    public boolean isSubset(PowerSet set2)
    {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        return false;
    }
}
