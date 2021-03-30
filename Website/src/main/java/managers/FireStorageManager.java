package managers;

import com.google.auth.ServiceAccountSigner;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import java.io.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FireStorageManager {
    FirebaseApp firebaseApp;
    Storage storage;
    private void readPrivateKey() throws IOException {

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(getClass().getResourceAsStream("/iti-ecommerce-website-firebase-adminsdk-g8k8r-cbdbe9fb4b.json")))
                .setStorageBucket("iti-ecommerce-website.appspot.com")
                .build();
        firebaseApp = FirebaseApp.initializeApp(options);
        storage = StorageOptions.newBuilder().setCredentials(GoogleCredentials.fromStream(this.getClass().getResourceAsStream("/iti-ecommerce-website-firebase-adminsdk-g8k8r-cbdbe9fb4b.json")))
                .build().getService();
    }

    public String uploadFileToStorage(byte[] fileBytes) throws IOException {
        Bucket bucket = StorageClient.getInstance(firebaseApp).bucket();
        BlobId blobId = BlobId.of(bucket.getName(),"test1.jpg");
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/jpeg").build();
        Blob blob = storage.create(blobInfo,fileBytes);
        URL url =blob.signUrl(100,TimeUnit.DAYS, Storage.SignUrlOption.signWith((ServiceAccountSigner) GoogleCredentials.fromStream(getClass().getResourceAsStream("/iti-ecommerce-website-firebase-adminsdk-g8k8r-cbdbe9fb4b.json"))));
        System.out.println(url.getHost()+url.getFile());
        return url.getProtocol()+"://"+url.getHost()+url.getFile();
    }

}
