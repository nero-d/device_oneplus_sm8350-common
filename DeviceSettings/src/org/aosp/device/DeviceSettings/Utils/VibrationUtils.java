/*
 * Copyright (C) 2020 Havoc-OS
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
 * limitations under the License.
 */

package org.aosp.device.DeviceSettings.Utils;

import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;

public class VibrationUtils {

    public static void doHapticFeedback(Context context, int effect, boolean force) {
        final Vibrator mVibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        final boolean hapticEnabled = Settings.System.getInt(context.getContentResolver(),
                Settings.System.HAPTIC_FEEDBACK_ENABLED, 1) != 0;
        final boolean hapticOnSwitch = Settings.System.getInt(context.getContentResolver(),
                Settings.System.HAPTIC_ON_SWITCH, 1) != 0;
        if (mVibrator != null && (force || mVibrator.hasVibrator() && hapticEnabled && hapticOnSwitch)) {
            mVibrator.vibrate(VibrationEffect.get(effect));
        }
    }
}
