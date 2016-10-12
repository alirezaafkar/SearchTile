package com.alirezaafkar.searchtile;

import android.content.Intent;
import android.service.quicksettings.TileService;

/**
 * Created by Alireza Afkar on 12/10/2016AD.
 */

public class TileSearchService extends TileService {
    @Override
    public void onClick() {
        if (isLocked()) {
            unlockAndRun();
        } else {
            launch();
        }
    }

    private void unlockAndRun() {
        unlockAndRun(new Runnable() {
            @Override
            public void run() {
                launch();
            }
        });
    }

    private void launch() {
        Intent intent = new Intent(Intent.ACTION_SEARCH_LONG_PRESS);
        startActivityAndCollapse(intent);
    }
}
