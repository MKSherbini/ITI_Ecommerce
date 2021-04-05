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
    private static volatile FireStorageManager instance = null;
    FirebaseApp firebaseApp;
    Storage storage;

    private FireStorageManager(){
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
        try {
            readPrivateKey();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static FireStorageManager getInstance() {
        if (instance == null) {
            synchronized (FireStorageManager.class) {
                if (instance == null) {
                    instance = new FireStorageManager();
                }
            }
        }
        return instance;
    }
    private void readPrivateKey() throws IOException {

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(getClass().getResourceAsStream("/iti-ecommerce-website-firebase-adminsdk-g8k8r-cbdbe9fb4b.json")))
                .setStorageBucket("iti-ecommerce-website.appspot.com")
                .build();
        firebaseApp = FirebaseApp.initializeApp(options);
        storage = StorageOptions.newBuilder().setCredentials(GoogleCredentials.fromStream(this.getClass().getResourceAsStream("/iti-ecommerce-website-firebase-adminsdk-g8k8r-cbdbe9fb4b.json")))
                .build().getService();
    }

    public String uploadFileToStorage(byte[] fileBytes,String filename) throws IOException {
        Bucket bucket = StorageClient.getInstance(firebaseApp).bucket();
        BlobId blobId = BlobId.of(bucket.getName(),filename);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/jpeg").build();
        Blob blob = storage.create(blobInfo,fileBytes);
        URL url =blob.signUrl(100,TimeUnit.DAYS, Storage.SignUrlOption.signWith((ServiceAccountSigner) GoogleCredentials.fromStream(getClass().getResourceAsStream("/iti-ecommerce-website-firebase-adminsdk-g8k8r-cbdbe9fb4b.json"))));
        System.out.println(url.getHost()+url.getFile());
        return url.getProtocol()+"://"+url.getHost()+url.getFile();
    }

}
