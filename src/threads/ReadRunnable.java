package threads;

public class ReadRunnable implements Runnable {

    private ProductSynchronizer productSynchronizer;

    public ReadRunnable(ProductSynchronizer productSynchronizer) {

        this.productSynchronizer = productSynchronizer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 6; i++) {
               productSynchronizer.read();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
