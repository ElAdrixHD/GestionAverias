package es.adrianmmudarra.gestionaverias.ui.breakdownslist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.adrianmmudarra.gestionaverias.R;

public class BreakdownListFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener {
    public static String FRAGMENT_ID = "breakdown_list";
    RecyclerView recyclerView;
    FloatingActionButton btn_add;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_breakdown_list,container,false);
        if (v !=null){
            initialize(v);
        }
        return v;
    }

    private void initialize(View v) {
        recyclerView = v.findViewById(R.id.breakdownRecyclerList);
        btn_add = v.findViewById(R.id.fab_breakdown_list);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
