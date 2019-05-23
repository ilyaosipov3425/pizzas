package ru.job4j.bitsandpizzas.fragment;

import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import ru.job4j.bitsandpizzas.R;

/**
 * Класс StoresFragment - фрагмент служит для отображения списка видов пасты
 * @author Ilya Osipov (mailto:il.osipov.ya@yandex.ru)
 * @since 09.05.2019
 * @version $Id$
 */

public class StoresFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.stores));
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
