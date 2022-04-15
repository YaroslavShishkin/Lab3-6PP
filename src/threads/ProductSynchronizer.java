package threads;

import store.Product;

public class ProductSynchronizer {

    private Product product;
    private boolean flag;

    public ProductSynchronizer(Product product) {

        this.product = product;
        this.flag = false;
    }

    public synchronized void write(String material) throws InterruptedException {

        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product.getMaterials().add(material);
        flag = true;
        System.out.println("Write " + material + " to position " + (product.getMaterials().size() - 1));

        notify();
    }

    public synchronized void read() throws InterruptedException {

        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
        flag = false;
        System.out.println("Read " + product.getMaterials().get(product.getMaterials().size() - 1) +
                " to position " + (product.getMaterials().size() - 1));

        notify();
    }
}
