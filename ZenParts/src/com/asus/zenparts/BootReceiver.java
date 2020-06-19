/*
 * Copyright (C) 2018 The Asus-SDM660 Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.asus.zenparts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import android.provider.Settings;
import com.asus.zenparts.preferences.VibratorStrengthPreference;

import com.asus.zenparts.kcal.Utils;
import com.asus.zenparts.ambient.SensorsDozeService;

public class BootReceiver extends BroadcastReceiver implements Utils {

    public void onReceive(Context context, Intent intent) {

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);

        FileUtils.setValue(DeviceSettings.BACKLIGHT_DIMMER_PATH, Settings.Secure.getInt(context.getContentResolver(),
                DeviceSettings.PREF_BACKLIGHT_DIMMER, 0));

        if (Settings.Secure.getInt(context.getContentResolver(), PREF_ENABLED, 0) == 1) {
            FileUtils.setValue(KCAL_ENABLE, Settings.Secure.getInt(context.getContentResolver(),
                    PREF_ENABLED, 0));

            String rgbValue = Settings.Secure.getInt(context.getContentResolver(),
                    PREF_RED, RED_DEFAULT) + " " +
                    Settings.Secure.getInt(context.getContentResolver(), PREF_GREEN,
                            GREEN_DEFAULT) + " " +
                    Settings.Secure.getInt(context.getContentResolver(), PREF_BLUE,
                            BLUE_DEFAULT);

            FileUtils.setValue(KCAL_RGB, rgbValue);
            FileUtils.setValue(KCAL_MIN, Settings.Secure.getInt(context.getContentResolver(),
                    PREF_MINIMUM, MINIMUM_DEFAULT));
            FileUtils.setValue(KCAL_SAT, Settings.Secure.getInt(context.getContentResolver(),
                    PREF_GRAYSCALE, 0) == 1 ? 128 :
                    Settings.Secure.getInt(context.getContentResolver(),
                            PREF_SATURATION, SATURATION_DEFAULT) + SATURATION_OFFSET);
            FileUtils.setValue(KCAL_VAL, Settings.Secure.getInt(context.getContentResolver(),
                    PREF_VALUE, VALUE_DEFAULT) + VALUE_OFFSET);
            FileUtils.setValue(KCAL_CONT, Settings.Secure.getInt(context.getContentResolver(),
                    PREF_CONTRAST, CONTRAST_DEFAULT) + CONTRAST_OFFSET);
            FileUtils.setValue(KCAL_HUE, Settings.Secure.getInt(context.getContentResolver(),
                    PREF_HUE, HUE_DEFAULT));
        VibratorStrengthPreference.restore(context);
        }

        FileUtils.setValue(DeviceSettings.TORCH_1_BRIGHTNESS_PATH,
                Settings.Secure.getInt(context.getContentResolver(),
                        DeviceSettings.PREF_TORCH_BRIGHTNESS, 100));
        FileUtils.setValue(DeviceSettings.TORCH_2_BRIGHTNESS_PATH,
                Settings.Secure.getInt(context.getContentResolver(),
                        DeviceSettings.PREF_TORCH_BRIGHTNESS, 100));
        FileUtils.setValue(DeviceSettings.NOTIF_LED_BLUE_PATH,
                Settings.Secure.getInt(context.getContentResolver(),
                        DeviceSettings.PREF_NOTIF_LED, 100) / 100.0 * (DeviceSettings.MAX_LED - DeviceSettings.MIN_LED) + DeviceSettings.MIN_LED);
        FileUtils.setValue(DeviceSettings.NOTIF_LED_RED_PATH,
                Settings.Secure.getInt(context.getContentResolver(),
                        DeviceSettings.PREF_NOTIF_LED, 100) / 100.0 * (DeviceSettings.MAX_LED - DeviceSettings.MIN_LED) + DeviceSettings.MIN_LED);
        FileUtils.setValue(DeviceSettings.NOTIF_LED_GREEN_PATH,
                Settings.Secure.getInt(context.getContentResolver(),
                        DeviceSettings.PREF_NOTIF_LED, 100) / 100.0 * (DeviceSettings.MAX_LED - DeviceSettings.MIN_LED) + DeviceSettings.MIN_LED);
        int gain = Settings.Secure.getInt(context.getContentResolver(),
                DeviceSettings.PREF_HEADPHONE_GAIN, 4);
        FileUtils.setValue(DeviceSettings.HEADPHONE_GAIN_PATH, gain + " " + gain);
        FileUtils.setValue(DeviceSettings.MICROPHONE_GAIN_PATH, Settings.Secure.getInt(context.getContentResolver(),
                DeviceSettings.PREF_MICROPHONE_GAIN, 0));
        FileUtils.setValue(DeviceSettings.EARPIECE_GAIN_PATH, Settings.Secure.getInt(context.getContentResolver(),
                DeviceSettings.PREF_EARPIECE_GAIN, 0));
        FileUtils.setValue(DeviceSettings.SPEAKER_GAIN_PATH, Settings.Secure.getInt(context.getContentResolver(),
                DeviceSettings.PREF_SPEAKER_GAIN, 0));
        FileUtils.setValue(DeviceSettings.USB_FASTCHARGE_PATH, Settings.Secure.getInt(context.getContentResolver(),
                DeviceSettings.PREF_USB_FASTCHARGE, 0));
        FileUtils.setValue(DeviceSettings.MSM_TOUCHBOOST_PATH, Settings.Secure.getInt(context.getContentResolver(),
                DeviceSettings.PREF_MSM_TOUCHBOOST, 0));
        // Dirac
        context.startService(new Intent(context, DiracService.class));

       // Ambient
        context.startService(new Intent(context, SensorsDozeService.class));

        boolean enabled = sharedPrefs.getBoolean(DeviceSettings.PREF_KEY_FPS_INFO, false);
        if (enabled) {
            context.startService(new Intent(context, FPSInfoService.class));
        }
    }
}
