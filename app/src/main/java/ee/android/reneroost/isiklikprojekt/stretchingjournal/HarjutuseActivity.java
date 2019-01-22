package ee.android.reneroost.isiklikprojekt.stretchingjournal;

import android.support.v4.app.Fragment;

public class HarjutuseActivity extends UheFragmendiActivity {
    @Override
    protected Fragment looFragment() {
        return new HarjutuseFragment();
    }
}
