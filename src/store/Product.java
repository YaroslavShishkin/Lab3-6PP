package store;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.List;

public interface Product extends Serializable {

    List<String> getMaterials();
    BigDecimal calculateCost();
    void sortingMaterials();
    String getDescription();

    void output(OutputStream out) throws IOException;
    void write(Writer out) throws IOException;
}
