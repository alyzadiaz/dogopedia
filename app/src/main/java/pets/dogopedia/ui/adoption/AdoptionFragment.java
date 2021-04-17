package pets.dogopedia.ui.adoption;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import pets.dogopedia.R;

public class AdoptionFragment extends Fragment {
    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){

        View root = inflater.inflate(R.layout.fragment_adoptions, container, false);

        WebView petFinder_web = root.findViewById(R.id.petFinder_webView);
        petFinder_web.getSettings().setJavaScriptEnabled(true);
        petFinder_web.setWebViewClient(new WebViewClient());
        petFinder_web.loadUrl("https://www.petfinder.com");

        WebView aspca_web = root.findViewById(R.id.aspca_webView);
        aspca_web.getSettings().setJavaScriptEnabled(true);
        aspca_web.setWebViewClient(new WebViewClient());
        aspca_web.loadUrl("https://aspca.org/adopt-pet");

        WebView adoptApet_web = root.findViewById(R.id.adoptApet_webView);
        adoptApet_web.getSettings().setJavaScriptEnabled(true);
        adoptApet_web.setWebViewClient(new WebViewClient());
        adoptApet_web.loadUrl("https://adoptapet.com");

        Button petFinderTab = root.findViewById(R.id.petFinder_button);
        petFinderTab.setOnClickListener(v -> {
            petFinder_web.setVisibility(View.VISIBLE);
            aspca_web.setVisibility(View.GONE);
            adoptApet_web.setVisibility(View.GONE);
        });

        Button aspcaTab = root.findViewById(R.id.aspca_button);
        aspcaTab.setOnClickListener(v -> {
            petFinder_web.setVisibility(View.GONE);
            aspca_web.setVisibility(View.VISIBLE);
            adoptApet_web.setVisibility(View.GONE);
        });

        Button adoptApetTab = root.findViewById(R.id.adoptApet_button);
        adoptApetTab.setOnClickListener(v -> {
            petFinder_web.setVisibility(View.GONE);
            aspca_web.setVisibility(View.GONE);
            adoptApet_web.setVisibility(View.VISIBLE);
        });

        return root;
    }
}
