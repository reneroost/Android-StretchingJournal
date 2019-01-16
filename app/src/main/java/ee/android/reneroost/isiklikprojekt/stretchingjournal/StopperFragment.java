package ee.android.reneroost.isiklikprojekt.stretchingjournal;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class StopperFragment extends Fragment implements View.OnClickListener {

    private int sekundid = 0;
    private boolean stopperKaib;
    private TextView ajaVaade;
    private Button alustaNupp;
    private Button peatuNupp;
    private Button nulliNupp;

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

        alustaNupp = (Button) vaade.findViewById(R.id.nupp_alusta);
        peatuNupp = (Button) vaade.findViewById(R.id.nupp_peatu);
        nulliNupp = (Button) vaade.findViewById(R.id.nupp_nulli);

        alustaNupp.setOnClickListener(this);
        peatuNupp.setOnClickListener(this);
        nulliNupp.setOnClickListener(this);

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
        }
    }

    private void kaitaStopperit() {
        final Handler kaitleja = new Handler();

        kaitleja.post(new Runnable() {

            @Override
            public void run() {
                int kuvatavadMinutid = sekundid / 60;
                int kuvatavadSekundid = sekundid % 60;

                String aeg = String.format(Locale.getDefault(), "%02d:%02d",
                        kuvatavadMinutid, kuvatavadSekundid);
                ajaVaade.setText(aeg);

                if (stopperKaib) {
                    sekundid++;
                }

                kaitleja.postDelayed(this, 1000);
            }
        });
    }
}
