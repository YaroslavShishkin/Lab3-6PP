package threads;

import store.Product;

public class ReadThread extends Thread{

    private Product product;

    public ReadThread(Product product) {

        this.product = product;
    }

    @Override
    public void run() {
        if (product != null) {
            for (int i = 0; i < product.getMaterials().size(); i++) {
                System.out.println("Read: " + product.getMaterials().get(i) + " to position" + i);
            }
        }
    }
}
