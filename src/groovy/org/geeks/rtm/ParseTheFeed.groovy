package org.geeks.rtm

class ParseTheFeed {
  static String url = "http://iwdrm.tumblr.com/"
  static String pagination = "page/"

  def parse() {
    parsePage()
  }

  def parsePage(page = null) {
    def fullUrl = page ? url : url + pagination + page
    def html = new XmlSlurper(fullUrl).parse()

    html.'**'.post.each {
      println it.name()
    }
  }
}