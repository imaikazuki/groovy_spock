package tddbc

/**
 * Created by numamino on 2015/11/14.
 */
class GridPointPair {
    private GridPoint gp1;
    private GridPoint gp2;

    GridPointPair(GridPoint gp1, GridPoint gp2) {
        this.gp1 = gp1
        this.gp2 = gp2
    }

    def contains(GridPoint opponent) {
        gp1.hasSameCoordinatesWith(opponent) || gp2.hasSameCoordinatesWith(opponent)
    }
}
