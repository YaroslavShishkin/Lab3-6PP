package threads;

import store.Product;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.List;

public class SynhronizedProduct implements Product {

    private Product product;

    public SynhronizedProduct(Product product) {

        this.product = product;
    }

    public synchronized List<String> getMaterials() {

        return product.getMaterials();
    }

    public synchronized BigDecimal calculateCost() {

        return product.calculateCost();
    }
    public synchronized void sortingMaterials() {

        product.sortingMaterials();
    }
    public synchronized String getDescription() {

        return product.getDescription();
    }

    public synchronized void output(OutputStream out) throws IOException {

        product.output(out);
    }
    public synchronized void write(Writer out) throws IOException {

        product.write(out);
    }
}
