/*
 * Copyright 2024 The Android Open Source Project
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

package androidx.pdf.viewer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.pdf.util.ObservableValue;
import androidx.pdf.widget.FastScrollView;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public class FastScrollPositionValueObserver implements ObservableValue.ValueObserver<Integer> {
    private final FastScrollView mFastScrollView;
    private final PageIndicator mPageIndicator;

    public FastScrollPositionValueObserver(@NonNull FastScrollView fastScrollView,
            @NonNull PageIndicator pageIndicator) {
        mFastScrollView = fastScrollView;
        mPageIndicator = pageIndicator;
    }

    @Override
    public void onChange(@Nullable Integer oldValue, @Nullable Integer newValue) {
        if (mPageIndicator != null && newValue != null) {
            mPageIndicator.getView().setY(
                    newValue - (mPageIndicator.getView().getHeight() / 2));
            mPageIndicator.show();
            showFastScrollView();
        }
    }

    private void showFastScrollView() {
        if (mFastScrollView != null) {
            mFastScrollView.setVisible();
        }
    }
}
