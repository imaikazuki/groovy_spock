package tddbc

import spock.lang.Specification

/**
 * Created by numamino on 2015/11/14.
 */
class GridPointSpec extends Specification {

    def 格子点が生成できること() {
        given:
        def sut = new GridPoint(0, 0)
    }

    def 格子点がX座標を持つこと(int x, int expect) {
        given:
        def sut = new GridPoint(x, 0)

        expect:
        expect == sut.getX()

        where:
        x  | expect
        0  | 0
        1  | 1
        -3 | -3
    }

    def 格子点がY座標を持つこと(int y, int expect) {
        given:
        def sut = new GridPoint(0, y)

        expect:
        assert expect == sut.getY()

        where:
        y  | expect
        1  | 1
        3  | 3
        -1 | -1
    }
}
