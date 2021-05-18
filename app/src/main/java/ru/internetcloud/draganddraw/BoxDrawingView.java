package ru.internetcloud.draganddraw;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class BoxDrawingView extends View {

    // Конструтор № 1, используется при создании представления в коде
    public BoxDrawingView(Context context) {
        this(context, null); // вызов другого конструктора
    }

    // Конструктор № 2, используется при заполнении представления по разметке XML
    public BoxDrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}
