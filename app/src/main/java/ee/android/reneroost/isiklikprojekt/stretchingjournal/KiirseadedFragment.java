package ee.android.reneroost.isiklikprojekt.stretchingjournal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

public class KiirseadedFragment extends Fragment {

    private final int[] kestused = {30, 60 , 90};
    private int valitudKestus;

    @Override
    public View onCreateView(@NonNull LayoutInflater taispuhuja, ViewGroup konteiner,
                             Bundle savedInstanceState) {
        View vaade = taispuhuja.inflate(R.layout.fragment_kiirseaded, konteiner, false);

        TextView raadionuppKestusLuhike = vaade.findViewById(R.id.raadionupp_kestvus_luhike);
        TextView raadionuppKestusKeskmine = vaade.findViewById(R.id.raadionupp_kestvus_keskmine);
        TextView raadionuppKestusPikk = vaade.findViewById(R.id.raadionupp_kestvus_pikk);

        String kestus;
        kestus = Integer.toString(kestused[0]) + getResources().getString(R.string.sekundid);
        raadionuppKestusLuhike.setText(kestus);
        kestus = Integer.toString(kestused[1]) + getResources().getString(R.string.sekundid);
        raadionuppKestusKeskmine.setText(kestus);
        kestus = Integer.toString(kestused[2]) + getResources().getString(R.string.sekundid);
        raadionuppKestusPikk.setText(kestus);

        final RadioGroup raadioGruppKestused = vaade.findViewById(R.id.raadiogrupp_kestused);
        raadioGruppKestused.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.raadionupp_kestvus_luhike:
                        valitudKestus = 0;
                        break;
                    case R.id.raadionupp_kestvus_keskmine:
                        valitudKestus = 1;
                        break;
                    case R.id.raadionupp_kestvus_pikk:
                        valitudKestus = 2;
                        break;
                }
            }
        });

        return vaade;
    }

}
