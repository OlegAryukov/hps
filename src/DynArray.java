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
                for (int i = 0; i < capacity; i++) {
                    newArray[i] = this.array[i];
                }
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
        if (index > capacity - 1)
            throw new IndexOutOfBoundsException();
        if (count + 1 >= capacity) {
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
        } else {
            T tmp = array[index];
            for (int i = index; i < count + 1; i++) {
                if (i == index) {
                    array[i] = itm;
                    continue;
                }
                T innerTmp = array[i];
                array[i] = tmp;
                tmp = innerTmp;
            }
        }
        count++;
    }

    public void remove(int index) {
        if (index > count) {
            throw new IndexOutOfBoundsException();
        }
        if (count != 0) {
            if ((count - 1) <= (capacity / 1.5)) {
                int newCapacity = Math.max((int) (this.capacity / 1.5), 16);
                T[] newArray = (T[]) Array.newInstance(this.clazz, newCapacity);
                int j = 0;
                for (int i = 0; i < count; i++) {
                    if (i == index) {
                        newArray[j] = array[i + 1];
                        i++;
                        j++;
                        continue;
                    }
                    newArray[j] = array[i];
                    j++;
                }
                this.array = newArray;
                this.capacity = newCapacity;
            } else {
                int j = index;
                for (int i = index; i < capacity - 1; i++) {
                    array[j] = array[i + 1];
                    j++;
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

