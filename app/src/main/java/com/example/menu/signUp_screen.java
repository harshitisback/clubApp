package com.example.menu;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;


public class signUp_screen extends AppCompatActivity {
    ImageView profile;
    EditText name, email , mobile, pass, confPass;
    String Name, Email, Mobile, Pass, ConfPass, ProfileImg , uid;
    Button submit;
    ActivityResultLauncher<String> takeImage;
    private Bitmap bitmap;

    private FirebaseAuth auth;
    private DatabaseReference dbReference;
    private DatabaseReference dbRef;
    private StorageReference sReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        findingId();

        auth = FirebaseAuth.getInstance();
        dbReference = FirebaseDatabase.getInstance().getReference();
        sReference = FirebaseStorage.getInstance().getReference();

        takeImage = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        try {
                            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        profile.setImageBitmap(bitmap);
                    }
                }
        );

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeImage.launch("image/*");
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile.setEnabled(false);
                validateData();
            }
        });





    }

 // outer methods

//    @Override
//    protected void onStart() {
//        super.onStart();
//        if(auth.getCurrentUser() != null){
//            openHomeScreen();
//        }
//    }

    private void openHomeScreen() {
        startActivity(new Intent(signUp_screen.this, MainActivity.class));
    }

    private void findingId() {
        profile = (ImageView) findViewById(R.id.login_scree);
        name = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.enteremail);
        mobile = findViewById(R.id.entermobileno);
        pass = findViewById(R.id.enterpass);
        confPass = findViewById(R.id.confirmpass);
        submit = findViewById(R.id.button4);

    }

    private void validateData() {
        Name = name.getText().toString();
        Email = email.getText().toString();
        Mobile = mobile.getText().toString();
        Pass = pass.getText().toString();
        ConfPass = confPass.getText().toString();

        if (bitmap == null){
            profile.setEnabled(true);
            Toast.makeText(signUp_screen.this, "Please select the image" , Toast.LENGTH_SHORT).show();
        }else if(Name.isEmpty()){
            submit.setEnabled(true);
            name.setError("Required");
            name.requestFocus();
        }else if(Email.isEmpty()){
            submit.setEnabled(true);
            email.setError("Required");
            email.requestFocus();
        }else if(Mobile.isEmpty()){
            submit.setEnabled(true);
            mobile.setError("Required");
            mobile.requestFocus();
        }else if(Pass.isEmpty()){
            submit.setEnabled(true);
            pass.setError("Required");
            pass.requestFocus();
        }else if(ConfPass.isEmpty()){
            submit.setEnabled(true);
            confPass.setError("Required");
            confPass.requestFocus();
        }else {
            createUser();
        }

    }

    private void createUser() {
        auth.createUserWithEmailAndPassword(Email, Pass)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        FirebaseUser currentUser = auth.getCurrentUser();
                        if (currentUser != null) {
                            uid = currentUser.getUid();
                        }else {
                            uid = "NULL_"+ UUID.randomUUID();
                        }
//                        uploadUserData();
                        uploadUserImage();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        submit.setEnabled(true);
                        Toast.makeText(signUp_screen.this, "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }
    private void uploadUserImage() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        byte[] finalImage = baos.toByteArray();
        final StorageReference filePath;
        filePath = sReference.child("Users").child(UUID.randomUUID()+".jpg");

        final UploadTask uploadTask = filePath.putBytes(finalImage);

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                filePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        ProfileImg = String.valueOf(uri);
                        uploadUserData();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(signUp_screen.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void uploadUserData() {
        dbRef = dbReference.child("Users");


        HashMap<String, String> user = new HashMap<>();
        user.put("uid", uid);
        user.put("name", Name);
        user.put("email", Email);
        user.put("mobile", Mobile);
        user.put("password", Pass);
        user.put("imageUrl", ProfileImg);


        dbRef.child(uid).setValue(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        submit.setEnabled(true);
                        Toast.makeText(signUp_screen.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        openHomeScreen();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        submit.setEnabled(true);
                        Toast.makeText(signUp_screen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


}