package tddbc

/**
 * Created by numamino on 2015/11/14.
 */
class GridPoint {

    private x
    private y

    public GridPoint(def x, def y) {
        this.x = x
        this.y = y
    }

    def getX() {
        x
    }

    def getY() {
        y
    }

    def getNotation() {
        "(${x},${y})".toString()
    }

    def hasSameCoordinatesWith(GridPoint gridPoint) {
        x == gridPoint.x && y == gridPoint.y
    }
}
