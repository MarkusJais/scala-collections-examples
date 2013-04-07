import sbt._
import sbt.Keys._

object collections_talk_Build extends Build {

  lazy val scala_collections_examples = Project(
    id = "scala-collections-examples",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "scala-collections-examples",
      organization := "com.markusjais",
      version := "0.1-SNAPSHOT",
   	  scalaVersion := "2.10.1",
      resolvers ++= Seq(
            "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases",
            "sgodbillon" at "https://bitbucket.org/sgodbillon/repository/raw/master/snapshots/",
            "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
      ),

      libraryDependencies ++= Seq(
        "com.github.axel22" %% "scalameter" % "0.3" withSources(),
        "org.scalatest" % "scalatest_2.10" % "2.0.M5b" % "test" withSources()
       ),
       testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")
    )
  )
}

