package ru.internetcloud.draganddraw;

import android.app.Application;

public class App extends Application {

    // этот класс живет всегда, когда живет приложение.
    // этот класс стартует до всех наших активити.

    // мы отнаследовались от стандартного класса Application, чтобы наш класс запускался, а не стандартный,
    // надо в манифесте указать

    // android:name=".App"


    @Override
    public void onCreate() {
        super.onCreate();

        // здесь можно проинициализировать Retrofit и всякие штуки, которые должны принадлежать всему приложению, вне зависимости от Активностей.

    }
}
