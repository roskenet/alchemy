package effectivejava.item01;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

// Favor composition over inheritance
// Broken - Inappropriate use of inheritance!
class InstrumentedHashSet<E> extends HashSet<E> {
    // The number of attempted element insertions
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}

public class Item18 {
    public static void main(String[] args) {
        var myStringHashMap = new InstrumentedHashSet<String>();

        myStringHashMap.addAll(List.of("Ernie", "Bert", "Maja"));

        System.out.println(myStringHashMap.getAddCount());
    }
}
