package bloch.item33;
// Consider typesafe heterogeneous containers

import java.util.HashMap;
import java.util.Map;

class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <K> void putFavorite(Class<K> key, K value) {
       favorites.put(key, value);
    }

    public <K> K getFavorite(Class<K> key) {
        return key.cast(favorites.get(key));
    }
}

public class Main {
    static void main() {
        Integer myInt = Integer.valueOf(42);
        String myString = "Elvis";

        Favorites myFavorites = new Favorites();
        myFavorites.putFavorite(String.class, myString);
//        myFavorites.putFavorite(String.class, myInt);
        myFavorites.putFavorite(Integer.class, myInt);

        String favorite = myFavorites.getFavorite(String.class);
        System.out.println(favorite);
    }
}
