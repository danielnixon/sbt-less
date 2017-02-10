lazy val root = (project in file(".")).enablePlugins(SbtWeb)

//JsEngineKeys.engineType := JsEngineKeys.EngineType.Node

libraryDependencies += "org.webjars" % "bootstrap" % "3.3.7-1"

LessKeys.compress in Assets := false

includeFilter in (Assets, LessKeys.less) := "foo.less" | "bar.less"
