package threads;

public class WriteRunnable implements Runnable {

    private ProductSynchronizer productSynchronizer;
    private String[] materials = {"leather", "cloth", "threads", "rubber"};

    public WriteRunnable(ProductSynchronizer productSynchronizer) {

        this.productSynchronizer = productSynchronizer;
    }

    @Override
    public void run() {

        try {
            int value;
            for (int i = 0; i < 6; i++) {
                value = (int) (Math.random() * (4));
                productSynchronizer.write(materials[value]);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
