package tddbc

import spock.lang.Specification

/**
 * Created by numamino on 2015/11/14.
 */
class GridPointSpec extends Specification {

    def 格子点が生成できること() {
        given:
        def sut = new GridPoint()
    }

    def 格子点がX座標を持つこと(int x, int expect) {
        given:
        def sut = new GridPoint(x)

        expect:
        expect == sut.getX()

        where:
        x  | expect
        0  | 0
        1  | 1
        -3 | -3
    }
}
