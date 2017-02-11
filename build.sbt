lazy val `sbt-less` = project in file(".")
description := "sbt-web less plugin"
scalaVersion := "2.10.6"
sbtPlugin := true
organization := "org.danielnixon"
licenses := Seq("The Apache Software License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))
version := "1.1.3-SNAPSHOT"
publishMavenStyle := true
publishArtifact in Test := false
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}
homepage := Some(url("https://github.com/danielnixon/sbt-less"))
pomExtra := {
  <scm>
    <url>git@github.com:danielnixon/sbt-less.git</url>
    <connection>scm:git:git@github.com:danielnixon/sbt-less.git</connection>
  </scm>
    <developers>
      <developer>
        <id>danielnixon</id>
        <name>Daniel Nixon</name>
        <url>https://danielnixon.org/</url>
      </developer>
    </developers>
}

scriptedSettings
scriptedLaunchOpts += s"-Dproject.version=${version.value}"

libraryDependencies ++= Seq(
  "org.webjars" % "less-node" % "2.7.2",
  "org.webjars" % "mkdirp" % "0.5.0",
  "org.webjars.npm" % "clean-css" % "4.0.5",
  "org.webjars.npm" % "less-plugin-clean-css" % "1.5.1" intransitive(),
  "org.webjars" % "es6-promise-node" % "2.1.1"
)

addSbtPlugin("com.typesafe.sbt" % "sbt-js-engine" % "1.1.4")
