name          := """SARW"""
organization  := "com.test"
version       := "0.0.1"
scalaVersion  := "2.11.7"

libraryDependencies ++= {
  val akkaio = "1.0"

  Seq(
    "com.typesafe.akka" % "akka-stream-experimental_2.11"          % akkaio,
    "com.typesafe.akka" % "akka-http-core-experimental_2.11"       % akkaio,
    "com.typesafe.akka" % "akka-http-core-experimental_2.11"       % akkaio,
    "com.typesafe.akka" % "akka-http-spray-json-experimental_2.11" % akkaio
  )
}