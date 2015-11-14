package tddbc

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by numamino on 2015/11/14.
 */
class GridPointSpec extends Specification {

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

    @Unroll
    def "2つの格子点(1, 2)と(#opponentX,#opponentY)が同じ座標か判定する"(result, opponentX, opponentY) {
        given:
        def sut = new GridPoint(1, 2)

        expect:
        assert result == sut.hasSameCoordinatesWith(new GridPoint(opponentX, opponentY))

        where:
        result | opponentX | opponentY
        true   | 1         | 2
        false  | 1         | 3
        false  | 2         | 2
        false  | 3         | 4
    }

    @Unroll
    def "2つの格子点(3, 3)と#locationの点(#opponentX,#opponentY)が隣り合っているか判定する"(result, location, opponentX, opponentY) {
        given:
        def sut = new GridPoint(3, 3)

        expect:
        assert result == sut.isNeighborOf(new GridPoint(opponentX, opponentY))

        where:
        result | location | opponentX | opponentY
        true   | '上'      | 3         | 4
        false  | '右上'     | 4         | 4
        true   | '右'      | 4         | 3
        false  | '右下'     | 4         | 2
        true   | '下'      | 3         | 2
        false  | '左下'     | 2         | 2
        true   | '左'      | 2         | 3
        false  | '左上'     | 2         | 4
        false  | '同じ座標'   | 3         | 3
        false  | '離れた座標'  | -100      | -200

    }

    def "格子点のペアが作成できる"(){
        given:
        def sut = new GridPointPair(new GridPoint(1, 2), new GridPoint(1, 3))
    }
}
