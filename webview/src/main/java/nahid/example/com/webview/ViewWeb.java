package nahid.example.com.webview;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class ViewWeb extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(url!=null && url.startsWith("market://")){
            view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));

            return true;
        }
        else {
            return false;
        }
    }
}
