
import javafx.scene.image.ImageView;

public class BanditRunnable implements Runnable {

    private int i; //Index of current picture
    private long sleepTime;
    private boolean running;
    private ImageView iw;

    public BanditRunnable(int i, long sleepTime, ImageView iw) {
        this.i = i;
        this.sleepTime = sleepTime;
        this.iw = iw;
    }

    @Override
    public void run() {
        try {
            while (running) {
                for (int j = 0; j < 10; j++) {
                    
                }
            }
        } catch (Exception e) {
        }
    }
}
