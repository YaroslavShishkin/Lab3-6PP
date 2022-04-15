package patterns;

import store.Boots;
import store.Product;

public class BootsFactory implements ProductFactory {

    @Override
    public Product createInstance() {

        return new Boots();
    }
}
