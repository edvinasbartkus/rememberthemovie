package org.geeks.rtm

import grails.test.mixin.*
import org.junit.*

@TestFor(Movie)
class MovieTests {

    void testMovieCreation() {
      def movie = new Movie(title:"500 Days of Summer").save(flush:true, 
        failOnError:true)
      assert movie.id
    }
}
