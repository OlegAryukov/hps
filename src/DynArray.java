import java.lang.reflect.Array;

public class DynArray<T> {

    public T[] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz) {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);

        count = 0;
        makeArray(16);
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
        if (count + 1 > capacity) {
            int newCapacity = this.capacity * 2;
            T[] newArray = (T[]) Array.newInstance(this.clazz, newCapacity);
            int j = 0;
            for (int i = 0; i < count + 1; i++) {
                if (i == index) {
                    newArray[i] = itm;
                    continue;
                }
                newArray[i] = array[j];
                j++;
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
                int newCapacity = Math.max((int) (this.capacity / 1.5), 16);
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
}

