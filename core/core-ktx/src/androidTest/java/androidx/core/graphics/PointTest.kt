/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.core.graphics

import android.graphics.Point
import android.graphics.PointF
import androidx.test.filters.SmallTest
import org.junit.Assert.assertEquals
import org.junit.Test

@SmallTest
class PointTest {
    @Test
    fun destructuringInt() {
        val (x, y) = Point(2, 3)
        assertEquals(2, x)
        assertEquals(3, y)
    }

    @Test
    fun destructuringFloat() {
        val (x, y) = PointF(2.0f, 3.0f)
        assertEquals(2.0f, x)
        assertEquals(3.0f, y)
    }

    @Test
    fun offsetInt() {
        val (x, y) = Point(2, 3) + 2
        assertEquals(4, x)
        assertEquals(5, y)
    }

    @Test
    fun offsetFloat() {
        val (x, y) = PointF(2.0f, 3.0f) + 2.0f
        assertEquals(4.0f, x)
        assertEquals(5.0f, y)
    }

    @Test
    fun offsetPoint() {
        val (x, y) = Point(2, 3) + Point(1, 2)
        assertEquals(3, x)
        assertEquals(5, y)
    }

    @Test
    fun offsetPointF() {
        val (x, y) = PointF(2.0f, 3.0f) + PointF(1.0f, 2.0f)
        assertEquals(3.0f, x)
        assertEquals(5.0f, y)
    }

    @Test
    fun negativeOffsetInt() {
        val (x, y) = Point(2, 3) - 2
        assertEquals(0, x)
        assertEquals(1, y)
    }

    @Test
    fun negativeOffsetFloat() {
        val (x, y) = PointF(2.0f, 3.0f) - 2.0f
        assertEquals(0.0f, x)
        assertEquals(1.0f, y)
    }

    @Test
    fun negativeOffsetPoint() {
        val (x, y) = Point(2, 3) - Point(1, 2)
        assertEquals(1, x)
        assertEquals(1, y)
    }

    @Test
    fun negativeOffsetPointF() {
        val (x, y) = PointF(2.0f, 3.0f) - PointF(1.0f, 2.0f)
        assertEquals(1.0f, x)
        assertEquals(1.0f, y)
    }

    @Test
    fun negateInt() {
        val (x, y) = -Point(2, 3)
        assertEquals(-2, x)
        assertEquals(-3, y)
    }

    @Test
    fun negateFloat() {
        val (x, y) = -PointF(2.0f, 3.0f)
        assertEquals(-2.0f, x)
        assertEquals(-3.0f, y)
    }

    @Test
    fun multiplyPoint() {
        var (x, y) = Point(2, 3) * 5f
        assertEquals(10, x)
        assertEquals(15, y)
        val (x1, y1) = Point(2, 3) * 5.1f
        assertEquals(10, x1)
        assertEquals(15, y1)
    }

    val Epsilon = 1e-4f

    @Test
    fun multiplyPointF() {
        var (x, y) = PointF(2f, 3f) * 5f
        assertEquals(10f, x, Epsilon)
        assertEquals(15f, y, Epsilon)
    }

    @Test
    fun dividePoint() {
        var (x, y) = Point(10, 15) / 5f
        assertEquals(2, x)
        assertEquals(3, y)
        val (x1, y1) = Point(10, 15) / 5.1f
        assertEquals(2, x1)
        assertEquals(3, y1)
    }

    @Test
    fun dividePointF() {
        var (x, y) = PointF(10f, 15f) / 5f
        assertEquals(2f, x, Epsilon)
        assertEquals(3f, y, Epsilon)
    }

    @Test
    fun toPointF() {
        val pointF = Point(1, 2).toPointF()
        assertEquals(1f, pointF.x, 0f)
        assertEquals(2f, pointF.y, 0f)
    }

    @Test
    fun toPoint() {
        assertEquals(Point(1, 2), PointF(1.1f, 2.8f).toPoint())
    }
}
