package algosecon.abst;

class aBST {
    public Integer Tree[]; // массив ключей

    public aBST(int depth) {
        // правильно рассчитайте размер массива для дерева глубины depth:
        int tree_size = (int) (Math.pow(2, depth) - 1);
        Tree = new Integer[tree_size];
        for (int i = 0; i < tree_size; i++) Tree[i] = null;
    }

    public Integer FindKeyIndex(int key) {
        if (Tree[0] == null)
            return null;
        int res = findSlotRec(key, 0);
        // ищем в массиве индекс ключа
        return res == 0 ? null : res; // не найден
    }

    public int AddKey(int key) {
        if (Tree[0] == null) {
            Tree[0] = key;
            return 0;
        }
        Integer keyIndex = FindKeyIndex(key);
        // добавляем ключ в массив
        if (keyIndex == null || keyIndex == 0)
            return -1;
        if (keyIndex < 0) {
            Tree[-keyIndex] = key;
            return keyIndex;
        }
        return keyIndex;
//        return keyIndex == null ? -1 : Math.abs(keyIndex);
        // индекс добавленного/существующего ключа или -1 если не удалось
    }

    private int findSlotRec(int key, int currIndex) {
        if (Tree[currIndex] == null)
            return -currIndex;
        if (Tree[currIndex] == key)
            return currIndex;
        int nextIndex = key < Tree[currIndex] ? 2 * currIndex + 1 : 2 * currIndex + 2;
        if (nextIndex <= Tree.length) {
            return findSlotRec(key, nextIndex);
        }
        return 0;
    }
}
