package com.loader.my.mymindvalleyapp

import android.arch.persistence.room.*


@Entity(indices = arrayOf(Index(value = ["itemid"],unique = true)))
class MindItemData{
    @PrimaryKey(autoGenerate = true) var id:Int=0
    @Embedded(prefix = "item") var mindItem:MindItem= MindItem()
}

class MindItem {


     var id: String=""

     var createdAt: String=""

     var width: Int? = null

     var height: Int? = null

      var color: String=""

     var likes: Int? = null

     var likedByUser: Boolean? = null

        @Embedded(prefix = "user") var user: User= User()

       @Ignore var currentUserCollections: List<Any>? = null

     @Ignore var urls: Urls=Urls()

       @Ignore var categories: List<Category>? = null

        @Ignore var links: Links__= Links__()

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param id
     * @param currentUserCollections
     * @param height
     * @param color
     * @param urls
     * @param createdAt
     * @param likes
     * @param width
     * @param links
     * @param categories
     * @param likedByUser
     * @param user
     */
    constructor(id: String, createdAt: String, width: Int?, height: Int?, color: String, likes: Int?, likedByUser: Boolean?, user: User, currentUserCollections: List<Any>, urls: Urls, categories: List<Category>, links: Links__) : super() {
        this.id = id
        this.createdAt = createdAt
        this.width = width
        this.height = height
        this.color = color
        this.likes = likes
        this.likedByUser = likedByUser
        this.user = user
        this.currentUserCollections = currentUserCollections
        this.urls = urls
        this.categories = categories
        this.links = links
    }

}


class Category {


      var id: Int? = null

       var title: String=""

      var photoCount: Int? = null

    var links: Links_= Links_()

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param id
     * @param title
     * @param photoCount
     * @param links
     */
    constructor(id: Int?, title: String, photoCount: Int?, links: Links_) : super() {
        this.id = id
        this.title = title
        this.photoCount = photoCount
        this.links = links
    }

}

class Links {


   var self: String=""

       var html: String=""

       var photos: String=""

     var likes: String=""

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param photos
     * @param likes
     * @param html
     * @param self
     */
    constructor(self: String, html: String, photos: String, likes: String) : super() {
        this.self = self
        this.html = html
        this.photos = photos
        this.likes = likes
    }

}

class Links_ {


      var self: String=""

     var photos: String=""

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param photos
     * @param self
     */
    constructor(self: String, photos: String) : super() {
        this.self = self
        this.photos = photos
    }

}

class Links__ {


      var self: String=""

        var html: String=""

     var download: String=""

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param download
     * @param html
     * @param self
     */
    constructor(self: String, html: String, download: String) : super() {
        this.self = self
        this.html = html
        this.download = download
    }

}



class ProfileImage {


     var small: String=""

       var medium: String=""

       var large: String=""

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param small
     * @param large
     * @param medium
     */
    constructor(small: String, medium: String, large: String) : super() {
        this.small = small
        this.medium = medium
        this.large = large
    }

}

class Urls {


      var raw: String=""

     var full: String=""

  var regular: String=""

    var small: String=""

   var thumb: String=""

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param raw
     * @param regular
     * @param full
     * @param thumb
     * @param small
     */
    constructor(raw: String, full: String, regular: String, small: String, thumb: String) : super() {
        this.raw = raw
        this.full = full
        this.regular = regular
        this.small = small
        this.thumb = thumb
    }

}


class User {


      var id: String=""

    var username: String=""

   var name: String=""

      @Embedded var profileImage: ProfileImage= ProfileImage()

      @Ignore var links: Links= Links()

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param id
     * @param username
     * @param profileImage
     * @param name
     * @param links
     */
    constructor(id: String, username: String, name: String, profileImage: ProfileImage, links: Links) : super() {
        this.id = id
        this.username = username
        this.name = name
        this.profileImage = profileImage
        this.links = links
    }

}
