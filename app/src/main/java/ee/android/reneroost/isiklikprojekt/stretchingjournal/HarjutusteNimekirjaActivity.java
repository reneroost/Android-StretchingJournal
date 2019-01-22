package ee.android.reneroost.isiklikprojekt.stretchingjournal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HarjutusteNimekirjaActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harjutuste_nimekiri);
        ArrayAdapter<Harjutus> nimekirjaAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Harjutus.harjutused
        );
        ListView nimekirjaHarjused = (ListView) findViewById(R.id.nimekiri_harujutus);
        nimekirjaHarjused.setAdapter(nimekirjaAdapter);
    }

}
