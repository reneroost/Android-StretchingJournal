package ee.android.reneroost.isiklikprojekt.stretchingjournal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class VenitamisePaevikAndmebaasiAbistaja extends SQLiteOpenHelper {

    private static final String ANDMEBAASI_NIMI = "venitamisepaevik";
    private static final int ANDMEBAASI_VERSIOON = 1;

    VenitamisePaevikAndmebaasiAbistaja(Context kontekst) {
        super(kontekst, ANDMEBAASI_NIMI, null, ANDMEBAASI_VERSIOON);
    }

    @Override
    public void onCreate(SQLiteDatabase andmebaas) {
        andmebaas.execSQL("CREATE TABLE HarjutusteKirjeldused "
                + "("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "HarjutuseIngliskeelneNimi TEXT, "
                + "HarjutuseEestikeelneNimi TEXT, "
                + "KategooriaYldine TEXT, "
                + "KategooriaSpetsiifiline TEXT, "
                + "KirjeldusLuhike TEXT, "
                + "KirjeldusPikk TEXT, "
                + "PildiRessursiId INTEGER"
                + ");"
        );

        sisestaVenitusHarjutus(andmebaas,
                "Standing Reach Down Hamstring Stretch",
                "Reie kakspealihase venitus",
                "jalad",
                "reie kakspealihas, alaselg",
                "seistes sirgelt (põlvest sirgelt) kallutada ette",
                "blablablaaa",
                1
        );
        sisestaVenitusHarjutus(andmebaas,
                "Sitting Knee-to-Chest Piriformis Stretch",
                "Tuharalihase venitus",
                "jalad",
                "tuharalihas",
                "istuda üks jalg sirgelt ja teine risti üle põlve",
                "blablablaaa",
                1
        );
        sisestaVenitusHarjutus(andmebaas,
                "Triceps Stretch",
                "Triitsepsi venitus",
                "käed",
                "triitseps",
                "seistes viia käelaba turjale ja sirutada küünarnukk üles",
                "blablablaaa",
                1
        );
        sisestaVenitusHarjutus(andmebaas,
                "Butterfly Stretch",
                "Liblikasendis venitus",
                "jalad",
                "reie sisemine külg (sirelihas ja pikk lähendajalihas)",
                "viia maas istudes jalatallad vastamisi",
                "blablablaaa",
                1
        );
        sisestaVenitusHarjutus(andmebaas,
                "Lunging Hip Flexor Stretch",
                "Nimmelihase venitus",
                "kere",
                "nimmelihas, rätsepalihas",
                "ühel põlvel olles viia teine jalg taha",
                "blablablaaa",
                1
        );
        sisestaVenitusHarjutus(andmebaas,
                "Lying Quad Stretch",
                "Lamades reie nelipealihase venitus",
                "jalad",
                "reie nelipealihas",
                "maas sirgelt lamades kõverdada pealmist jalga",
                "blablablaaa",
                1
        );
        sisestaVenitusHarjutus(andmebaas,
                "Side Bend Stretch",
                "Külje painutus",
                "kere",
                "selja lailihas, suur ümarlihas, eesmine saaglihas",
                "seistes sirgelt (põlvest sirgelt) kallutada ette",
                "blablablaa",
                1
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase andmebaas, int vanaVersioon, int uusVersioon) {

    }

    private static void sisestaVenitusHarjutus(SQLiteDatabase andmebaas,
                                               String harjutuseIngliskeelneNimi,
                                               String harjutuseEestikeelneNimi,
                                               String kategooriaYldine,
                                               String kategooriaSpetsiifiline,
                                               String kirjeldusLuhike,
                                               String kirjeldusPikk,
                                               int pildiRessursiId) {
        ContentValues venitusHarjutuseVaartused = new ContentValues();
        venitusHarjutuseVaartused.put("HarjutuseIngliskeelneNimi", harjutuseIngliskeelneNimi);
        venitusHarjutuseVaartused.put("HarjutuseEestikeelneNimi", harjutuseEestikeelneNimi);
        venitusHarjutuseVaartused.put("KategooriaYldine", kategooriaYldine);
        venitusHarjutuseVaartused.put("KategooriaSpetsiifiline", kategooriaSpetsiifiline);
        venitusHarjutuseVaartused.put("KirjeldusLuhike", kirjeldusLuhike);
        venitusHarjutuseVaartused.put("KirjeldusPikk", kirjeldusPikk);
        venitusHarjutuseVaartused.put("PildiRessursiId", pildiRessursiId);
        andmebaas.insert("HarjutusteKirjeldused", null, venitusHarjutuseVaartused);
    }

}
