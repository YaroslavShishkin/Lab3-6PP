package threads;

import store.Product;

public class WriteThread extends Thread {

    private Product product;
    private String[] materials = {"leather", "cloth", "threads", "rubber"};

    public WriteThread(Product product) {

        this.product = product;
    }

    @Override
    public void run() {

        if (product != null) {
            for (int i = 0; i < 6 ; i++) {
                int index = (int) (Math.random() * 4);
                product.getMaterials().add(materials[index]);
                System.out.println("Write: " + materials[index] +
                                   " to position" + product.getMaterials().indexOf(materials[index]));
            }
        }
    }
}
