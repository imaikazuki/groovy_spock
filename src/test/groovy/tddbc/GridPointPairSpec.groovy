package tddbc

import spock.lang.Specification

/**
 * Created by kazuki on 11/14/15.
 */
class GridPointPairSpec extends Specification {
    
    def "格子点のペアが,指定した格子点を含むことを判定できる"() {
        given:
        def sut = new GridPointPair(new GridPoint(1, 2), new GridPoint(1, 3))

        expect:
        assert sut.contains(new GridPoint(1, 2))
    }

    def "格子点のペアが,指定した格子点を含まないことを判定できる"() {
        given:
        def sut = new GridPointPair(new GridPoint(1, 2), new GridPoint(1, 3))

        expect:
        assert ! sut.contains(new GridPoint(0, 42))
    }

}
