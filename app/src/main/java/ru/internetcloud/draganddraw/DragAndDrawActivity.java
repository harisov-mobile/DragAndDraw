package ru.internetcloud.draganddraw;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

// Пользовательские представления и события касания

public class DragAndDrawActivity extends TemplateFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return DragAndDrawFragment.newInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
