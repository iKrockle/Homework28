import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringListImpl stringList = new StringListImpl(1);

        stringList.add("Hello");
        stringList.add("World");
        stringList.add("Today");
        System.out.println(Arrays.toString(stringList.toArray()));

        stringList.add(1,"smthing");
        System.out.println(Arrays.toString(stringList.toArray()));
        try{
            stringList.set(0,"Gb");
            System.out.println(Arrays.toString(stringList.toArray()));
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        try{
            stringList.set(10,"Gb");
            System.out.println(Arrays.toString(stringList.toArray()));
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.remove(1);
        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.remove("Today");
        System.out.println(Arrays.toString(stringList.toArray()));
        System.out.println(stringList.contains("Today"));
        System.out.println(stringList.contains("Gb"));
        stringList.add("Today");
        stringList.add("Today");
        System.out.println(stringList.indexOf("Today"));
        System.out.println(stringList.indexOf("grp"));
        System.out.println(Arrays.toString(stringList.toArray()));
        System.out.println(stringList.lastIndexOf("Today"));
        System.out.println(stringList.get(0));
        System.out.println(Arrays.toString(stringList.toArray()));
        System.out.println(stringList.equals(stringList));
        System.out.println(stringList.size());
        System.out.println(stringList.isEmpty());
        stringList.clear();
        System.out.println(Arrays.toString(stringList.toArray()));
    }
}