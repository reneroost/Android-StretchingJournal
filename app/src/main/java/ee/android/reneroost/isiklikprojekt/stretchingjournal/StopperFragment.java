package ee.android.reneroost.isiklikprojekt.stretchingjournal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StopperFragment extends Fragment {

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }

    @Override
    public View onCreateView(@NonNull LayoutInflater taispuhuja, ViewGroup konteiner,
                             Bundle savedInstanceState) {
        return taispuhuja.inflate(R.layout.fragment_stopper, konteiner, false);
    }

}
