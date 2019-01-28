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
        andmebaas.execSQL("CREATE TABLE HarjutusteKirjeldusedEestikeeles "
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

        andmebaas.execSQL("CREATE TABLE HarjutusteKirjeldusedIngliskeeles "
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

        sisestaVenitusHarjutusEestikeeles(andmebaas,
                "Standing Reach Down Hamstring Stretch",
                "Reie kakspealihase venitus",
                "jalad",
                "reie kakspealihas, alaselg",
                "seistes sirgelt (põlvest sirgelt) kallutada ette",
                "blablablaaa",
                1
        );
        sisestaVenitusHarjutusEestikeeles(andmebaas,
                "Sitting Knee-to-Chest Piriformis Stretch",
                "Tuharalihase venitus",
                "jalad",
                "tuharalihas",
                "istuda üks jalg sirgelt ja teine risti üle põlve",
                "blablablaaa",
                1
        );
        sisestaVenitusHarjutusEestikeeles(andmebaas,
                "Triceps Stretch",
                "Triitsepsi venitus",
                "käed",
                "triitseps",
                "seistes viia käelaba turjale ja sirutada küünarnukk üles",
                "blablablaaa",
                1
        );
        sisestaVenitusHarjutusEestikeeles(andmebaas,
                "Butterfly Stretch",
                "Liblikasendis venitus",
                "jalad",
                "reie sisemine külg (sirelihas ja pikk lähendajalihas)",
                "viia maas istudes jalatallad vastamisi",
                "blablablaaa",
                1
        );
        sisestaVenitusHarjutusEestikeeles(andmebaas,
                "Lunging Hip Flexor Stretch",
                "Nimmelihase venitus",
                "kere",
                "nimmelihas, rätsepalihas",
                "ühel põlvel olles viia teine jalg taha",
                "blablablaaa",
                1
        );
        sisestaVenitusHarjutusEestikeeles(andmebaas,
                "Lying Quad Stretch",
                "Lamades reie nelipealihase venitus",
                "jalad",
                "reie nelipealihas",
                "maas sirgelt lamades kõverdada pealmist jalga",
                "blablablaaa",
                1
        );
        sisestaVenitusHarjutusEestikeeles(andmebaas,
                "Side Bend Stretch",
                "Külje painutus",
                "kere",
                "selja lailihas, suur ümarlihas, eesmine saaglihas",
                "seistes sirgelt (põlvest sirgelt) kallutada ette",
                "blablablaa",
                1
        );


        sisestaVenitusHarjutusIngliskeeles(andmebaas,
                "Standing Reach Down Hamstring Stretch",
                "Standing Reach Down Hamstring Stretch",
                "Thighs",
                "Biceps Femoris, Semimembranosus",
                " Stand up tall and bend forwards from the hips, reaching for your toes with your hands\n",
                "blablablaaa",
                1
        );
        sisestaVenitusHarjutusIngliskeeles(andmebaas,
                "Sitting Knee-to-Chest Piriformis Stretch",
                "Sitting Knee-to-Chest Piriformis Stretch",
                "Hips",
                "Gluteus Maximus, Gluteus Medus",
                "Cross your leg over the other leg, and place its foot flat on the floor",
                "blablablaaa",
                1
        );
        sisestaVenitusHarjutusIngliskeeles(andmebaas,
                "Triceps Stretch",
                "Triceps Stretch",
                "Arms",
                "Triceps",
                "Raise your left elbow and reach toward your upper back",
                "blablablaaa",
                1
        );
        sisestaVenitusHarjutusIngliskeeles(andmebaas,
                "Butterfly Stretch",
                "Butterfly Stretch",
                "Thighs",
                "Adductors of hip joint",
                "Sitting with upright posture, bend your knees and put the pads of your feet againt one another",
                "blablablaaa",
                1
        );
        sisestaVenitusHarjutusIngliskeeles(andmebaas,
                "Lunging Hip Flexor Stretch",
                "Lunging Hip Flexor Stretch",
                "Hips",
                "Psoas muscle",
                "Squat down with chest high, straightening hip of rear leg by pushing hips down and forward",
                "blablablaaa",
                1
        );
        sisestaVenitusHarjutusIngliskeeles(andmebaas,
                "Lying Quad Stretch",
                "Lying Quad Stretch",
                "Thighs",
                "Quadriceps",
                "Lie on your side, pull your foot toward your butt and bend your knee to stabilize yourself",
                "blablablaaa",
                1
        );
        sisestaVenitusHarjutusIngliskeeles(andmebaas,
                "Side Bend Stretch",
                "Standing Side Bend Stretch",
                "Torso",
                "Quadratus Lumborum, Obliques",
                "Stand tall reaching both arms straight up and lower on side down",
                "blablablaa",
                1
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase andmebaas, int vanaVersioon, int uusVersioon) {

    }

    private static void sisestaVenitusHarjutusEestikeeles(SQLiteDatabase andmebaas,
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
        andmebaas.insert("HarjutusteKirjeldusedEestikeeles", null, venitusHarjutuseVaartused);
    }

    private static void sisestaVenitusHarjutusIngliskeeles(SQLiteDatabase andmebaas,
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
        andmebaas.insert("HarjutusteKirjeldusedIngliskeeles", null, venitusHarjutuseVaartused);
    }

}
