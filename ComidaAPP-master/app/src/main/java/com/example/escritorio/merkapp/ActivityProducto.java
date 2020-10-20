package com.example.escritorio.merkapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class ActivityProducto extends AppCompatActivity {

        private DatabaseReference mReference;
        private FirebaseAuth mAuth;
        private String mUser, mNombre, mPrecio, mUrl, mCategoria, mDes;
        private StorageReference referenciaIMG;

        private EditText mEditnombre, mEditPrecio, mEditDes;
        private ImageView mImgPro, mImgpollo, mImgcarne, mImgpasta, mImgseco,mImgmariscos,mImglasa,mImgpica, mImglic;
        private static final int GALLERY_REGUEST = 1;
        private Uri mUrlPerfil;
        private ProgressDialog mProgres;
        private Button mBtnCargar;
        private TextView mTxtSeleccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);


        // Referencia a la base de datos y al Storage de las imagenes
        referenciaIMG = FirebaseStorage.getInstance().getReference();
        mReference = FirebaseDatabase.getInstance().getReference().child("productos");
        mAuth=FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser().getUid().trim();


        mTxtSeleccion = (TextView)findViewById(R.id.txtseleccione);
        mEditnombre = (EditText)findViewById(R.id.txtnompp);
        mEditDes = (EditText)findViewById(R.id.txtdespp);
        mEditPrecio = (EditText)findViewById(R.id.txtpreciopp);
        mImgPro = (ImageView)findViewById(R.id.imgprop);

        mImgpollo = (ImageView)findViewById(R.id.imgpollo);
        mImgcarne = (ImageView)findViewById(R.id.imgCarn);
        mImgpasta = (ImageView)findViewById(R.id.imgpasta);

        mImgseco = (ImageView)findViewById(R.id.imgseco);
        mImgmariscos = (ImageView)findViewById(R.id.imgMaris);
        mImglasa = (ImageView)findViewById(R.id.imglasa);
        mImgpica = (ImageView)findViewById(R.id.imgpica);
        mImglic = (ImageView)findViewById(R.id.imglic);


        mBtnCargar = (Button)findViewById(R.id.btncargarp);
        Toolbar toolbar = (Toolbar)findViewById(R.id.tbladd);

        mProgres = new ProgressDialog(this);

        // Se Accede a la galeria para elegir una imagen
        mImgPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentimg = new Intent(Intent.ACTION_GET_CONTENT);
                intentimg.setType("image/*");
                startActivityForResult(intentimg, GALLERY_REGUEST);
            }
        });
        // Seleccion de categoria
        mImgpollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTxtSeleccion.setText("Carge una foto de referencia");
                mCategoria = "pizza";
                mImgPro.setVisibility(View.VISIBLE);
                mImgpollo.setVisibility(View.GONE);
                mImgcarne.setVisibility(View.GONE);
                mImgpasta.setVisibility(View.GONE);
                mImgseco.setVisibility(View.GONE);
                mImgmariscos.setVisibility(View.GONE);
                mImglasa.setVisibility(View.GONE);
                mImgpica.setVisibility(View.GONE);
                mImglic.setVisibility(View.GONE);


            }
        });
        // Seleccion de categoria
        mImgcarne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTxtSeleccion.setText("Carge una foto de referencia");
                mCategoria = "hamburgesa";
                mImgPro.setVisibility(View.VISIBLE);
                mImgpollo.setVisibility(View.GONE);
                mImgcarne.setVisibility(View.GONE);
                mImgpasta.setVisibility(View.GONE);
                mImgseco.setVisibility(View.GONE);
                mImgmariscos.setVisibility(View.GONE);
                mImglasa.setVisibility(View.GONE);
                mImgpica.setVisibility(View.GONE);
                mImglic.setVisibility(View.GONE);
            }
        });
        // Seleccion de categoria
        mImgpasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTxtSeleccion.setText("Carge una foto de referencia");
                mCategoria = "comidac";
                mImgPro.setVisibility(View.VISIBLE);
                mImgpollo.setVisibility(View.GONE);
                mImgcarne.setVisibility(View.GONE);
                mImgpasta.setVisibility(View.GONE);
                mImgseco.setVisibility(View.GONE);
                mImgmariscos.setVisibility(View.GONE);
                mImglasa.setVisibility(View.GONE);
                mImgpica.setVisibility(View.GONE);
                mImglic.setVisibility(View.GONE);
            }
        });
        // Seleccion de categoria
        mImgseco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTxtSeleccion.setText("Carge una foto de referencia");
                mCategoria = "comidac";
                mImgPro.setVisibility(View.VISIBLE);
                mImgpollo.setVisibility(View.GONE);
                mImgcarne.setVisibility(View.GONE);
                mImgpasta.setVisibility(View.GONE);
                mImgseco.setVisibility(View.GONE);
                mImgmariscos.setVisibility(View.GONE);
                mImglasa.setVisibility(View.GONE);
                mImgpica.setVisibility(View.GONE);
                mImglic.setVisibility(View.GONE);
            }
        });
        // Seleccion de categoria
        mImgmariscos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTxtSeleccion.setText("Carge una foto de referencia");
                mCategoria = "comidac";
                mImgPro.setVisibility(View.VISIBLE);
                mImgpollo.setVisibility(View.GONE);
                mImgcarne.setVisibility(View.GONE);
                mImgpasta.setVisibility(View.GONE);
                mImgseco.setVisibility(View.GONE);
                mImgmariscos.setVisibility(View.GONE);
                mImglasa.setVisibility(View.GONE);
                mImgpica.setVisibility(View.GONE);
                mImglic.setVisibility(View.GONE);
            }
        });
        // Seleccion de categoria
        mImglasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTxtSeleccion.setText("Carge una foto de referencia");
                mCategoria = "comidac";
                mImgPro.setVisibility(View.VISIBLE);
                mImgpollo.setVisibility(View.GONE);
                mImgcarne.setVisibility(View.GONE);
                mImgpasta.setVisibility(View.GONE);
                mImgseco.setVisibility(View.GONE);
                mImgmariscos.setVisibility(View.GONE);
                mImglasa.setVisibility(View.GONE);
                mImgpica.setVisibility(View.GONE);
                mImglic.setVisibility(View.GONE);
            }
        });
        // Seleccion de categoria
        mImgpica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTxtSeleccion.setText("Carge una foto de referencia");
                mCategoria = "comidac";
                mImgPro.setVisibility(View.VISIBLE);
                mImgpollo.setVisibility(View.GONE);
                mImgcarne.setVisibility(View.GONE);
                mImgpasta.setVisibility(View.GONE);
                mImgseco.setVisibility(View.GONE);
                mImgmariscos.setVisibility(View.GONE);
                mImglasa.setVisibility(View.GONE);
                mImgpica.setVisibility(View.GONE);
                mImglic.setVisibility(View.GONE);
            }
        });
        // Seleccion de categoria
        mImglic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTxtSeleccion.setText("Carge una foto de referencia");
                mCategoria = "comidac";
                mImgPro.setVisibility(View.VISIBLE);
                mImgpollo.setVisibility(View.GONE);
                mImgcarne.setVisibility(View.GONE);
                mImgpasta.setVisibility(View.GONE);
                mImgseco.setVisibility(View.GONE);
                mImgmariscos.setVisibility(View.GONE);
                mImglasa.setVisibility(View.GONE);
                mImgpica.setVisibility(View.GONE);
                mImglic.setVisibility(View.GONE);
            }
        });

        mBtnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                publicar();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REGUEST && resultCode == RESULT_OK) {
            mUrlPerfil = data.getData();
            mImgPro.setImageURI(mUrlPerfil);

        }
    }

    private void publicar(){
        mNombre = mEditnombre.getText().toString();
        mPrecio = mEditPrecio.getText().toString();
        mDes = mEditDes.getText().toString();

        if (mNombre != null && mPrecio!=null && mCategoria != null){

            mProgres.setMessage("Cargando...");
            mProgres.show();
            mProgres.setCanceledOnTouchOutside(false);
            // Carga de datos
            final DatabaseReference referencia = mReference.child(mCategoria).push();
            // El parametro "PUSH" se utiliza para generar una clave aleatoria
            referencia.child("nombrep").setValue(mNombre);
            referencia.child("preciop").setValue(mPrecio);
            referencia.child("descripcion").setValue(mDes);
            referencia.child("carritop").setValue("no");

            // Referencia al Storage donde se guardan las imagenes
            StorageReference carpetaperfil = referenciaIMG.child("Imagenes_perfil").child(mUrlPerfil.getLastPathSegment());
            carpetaperfil.putFile(mUrlPerfil).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    // Extraccion de la url donde esta la imagen
                    Uri descargarimg = taskSnapshot.getDownloadUrl();

                    if (descargarimg != null) {

                        referencia.child("imgp").setValue(descargarimg.toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isComplete()){

                                    mProgres.dismiss();

                                    Toast.makeText(getApplicationContext(), "Carga Completa!", Toast.LENGTH_LONG).show();
                                    Intent volver = new Intent(getApplicationContext(), ActivityPrincipal.class);
                                    volver.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(volver);

                                }
                            }
                        });
                    }

                }
            });

        }

    }
}
