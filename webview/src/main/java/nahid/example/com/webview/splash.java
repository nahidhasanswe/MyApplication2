package nahid.example.com.webview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class splash extends AppCompatActivity {

    protected static final int RUN_TIMER = 6000;
    protected boolean mbaction;
    private ProgressBar progressBar;
    private int waited;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        progressBar = (ProgressBar) findViewById(R.id.progressbar);

         ProgressBar();
         SplashScreen();
    }

    private void SplashScreen() {
        Thread thread = new Thread() {
            @Override
            public void run() {

                try {
                    sleep(8000);
                    Intent start = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(start);
                    finish();
                } catch (InterruptedException e) {

                }
            }
        };
        thread.start();
    }

    private void ProgressBar() {

        Thread timerThread = new Thread() {
            @Override
            public void run() {
                mbaction = true;
                try {
                    waited = 0;
                    while (mbaction && (waited < RUN_TIMER)) {
                        sleep(200);
                        if (mbaction) {
                            waited += 200;
                            updateProgress(waited);
                        }
                    }
                } catch (InterruptedException e) {

                }
            }
        };
        timerThread.start();
    }

    private void show() {

        Thread thread = new Thread() {
            @Override
            public void run() {

                try {
                    sleep(6000);
                } catch (InterruptedException e) {

                }
            }
        };
        thread.start();

    }

    private void updateProgress(final int timePassed) {
        if (progressBar != null) {
            final int progress = progressBar.getMax() * timePassed / RUN_TIMER;

            progressBar.setProgress(progress);
        }
    }

}
