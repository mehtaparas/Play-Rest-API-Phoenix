
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/parmehta/Play-Rest-API-Phoenix/conf/routes
// @DATE:Thu Mar 22 10:05:18 EDT 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def save(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "post_test/")
    }
  
    // @LINE:9
    def search(siteid:Int, accountnbr:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "customers/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("siteid", siteid)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("accountnbr", accountnbr)))
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:15
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }


}
