import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

public class TimerService {

    private Timer timer;

    public void startTimer(int seconds, Consumer<Integer> onTick, Runnable onFinish) {
        timer = new Timer();
        final int[] counter = {seconds};

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                counter[0]--;
                onTick.accept(counter[0]);

                if (counter[0] <= 0) {
                    cancel();
                    onFinish.run();
                }
            }
        }, 1000, 1000);
    }

    public void stop() {
        if (timer != null) timer.cancel();
    }
}
