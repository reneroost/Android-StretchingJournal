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
                "Seisa sirgelt ning kalluta ette, üritades ulatuda kätega oma varvasteni. Ürita hoida jalgu põlvest sirgetena. Kui sa ei ulatu kätega varvasteni, siis aseta need oma jalgadele nii kaugele kui ulatud.",
                R.drawable.standing_reach_down_hamstring_stretch
        );
        sisestaVenitusHarjutusEestikeeles(andmebaas,
                "Sitting Knee-to-Chest Piriformis Stretch",
                "Tuharalihase venitus",
                "jalad",
                "tuharalihas",
                "istuda üks jalg sirgelt ja teine risti üle põlve",
                "Istu maas jalad ette välja sirutatult. Kõverda üht põlve ning tõsta see üle teise asetades talla vastu maad. Haara vastaskäega ümber oma põlve.",
                R.drawable.sitting_knee_to_chest_piriformis_stretch
        );
        sisestaVenitusHarjutusEestikeeles(andmebaas,
                "Triceps Stretch",
                "Triitsepsi venitus",
                "käed",
                "triitseps",
                "seistes viia käelaba turjale ja sirutada küünarnukk üles",
                "Seisa sirgelt õlgadelaiuse harkseisuga põlvi mitte lukustades. Suuna oma vasak küünarnukk lae poole ning puuduta oma ülaselga käega.",
                R.drawable.triceps_stretch
        );
        sisestaVenitusHarjutusEestikeeles(andmebaas,
                "Butterfly Stretch",
                "Liblikasendis venitus",
                "jalad",
                "reie sisemine külg (sirelihas ja pikk lähendajalihas)",
                "viia maas istudes jalatallad vastamisi",
                "Istu maas jalad ette välja sirutatult. Too oma jalatallad maas kokku. Too oma kannad kehale nii lähedale, kui võimalik. Kalluta ette.",
                R.drawable.butterfly_stretch
        );
        sisestaVenitusHarjutusEestikeeles(andmebaas,
                "Lunging Hip Flexor Stretch",
                "Nimmelihase venitus",
                "kere",
                "nimmelihas, rätsepalihas",
                "ühel põlvel olles viia teine jalg taha",
                "Alusta matil põlvitades. Tõsta vasak põlv üles ning astu selle jalaga edasi, nii et vasak jalg on ees nii kaugel kui võimalik. Liiguta oma keharaskus ettepoole hoides selg sirge.",
                R.drawable.lunging_hip_flexor_stretch
        );
        sisestaVenitusHarjutusEestikeeles(andmebaas,
                "Lying Quad Stretch",
                "Lamades reie nelipealihase venitus",
                "jalad",
                "reie nelipealihas",
                "maas sirgelt lamades kõverdada pealmist jalga",
                "Lama põrandal parema külje peal. Toeta parema käega oma pead, või siruta parem käsi lihtsalt ette tasakaalu hoidmiseks. Haara oma vasakust jalalabast vasaku käega. Tõmba vasakut jalalaba hoides parem jalg sirgena.",
                R.drawable.lying_quad_stretch
        );
        sisestaVenitusHarjutusEestikeeles(andmebaas,
                "Side Bend Stretch",
                "Külje painutus",
                "kere",
                "selja lailihas, suur ümarlihas, eesmine saaglihas",
                "seistes sirgelt (põlvest sirgelt) kallutada ette",
                "Seisa sirgelt vasak käsi sirgelt üles sirutatud. Kalluta kogu kerega paremale sirutades vasakut kätt üle pea. ",
                R.drawable.side_bend_stretch
        );


        sisestaVenitusHarjutusIngliskeeles(andmebaas,
                "Standing Reach Down Hamstring Stretch",
                "Standing Reach Down Hamstring Stretch",
                "Thighs",
                "Biceps Femoris, Semimembranosus",
                " Stand up tall and bend forwards from the hips, reaching for your toes with your hands\n",
                "Stand up tall and bend forwards from the hips, reaching for your toes with your hands. Aim to keep your legs straight a. If you cannot reach your feet with your hands, rest them as far down your legs as you can reach for the duration of the stretch.",
                R.drawable.standing_reach_down_hamstring_stretch
        );
        sisestaVenitusHarjutusIngliskeeles(andmebaas,
                "Sitting Knee-to-Chest Piriformis Stretch",
                "Sitting Knee-to-Chest Piriformis Stretch",
                "Hips",
                "Gluteus Maximus, Gluteus Medus",
                "Cross your leg over the other leg, and place its foot flat on the floor",
                "Sit upright with both legs extended in front of you. Bend one knee and cross that lower extremity over the other, placing the foot on the floor next to, and on the inside edge of, the knee that’s outstretched. Wrap your opposite arm around the bent knee.",
                R.drawable.sitting_knee_to_chest_piriformis_stretch
        );
        sisestaVenitusHarjutusIngliskeeles(andmebaas,
                "Triceps Stretch",
                "Triceps Stretch",
                "Arms",
                "Triceps",
                "Raise your left elbow and reach toward your upper back",
                "Stand straight with your feet shoulder width apart and knees slightly bent. Point your left elbow toward the ceiling and touch the center of your upper back with your hand.",
                R.drawable.triceps_stretch
        );
        sisestaVenitusHarjutusIngliskeeles(andmebaas,
                "Butterfly Stretch",
                "Butterfly Stretch",
                "Thighs",
                "Adductors of hip joint",
                "Sitting with upright posture, bend your knees and put the pads of your feet againt one another",
                "Sit on the floor with both legs straight out in front of you. Bring the soles of your feet together. Bring your heels as close to your body as you can. Lean forward.",
                R.drawable.butterfly_stretch
        );
        sisestaVenitusHarjutusIngliskeeles(andmebaas,
                "Lunging Hip Flexor Stretch",
                "Lunging Hip Flexor Stretch",
                "Hips",
                "Psoas muscle",
                "Squat down with chest high, straightening hip of rear leg by pushing hips down and forward",
                "Start by kneeling on the floor with a soft cushion under your knees. Lift your left knee up and step forward with that leg so that your left foot is as far out in front of you as your flexibility will allow. Shift your body weight forward over this leg while maintaining your right knee on the cushion and keeping your back straight.",
                R.drawable.lunging_hip_flexor_stretch
        );
        sisestaVenitusHarjutusIngliskeeles(andmebaas,
                "Lying Quad Stretch",
                "Lying Quad Stretch",
                "Thighs",
                "Quadriceps",
                "Lie on your side, pull your foot toward your butt and bend your knee to stabilize yourself",
                "Lie on the ground and turn over on your right side. Place your right hand on your head for support or simply extend it out for balance. Grab your left foot with your left hand. Keep the right leg extended straight out. Pull on the left foot, feeling the stretch in the quadricep muscle.",
                R.drawable.lying_quad_stretch
        );
        sisestaVenitusHarjutusIngliskeeles(andmebaas,
                "Side Bend Stretch",
                "Standing Side Bend Stretch",
                "Torso",
                "Quadratus Lumborum, Obliques",
                "Stand tall reaching both arms straight up and lower on side down",
                "Stand tall with feet and legs together and reach both arms straight up overhead as you inhale. Lower your right arm down the right side of your body and exhale as you lengthen the left arm over the head, bending body gently to the right.",
                R.drawable.side_bend_stretch
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
