package store;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class Boots extends ParticularProduct {

    private int size;
    private CategoryBoots category;

    public Boots() {

        super();
    }

    public Boots(long particularProductId, int size, CategoryBoots category,
                 BigDecimal price, int percentageDiscount, String tradeMark, ArrayList<String> materials) {

        super(particularProductId, price, percentageDiscount, tradeMark, materials);
        this.size = size;
        this.category = category;
    }

    public int getSize() {

        return size;
    }

    public void setSize(int size) {

        this.size = size;
    }

    public CategoryBoots getCategory() {

        return category;
    }

    public void setCategory(CategoryBoots category) {

        this.category = category;
    }

    @Override
    public void output(OutputStream out) throws IOException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeUTF("Boots");
        objectOutputStream.writeLong(getParticularProductId());
        objectOutputStream.writeInt(getPercentageDiscount());
        objectOutputStream.writeObject(getPrice());
        objectOutputStream.writeObject(getTradeMark());
        objectOutputStream.writeObject(getMaterials());
        objectOutputStream.writeInt(size);
        objectOutputStream.writeObject(getCategory());
        objectOutputStream.close();
    }

    @Override
    public void write(Writer out) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(out);
        bufferedWriter.write("Boots");
        bufferedWriter.newLine();
        bufferedWriter.write((int) getParticularProductId());
        bufferedWriter.newLine();
        bufferedWriter.write(getPercentageDiscount());
        bufferedWriter.newLine();
        bufferedWriter.write(getPrice().toString());
        bufferedWriter.write(getTradeMark());
        bufferedWriter.write(getMaterials().toString());
        bufferedWriter.close();
        out.close();
    }

    @Override
    public String getDescription() {

        return "Boots{" +
                "size=" + size +
                ", categoryBoots=" + category +
                ", particularProductId=" + getParticularProductId() +
                ", percentageDiscount=" + getPercentageDiscount() +
                ", price=" + getPrice() +
                ", tradeMark='" + getTradeMark() + '\'' +
                ", materials=" + getMaterials() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boots)) return false;
        if (!super.equals(o)) return false;
        Boots boots = (Boots) o;
        return size == boots.size &&
                Objects.equals(category, boots.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), size, category);
    }

    @Override
    public String toString() {
        return "Boots{" +
                super.toString() +
                "size=" + size +
                ", category=" + category +
                '}';
    }
}
