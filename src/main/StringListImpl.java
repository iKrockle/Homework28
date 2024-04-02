import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private Integer[] stringArr;
    public StringListImpl(int len) {
        stringArr = new Integer[len];
    }

    private void grow(){
        Integer[] newStringArr = stringArr;
        stringArr = new Integer[(int) (stringArr.length*1.5)];
        System.arraycopy(newStringArr, 0, stringArr, 0, newStringArr.length);
    }

    @Override
    public Integer add(Integer item) {
        Integer index = null;
        for (int i=0;i<stringArr.length;i++){
            if (stringArr[i]==null) {
                index=i;
                break;
            }
        }
        if (index != null){
            stringArr[index] = item;
        }
        else {
            grow();
            add(item);
        }
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (stringArr[stringArr.length-1]!=null){
            grow();
        }
        for (int i=stringArr.length-1;i>index;i--){
                stringArr[i] = stringArr[i-1];
        }
        stringArr[index]=item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index>stringArr.length-1){
            throw new IndexOutOfBoundsException("Указанный индекс не существует");
        }
        stringArr[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) throws ItemNotFoundException {
        int index = -1;
        for (int i=0;i<stringArr.length;i++){
            if (stringArr[i].equals(item)){
                index = i;
                break;
            }
        }
        if (index >=0) {
            for (int i=index;i<stringArr.length-1;i++){
                stringArr[i] = stringArr[i+1];
            }
            stringArr[stringArr.length-1]=null;
            return item;
        }
        else {
            throw new ItemNotFoundException("Указанный элемент не найден");
        }
    }

    @Override
    public Integer remove(int index) {
        if (index>stringArr.length-1){
            throw new IndexOutOfBoundsException("Указанный индекс не существует");
        }
        Integer item = stringArr[index];
        for (int i=index;i<stringArr.length-1;i++){
            stringArr[i] = stringArr[i+1];
        }
        stringArr[stringArr.length-1]=null;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return binarySearch(item);
    }

    @Override
    public int indexOf(Integer item) {
        int index = -1;
        for (int i=0;i<stringArr.length;i++){
            if (stringArr[i]!=null) {
                if (stringArr[i].equals(item)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Integer item) {
        int index = -1;
        for (int i=stringArr.length-1;i>=0;i--){
            if (stringArr[i]!=null) {
                if (stringArr[i].equals(item)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    @Override
    public Integer get(int index) {
        if (index>stringArr.length-1){
            throw new IndexOutOfBoundsException("Указанный индекс не существует");
        }
        return stringArr[index];
    }

    @Override
    public boolean equals(@NotNull StringList otherList) {
        return  Arrays.equals(stringArr, otherList.toArray());
    }

    @Override
    public int size() {
        return stringArr.length;
    }

    @Override
    public boolean isEmpty() {
        boolean empty = true;
        for (Object ob : stringArr) {
            if (ob != null) {
                empty = false;
                break;
            }
        }
        return empty;
    }

    @Override
    public void clear() {
        Arrays.fill(stringArr, null);
    }

    @Override
    public Integer[] toArray() {
        Integer[] newStringArr = stringArr;
        return newStringArr;
    }

    private static Integer[] sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }

    private Integer[] quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr,partitionIndex + 1, end);
        }
        return arr;
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Integer[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    boolean binarySearch(Integer element) {
        // в начале левая и правая границы равны первому и последнему элементу массива
        Integer[] sortedArray = quickSort(stringArr,0,stringArr.length-1);
        var left = 0;
        var right = sortedArray.length - 1;
        // пока левая и правая границы поиска не пересеклись
        while (left <= right) {
            // индекс текущего элемента находится посередине
            var middle = (left + right) / 2;
            var current = sortedArray[middle];

            if (current.equals(element)) {
                // нашли элемент - возвращаем его индекс
                return true;
            } else if (current < element) {
                // текущий элемент меньше искомого - сдвигаем левую границу
                left = middle + 1;
            } else {
                // иначе сдвигаем правую границу
                right = middle - 1;
            }
        }
        // проверили весь массив, но не нашли элемент
        return false;
    }
}
