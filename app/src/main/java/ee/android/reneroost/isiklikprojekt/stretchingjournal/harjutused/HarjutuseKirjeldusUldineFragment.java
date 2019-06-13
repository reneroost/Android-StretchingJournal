package ee.android.reneroost.isiklikprojekt.stretchingjournal.harjutused;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import ee.android.reneroost.isiklikprojekt.stretchingjournal.R;
import ee.android.reneroost.isiklikprojekt.stretchingjournal.andmebaas.VenitamisePaevikAndmebaasiAbistaja;

public class HarjutuseKirjeldusUldineFragment extends Fragment {


    //public static final String EKSTRA_HARJUTUSE_ID = "harjutuseID";

    private boolean kuvatakseTapneKirjeldus = false;

    @Override
    public View onCreateView(@NonNull LayoutInflater taispuhuja, ViewGroup konteiner,
                                Bundle savedInstanceState) {

        View vaade = taispuhuja.inflate(R.layout.fragment_harjutuse_kirjeldus_uldine, konteiner, false);

        TextView kategooriaUldineAbitekst = vaade.findViewById(R.id.kategooria_uldine_abitekst);
        TextView kategooriaSpetsiifilineAbitekst = vaade.findViewById(R.id.kategooria_spetsiifiline_abitekst);
        TextView kirjeldusLuhikeAbitekst = vaade.findViewById(R.id.kirjeldus_luhike_abitekst);

        TextView harjutuseEestikeelneNimi = vaade.findViewById(R.id.harjutuse_eestikeelne_nimi);
        TextView kategooriaYldine = vaade.findViewById(R.id.kategooria_uldine);
        TextView kategooriaSpetsiifiline = vaade.findViewById(R.id.kategooria_spetsiifiline);
        TextView kirjeldusLuhike = vaade.findViewById(R.id.kirjeldus_luhike);
        final TextView kirjeldusPikk = vaade.findViewById(R.id.kirjeldus_pikk);
        kirjeldusPikk.setVisibility(View.GONE);

        ImageView pildiVaadeHarjutus = vaade.findViewById(R.id.foto);

        kategooriaUldineAbitekst.setText(getResources().getString(R.string.kirjelduse_liik_kategooria_uldine));
        kategooriaSpetsiifilineAbitekst.setText(getResources().getString(R.string.kirjelduse_liik_kategooria_spetsiifiline));
        kirjeldusLuhikeAbitekst.setText(getResources().getString(R.string.kirjelduse_liik_kirjeldus_lyhike));

        final Button nuppTapneKirjeldus = vaade.findViewById(R.id.nupp_naita_tapsemat_kirjeldust);
        nuppTapneKirjeldus.setText(getResources().getString(R.string.nupp_tapsem_kirjeldus_naita));
        nuppTapneKirjeldus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kuvatakseTapneKirjeldus) {
                    nuppTapneKirjeldus.setText(getResources().getString(R.string.nupp_tapsem_kirjeldus_naita));
                    kirjeldusPikk.setVisibility(View.GONE);
                } else {
                    nuppTapneKirjeldus.setText(getResources().getString(R.string.nupp_tapsem_kirjeldus_peida));
                    kirjeldusPikk.setVisibility(View.VISIBLE);
                }
                kuvatakseTapneKirjeldus = !kuvatakseTapneKirjeldus;
            }
        });

        String harjutuseId = (Objects.requireNonNull(getActivity())).getIntent().getStringExtra(HarjutuseKirjeldusActivity.EKSTRA_HARJUTUSE_ID);

        SQLiteOpenHelper venitamisePaevikAndmebaasiAbistaja = new VenitamisePaevikAndmebaasiAbistaja(getActivity());
        try {
            SQLiteDatabase andmebaas = venitamisePaevikAndmebaasiAbistaja.getReadableDatabase();

            Cursor kursor = andmebaas.query(getResources().getString(R.string.harjutuste_kirjeldused),
                    new String[]  {"HarjutuseIngliskeelneNimi", "HarjutuseEestikeelneNimi",
                            "KategooriaYldine", "KategooriaSpetsiifiline", "KirjeldusLuhike", "KirjeldusPikk", "PildiRessursiId"},
                    "_id = ?",
                    new String[] {harjutuseId},
                    null, null, null);

            if (kursor.moveToFirst()) {
                //String harjutuseIngliskeelneNimiTekst = kursor.getString(0);
                String harjutuseEestikeelneNimiTekst = kursor.getString(1);
                String kategooriaYldineTekst = kursor.getString(2);
                String kategooriaSpetsiifilineTekst = kursor.getString(3);
                String kirjeldusLuhikeTekst = kursor.getString(4);
                String kirjeldusPikkTekst = kursor.getString(5);
                int harjutusePilt = kursor.getInt(6);

                harjutuseEestikeelneNimi.setText(harjutuseEestikeelneNimiTekst);
                kategooriaYldine.setText(kategooriaYldineTekst);
                kategooriaSpetsiifiline.setText(kategooriaSpetsiifilineTekst);
                kirjeldusLuhike.setText(kirjeldusLuhikeTekst);
                kirjeldusPikk.setText(kirjeldusPikkTekst);
                pildiVaadeHarjutus.setImageResource(harjutusePilt);
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

}
