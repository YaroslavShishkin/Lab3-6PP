package patterns;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MaterialsIterator implements Iterator<String> {

    private List<String> materials;
    private int index;

    public MaterialsIterator(List<String> materials) {

        this.materials = materials;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {

        return index < materials.size();
    }

    @Override
    public String next() {

        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String result = materials.get(index);
        index++;
        return result;
    }
}
