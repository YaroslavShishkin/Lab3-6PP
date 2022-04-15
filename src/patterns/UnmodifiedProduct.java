package patterns;

import store.Product;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.List;

public class UnmodifiedProduct implements Product {

    Product product;

    public UnmodifiedProduct(Product product) {

        this.product = product;
    }

    @Override
    public BigDecimal calculateCost() {

        return product.calculateCost();
    }

    @Override
    public void sortingMaterials() {

        product.sortingMaterials();
    }

    @Override
    public String getDescription() {

        return product.getDescription();
    }

    @Override
    public void output(OutputStream out) throws IOException {

        product.output(out);
    }

    @Override
    public void write(Writer out) throws IOException {

        product.write(out);
    }

    @Override
    public List<String> getMaterials() throws UnsupportedOperationException {

        throw new UnsupportedOperationException("Для этого класса не поддерживаются операции изменения");
    }
}
