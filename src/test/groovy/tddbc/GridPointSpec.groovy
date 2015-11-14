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

    def 格子点が同じ座標かどうかを判定できる() {
        given:
        def sut = new GridPoint(1, 2)

        expect:
        assert sut.hasSameCoordinatesWith(new GridPoint(1, 2))
    }

    def 格子点のY座標が異なる場合に違う格子点であること() {
        given:
        def sut = new GridPoint(1, 2)

        expect:
        assert !sut.hasSameCoordinatesWith(new GridPoint(1, 3))
    }

    def 格子点のX座標が異なる場合に違う格子点であること() {
        given:
        def sut = new GridPoint(1, 2)

        expect:
        assert !sut.hasSameCoordinatesWith(new GridPoint(2, 2))
    }

    def 格子点のX座標とY座標が異なる場合に違う格子点であること() {
        given:
        def sut = new GridPoint(1, 2)

        expect:
        assert !sut.hasSameCoordinatesWith(new GridPoint(3, 4))
    }

    @Unroll
    def "2つの格子点(#x,#y)と(#opponentX,#opponentY)が隣り合っているか判定する"(result, x, y, opponentX, opponentY) {
        given:
        def sut = new GridPoint(x, y)

        expect:
        assert result == sut.isNeighborOf(new GridPoint(opponentX, opponentY))

        where:
        result | x | y | opponentX | opponentY
        true   | 3 | 3 | 3         | 4 // 上
        false  | 3 | 3 | 4         | 4 // 右上
        true   | 3 | 3 | 4         | 3 // 右
        false  | 3 | 3 | 4         | 2 // 右下
        true   | 3 | 3 | 3         | 2 // 下
        false  | 3 | 3 | 2         | 2 // 左下
        true   | 3 | 3 | 2         | 3 // 左
        false  | 3 | 3 | 2         | 4 // 左上

        false  | 3 | 3 | 3         | 3 // 同じ座標

        false  | 3 | 3 | -100      | -200 // 離れた座標

    }
}
