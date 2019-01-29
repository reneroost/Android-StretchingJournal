package ee.android.reneroost.isiklikprojekt.stretchingjournal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HarjutuseKirjeldusActivity extends AppCompatActivity {

    public static final String EKSTRA_HARJUTUSE_ID = "harjutuseID";

    boolean kuvatakseTapneKirjeldus = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_harjutuse_kirjeldus);

        TextView kategooriaUldineAbitekst = (TextView) findViewById(R.id.kategooria_uldine_abitekst);
        TextView kategooriaSpetsiifilineAbitekst = (TextView) findViewById(R.id.kategooria_spetsiifiline_abitekst);
        TextView kirjeldusLuhikeAbitekst = (TextView) findViewById(R.id.kirjeldus_luhike_abitekst);

        TextView harjutuseEestikeelneNimi = (TextView) findViewById(R.id.harjutuse_eestikeelne_nimi);
        TextView kategooriaYldine = (TextView) findViewById(R.id.kategooria_uldine);
        TextView kategooriaSpetsiifiline = (TextView) findViewById(R.id.kategooria_spetsiifiline);
        TextView kirjeldusLuhike = (TextView) findViewById(R.id.kirjeldus_luhike);
        final TextView kirjeldusPikk = (TextView) findViewById(R.id.kirjeldus_pikk);
        kirjeldusPikk.setVisibility(View.GONE);

        ImageView pildiVaadeHarjutus = (ImageView) findViewById(R.id.foto);

        kategooriaUldineAbitekst.setText(getResources().getString(R.string.kirjelduse_liik_kategooria_uldine));
        kategooriaSpetsiifilineAbitekst.setText(getResources().getString(R.string.kirjelduse_liik_kategooria_spetsiifiline));
        kirjeldusLuhikeAbitekst.setText(getResources().getString(R.string.kirjelduse_liik_kirjeldus_lyhike));

        final Button nuppTapneKirjeldus = (Button) findViewById(R.id.nupp_naita_tapsemat_kirjeldust);
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

        int harjutuseId = (Integer) getIntent().getExtras().get(EKSTRA_HARJUTUSE_ID);

        SQLiteOpenHelper venitamisePaevikAndmebaasiAbistaja = new VenitamisePaevikAndmebaasiAbistaja(this);
        try {
            SQLiteDatabase andmebaas = venitamisePaevikAndmebaasiAbistaja.getReadableDatabase();

            Cursor kursor = andmebaas.query(getResources().getString(R.string.harjutuste_kirjeldused),
                    new String[]  {"HarjutuseIngliskeelneNimi", "HarjutuseEestikeelneNimi",
                    "KategooriaYldine", "KategooriaSpetsiifiline", "KirjeldusLuhike", "KirjeldusPikk", "PildiRessursiId"},
                    "_id = ?",
                    new String[] {Integer.toString(harjutuseId)},
                    null, null, null);

            if (kursor.moveToFirst()) {
                String harjutuseIngliskeelneNimiTekst = kursor.getString(0);
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
            Toast rost = Toast.makeText(this,
                    getResources().getString(R.string.andmebaas_pole_saadaval), Toast.LENGTH_SHORT);
            rost.show();
        }
    }



}
