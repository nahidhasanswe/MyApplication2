package nahid.example.com.webview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends ActionBarActivity {


    private WebView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isOnline();

        String url="http://www.liberationwars.org";
        view =(WebView)findViewById(R.id.webview);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);
        view.setEnabled(true);
        view.setWebViewClient(new ViewWeb());
    }

    @Override
    public void onBackPressed() {
        if(view.canGoBack())
            view.goBack();
        else{
            new AlertDialog.Builder(this).setIcon(R.drawable.exit).setTitle("Exit")
                    .setMessage("Are you sure?")
                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                           finish();
                        }
                    }).setNegativeButton("NO", null).show();
        }


    }


    public void isOnline(){
        ConnectivityManager conMgr=(ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=conMgr.getActiveNetworkInfo();

        if(networkInfo!=null && networkInfo.isConnected()){

        }else{
            showAlert();
        }

    }

    private void showAlert(){
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Warning!")
                .setMessage("No Internet Connection.Please TURN ON your WIFI or Data connection, Then Try")
                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }
                })
                .show();
    }
}
