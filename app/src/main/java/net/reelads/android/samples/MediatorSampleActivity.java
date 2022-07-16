package net.reelads.android.samples;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import net.reelads.android.AdView;
import net.reelads.android.Mediator;

public class MediatorSampleActivity extends AppCompatActivity {
    private LinearLayout adContainer;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediator);

        adContainer = findViewById(R.id.adContainer);
    }

    @Override
    protected void onResume() {
        super.onResume();
        createOrResumeAdView();
    }

    @Override
    protected void onPause() {
        pauseReelAdView();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        destroyAllAdViews();
        super.onDestroy();
    }

    private void createOrResumeAdView() {
        final Mediator mediator = new Mediator(this);
        mediator.setUid(getString(R.string.reelads_mediator_uid));
        mediator.load(new Mediator.OnReceiveListener() {
            @Override
            public void onReceived(String provider, String extra) {
                if (provider == null || extra == null) {
                    destroyAllAdViews();
                    return;
                }
                if (getString(R.string.reelads_sample_provider).equals(provider)) {
                    if (adView != null) {
                        adView.resume();
                    } else {
                        createReelAdView(extra);
                    }
                } else {
                    destroyAllAdViews();
                }
            }

            @Override
            public void onError(Mediator.Error error) {
                destroyAllAdViews();
            }
        });
    }

    private void destroyAllAdViews() {
        destroyReelAdView();
    }

    private void createReelAdView(String adUnitId) {
        adView = new AdView(this);
        adView.setUid(adUnitId);
        adContainer.removeAllViewsInLayout();
        adContainer.addView(adView);
        adView.loadAd();
    }

    private void pauseReelAdView() {
        if (adView != null) {
            adView.pause();
        }
    }

    private void destroyReelAdView() {
        if (adView != null) {
            adView.destroy();
            adView = null;
            adContainer.removeAllViewsInLayout();
        }
    }
}