import java.lang.reflect.Array;

public class DynArray<T> {

    public T[] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clazz) {
        this.clazz = clazz;
    }

    public static DynArray defaultCapacity(Class clz) {
        final DynArray<Object> dynArray = new DynArray<>(clz);
         // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);

        dynArray.setCount(0);
        dynArray.setCapacity(16);
        return dynArray;
    }

    public static DynArray customCapacity(Class clz, int capacity) {
        final DynArray<Object> dynArray = new DynArray<>(clz);
        // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);

        dynArray.setCount(0);
        dynArray.setCapacity(capacity);
        return dynArray;
    }

    public void makeArray(int new_capacity) {
        if (new_capacity >= 16) {
            final T[] newArray = (T[]) Array.newInstance(this.clazz, new_capacity);
            if (count != 0) {
                if (capacity >= 0) System.arraycopy(this.array, 0, newArray, 0, capacity);
            }
            this.array = newArray;
            this.capacity = new_capacity;
        }
    }

    public T getItem(int index) {
        if (index < count || index < capacity)
            return array[index];
        else
            throw new IndexOutOfBoundsException();
    }

    public void append(T itm) {
        if (count == capacity)
            makeArray(this.capacity * 2);
        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index) {
        if (index < 0 || index > count)
            throw new IndexOutOfBoundsException();
        final boolean capacityFull = count + 1 > capacity;
        if (capacityFull) {
            int newCapacity = this.capacity * 2;
            T[] newArray = (T[]) Array.newInstance(this.clazz, newCapacity);
            int oldIndexAfterInsert = 0;
            for (int oldIndexBeforeInsert = 0; oldIndexBeforeInsert < count + 1; oldIndexBeforeInsert++) {
                if (oldIndexBeforeInsert == index) {
                    newArray[oldIndexBeforeInsert] = itm;
                    continue;
                }
                newArray[oldIndexBeforeInsert] = array[oldIndexAfterInsert];
                oldIndexAfterInsert++;
            }
            this.capacity = newCapacity;
            this.array = newArray;
        } else if (count == index) {
            array[count] = itm;
        } else if (index < count) {
            T previousValueStorage = array[index];
            array[index] = itm;
            for (int i = index + 1; i < capacity; i++) {
                T temporaryCurrentValueStorage = array[i];
                array[i] = previousValueStorage;
                previousValueStorage = temporaryCurrentValueStorage;
            }
        } else {
            array[index] = itm;
        }
        count++;
    }

    public void remove(int index) {
        if ((index > count) || (count == 0 && index > -1)) {
            throw new IndexOutOfBoundsException();
        }
        if (count != 0) {
            final boolean needChangeCapacity = (1 / ((double) capacity / (double) (count - 1))) < 0.5;
            if (needChangeCapacity) {
                int calcCapacity = (int) (this.capacity / 1.5);
                int newCapacity = Math.max(calcCapacity, 16);
                T[] newArray = (T[]) Array.newInstance(this.clazz, newCapacity);
                int newArrIndex = 0;
                for (int scrArrIndex = 0; scrArrIndex < count; scrArrIndex++) {
                    if (scrArrIndex == index) {
                        newArray[newArrIndex] = array[scrArrIndex + 1];
                        scrArrIndex++;
                        newArrIndex++;
                        continue;
                    }
                    newArray[newArrIndex] = array[scrArrIndex];
                    newArrIndex++;
                }
                this.array = newArray;
                this.capacity = newCapacity;

            } else {
                int newIndex = index;
                for (int oldIndex = index; oldIndex < capacity - 1; oldIndex++) {
                    array[newIndex] = array[oldIndex + 1];
                    newIndex++;
                }
            }
            count--;
        }
    }


    public void print() {
        for (int i = 0; i < capacity; i++) {
            System.out.print(array[i] + " | ");
        }
        System.out.print("\n");
    }

    private void setCount(int count) {
        this.count = count;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}

