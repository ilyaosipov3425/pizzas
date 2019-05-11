package ru.job4j.bitsandpizzas;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

/**
 * Класс OrderActivity - activity для создания заказа
 * @author Ilya Osipov (mailto:il.osipov.ya@yandex.ru)
 * @since 09.05.2019
 * @version $Id$
 */

public class OrderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
