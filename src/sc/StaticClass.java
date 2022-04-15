package sc;

import store.*;
import threads.SynhronizedProduct;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

public class StaticClass {

    public static void outputProduct(Product o, OutputStream out) throws IOException {

        o.output(out);
    }

    public static Optional<Product> inputProduct(InputStream in) throws IOException, ClassNotFoundException {

        ObjectInputStream objectInputStream = new ObjectInputStream(in);

        long particularProductId;
        int percentageDiscount;
        BigDecimal price;
        String tradeMark;
        ArrayList<String> materials;

        String nameClass = objectInputStream.readUTF();

        Product result = null;

        if (nameClass.equals("Clothes")) {

            String sizeClothes;
            CategoryClothes categoryClothes;

            particularProductId = objectInputStream.readLong();
            percentageDiscount = objectInputStream.readInt();
            price = (BigDecimal) objectInputStream.readObject();
            tradeMark = (String) objectInputStream.readObject();
            materials = (ArrayList<String>) objectInputStream.readObject();
            sizeClothes = (String) objectInputStream.readObject();
            categoryClothes = (CategoryClothes) objectInputStream.readObject();
            result = new Clothes(particularProductId, sizeClothes, categoryClothes,  price,
                    percentageDiscount, tradeMark, materials);
        }
        if (nameClass.equals("Boots")) {

            int sizeBoots;
            CategoryBoots categoryBoots;

            particularProductId = objectInputStream.readLong();
            percentageDiscount = objectInputStream.readInt();
            price = (BigDecimal) objectInputStream.readObject();
            tradeMark = (String) objectInputStream.readObject();
            materials = (ArrayList<String>) objectInputStream.readObject();
            sizeBoots = objectInputStream.readInt();
            categoryBoots = (CategoryBoots) objectInputStream.readObject();
            result = new Boots(particularProductId, sizeBoots, categoryBoots, price,
                    percentageDiscount, tradeMark, materials);
        }
        objectInputStream.close();
        in.close();
        return Optional.ofNullable(result);
    }

    public static void writeProduct(Product product, Writer writer) throws IOException {

        product.write(writer);
    }

    public static Optional<Product> readProduct(Reader reader) throws IOException {

        long particularProductId;
        int percentageDiscount;
        BigDecimal price;
        String tradeMark;
        ArrayList<String> materials = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();

        Product result = null;

        if (line.equals("Clothes")) {

            particularProductId = Long.parseLong(bufferedReader.readLine());
            percentageDiscount = Integer.parseInt(bufferedReader.readLine());
            price = new BigDecimal(bufferedReader.readLine());
            tradeMark = bufferedReader.readLine();
            String sizeClothes = bufferedReader.readLine();

            StringBuilder sb = new StringBuilder();
            readMaterials(bufferedReader.readLine(), sb, materials);

            CategoryClothes categoryClothes = new CategoryClothes();
            readCategoryName(bufferedReader.readLine(), sb, categoryClothes);

            bufferedReader.close();
            result = new Clothes(particularProductId, sizeClothes, categoryClothes,
                    price, percentageDiscount, tradeMark, materials);
        }
        if (line.equals("Boots")) {

            particularProductId = Long.parseLong(bufferedReader.readLine());
            percentageDiscount = Integer.parseInt(bufferedReader.readLine());
            price = new BigDecimal(bufferedReader.readLine());
            tradeMark = bufferedReader.readLine();
            int sizeBoots = Integer.parseInt(bufferedReader.readLine());

            StringBuilder sb = new StringBuilder();
            readMaterials(bufferedReader.readLine(), sb, materials);

            CategoryBoots categoryBoots = new CategoryBoots();
            readCategoryName(bufferedReader.readLine(), sb, categoryBoots);

            bufferedReader.close();

            result = new Boots(particularProductId, sizeBoots, categoryBoots,
                    price, percentageDiscount, tradeMark, materials);
        }
        return Optional.ofNullable(result);
    }

    private static void readMaterials(String line, StringBuilder sb, ArrayList<String> materials) {

        for (int i = 0; i < line.toCharArray().length; i++) {
            if (line.toCharArray()[i] != '[' && line.toCharArray()[i] != ' ') {
                sb.setLength(0);
                while (line.toCharArray()[i] != ',' && line.toCharArray()[i] != ']') {
                    sb.append(line.toCharArray()[i]);
                    i++;
                }
                materials.add(sb.toString());
            }
        }
    }

    private static void readCategoryName(String line, StringBuilder sb, Category category) {

        sb.setLength(0);

        for (char i : line.toCharArray()) {
            if (Character.isDigit(i)) {
                sb.append(i);
            }
        }

        if (category.getClass().equals(CategoryClothes.class)) {
            ((CategoryClothes) category).setCategoryId(Long.parseLong(sb.toString()));
        } else if (category.getClass().equals(CategoryBoots.class)) {
            ((CategoryBoots) category).setCategoryId(Long.parseLong(sb.toString()));
        }

        sb.setLength(0);
        for (int i = 0; i < line.toCharArray().length; i++) {
            if (line.toCharArray()[i] == '\'') {
                i++;
                while (line.toCharArray()[i] != '\'' && i < line.toCharArray().length) {
                    sb.append(line.toCharArray()[i]);
                    i++;
                }
            }
        }
        category.setCategoryName(sb.toString());
    }

    public static void serializeProduct(Product product, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(product);
        objectOutputStream.close();
    }

    public static Product deserializeProduct(ObjectInputStream objectInputStream)
            throws IOException, ClassNotFoundException {
        return (Product) objectInputStream.readObject();
    }

    public static Product synhronized(Product product) {

        return new SynhronizedProduct(product);
    }
}
