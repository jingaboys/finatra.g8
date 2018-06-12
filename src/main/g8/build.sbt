import sbt.Keys._
import com.typesafe.sbt.packager.docker._
import com.typesafe.sbt.packager.docker.DockerPlugin.autoImport.DockerAlias

import scala.language.postfixOps

name := "$name$"

organization := "$organization$"

version := "$service_version$"

scalaVersion := "$scala_version$"

fork in run := true

cancelable in Global := true

resolvers += Resolver.sonatypeRepo("releases")

resolvers += "maven.twttr.com" at "https://maven.twttr.com"

enablePlugins(JavaAppPackaging,
              GitVersioning,
              GitBranchPrompt)

initialCommands in console := """
                | import com.twitter.util.{Future, FuturePool, Await}
                |""".stripMargin

scalafmtConfig := Some(file(".scalafmt.conf"))
scalafmtOnCompile := true

lazy val versions = new {
  val finatra        = "18.5.0"
  val guice          = "4.2.0"
  val logback        = "1.2.3"
  val mockito        = "1.10.19"
  val scalatest      = "3.0.5"
  val junitInterface = "0.11"
  val scalaUri       = "0.4.16"
  val swaggerFinatra = "18.4.0"
}

libraryDependencies ++= Seq(
  "com.netaporter"               %% "scala-uri"                      % versions.scalaUri,
  "com.twitter"                  %% "finatra-http"                   % versions.finatra,
  "com.twitter"                  %% "finatra-httpclient"             % versions.finatra,
  "com.twitter"                  %% "finatra-jackson"                % versions.finatra,
  "ch.qos.logback"               % "logback-classic"                 % versions.logback,
  "com.twitter"                  %% "twitter-server-logback-classic" % versions.finatra,
  "com.twitter"                  %% "finatra-http"                   % versions.finatra % "test",
  "com.twitter"                  %% "finatra-jackson"                % versions.finatra % "test",
  "com.twitter"                  %% "inject-server"                  % versions.finatra % "test",
  "com.twitter"                  %% "inject-app"                     % versions.finatra % "test",
  "com.twitter"                  %% "inject-core"                    % versions.finatra % "test",
  "com.twitter"                  %% "inject-modules"                 % versions.finatra % "test",
  "com.google.inject.extensions" % "guice-testlib"                   % versions.guice   % "test",
  "com.twitter"                  %% "finatra-http"                   % versions.finatra % "test" classifier "tests",
  "com.twitter"                  %% "finatra-jackson"                % versions.finatra % "test" classifier "tests",
  "com.twitter"                  %% "inject-server"                  % versions.finatra % "test" classifier "tests",
  "com.twitter"                  %% "inject-app"                     % versions.finatra % "test" classifier "tests",
  "com.twitter"                  %% "inject-core"                    % versions.finatra % "test" classifier "tests",
  "com.twitter"                  %% "inject-modules"                 % versions.finatra % "test" classifier "tests",
  "com.jakehschwartz"            % "finatra-swagger_2.12"            % versions.swaggerFinatra,
  "org.mockito"                  % "mockito-core"                    % versions.mockito        % "test",
  "org.scalatest"                %% "scalatest"                      % versions.scalatest      % "test",
  "com.novocode"                 % "junit-interface"                 % versions.junitInterface % "test"
)

testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")

fork in test := false

parallelExecution in Test := false

clippyColorsEnabled := true

scalacOptions ++= Seq(
  "-target:jvm-1.8",
    "-encoding",
    "UTF-8",
    "-unchecked",
    "-language:existentials",
    "-language:experimental.macros",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-deprecation",
    "-explaintypes",
    "-feature",
    "-Xcheckinit",
    "-Xlint:adapted-args", // Warn if an argument list is modified to match the receiver.
    "-Xlint:by-name-right-associative", // By-name parameter of right associative operator.
    "-Xlint:constant", // Evaluation of a constant arithmetic expression results in an error.
    "-Xlint:delayedinit-select", // Selecting member of DelayedInit.
    "-Xlint:doc-detached", // A Scaladoc comment appears to be detached from its element.
    "-Xlint:inaccessible", // Warn about inaccessible types in method signatures.
    "-Xlint:infer-any", // Warn when a type argument is inferred to be `Any`.
    "-Xlint:missing-interpolator", // A string literal appears to be missing an interpolator id.
    "-Xlint:nullary-override", // Warn when non-nullary `def f()' overrides nullary `def f'.
    "-Xlint:nullary-unit", // Warn when nullary methods return Unit.
    "-Xlint:option-implicit", // Option.apply used implicit view.
    "-Xlint:package-object-classes", // Class or object defined in package object.
    "-Xlint:poly-implicit-overload", // Parameterized overloaded implicit methods are not visible as view bounds.
    "-Xlint:private-shadow", // A private field (or class parameter) shadows a superclass field.
    "-Xlint:stars-align", // Pattern sequence wildcard must align with sequence component.
    "-Xlint:type-parameter-shadow", // A local type parameter shadows a type already in scope.
    "-Xlint:unsound-match", // Pattern match may not be typesafe.
    "-Yno-adapted-args", // Do not adapt an argument list (either by inserting () or creating a tuple) to match the receiver.
    "-Ypartial-unification", // Enable partial unification in type constructor inference
    "-Ywarn-dead-code", // Warn when dead code is identified.
    "-Ywarn-extra-implicit", // Warn when more than one implicit parameter section is defined.
    "-Ywarn-inaccessible", // Warn about inaccessible types in method signatures.
    "-Ywarn-infer-any", // Warn when a type argument is inferred to be `Any`.
    "-Ywarn-nullary-override", // Warn when non-nullary `def f()' overrides nullary `def f'.
    "-Ywarn-nullary-unit", // Warn when nullary methods return Unit.
    "-Ywarn-numeric-widen", // Warn when numerics are widened.
    "-Ywarn-unused:implicits", // Warn if an implicit parameter is unused.
    "-Ywarn-unused:imports", // Warn if an import selector is not referenced.
    "-Ywarn-unused:locals", // Warn if a local definition is unused.
    "-Ywarn-unused:params", // Warn if a value parameter is unused.
    "-Ywarn-unused:patvars", // Warn if a variable bound in a pattern is unused.
    "-Ywarn-unused:privates", // Warn if a private member is unused.
    "-Ywarn-value-discard", // Warn when non-Unit expression results are unused.
    "-P:clippy:colors=true",
    "-Ycache-plugin-class-loader:last-modified",
    "-Ycache-macro-class-loader:last-modified",
    "-Ybackend-parallelism",
    s"$"$"${sys.runtime.availableProcessors() * 2}",
    "-Ybackend-worker-queue",
    "8"
)

// bashScriptExtraDefines += """addJava "-Dnetworkaddress.cache.ttl=60""""
bashScriptExtraDefines ++= Seq("""addJava "-Dnetworkaddress.cache.ttl=60"""",
                               """addJava "-XX:+UnlockExperimentalVMOptions"""",
                               """addJava "-XX:+UseCGroupMemoryLimitForHeap"""",
                               """addJava "-XX:+UseG1GC"""",
                               """addJava "-XX:+UseStringDeduplication"""")
bashScriptExtraDefines ++= Seq("""addApp "-log.level=$"$"${LOG_LEVEL:-INFO}"""",
                               """addApp "-swagger.docs.endpoint=$"$"${/$name;format="norm,word"$/docs}"""",
                               s"""addApp "-service.version=$"$"${version.value}"""")

val gitHeadCode = SettingKey[String]("git-head-hash", "The commit hash code of HEAD")
gitHeadCode := git.gitHeadCommit.value.map { sha => s"$"$"${sha.take(7)}" }.getOrElse("na")