package net.reelads.android.samples;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bannerSampleButton = findViewById(R.id.banner_sample_button);
        bannerSampleButton.setOnClickListener(v -> startActivity(new Intent(this, BannerSampleActivity.class)));

        Button mediatorSampleButton = findViewById(R.id.mediator_sample_button);
        mediatorSampleButton.setOnClickListener(v -> startActivity(new Intent(this, MediatorSampleActivity.class)));
    }
}
