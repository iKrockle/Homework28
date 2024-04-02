import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringListImpl stringList = new StringListImpl(1);

        stringList.add(21);
        stringList.add(23);
        stringList.add(24);
        System.out.println(Arrays.toString(stringList.toArray()));

        stringList.add(1,25);
        System.out.println(Arrays.toString(stringList.toArray()));
        try{
            stringList.set(0,26);
            System.out.println(Arrays.toString(stringList.toArray()));
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        try{
            stringList.set(10,26);
            System.out.println(Arrays.toString(stringList.toArray()));
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.remove(1);
        System.out.println(Arrays.toString(stringList.toArray()));
        Integer a = 24;
        stringList.remove(a);
        System.out.println(Arrays.toString(stringList.toArray()));
        System.out.println(stringList.contains(24));
        System.out.println(stringList.contains(26));
        stringList.add(24);
        stringList.add(24);
        System.out.println(stringList.indexOf(24));
        System.out.println(stringList.indexOf(111));
        System.out.println(Arrays.toString(stringList.toArray()));
        System.out.println(stringList.lastIndexOf(24));
        System.out.println(stringList.get(0));
        System.out.println(Arrays.toString(stringList.toArray()));
        System.out.println(stringList.equals(stringList));
        System.out.println(stringList.size());
        System.out.println(stringList.isEmpty());
        stringList.clear();
        System.out.println(Arrays.toString(stringList.toArray()));
    }
}