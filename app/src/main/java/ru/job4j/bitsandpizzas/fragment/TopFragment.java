package ru.job4j.bitsandpizzas.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import ru.job4j.bitsandpizzas.CaptionedImagesAdapter;
import ru.job4j.bitsandpizzas.PastaDetailActivity;
import ru.job4j.bitsandpizzas.PizzaDetailActivity;
import ru.job4j.bitsandpizzas.R;
import ru.job4j.bitsandpizzas.model.Pasta;
import ru.job4j.bitsandpizzas.model.Pizza;

/**
 * Класс TopFragment - фрагмент для отображения контента верхнего уровня
 * @author Ilya Osipov (mailto:il.osipov.ya@yandex.ru)
 * @since 09.05.2019
 * @version $Id$
 */

public class TopFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RelativeLayout layout = (RelativeLayout)
                inflater.inflate(R.layout.fragment_top, container, false);
        RecyclerView pizzaRecycler = layout.findViewById(R.id.pizza_recycler);
        RecyclerView pastaRecycler = layout.findViewById(R.id.pasta_recycler);

        String[] pizzaNames = new String[2];
        for (int i = 0; i < 2; i++) {
            pizzaNames[i] = Pizza.pizzas[i].getName();
        }

        int[] pizzaImages = new int[2];
        for (int i = 0; i < 2; i++) {
            pizzaImages[i] = Pizza.pizzas[i].getImageResourceId();
        }

        String[] pastaNames = new String[2];
        for (int i = 0; i < 2; i++) {
            pastaNames[i] = Pasta.pastas[i].getName();
        }

        int[] pastaImages = new int[2];
        for (int i = 0; i < 2; i++) {
            pastaImages[i] = Pasta.pastas[i].getImageResourceId();
        }

        GridLayoutManager layoutManagerPizza = new GridLayoutManager(getActivity(), 2);
        pizzaRecycler.setLayoutManager(layoutManagerPizza);
        CaptionedImagesAdapter adapterPizza = new CaptionedImagesAdapter(pizzaNames, pizzaImages);
        pizzaRecycler.setAdapter(adapterPizza);
        adapterPizza.setListener(
                (position) -> {
                    Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
                    intent.putExtra(PizzaDetailActivity.EXTRA_PIZZANO, position);
                    getActivity().startActivity(intent);
                });

        GridLayoutManager layoutManagerPasta = new GridLayoutManager(getActivity(), 2);
        pastaRecycler.setLayoutManager(layoutManagerPasta);
        CaptionedImagesAdapter adapterPasta = new CaptionedImagesAdapter(pastaNames, pastaImages);
        pastaRecycler.setAdapter(adapterPasta);
        adapterPasta.setListener(
                (position) -> {
                    Intent intent = new Intent(getActivity(), PastaDetailActivity.class);
                    intent.putExtra(PastaDetailActivity.EXTRA_PASTANO, position);
                    getActivity().startActivity(intent);
                });
        return layout;
    }
}
