package org.geeks.rtm

class Movie {
  String title
  String url = null
  String quote

  byte[] image = null
  Integer year = null

  Date dateCreated
  Date lastUpdated

  static mapping = {
    quote column:'text'
  }

  static constraints = {
    title blank:false
    url   nullable:true
    quote blank:true, nullable:true

    image nullable:true
    year  nullable:true
  }
}
