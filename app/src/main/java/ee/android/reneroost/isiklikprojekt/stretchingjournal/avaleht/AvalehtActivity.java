package ee.android.reneroost.isiklikprojekt.stretchingjournal.avaleht;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ee.android.reneroost.isiklikprojekt.stretchingjournal.R;
import ee.android.reneroost.isiklikprojekt.stretchingjournal.avaleht.AvalehtFragment;

public class AvalehtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raam_uldine);

        FragmentManager fragmendiHaldur = getSupportFragmentManager();
        Fragment fragment = fragmendiHaldur.findFragmentById(R.id.fragmendi_konteiner_uldine);

        if (fragment == null) {
            fragment = new AvalehtFragment();
            fragmendiHaldur.beginTransaction()
                    .add(R.id.fragmendi_konteiner_uldine, fragment)
                    .commit();
        }
    }
}
