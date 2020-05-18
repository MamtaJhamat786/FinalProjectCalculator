package com.example.firebasedemo.databasestorage;

import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class FirebaseDatabase {

    public void saveDataToFirebase(String calculation) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        HashMap<String, Object> equation = new HashMap<>();
        equation.put("equation", calculation);
        equation.put("timestamp", FieldValue.serverTimestamp());
        db.collection("equation").add(equation);
    }
}
