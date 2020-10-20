package com.example.escritorio.merkapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class FragmentInicio extends Fragment {

    // Variables Globales
    private RecyclerView mRvInicio;
    private ProgressBar mProgInicio;
    private String mUser, key;
    private FloatingActionButton mBtnFlo;
    private ImageView mImgpollo, mImgcarne, mImgpasta, mImgseco, mImgmaris, mImglasa, mImgpica, mImglic;
    private String mCategoria;
    private FirebaseRecyclerAdapter<Datos,DatosViewHolder> firebaseRecyclerAdapter;
    private FirebaseRecyclerAdapter<Datos, PeopleVH> mPeopleRVAdapter;

    private DatabaseReference mReferenciaLista,mRefenciaUsuario;
    private FirebaseAuth mAuth;

    private LinearLayoutManager mLayout;

    public FragmentInicio() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Creamos una vista del layout que usaremos
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        mRefenciaUsuario = FirebaseDatabase.getInstance().getReference().child("usuarios");
        mAuth=FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser().getUid().trim();

        // Enlace de variables
        mRvInicio =(RecyclerView)view.findViewById(R.id.lista);
        mBtnFlo = (FloatingActionButton)view.findViewById(R.id.btnflo);
        mImgpollo = (ImageView)view.findViewById(R.id.imgpollo);
        mImgcarne = (ImageView)view.findViewById(R.id.imgcarne);
        mImgpasta = (ImageView)view.findViewById(R.id.imgpasta);
        mImgseco = (ImageView)view.findViewById(R.id.imgseco);
        mImgmaris = (ImageView)view.findViewById(R.id.imgmaris);
        mImglasa = (ImageView)view.findViewById(R.id.imglasa);
        mImgpica = (ImageView)view.findViewById(R.id.imgpica);
        mImglic = (ImageView)view.findViewById(R.id.imglic);
        mRvInicio.setHasFixedSize(true);

        mProgInicio = (ProgressBar)view.findViewById(R.id.progress);
        mLayout =new GridLayoutManager(getActivity(),2);

        mRvInicio.setLayoutManager(mLayout);

        mBtnFlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getContext(),ActivityProducto.class));

            }
        });

        Drawable originalDrawable = getResources().getDrawable(R.drawable.pollo);
        Drawable originalDrawable3 = getResources().getDrawable(R.drawable.carne);
        Drawable originalDrawable2 = getResources().getDrawable(R.drawable.pastas);
        Drawable originalDrawable4 = getResources().getDrawable(R.drawable.sec);
        Drawable originalDrawable5 = getResources().getDrawable(R.drawable.mar);
        Drawable originalDrawable6 = getResources().getDrawable(R.drawable.lasa);
        Drawable originalDrawable7 = getResources().getDrawable(R.drawable.pic);
        Drawable originalDrawable8 = getResources().getDrawable(R.drawable.lic);


        Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();
        Bitmap originalBitmap2 = ((BitmapDrawable) originalDrawable2).getBitmap();
        Bitmap originalBitmap3 = ((BitmapDrawable) originalDrawable3).getBitmap();
        Bitmap originalBitmap4 = ((BitmapDrawable) originalDrawable4).getBitmap();
        Bitmap originalBitmap5 = ((BitmapDrawable) originalDrawable5).getBitmap();
        Bitmap originalBitmap6 = ((BitmapDrawable) originalDrawable6).getBitmap();
        Bitmap originalBitmap7 = ((BitmapDrawable) originalDrawable7).getBitmap();
        Bitmap originalBitmap8 = ((BitmapDrawable) originalDrawable8).getBitmap();


        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(getResources(), originalBitmap);

        //asignamos el CornerRadius
        roundedDrawable.setCornerRadius(originalBitmap.getHeight());

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable2 =
                RoundedBitmapDrawableFactory.create(getResources(), originalBitmap2);

        //asignamos el CornerRadius
        roundedDrawable2.setCornerRadius(originalBitmap3.getHeight());

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable3 =
                RoundedBitmapDrawableFactory.create(getResources(), originalBitmap3);

        //asignamos el CornerRadius
        roundedDrawable3.setCornerRadius(originalBitmap3.getHeight());

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable4 =
                RoundedBitmapDrawableFactory.create(getResources(), originalBitmap4);

        //asignamos el CornerRadius
        roundedDrawable4.setCornerRadius(originalBitmap3.getHeight());

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable5 =
                RoundedBitmapDrawableFactory.create(getResources(), originalBitmap5);

        //asignamos el CornerRadius
        roundedDrawable5.setCornerRadius(originalBitmap3.getHeight());

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable6 =
                RoundedBitmapDrawableFactory.create(getResources(), originalBitmap6);

        //asignamos el CornerRadius
        roundedDrawable6.setCornerRadius(originalBitmap3.getHeight());

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable7 =
                RoundedBitmapDrawableFactory.create(getResources(), originalBitmap7);

        //asignamos el CornerRadius
        roundedDrawable7.setCornerRadius(originalBitmap3.getHeight());

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable8 =
                RoundedBitmapDrawableFactory.create(getResources(), originalBitmap8);

        //asignamos el CornerRadius
        roundedDrawable8.setCornerRadius(originalBitmap3.getHeight());

        mImgpollo.setImageDrawable(roundedDrawable);
        mImgcarne.setImageDrawable(roundedDrawable2);
        mImgpasta.setImageDrawable(roundedDrawable3);
        mImgseco.setImageDrawable(roundedDrawable4);
        mImgmaris.setImageDrawable(roundedDrawable5);
        mImglasa.setImageDrawable(roundedDrawable6);
        mImgpica.setImageDrawable(roundedDrawable7);
        mImglic.setImageDrawable(roundedDrawable8);

        mImgpollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCategoria = "pollo";
                mRvInicio.setVisibility(View.VISIBLE);
                mProgInicio.setVisibility(View.VISIBLE);
                mRefenciaUsuario.child(mUser).child("categoria").setValue(mCategoria);
            }
        });
        mImgcarne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCategoria = "carne";
                mRvInicio.setVisibility(View.VISIBLE);
                mProgInicio.setVisibility(View.VISIBLE);
                mRefenciaUsuario.child(mUser).child("categoria").setValue(mCategoria);
            }
        });
        mImgpasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCategoria = "pastas";
                mRvInicio.setVisibility(View.VISIBLE);
                mProgInicio.setVisibility(View.VISIBLE);
                mRefenciaUsuario.child(mUser).child("categoria").setValue(mCategoria);
            }
        });
        mImgseco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCategoria = "secos";
                mRvInicio.setVisibility(View.VISIBLE);
                mProgInicio.setVisibility(View.VISIBLE);
                mRefenciaUsuario.child(mUser).child("categoria").setValue(mCategoria);
            }
        });
        mImgmaris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCategoria = "mariscos";
                mRvInicio.setVisibility(View.VISIBLE);
                mProgInicio.setVisibility(View.VISIBLE);
                mRefenciaUsuario.child(mUser).child("categoria").setValue(mCategoria);
            }
        });
        mImglasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCategoria = "lasañas";
                mRvInicio.setVisibility(View.VISIBLE);
                mProgInicio.setVisibility(View.VISIBLE);
                mRefenciaUsuario.child(mUser).child("categoria").setValue(mCategoria);
            }
        });
        mImgpica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCategoria = "picaditas y ensaladas";
                mRvInicio.setVisibility(View.VISIBLE);
                mProgInicio.setVisibility(View.VISIBLE);
                mRefenciaUsuario.child(mUser).child("categoria").setValue(mCategoria);
            }
        });
        mImglic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCategoria = "licores";
                mRvInicio.setVisibility(View.VISIBLE);
                mProgInicio.setVisibility(View.VISIBLE);
                mRefenciaUsuario.child(mUser).child("categoria").setValue(mCategoria);
            }
        });

        mRefenciaUsuario.child(mUser).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null){

                    if (dataSnapshot.child("tipousu").exists()&& dataSnapshot.child("tipousu").getValue().toString().equals("Administrador")){

                        mBtnFlo.setVisibility(View.VISIBLE);

                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }

    @Override
    public void onStart(){
        super.onStart();


        mRefenciaUsuario.child(mUser).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot!=null){

                    if (dataSnapshot.child("categoria").exists() && dataSnapshot.child("categoria").getValue().toString().trim()!=null){

                        if (mCategoria!=null){
                            mReferenciaLista = FirebaseDatabase.getInstance().getReference().child("productos").child(mCategoria);

                            Query personsQuery = mReferenciaLista.orderByKey();

                            FirebaseRecyclerOptions<Datos> options = new FirebaseRecyclerOptions.Builder<Datos>().setQuery(personsQuery, Datos.class).build();

                            mPeopleRVAdapter = new FirebaseRecyclerAdapter<Datos, FragmentInicio.PeopleVH>(options) {
                                @Override
                                protected void onBindViewHolder(PeopleVH holder, @SuppressLint("RecyclerView") final int position, Datos model) {

                                    if (holder != null && model!=null){

                                        mProgInicio.setVisibility(View.GONE);
                                        holder.setImgp(getActivity(),model.getImgp());
                                        holder.setPreciop(model.getPreciop());
                                        holder.setCarritop(getActivity(),model.getCarritop());
                                        holder.setNombrep(model.getNombrep());

                                        holder.mView.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {

                                                key = getRef(position).getKey();

                                                Intent intent = new Intent(getContext(),ActivityDetalles.class);
                                                intent.putExtra("ID",key);
                                                startActivity(intent);

                                            }
                                        });


                                    }

                                }

                                @Override
                                public FragmentInicio.PeopleVH onCreateViewHolder(ViewGroup parent, int viewType) {

                                    View view = LayoutInflater.from(parent.getContext())
                                            .inflate(R.layout.cartaprincipal, parent, false);

                                    return new PeopleVH(view);
                                }
                            };
                            mPeopleRVAdapter.startListening();
                            mRvInicio.setAdapter(mPeopleRVAdapter);
                        }
                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private static class DatosViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public DatosViewHolder(View itemView) {

            super(itemView);
            mView=itemView;
        }

    }

    private class PeopleVH extends RecyclerView.ViewHolder {

        View mView;
        PeopleVH(View view) {
            super(view);

            mView = view;
        }

        void setImgp(Context context, String imgp){

            if (imgp!=null){
                ImageView imagenP= (ImageView)mView.findViewById(R.id.imgproducto);
                Glide.with(context).load(imgp).into(imagenP);

            }

        }

        void setNombrep(String nombrep){
            if (nombrep!=null){
                TextView viewnombre=(TextView)mView.findViewById(R.id.txtnompro);
                viewnombre.setText(nombrep);
            }

        }

        void setPreciop(String preciop){

            if (preciop!=null){
                TextView viewprecio=(TextView)mView.findViewById(R.id.txtpreper);
                viewprecio.setText(preciop);

            }

        }

        void setCarritop(final Context context, String carritop){
            final ImageView viewcarrito=(ImageView) mView.findViewById(R.id.imgcar);

            if (carritop!=null){

                if (carritop.equals("no")){
                    viewcarrito.setImageResource(R.drawable.vcar);
                    viewcarrito.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            viewcarrito.setImageResource(R.drawable.vcar2);
                            Toast.makeText(context, "Carga Completa!", Toast.LENGTH_LONG).show();

                        }
                    });

                }
                else if (carritop.equals("si")){
                    viewcarrito.setImageResource(R.drawable.vcar2);
                    viewcarrito.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            viewcarrito.setImageResource(R.drawable.vcar);
                            Toast.makeText(context, "Carga Completa!", Toast.LENGTH_LONG).show();

                        }
                    });

                }
            }

        }

    }

    @Override
    public void onStop() {
        super.onStop();
        mPeopleRVAdapter.stopListening();
    }

}
