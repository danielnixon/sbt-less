lazy val root = (project in file(".")).enablePlugins(SbtWeb)

libraryDependencies += "org.webjars" % "bootstrap" % "3.3.7-1"

val checkMapFileContents = taskKey[Unit]("check that map contents are correct")

checkMapFileContents := {
  val contents = IO.read((WebKeys.public in Assets).value / "main.css.map")
  val expectedContents = """{"version":3,"sources":["main.less","../lib/bootstrap/less/mixins/center-block.less"],"names":[],"mappings":"AAEA;ECCE,cAAA;EACA,iBAAA;EACA,kBAAA","file":"main.css"}"""

  if (contents != expectedContents) {
    sys.error(s"Unexpected contents: $contents, \nexpected: $expectedContents")
  }
}
