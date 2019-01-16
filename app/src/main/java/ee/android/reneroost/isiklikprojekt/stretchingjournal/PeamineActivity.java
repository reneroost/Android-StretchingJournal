package ee.android.reneroost.isiklikprojekt.stretchingjournal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PeamineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peamine);

        FragmentManager fragmendiHaldur = getSupportFragmentManager();
        Fragment fragment = fragmendiHaldur.findFragmentById(R.id.fragmendi_konteiner);

        if (fragment == null) {
            fragment = new StopperFragment();
            fragmendiHaldur.beginTransaction()
                    .add(R.id.fragmendi_konteiner, fragment)
                    .commit();
        }

    }
}
