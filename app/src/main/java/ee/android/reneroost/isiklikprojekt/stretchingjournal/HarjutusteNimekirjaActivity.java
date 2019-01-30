package ee.android.reneroost.isiklikprojekt.stretchingjournal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class HarjutusteNimekirjaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harjutuste_nimekiri);

        FragmentManager fragmendiHaldur = getSupportFragmentManager();
        Fragment fragment = fragmendiHaldur.findFragmentById(R.id.fragmendi_konteiner_harjutuse_kirjeldus);

        if (fragment == null) {
            fragment = new HarjutusteNimekirjaFragment();
            fragmendiHaldur.beginTransaction()
                    .add(R.id.fragmendi_konteiner_harjutuse_kirjeldus, fragment)
                    .commit();
        }
    }
}