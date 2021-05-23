package br.com.aravisa20.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.aravisa20.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MinhasRequisicoes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MinhasRequisicoes extends Fragment {


    String dados[]
            = { "Rua com um grande buraco", "Falta de Iluminação",
            "Vandalismo no Muro da Escola", "Recorrência de acidentes de transito",
            "Muitos roubos no local a noite"};
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MinhasRequisicoes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MinhasRequisicoes.
     */
    // TODO: Rename and change types and number of parameters
    public static MinhasRequisicoes newInstance(String param1, String param2) {
        MinhasRequisicoes fragment = new MinhasRequisicoes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ListView listview = findViewById()

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_minhas_requisicoes, container, false);
        // Inflate the layout for this fragment
        ListView listView = (ListView) view.findViewById(R.id.lvminhasrequisicoes);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                dados
        );
        listView.setAdapter(listViewAdapter);
        return view;
    }
}