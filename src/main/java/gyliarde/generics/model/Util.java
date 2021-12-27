package gyliarde.generics.model;

public class Util {
    public static <K,V> boolean compare(Pair<K,V> pair1, Pair<K,V> pair2 ) {
        return pair1.getKey().equals(pair2.getKey()) &&
               pair1.getValue().equals(pair2.getValue());
    }
}
