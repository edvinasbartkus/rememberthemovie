package org.geeks.rtm

class ParseTheFeed {
  static String url = "http://iwdrm.tumblr.com/"
  static String pagination = "page/"

  def parse() {
    def objects = []
    def result
    for(def i = 1; (result = parsePage(i)).size() != 0; i++) {
      objects += result
    }

    objects
  }

  def parsePage(page = null) {
    def fullUrl = page && (page as Integer) > 1 ? url + pagination + page : url

    def tagSoupParser = new org.ccil.cowan.tagsoup.Parser()
    def html = new XmlSlurper(tagSoupParser).parse(fullUrl)

    def objects = []
    def posts = html.depthFirst().findAll { it.@class == 'post' }

    if(posts.size() <= 1) {
      return []
    }

    posts[1..-1].each {
      def object = [:]
      object.img   = it.img.@src
      object.quote = it.div[1].p[0].i
      object.link  = it.div[1].p[1].a.@href
      object.title = it.div[1].p[1].a.text()

      objects << object
    }

    objects
  }
}