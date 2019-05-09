package es.adrianmmudarra.gestionaverias.ui.breakdownslist;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.adrianmmudarra.gestionaverias.R;

public class BreakdownActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    BreakdownListFragment breakdownListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakdown);
        fragmentManager = getSupportFragmentManager();
        breakdownListFragment = (BreakdownListFragment) fragmentManager.findFragmentByTag(BreakdownListFragment.FRAGMENT_ID);
        if (breakdownListFragment == null){
            breakdownListFragment = new BreakdownListFragment();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.breakdownActivity,breakdownListFragment,BreakdownListFragment.FRAGMENT_ID);
            transaction.commit();
        }
    }
}
