package ru.mpt.p50_4_19.flwa;

import android.view.View;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    /** для краткости */
    public <T extends View> T vid (@IdRes int id) {
        return findViewById(id);
    }
}
