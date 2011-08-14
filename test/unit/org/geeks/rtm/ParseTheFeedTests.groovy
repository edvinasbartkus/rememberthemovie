package org.geeks.rtm

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class ParseTheFeedTests {

  void setUp() {
    // Setup logic here
  }

  void tearDown() {
    // Tear down logic here
  }

  void testResultOfPageParse() {
    def result = new ParseTheFeed().parsePage()
    assert result.size() == 5

    def object = result.first()
    assertNotNull object.img
    assertNotNull object.title
  }

  void testPagination() {
    def parseFeed = new ParseTheFeed()
    def result = parseFeed.parsePage()
    assert result.size() == 5

    def result2 = parseFeed.parsePage(2)
    assert result2.size() == 5
    assert result.first().title != result2.first().title
  }

  void testInfinity() {
    def parseFeed = new ParseTheFeed()
    def result = parseFeed.parsePage(999)
    assert result.size() == 0
  }

  void testParseAll() {
    def movies = new ParseTheFeed().parse()
    assert movies.size() > 0
  }
}
