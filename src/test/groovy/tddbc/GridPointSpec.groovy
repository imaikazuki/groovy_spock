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
        assert expect == sut.getX()

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

    def "格子点が(X,Y)の文字列表記を生成できる"(notation, x, y) {
        given:
        def sut = new GridPoint(x, y)

        expect:
        assert notation.equals(sut.getNotation())

        where:
        notation   | x  | y
        "(1,2)"    | 1  | 2
        "(-1,-99)" | -1 | -99
    }

}
