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
import ru.job4j.bitsandpizzas.R;
import ru.job4j.bitsandpizzas.StoresDetailActivity;
import ru.job4j.bitsandpizzas.model.Stores;

/**
 * Класс StoresMaterialsFragment - фрагмент служит для отображения списка магазинов в Material Design
 * @author Ilya Osipov (mailto:il.osipov.ya@yandex.ru)
 * @since 23.05.2019
 * @version $Id$
 */

public class StoresMaterialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView storesRecycler = (RecyclerView)
                inflater.inflate(R.layout.fragment_stores_material, container, false);

        String[] storesAddress = new String[Stores.stores.length];
        for (int i = 0; i < storesAddress.length; i++) {
            storesAddress[i] = Stores.stores[i].getAddress();
        }

        String[] storesPhone = new String[Stores.stores.length];
        for (int i = 0; i < storesPhone.length; i++) {
            storesPhone[i] = Stores.stores[i].getPhone();
        }

        int[] storesImage = new int[Stores.stores.length];
        for (int i = 0; i < storesImage.length; i++) {
            storesImage[i] = Stores.stores[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(storesAddress, storesImage);
        storesRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        storesRecycler.setLayoutManager(layoutManager);

        adapter.setListener(
                (position) -> {
                    Intent intent = new Intent(getActivity(), StoresDetailActivity.class);
                    intent.putExtra(StoresDetailActivity.EXTRA_STORESNO, position);
                    startActivity(intent);
                });
        return storesRecycler;
    }
}
