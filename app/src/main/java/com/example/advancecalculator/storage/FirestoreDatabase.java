package com.example.advancecalculator.storage;

import android.util.Log;

import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FirestoreDatabase {

    public void saveToFirebase (String finalCalculation) throws IOException {

        FirebaseFirestore db=FirebaseFirestore.getInstance();
        Map<String, Object> equation =new HashMap<>();
        equation.put("equation", finalCalculation);
        equation.put("timestamp", FieldValue.serverTimestamp());
        db.collection("equation").add(equation);
        Log.i("myTag", String.valueOf(equation));
    }


}
