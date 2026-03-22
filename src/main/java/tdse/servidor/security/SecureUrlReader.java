package tdse.servidor.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class SecureUrlReader {

  public void initSsl()
      throws KeyStoreException, NoSuchAlgorithmException, FileNotFoundException, CertificateException, IOException,
      KeyManagementException {

    File trustStoreFile = new File("keystores/myTrustStore");

    char[] trustStorePassword = "567890".toCharArray();

    KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
    trustStore.load(new FileInputStream(trustStoreFile), trustStorePassword);

    TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

    tmf.init(trustStore);

    SSLContext sslContext = SSLContext.getInstance("TLS");
    sslContext.init(null, tmf.getTrustManagers(), null);
    SSLContext.setDefault(sslContext);

  }
}
