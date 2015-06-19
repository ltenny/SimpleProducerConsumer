name := "SimpleConsumer"

version := "1.0"

scalaVersion := "2.11.6"

mainClass in assembly := Some("com.ctd.bigdata.SimpleConsumer")

resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases" at "http://oss.sonatype.org/content/repositories/releases",
  "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases",
  "Akka Snapshot Respository" at "http://repo.akka.io/snapshots/")

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

libraryDependencies += "com.typesafe.akka" %% "akka-remote" % "2.3.11"

libraryDependencies += "org.specs2" %% "specs2-core" % "3.6.1" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.4" % "test"

scalacOptions in Test ++= Seq("-Yrangepos")


