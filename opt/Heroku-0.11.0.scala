import sbt._
import Keys._

object Heroku extends Plugin {
  override def settings = Seq(
    externalResolvers <<= resolvers map { appResolvers =>
      Seq(Resolver.defaultLocal) ++ appResolvers ++
      Seq(Resolver.url("heroku-sbt-typesafe") artifacts "http://s3pository-staging-brainard.herokuapp.com/ivy-typesafe-releases/[organization]/[module]/[revision]/[type]s/[artifact](-[classifier]).[ext]",
          "heroku-central" at "http://s3pository-staging-brainard.herokuapp.com/maven-central/",
          "heroku-scala-tools-releases" at "http://s3pository-staging-brainard.herokuapp.com/maven-sonatype-oss-scala-tools/",
          "heroku-scala-tools-snapshots" at "http://s3pository-staging-brainard.herokuapp.com/maven-scala-tools-snapshots/")
  })
}
