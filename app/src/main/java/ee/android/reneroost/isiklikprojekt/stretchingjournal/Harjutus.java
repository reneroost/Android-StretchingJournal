package ee.android.reneroost.isiklikprojekt.stretchingjournal;

public class Harjutus {

    private String nimi;
    private String kirjeldus;

    public static final Harjutus[] harjutused = {
            new Harjutus("Reie kakspealihase venitus",
                    "seistes sirgelt (põlvest sirgelt) kallutada ette"),
            new Harjutus("Tuharalihase venitus",
                    "istuda üks jalg sirgelt ja tõsta teine risti üle põlve"),
            new Harjutus("Triitsepsi venitus",
                    "seistes viia käelaba turjale ja sirutada küünarnukk üles"),
            new Harjutus("Liblikasendis venitus",
                    "viia maas istudes jalatallad vastamisi"),
            new Harjutus("Nimmelihase venitus",
                    "ühel põlvel olles viia teine jalg taha"),
            new Harjutus("Lamades reie nelipealihase venitus",
                    "maas sirgelt lamades kõverdada pealmist jalga"),
            new Harjutus("Külje painutus",
                    "seistes sirgelt (põlvest sirgelt) kallutada ette")
    };

    public Harjutus(String nimi, String kirjeldus) {
        this.nimi = nimi;
        this.kirjeldus = kirjeldus;
    }

    public Harjutus() {
        this.nimi = "Reie kakspealihase venitus";
        this.kirjeldus = "seistes sirgelt (põlvest sirgelt) kallutada ette";
    }

    public String saaNimi() {
        return nimi;
    }

    public String saaKirjeldus() {
        return kirjeldus;
    }

    public String toString() {
        return this.nimi;
    }
}
