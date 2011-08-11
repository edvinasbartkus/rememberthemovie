package org.geeks.rtm

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainUnitTestMixin} for usage instructions
 */
@TestFor(Movie)
class MovieTests {

    void testMovieCraetion() {
      def movie = new Movie(title:"500 Days of Summer").save(flush:true, 
        failOnError:true)
      assert movie.id
    }
}
