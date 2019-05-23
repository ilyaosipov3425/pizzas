package ru.job4j.bitsandpizzas;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Класс TopFragment - фрагмент для вывода контента верхнего уровня
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

        String[] pizzaNames = new String[2];
        for (int i = 0; i < 2; i++) {
            pizzaNames[i] = Pizza.pizzas[i].getName();
        }

        int[] pizzaImages = new int[2];
        for (int i = 0; i < 2; i++) {
            pizzaImages[i] = Pizza.pizzas[i].getImageResourceId();
        }

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pizzaRecycler.setLayoutManager(layoutManager);
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pizzaNames, pizzaImages);
        pizzaRecycler.setAdapter(adapter);
        adapter.setListener(
                (position) -> {
                    Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
                    intent.putExtra(PizzaDetailActivity.EXTRA_PIZZANO, position);
                    getActivity().startActivity(intent);
                });
        return layout;
    }
}
