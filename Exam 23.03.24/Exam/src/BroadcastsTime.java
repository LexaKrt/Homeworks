public class BroadcastsTime implements Comparable<BroadcastsTime> {

    byte hours = 0;

    byte minutes = 0;

    BroadcastsTime(byte hours, byte minutes) {
        this.hours = hour(hours);
        this.minutes = minutes(minutes);
    }

    BroadcastsTime(String str) {
        String[] string = str.split(":");
        this.hours = Byte.parseByte(string[0]);
        this.minutes = Byte.parseByte(string[1]);
    }

    byte hour(byte hours) {
        return (byte) (hours % 24);
    }

    byte minutes(byte minutes) {
        if (minutes / 60 > 0) {
            hours += (byte)(minutes / 60);
        }
        return (byte) (minutes % 60);
    }

    boolean after(BroadcastsTime t) {
        return compareTo(t) > 0;
    }

    boolean before(BroadcastsTime t) {
        return compareTo(t) < 0;
    }

    boolean between(BroadcastsTime t1, BroadcastsTime t2) {
        return after(t1) & before(t2);
    }

    public byte getHours() {
        return hours;
    }

    public byte getMinutes() {
        return minutes;
    }

    @Override
    public int compareTo(BroadcastsTime t) {
        if (getHours() - t.getHours() > 0) {
            return 1;
        } else if (getHours() - t.getHours() < 0) {
            return -1;
        } else {
            if (getMinutes() - t.getMinutes() > 0) {
                return 1;
            } else if (getMinutes() - t.getMinutes() < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
