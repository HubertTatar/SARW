name          := """SARW"""
organization  := "com.test"
version       := "0.0.1"
scalaVersion  := "2.11.7"

resolvers += "Local Maven Repository" at "file:///home/huta/.m2/repository"
resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/maven-releases/"

libraryDependencies ++= {
  val akkaio = "1.0"
  val slick  = "3.0.0"

  Seq(
    "com.typesafe.akka"  % "akka-stream-experimental_2.11"          % akkaio,
    "com.typesafe.akka"  % "akka-http-core-experimental_2.11"       % akkaio,
    "com.typesafe.akka"  % "akka-http-spray-json-experimental_2.11" % akkaio,
    "org.slf4j"          %  "slf4j-nop"                             % "1.7.9",
    "com.typesafe.slick" %% "slick"                                 % slick,
    "com.typesafe.slick" %% "slick-extensions"                      % slick,
    "com.oracle"         % "ojdbc7"                                 % "12.2.0"
  )
}