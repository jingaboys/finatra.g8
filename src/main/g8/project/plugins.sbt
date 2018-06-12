resolvers += Resolver.url("bintray-sbt-plugin-releases", url("http://dl.bintray.com/content/sbt/sbt-plugin-releases"))(
  Resolver.ivyStylePatterns)
resolvers += Classpaths.sbtPluginReleases

addSbtPlugin("au.com.onegeek"         %% "sbt-dotenv"               % "1.2.88")
addSbtPlugin("com.typesafe.sbt"        % "sbt-git"                  % "0.9.3")
addSbtPlugin("com.softwaremill.clippy" % "plugin-sbt"               % "0.5.3")
addSbtPlugin("com.geirsson"            % "sbt-scalafmt"             % "1.5.1")
addSbtPlugin("com.timushev.sbt"        % "sbt-updates"              % "0.3.4")
addSbtPlugin("com.typesafe.sbt"        % "sbt-native-packager"      % "1.3.4")
