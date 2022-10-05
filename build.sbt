ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.2"

lazy val root = (project in file("."))
  .settings(
    name := "lgbt/tech/tammy/pulsar",
    idePackagePrefix := Some("lgbt.tech.tammy"),
    libraryDependencies ++= Seq(
      "org.typelevel"  %% "squants"  % "1.8.3"
    ),
    scalacOptions ++= Seq(
      "-deprecation",
      "-explain",
      "-explain-types",
      "-feature",
      "-indent",
      "-new-syntax",
      "-print-lines",
      "-unchecked",
      //"-language:strictEquality",
      "-language:postfixOps",
      "-Yexplicit-nulls"
    )
  )
