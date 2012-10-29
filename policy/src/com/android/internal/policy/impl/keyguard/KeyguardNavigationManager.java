/*
 * Copyright (C) 2012 The Android Open Source Project
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

package com.android.internal.policy.impl.keyguard;

import android.widget.TextView;

public class KeyguardNavigationManager implements SecurityMessageDisplay {

    private TextView mMessageArea;

    public KeyguardNavigationManager(TextView messageArea) {
        if (messageArea != null) {
            mMessageArea = messageArea;
            mMessageArea.setSelected(true); // Make marquee work
        }
    }

    public void setMessage(CharSequence msg, boolean important) {
        if (mMessageArea == null) return;
        mMessageArea.setText(msg);
        mMessageArea.announceForAccessibility(mMessageArea.getText());
    }

    public void setMessage(int resId, boolean important) {
        if (mMessageArea == null) return;
        if (resId != 0) {
            mMessageArea.setText(resId);
            mMessageArea.announceForAccessibility(mMessageArea.getText());
        } else {
            mMessageArea.setText("");
        }
    }

    public void setMessage(int resId, boolean important, Object... formatArgs) {
        if (mMessageArea == null) return;
        if (resId != 0) {
            mMessageArea.setText(mMessageArea.getContext().getString(resId, formatArgs));
            mMessageArea.announceForAccessibility(mMessageArea.getText());
        } else {
            mMessageArea.setText("");
        }
    }
}