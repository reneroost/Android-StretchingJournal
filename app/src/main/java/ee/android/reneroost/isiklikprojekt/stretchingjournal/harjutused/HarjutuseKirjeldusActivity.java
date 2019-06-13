package ee.android.reneroost.isiklikprojekt.stretchingjournal.harjutused;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import ee.android.reneroost.isiklikprojekt.stretchingjournal.R;

public class HarjutuseKirjeldusActivity extends AppCompatActivity {

    public static final String EKSTRA_HARJUTUSE_ID =
            "ee.android.reneroost.isiklikprojekt.stretchingjournal.harjutuse_id";

    public static Intent uusKavatsus(Context pakiKontekst, String harjutuseID) {
        Intent kavatsus = new Intent(pakiKontekst, HarjutuseKirjeldusActivity.class);
        kavatsus.putExtra(EKSTRA_HARJUTUSE_ID, harjutuseID);
        return kavatsus;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raam_uldine);

        FragmentManager fragmendiHaldur = getSupportFragmentManager();
        Fragment fragment = fragmendiHaldur.findFragmentById(R.id.fragmendi_konteiner_uldine);

        if (fragment == null) {
            fragment = new HarjutuseKirjeldusUldineFragment();
            fragmendiHaldur.beginTransaction()
                    .add(R.id.fragmendi_konteiner_uldine, fragment)
                    .commit();
        }
    }


}
