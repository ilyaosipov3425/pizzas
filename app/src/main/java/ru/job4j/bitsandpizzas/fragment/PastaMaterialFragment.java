package ru.job4j.bitsandpizzas.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.job4j.bitsandpizzas.CaptionedImagesAdapter;
import ru.job4j.bitsandpizzas.PastaDetailActivity;
import ru.job4j.bitsandpizzas.R;
import ru.job4j.bitsandpizzas.model.Pasta;

/**
 * Класс PastaMaterialFragment - фрагмент служит для отображения списка видов пасты в Material Design
 * @author Ilya Osipov (mailto:il.osipov.ya@yandex.ru)
 * @since 23.05.2019
 * @version $Id$
 */

public class PastaMaterialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView pastaRecycler = (RecyclerView)
                inflater.inflate(R.layout.fragment_pasta_material, container, false);

        String[] pastaNames = new String[Pasta.pastas.length];
        for (int i = 0; i < pastaNames.length; i++) {
            pastaNames[i] = Pasta.pastas[i].getName();
        }

        int[] pastaImages = new int[Pasta.pastas.length];
        for (int i = 0; i < pastaImages.length; i++) {
            pastaImages[i] = Pasta.pastas[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pastaNames, pastaImages);
        pastaRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        pastaRecycler.setLayoutManager(layoutManager);

        adapter.setListener(
                (position) -> {
                    Intent intent = new Intent(getActivity(), PastaDetailActivity.class);
                    intent.putExtra(PastaDetailActivity.EXTRA_PASTANO, position);
                    startActivity(intent);
                });
        return pastaRecycler;
    }
}
