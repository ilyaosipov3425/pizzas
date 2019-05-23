package ru.job4j.bitsandpizzas;

/**
 * Класс Stores - определяет массив, который содержит название и изображение
 * @author Ilya Osipov (mailto:il.osipov.ya@yandex.ru)
 * @since 23.05.2019
 * @version $Id$
 */

public class Stores {
    private String address;
    private String phone;
    private int imageResourceId;

    public static final Stores[] stores = {
            new Stores("ADDRESS: 350, Hespeler Rd., Cambridge",
                    "PHONE: +1 519-622-2228", R.drawable.restaurant),
            new Stores("ADDRESS: 748, Gravenstein Hwy.N., Sebastopol",
                    "PHONE: +1 707-824-4712", R.drawable.restaurant)
    };

    private Stores(String address, String phone, int imageResourceId) {
        this.address = address;
        this.phone = phone;
        this.imageResourceId = imageResourceId;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
