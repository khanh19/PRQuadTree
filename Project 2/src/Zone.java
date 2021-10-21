public class Zone {
    int x;
    int y;
    int w;
    int h;

    public Zone(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return this.w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return this.h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public boolean isEmpty() {
        return (this.w == 0 || this.h == 0);
    }

    public boolean wrap(Zone zone) {
        return (x <= zone.getX() && y <= zone.getY() && (x + w) >= (zone.getX() + zone.getW())
                && (y + h) >= (zone.getY() + zone.getH()));
    }

    public boolean isInside(Point point) {
        return (point.getX() >= x && point.getY() >= y && point.getX() < x + w && point.getY() < y + h);
    }

    public Zone intersects(Zone zone) {
        Zone zo;
        int tempX, tempY;
        int tempW = Math.min(x + w, zone.getX() + zone.getW()) - Math.max(x, zone.getX());
        int tempH = Math.min(y + h, zone.getY() + zone.getH()) - Math.max(y, zone.getY());
        ;
        if (tempW >= 0 && tempH >= 0) {
            tempX = Math.min(x + w - tempW, zone.getX() + zone.getW() - tempW);
            tempY = Math.min(y + h - tempH, zone.getY() + zone.getH() - tempH);
            zo = new Zone(tempX, tempY, tempW, tempH);
        } else {
            zo = new Zone(0, 0, 0, 0);
        }
        return zo;
    }

    public Zone dividedById(int order) {
        int tempX, tempY;
        int tempW = w / 2;
        int tempH = h / 2;
        switch (order) {
        case 1:
            tempX = x;
            tempY = y + tempH;
            break;
        case 2:
            tempX = x + tempW;
            tempY = y + tempH;
            break;
        case 3:
            tempX = x;
            tempY = y;
            break;
        case 4:
            tempX = x + tempW;
            tempY = y;
            break;
        default:
            tempX = x;
            tempY = y;
        }
        Zone zone = new Zone(tempX, tempY, tempW, tempH);
        return zone;

    }

    public String toString() {
        return "( " + Integer.toString(x) + ", " + Integer.toString(y) + ", " + Integer.toString(w) + ", "
                + Integer.toString(h) + " )";
    }
}
