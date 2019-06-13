package ee.android.reneroost.isiklikprojekt.stretchingjournal.avaleht;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Objects;

import ee.android.reneroost.isiklikprojekt.stretchingjournal.andmebaas.VenitamisePaevikAndmebaasiAbistaja;
import ee.android.reneroost.isiklikprojekt.stretchingjournal.harjutused.HarjutusteNimekirjaActivity;
import ee.android.reneroost.isiklikprojekt.stretchingjournal.R;

public class AvalehtFragment extends Fragment implements View.OnClickListener {

    private int sekundid;
    private boolean stopperKaib;
    private TextView ajaVaade;

    private final int[] kestused = {30, 60, 90};
    private int valitudKestus = kestused[0];



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        kaitaStopperit();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater taispuhuja, ViewGroup konteiner,
                             Bundle savedInstanceState) {
        View vaade = taispuhuja.inflate(R.layout.fragment_avaleht, konteiner, false);

        ajaVaade = vaade.findViewById(R.id.tekstivaade_aeg);
        sekundid = valitudKestus;
        kuvaStopperiNait(sekundid);

        Button alustaNupp = vaade.findViewById(R.id.nupp_alusta);
        Button peatuNupp = vaade.findViewById(R.id.nupp_peatu);
        Button nulliNupp = vaade.findViewById(R.id.nupp_nulli);

        alustaNupp.setOnClickListener(this);
        peatuNupp.setOnClickListener(this);
        nulliNupp.setOnClickListener(this);

        TextView raadionuppKestusLuhike = vaade.findViewById(R.id.raadionupp_kestvus_luhike);
        TextView raadionuppKestusKeskmine = vaade.findViewById(R.id.raadionupp_kestvus_keskmine);
        TextView raadionuppKestusPikk = vaade.findViewById(R.id.raadionupp_kestvus_pikk);

        String kestus;
        kestus = kestused[0] + getResources().getString(R.string.sekundid);
        raadionuppKestusLuhike.setText(kestus);
        kestus = kestused[1] + getResources().getString(R.string.sekundid);
        raadionuppKestusKeskmine.setText(kestus);
        kestus = kestused[2] + getResources().getString(R.string.sekundid);
        raadionuppKestusPikk.setText(kestus);

        final RadioGroup raadioGruppKestused = vaade.findViewById(R.id.raadiogrupp_kestused);
        raadioGruppKestused.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.raadionupp_kestvus_luhike:
                        valitudKestus = kestused[0];
                        break;
                    case R.id.raadionupp_kestvus_keskmine:
                        valitudKestus = kestused[1];
                        break;
                    case R.id.raadionupp_kestvus_pikk:
                        valitudKestus = kestused[2];
                        break;
                }
                stopperKaib = false;
                sekundid = valitudKestus;
                kuvaStopperiNait(valitudKestus);
            }
        });

        Button nuppValiHarjutus = vaade.findViewById(R.id.nupp_vali_harjutus);
        nuppValiHarjutus.setOnClickListener(this);


        // harjutuse saamine andmebaasist
        TextView harjutuseNimi = vaade.findViewById(R.id.valitud_harjutus);
        SQLiteOpenHelper venitamisePaevikAndmebaasiAbistaja = new VenitamisePaevikAndmebaasiAbistaja(getActivity());
        try {
            SQLiteDatabase andmebaas = venitamisePaevikAndmebaasiAbistaja.getReadableDatabase();

            Cursor kursor = andmebaas.query(getResources().getString(R.string.harjutuste_kirjeldused),
                    new String[]  {"HarjutuseIngliskeelneNimi", "HarjutuseEestikeelneNimi",
                            "KategooriaYldine", "KategooriaSpetsiifiline", "KirjeldusLuhike", "KirjeldusPikk", "PildiRessursiId"},
                    "_id = ?",
                    new String[] {Integer.toString(1)},
                    null, null, null);

            if (kursor.moveToFirst()) {
                String harjutuseNimiTekst = kursor.getString(1);

                harjutuseNimi.setText(harjutuseNimiTekst);
            }
            kursor.close();
            andmebaas.close();
        } catch (SQLiteException e) {
            Toast rost = Toast.makeText(getActivity(),
                    getResources().getString(R.string.andmebaas_pole_saadaval), Toast.LENGTH_SHORT);
            rost.show();
        }

        return vaade;
    }

    @Override
    public void onClick(View vaade) {
        switch (vaade.getId()) {
            case R.id.nupp_alusta:
                stopperKaib = true;
                break;
            case R.id.nupp_peatu:
                stopperKaib = false;
                break;
            case R.id.nupp_nulli:
                stopperKaib = false;
                sekundid = 0;
                break;
            case R.id.nupp_vali_harjutus:
                Intent minuKavatsus = new Intent(getActivity(), HarjutusteNimekirjaActivity.class);
                Objects.requireNonNull(getActivity()).startActivity(minuKavatsus);
                break;
        }
    }

    private void kaitaStopperit() {
        final Handler kaitleja = new Handler();

        kaitleja.post(new Runnable() {

            @Override
            public void run() {
                kuvaStopperiNait(sekundid);

                if (stopperKaib && sekundid > 0) {
                    sekundid--;
                } else if (stopperKaib) {
                    stopperKaib = false;
                }

                kaitleja.postDelayed(this, 1000);
            }
        });
    }

    private void kuvaStopperiNait(int sekundid) {
        int kuvatavadMinutid = sekundid / 60;
        int kuvatavadSekundid = sekundid % 60;

        String aeg = String.format(Locale.getDefault(), "%02d:%02d",
                kuvatavadMinutid, kuvatavadSekundid);
        ajaVaade.setText(aeg);
    }
}
