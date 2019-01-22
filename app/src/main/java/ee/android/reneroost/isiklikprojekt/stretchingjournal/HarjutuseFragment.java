package ee.android.reneroost.isiklikprojekt.stretchingjournal;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class HarjutuseFragment extends Fragment {

    private Harjutus harjutus;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        harjutus = new Harjutus();
    }

}
