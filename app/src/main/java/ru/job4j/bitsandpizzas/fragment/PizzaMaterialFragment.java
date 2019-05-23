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
import ru.job4j.bitsandpizzas.PizzaDetailActivity;
import ru.job4j.bitsandpizzas.R;
import ru.job4j.bitsandpizzas.model.Pizza;

/**
 * Класс PizzaMaterialFragment - фрагмент служит для отображения списка видов пиццы в Material Design
 * @author Ilya Osipov (mailto:il.osipov.ya@yandex.ru)
 * @since 23.05.2019
 * @version $Id$
 */

public class PizzaMaterialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView pizzaRecycler = (RecyclerView)
                inflater.inflate(R.layout.fragment_pizza_material, container, false);

        String[] pizzaNames = new String[Pizza.pizzas.length];
        for (int i = 0; i < pizzaNames.length; i++) {
            pizzaNames[i] = Pizza.pizzas[i].getName();
        }

        int[] pizzaImages = new int[Pizza.pizzas.length];
        for (int i = 0; i < pizzaImages.length; i++) {
            pizzaImages[i] = Pizza.pizzas[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pizzaNames, pizzaImages);
        pizzaRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        pizzaRecycler.setLayoutManager(layoutManager);

        adapter.setListener(
                (position) -> {
                    Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
                    intent.putExtra(PizzaDetailActivity.EXTRA_PIZZANO, position);
                    startActivity(intent);
                });
        return pizzaRecycler;
    }

}
