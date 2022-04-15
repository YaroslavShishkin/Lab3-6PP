package main;

import sc.StaticClass;
import store.CategoryClothes;
import store.Clothes;
import store.Product;
import threads.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Main implements Serializable{

    public static void main(String[] args) {


        testSerializeProduct();
        testWriteProduct();
        //testThread();
        testProductSynchronizer();

    }

    public static void testSerializeProduct() {

        try {
            StaticClass.serializeProduct(createProduct(), new ObjectOutputStream
                    (new FileOutputStream("src/files/serialize.txt")));
            Clothes cl = (Clothes) StaticClass.deserializeProduct
                    (new ObjectInputStream(new FileInputStream("src/files/serialize.txt")));
            System.out.println(cl.toString());
        } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
        }
    }

    public static void testWriteProduct() {

        Clothes cl;

        try {
            StaticClass.outputProduct(createProduct(), new ObjectOutputStream
                (new FileOutputStream("src/files/byte.txt")));
            if (StaticClass.inputProduct
                    (new ObjectInputStream(new FileInputStream("src/files/byte.txt"))).isPresent()) {
                cl = (Clothes) StaticClass.inputProduct
                        (new ObjectInputStream(new FileInputStream("src/files/byte.txt"))).get();
                System.out.println(cl);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            StaticClass.writeProduct(createProduct(), new FileWriter("src/files/text.txt"));
            if (StaticClass.readProduct(new FileReader("src/files/text.txt")).isPresent()) {
                cl = (Clothes) (StaticClass.readProduct(new FileReader("src/files/text.txt")).get());
                System.out.println(cl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Product createProduct() {

        ArrayList<String> list = new ArrayList<>();
        list.add("cloth");
        list.add("threads");
        CategoryClothes category = new CategoryClothes(1, "shirts");

        return new Clothes(1, "M", category, new BigDecimal(1500),
                30, "MQ", list);
    }

    public static void testThread() {

        Product product = new Clothes();
        WriteThread writeThread = new WriteThread(product);
        writeThread.start();
        ReadThread readThread = new ReadThread(product);
        readThread.start();
    }

    public static void testProductSynchronizer() {

        Product product = new Clothes();
        ProductSynchronizer productSynchronizer = new ProductSynchronizer(product);
        WriteRunnable writeRunnable = new WriteRunnable(productSynchronizer);
        ReadRunnable readRunnable = new ReadRunnable(productSynchronizer);
        new Thread(writeRunnable).start();
        new Thread(readRunnable).start();
    }

    public static void testIterator() {

    }
}
