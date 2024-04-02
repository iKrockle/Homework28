import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] stringArr;
    public StringListImpl(int len) {
        stringArr = new String[len];
    }

    private void increaceLen(){
        String[] newStringArr = stringArr;
        stringArr = new String[stringArr.length+1];
        System.arraycopy(newStringArr, 0, stringArr, 0, newStringArr.length);
    }

    @Override
    public String add(String item) {
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
            increaceLen();
            add(item);
        }
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (stringArr[stringArr.length-1]!=null){
            increaceLen();
        }
        for (int i=stringArr.length-1;i>index;i--){
                stringArr[i] = stringArr[i-1];
        }
        stringArr[index]=item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index>stringArr.length-1){
            throw new IndexOutOfBoundsException("Указанный индекс не существует");
        }
        stringArr[index] = item;
        return item;
    }

    @Override
    public String remove(String item) throws ItemNotFoundException {
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
    public String remove(int index) {
        if (index>stringArr.length-1){
            throw new IndexOutOfBoundsException("Указанный индекс не существует");
        }
        String item = stringArr[index];
        for (int i=index;i<stringArr.length-1;i++){
            stringArr[i] = stringArr[i+1];
        }
        stringArr[stringArr.length-1]=null;
        return item;
    }

    @Override
    public boolean contains(String item) {
        for (String s : stringArr) {
            if (s!=null) {
                if (s.equals(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
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
    public int lastIndexOf(String item) {
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
    public String get(int index) {
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
    public String[] toArray() {
        String[] newStringArr = stringArr;
        return newStringArr;
    }
}
