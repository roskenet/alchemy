package bloch.item28;
// Prefer lists to arrays

public class Main {
    static void main() {
// Why generic array creation is illegal - won't compile!

//  List<String>[] stringLists = new List<String>[1];// (1)
//  List<Integer> intList = List.of(42); // (2)
//  Object[] objects = stringLists;// (3)
//  objects[0] = intList;// (4)
//  String s = stringLists[0].get(0);// (5)
    }
}
// In summary, arrays and generics have very different type rules.
// Arrays are covariant and reified; generics are invariant and erased.
// As a consequence, arrays provide runtime type safety but not
// compile-time type safety, and vice versa for generics.
// As a rule, arrays and generics don’t mix well.