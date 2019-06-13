package ee.android.reneroost.isiklikprojekt.stretchingjournal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class HarjutusteNimekirjaFragment extends Fragment {


    private SQLiteDatabase andmebaas;
    private Cursor kursor;

    @Override
    public View onCreateView(@NonNull LayoutInflater taispuhuja, ViewGroup konteiner, Bundle savedInstanceState) {

        View vaade = taispuhuja.inflate(R.layout.fragment_harjutuste_nimekiri, konteiner, false);

        ListView nimekiriHarjused = vaade.findViewById(R.id.nimekiri_harujutused);

        SQLiteOpenHelper venitamisepaevikAndmebaasiAbistaja = new VenitamisePaevikAndmebaasiAbistaja(getActivity());
        try {
            andmebaas = venitamisepaevikAndmebaasiAbistaja.getReadableDatabase();

            kursor = andmebaas.query(getResources().getString(R.string.harjutuste_kirjeldused),
                    new String[] {"_id", "HarjutuseEestikeelneNimi"},
                    null, null, null, null, null);

            SimpleCursorAdapter nimekiriAdapter = new SimpleCursorAdapter(getActivity(),
                    android.R.layout.simple_list_item_1,
                    kursor,
                    new String[] {"HarjutuseEestikeelneNimi"},
                    new int[] {android.R.id.text1},
                    0);

            nimekiriHarjused.setAdapter(nimekiriAdapter);


        } catch(SQLiteException e) {
            Toast rost = Toast.makeText(getActivity(), getResources().getString(R.string.andmebaas_pole_saadaval),
                    Toast.LENGTH_SHORT);
            rost.show();
        }

        AdapterView.OnItemClickListener uksuseKlikiKuular = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> nimekirjaHarjutused, View uksuseVaade, int positsioon, long id) {
                Intent kavatsus = HarjutuseKirjeldusActivity.uusKavatsus(getActivity(), Integer.toString(++positsioon));
                startActivity(kavatsus);
            }
        };
        nimekiriHarjused.setOnItemClickListener(uksuseKlikiKuular);

        return vaade;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        kursor.close();
        andmebaas.close();
    }

}
