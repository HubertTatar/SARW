package com.test.sarw.util

import java.security.{SecureRandom, KeyStore}
import javax.net.ssl.{TrustManagerFactory, KeyManagerFactory, SSLContext}

trait MySSLConfig {

  implicit def sslContext: SSLContext = {
    val keyStoreResource = "/ssl-keystore.jks"
    val password = "secret"

    val keyStore = KeyStore.getInstance("jks")
    keyStore.load(getClass.getResourceAsStream(keyStoreResource), password.toCharArray)

    val keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm())
    keyManagerFactory.init(keyStore, password.toCharArray)

    val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm)
    trustManagerFactory.init(keyStore)

    val ctx = SSLContext.getInstance("TLS")
    ctx.init(keyManagerFactory.getKeyManagers, trustManagerFactory.getTrustManagers, new SecureRandom())

    ctx
  }


/*  implicit def sslEngineProvider: ServerSSLEngineProvider = {
    ServerSSLEngineProvider { engine =>
      engine.setEnabledCipherSuites(Array("TLS_RSA_WITH_AES_256_CBC_SHA"))
      engine.setEnabledProtocols(Array("SSLv3", "TLSv1"))
      engine
    }
  }*/
}
