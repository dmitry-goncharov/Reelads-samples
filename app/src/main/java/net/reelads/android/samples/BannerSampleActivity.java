package net.reelads.android.samples;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import net.reelads.android.AdView;

public class BannerSampleActivity extends AppCompatActivity {
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        adView = findViewById(R.id.adview);
        adView.setUid(getString(R.string.reelads_banner_uid));
        adView.loadAd();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    @Override
    protected void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}