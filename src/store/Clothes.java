package store;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class Clothes extends ParticularProduct {

    private String size;
    private CategoryClothes category;

    public Clothes() {

        super();
    }

    public Clothes(long particularProductId, String size, CategoryClothes category,
                   BigDecimal price, int percentageDiscount, String tradeMark, ArrayList<String> materials) {

        super(particularProductId, price, percentageDiscount, tradeMark, materials);
        this.size = size;
        this.category = category;
    }

    public String getSize() {

        return size;
    }

    public void setSize(String size) {

        this.size = size;
    }

    public CategoryClothes getCategory() {

        return category;
    }

    public void setCategory(CategoryClothes category) {

        this.category = category;
    }

    @Override
    public String getDescription() {

        return "Clothes{" +
                "clothesId=" + getParticularProductId() +
                ", size='" + size + '\'' +
                ", categoryClothes=" + category +
                ", percentageDiscount=" + getPercentageDiscount() +
                ", price=" + getPrice() +
                ", tradeMark='" + getTradeMark() + '\'' +
                ", materials=" + getMaterials() +
                '}';
    }

    @Override
    public void output(OutputStream out) throws IOException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeUTF("Clothes");
        objectOutputStream.writeLong(getParticularProductId());
        objectOutputStream.writeInt(getPercentageDiscount());
        objectOutputStream.writeObject(getPrice());
        objectOutputStream.writeObject(getTradeMark());
        objectOutputStream.writeObject(getMaterials());
        objectOutputStream.writeObject(size);
        objectOutputStream.writeObject(category);
        objectOutputStream.close();
    }

    @Override
    public void write(Writer out) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(out);
        bufferedWriter.write("Clothes");
        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(getParticularProductId()));
        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(getPercentageDiscount()));
        bufferedWriter.newLine();
        bufferedWriter.write(getPrice().toString());
        bufferedWriter.newLine();
        bufferedWriter.write(getTradeMark());
        bufferedWriter.newLine();
        bufferedWriter.write(size);
        bufferedWriter.newLine();
        bufferedWriter.write(getMaterials().toString());
        bufferedWriter.newLine();
        bufferedWriter.write(category.toString());
        bufferedWriter.close();
        out.close();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clothes)) return false;
        if (!super.equals(o)) return false;
        Clothes clothes = (Clothes) o;
        return Objects.equals(size, clothes.size) &&
                Objects.equals(category, clothes.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), size, category);
    }

    @Override
    public String toString() {
        return "Clothes{" +
                super.toString() +
                "size='" + size + '\'' +
                ", category=" + category +
                '}';
    }
}
