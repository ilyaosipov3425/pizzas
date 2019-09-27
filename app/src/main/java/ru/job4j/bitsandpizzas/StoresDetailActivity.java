package ru.job4j.bitsandpizzas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import java.util.Objects;

import ru.job4j.bitsandpizzas.model.Stores;

/**
 * Класс StoresDetailActivity - выводит адрес, номер телефона и изображение выбраные пользователем
 * @author Ilya Osipov (mailto:il.osipov.ya@yandex.ru)
 * @since 23.05.2019
 * @version $Id$
 */

public class StoresDetailActivity extends Activity {
    private ShareActionProvider shareActionProvider;
    public static final String EXTRA_STORESNO = "storesNo";
    private TextView addressText;
    private TextView phoneText;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores_detail);

        Objects.requireNonNull(getActionBar()).setDisplayHomeAsUpEnabled(true);

        int storesNo = (Integer)getIntent().getExtras().get(EXTRA_STORESNO);
        String storesAddress = Stores.stores[storesNo].getAddress();
        addressText = findViewById(R.id.stores_address);
        addressText.setText(storesAddress);

        String storesPhone = Stores.stores[storesNo].getPhone();
        phoneText = findViewById(R.id.stores_phone);
        phoneText.setText(storesPhone);

        int storesImage = Stores.stores[storesNo].getImageResourceId();
        imageView = findViewById(R.id.stores_image);
        imageView.setImageDrawable(getResources().getDrawable(storesImage));
        imageView.setContentDescription(storesAddress);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        addressText = findViewById(R.id.stores_address);
        CharSequence storesAddress = addressText.getText();
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        Intent intent = new Intent(this, OrderActivity.class);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, storesAddress);
        shareActionProvider.setShareIntent(intent);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_create_order) {
            Intent intent = new Intent(this, OrderActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
