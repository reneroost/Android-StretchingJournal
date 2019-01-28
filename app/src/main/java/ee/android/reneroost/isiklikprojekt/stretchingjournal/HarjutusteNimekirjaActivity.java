package ee.android.reneroost.isiklikprojekt.stretchingjournal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class HarjutusteNimekirjaActivity extends AppCompatActivity {

    private SQLiteDatabase andmebaas;
    private Cursor kursor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harjutuste_nimekiri);

        ListView nimekiriHarjused = (ListView) findViewById(R.id.nimekiri_harujutused);

        SQLiteOpenHelper venitamisepaevikAndmebaasiAbistaja = new VenitamisePaevikAndmebaasiAbistaja(this);
        try {
            andmebaas = venitamisepaevikAndmebaasiAbistaja.getReadableDatabase();

            kursor = andmebaas.query(getResources().getString(R.string.harjutuste_kirjeldused),
                    new String[] {"_id", "HarjutuseEestikeelneNimi"},
                    null, null, null, null, null);

            SimpleCursorAdapter nimekiriAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    kursor,
                    new String[] {"HarjutuseEestikeelneNimi"},
                    new int[] {android.R.id.text1},
                    0);

            nimekiriHarjused.setAdapter(nimekiriAdapter);


            Log.w("HarjutusteNimekirjaAct", "onCreate() try bloki lõpus");
        } catch(SQLiteException e) {
            Toast rost = Toast.makeText(this, getResources().getString(R.string.andmebaas_pole_saadaval),
                    Toast.LENGTH_SHORT);
            rost.show();
        }

        AdapterView.OnItemClickListener uksuseKlikiKuular = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> nimekirjaHarjutused, View uksuseVaade, int positsioon, long id) {
                Intent kavatsus = new Intent(HarjutusteNimekirjaActivity.this,
                        HarjutuseKirjeldusActivity.class);
                kavatsus.putExtra(HarjutuseKirjeldusActivity.EKSTRA_HARJUTUSE_ID, (int) id);
                startActivity(kavatsus);
            }
        };
        nimekiriHarjused.setOnItemClickListener(uksuseKlikiKuular);

        Log.w("HarjutusteNimekirjaAct", "onCreate() lõpus");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        kursor.close();
        andmebaas.close();
    }
}