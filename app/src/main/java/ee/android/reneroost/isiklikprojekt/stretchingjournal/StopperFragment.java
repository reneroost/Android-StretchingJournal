package ee.android.reneroost.isiklikprojekt.stretchingjournal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Locale;

public class StopperFragment extends Fragment implements View.OnClickListener {

    private int sekundid;
    private boolean stopperKaib;
    private TextView ajaVaade;

    private final int[] kestused = {3, 6, 9};
    private int valitudKestus = kestused[0];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        kaitaStopperit();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater taispuhuja, ViewGroup konteiner,
                             Bundle savedInstanceState) {
        View vaade = taispuhuja.inflate(R.layout.fragment_stopper, konteiner, false);

        ajaVaade = vaade.findViewById(R.id.tekstivaade_aeg);
        sekundid = valitudKestus;
        kuvaStopperiNait(sekundid);

        Button alustaNupp = vaade.findViewById(R.id.nupp_alusta);
        Button peatuNupp = vaade.findViewById(R.id.nupp_peatu);
        Button nulliNupp = vaade.findViewById(R.id.nupp_nulli);

        alustaNupp.setOnClickListener(this);
        peatuNupp.setOnClickListener(this);
        nulliNupp.setOnClickListener(this);

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
                        valitudKestus = kestused[0];
                        break;
                    case R.id.raadionupp_kestvus_keskmine:
                        valitudKestus = kestused[1];
                        break;
                    case R.id.raadionupp_kestvus_pikk:
                        valitudKestus = kestused[2];
                        break;
                }
                stopperKaib = false;
                sekundid = valitudKestus;
                kuvaStopperiNait(valitudKestus);
            }
        });

        Button nuppValiHarjutus = vaade.findViewById(R.id.nupp_vali_harjutus);
        nuppValiHarjutus.setOnClickListener(this);

        return vaade;
    }

    @Override
    public void onClick(View vaade) {
        switch (vaade.getId()) {
            case R.id.nupp_alusta:
                stopperKaib = true;
                break;
            case R.id.nupp_peatu:
                stopperKaib = false;
                break;
            case R.id.nupp_nulli:
                stopperKaib = false;
                sekundid = 0;
                break;
            case R.id.nupp_vali_harjutus:
                Intent minuKavatsus = new Intent(getActivity(), HarjutusteNimekirjaActivity.class);
                getActivity().startActivity(minuKavatsus);
                break;
        }
    }

    private void kaitaStopperit() {
        final Handler kaitleja = new Handler();

        kaitleja.post(new Runnable() {

            @Override
            public void run() {
                kuvaStopperiNait(sekundid);

                if (stopperKaib && sekundid > 0) {
                    sekundid--;
                } else if (stopperKaib && sekundid <= 0) {
                    stopperKaib = false;
                }

                kaitleja.postDelayed(this, 1000);
            }
        });
    }

    private void kuvaStopperiNait(int sekundid) {
        int kuvatavadMinutid = sekundid / 60;
        int kuvatavadSekundid = sekundid % 60;

        String aeg = String.format(Locale.getDefault(), "%02d:%02d",
                kuvatavadMinutid, kuvatavadSekundid);
        ajaVaade.setText(aeg);
    }
}
