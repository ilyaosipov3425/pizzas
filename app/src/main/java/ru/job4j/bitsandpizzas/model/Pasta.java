package ru.job4j.bitsandpizzas.model;

import ru.job4j.bitsandpizzas.R;

/**
 * Класс Pasta - определяет массив, который содержит название и изображение
 * @author Ilya Osipov (mailto:il.osipov.ya@yandex.ru)
 * @since 23.05.2019
 * @version $Id$
 */

public class Pasta {
    private String name;
    private int imageResourceId;

    public static final Pasta[] pastas = {
            new Pasta("Spaghetti Bolognese", R.drawable.spaghetti_bolognese),
            new Pasta("Lasagne", R.drawable.lasagne)
    };

    private Pasta(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
