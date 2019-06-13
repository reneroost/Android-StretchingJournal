package ee.android.reneroost.isiklikprojekt.stretchingjournal.harjutused;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import ee.android.reneroost.isiklikprojekt.stretchingjournal.R;

public class HarjutusteNimekirjaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raam_uldine);

        FragmentManager fragmendiHaldur = getSupportFragmentManager();
        Fragment fragment = fragmendiHaldur.findFragmentById(R.id.fragmendi_konteiner_uldine);

        if (fragment == null) {
            fragment = new HarjutusteNimekirjaFragment();
            fragmendiHaldur.beginTransaction()
                    .add(R.id.fragmendi_konteiner_uldine, fragment)
                    .commit();
        }
    }
}