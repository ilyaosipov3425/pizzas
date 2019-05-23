package ru.job4j.bitsandpizzas;

/**
 * Класс Pizza - определяет массив, который содержит название и изображение
 * @author Ilya Osipov (mailto:i.osipov.ya@yandex.ru)
 * @since 23.05.2019
 * @version $Id$
 */

public class Pizza {
    private String name;
    private int imageResourceId;

    public static final Pizza[] pizzas = {
            new Pizza("Diavolo", R.drawable.diavolo),
            new Pizza("Funghi", R.drawable.funghi)
    };

    private Pizza(String name, int imageResourceId) {
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
