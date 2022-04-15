package patterns;

import store.Clothes;
import store.Product;

public class ClothesFactory implements ProductFactory {

    @Override
    public Product createInstance() {

        return new Clothes();
    }
}
