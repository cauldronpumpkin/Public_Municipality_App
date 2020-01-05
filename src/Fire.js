import firebase from 'firebase/app'
import 'firebase/firestore' 

 // Your web app's Firebase configuration
var firebaseConfig = {
    apiKey: "AIzaSyA12scKkPCY16hLwGSZAJivqsOB-9pEHmg",
    authDomain: "disease-f22d1.firebaseapp.com",
    databaseURL: "https://disease-f22d1.firebaseio.com",
    projectId: "disease-f22d1",
    storageBucket: "disease-f22d1.appspot.com",
    messagingSenderId: "870376153294",
    appId: "1:870376153294:web:a2f7a3b1cf96305487309f",
    measurementId: "G-Q5HKWP2RX6"
};
  // Initialize Firebase
firebase.initializeApp(firebaseConfig);
//firebase.analytics();

const db = firebase.firestore()
db.settings({ timestampsInSnapshots: true });

export default db;
