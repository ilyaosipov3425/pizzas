package ru.job4j.bitsandpizzas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import ru.job4j.bitsandpizzas.model.Pasta;

/**
 * Класс PastaDetailActivity - выводит название пасты, выбранной пользователем, вместе с ее изображением
 * @author Ilya Osipov (mailto:il.osipov.ya@yandex.ru)
 * @since 23.05.2019
 * @version $Id$
 */

public class PastaDetailActivity extends Activity {
    private ShareActionProvider shareActionProvider;
    public static final String EXTRA_PASTANO = "pastaNo";
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta_detail);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        int pastaNo = (Integer)getIntent().getExtras().get(EXTRA_PASTANO);
        String pastaName = Pasta.pastas[pastaNo].getName();
        textView = findViewById(R.id.pasta_text);
        textView.setText(pastaName);

        int pastaImage = Pasta.pastas[pastaNo].getImageResourceId();
        imageView = findViewById(R.id.pasta_image);
        imageView.setImageDrawable(getResources().getDrawable(pastaImage));
        imageView.setContentDescription(pastaName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        textView = findViewById(R.id.pasta_text);
        CharSequence pastaName = textView.getText();
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        Intent intent = new Intent(this, OrderActivity.class);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, pastaName);
        shareActionProvider.setShareIntent(intent);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_order:
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
