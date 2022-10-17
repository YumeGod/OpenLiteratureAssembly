/*
 * Decompiled with CFR 0_114.
 */
package just.monika.主播为什么开我端子.util;

public class Timer {
    private long prevMS = 0;

    public boolean delay(float milliSec) {
        if ((float)(this.getTime() - this.prevMS) >= milliSec) {
            return true;
        }
        return false;
    }

    public void reset() {
        this.prevMS = this.getTime();
    }

    public long getTime() {
        return System.nanoTime() / 1000000;
    }

    public long getDifference() {
        return this.getTime() - this.prevMS;
    }
}

