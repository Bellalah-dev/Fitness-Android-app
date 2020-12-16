package com.example.fitnesscoach;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Profil extends AppCompatActivity {
    private String photopath=null;
    String mCurrentPhotoPath;
    static final int PICTURE_RESULT = 1;
    protected static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 0;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;
    static final int RESULT_LOAD_IMG = 1;
    private static final String TAG = "Profil ";
    private EditText mDisplayDate, Name, Age, heigth, weigth, Imc;
    private RadioButton femme, homme;
    ImageView imageView;
    private Button calcul, photo;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Uri file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        mDisplayDate = (EditText) findViewById(R.id.tvDate);
        Name = (EditText) findViewById(R.id.btn_nom);
        Age = (EditText) findViewById(R.id.btn_age);
        heigth = (EditText) findViewById(R.id.hauteur);
        weigth = (EditText) findViewById(R.id.poids);
        Imc=(EditText) findViewById(R.id.imc);
        femme = (RadioButton) findViewById(R.id.Radio_femme);
        homme = (RadioButton) findViewById(R.id.radio_homme);
        imageView = (ImageView) findViewById(R.id.image);
        calcul=(Button)findViewById(R.id.btn_calcul);
        calcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float p= Float.parseFloat(weigth.getText().toString());
                float h=Float.parseFloat(heigth.getText().toString())/100;
                float res= p/(h*h);

                Imc.setText(""+res);
                if (res> 18.5 && res<25 ) {
                    Toast.makeText(Profil.this,getString(R.string.commentaire),Toast.LENGTH_LONG ).show();
                } else if( res>25 && res<30)
                { Toast.makeText(Profil.this,"surpoids",Toast.LENGTH_LONG ).show(); }
                 else if (res<18.5)
                 {
                     Toast.makeText(Profil.this,"maigreur",Toast.LENGTH_LONG ).show();
                 }
                 else Toast.makeText(Profil.this,"obésité modérée",Toast.LENGTH_LONG ).show();
            }

        });

        photo = (Button) findViewById(R.id.btn2);

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Profil.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };
    }




    public void Save(View view) {
        String nom= Name.getText().toString();
        String agstr= Age.getText().toString();
        int age=Integer.parseInt(agstr);
        String poids= weigth.getText().toString();
        float Weight=Float.parseFloat(poids);
        String seize= heigth.getText().toString();
        int height=Integer.parseInt(seize);
        String radio_fem=femme.getText().toString();
        String radi_homme=homme.getText().toString();
        String BMI=Imc.getText().toString();
        float imc=Float.parseFloat(BMI);
        SharedPreferences sh=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editeur=sh.edit();
        editeur.putString("nom",nom);
        editeur.putInt("age",age);
        editeur.putFloat("poids", Weight);
        editeur.putInt("seize",height);
        editeur.putString("femme",radio_fem);
        editeur.putString("homme",radi_homme);
        editeur.putFloat("imc",imc);
        editeur.apply();


    }

    private void selectImage() {
        final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(Profil.this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo"))
                {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    String time=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                    File f = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                    try{
                    File photo=File.createTempFile("photo"+time, ".jpg",f);
                    photopath=photo.getAbsolutePath();
                    Uri photoUri= FileProvider.getUriForFile(Profil.this,
                            Profil.this.getApplicationContext().getOpPackageName()+".provider",photo);
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                        startActivityForResult(intent, 1);
                    }
                    catch (IOException e){ e.printStackTrace();}


                }
                else if (options[item].equals("Choose from Gallery"))
                {
                    Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);
                }
                else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds options to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
               Bitmap image=BitmapFactory.decodeFile(photopath);
               imageView.setImageBitmap(image);
            } else if (requestCode == 2) {
                Uri selectedImage = data.getData();
                String[] filePath = { MediaStore.Images.Media.DATA };
                Cursor c = getContentResolver().query(selectedImage,filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                Log.w("path of image from gallery......******************.........", picturePath+"");
                imageView.setImageBitmap(thumbnail);
            }
        }
    }
}


