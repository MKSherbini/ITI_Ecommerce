package managers;

import com.google.auth.ServiceAccountSigner;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountJwtAccessCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.storage.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.cloud.StorageClient;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class FirebaseManager {
    private void readPrivateKey() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("src/main/java/resources/serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setStorageBucket("gs://iti-ecommerce-website.appspot.com/products")
                .build();

        FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
        Bucket bucket = StorageClient.getInstance(firebaseApp).bucket();

        Firestore firestore = FirestoreClient.getFirestore(firebaseApp);

    }

    public String uploadFileToStorage(byte[] fileBytes) throws IOException {
        // Enable Cloud Storage
        Storage storage = StorageOptions.newBuilder().setCredentials(GoogleCredentials.fromStream(this.getClass().getResourceAsStream("/iti-ecommerce-website-firebase-adminsdk-g8k8r-cbdbe9fb4b.json")))
                .build().getService();
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(getClass().getResourceAsStream("/iti-ecommerce-website-firebase-adminsdk-g8k8r-cbdbe9fb4b.json")))
                .setStorageBucket("iti-ecommerce-website.appspot.com")
                .build();

        FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
        Bucket bucket = StorageClient.getInstance(firebaseApp).bucket();

        InputStream in = new FileInputStream("C:\\Users\\Hadeer\\Desktop\\webapp\\ITI_Ecommerce_Website\\Website\\src\\main\\resources\\bora.jpg");
        BlobId blobId = BlobId.of(bucket.getName(),"test1.jpg");
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/jpeg").build();
        Blob blob = storage.create(blobInfo,fileBytes);
        URL url =blob.signUrl(100,TimeUnit.DAYS, Storage.SignUrlOption.signWith((ServiceAccountSigner) GoogleCredentials.fromStream(getClass().getResourceAsStream("/iti-ecommerce-website-firebase-adminsdk-g8k8r-cbdbe9fb4b.json"))));
        System.out.println(url.getHost()+url.getFile());
        return url.getProtocol()+"://"+url.getHost()+url.getFile();
    }

}
