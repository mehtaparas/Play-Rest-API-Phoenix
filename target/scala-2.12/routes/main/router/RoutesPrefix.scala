
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/parmehta/Play-Rest-API-Phoenix/conf/routes
// @DATE:Thu Mar 22 10:05:18 EDT 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
