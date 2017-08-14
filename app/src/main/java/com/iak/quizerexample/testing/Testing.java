package com.iak.quizerexample.testing;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by root on 12/08/17.
 */

public class Testing {

    public void test() {

        int total = 5;
        do {
            // happened once
            total = total - 1;

            // stop it if total = 3
            if (total == 3) {
                break;
            }
        } while (total > 0);

    }

}
