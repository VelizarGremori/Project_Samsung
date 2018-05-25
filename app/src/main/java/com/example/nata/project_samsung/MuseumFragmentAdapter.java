package com.example.nata.project_samsung;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.List;

public class MuseumFragmentAdapter extends RecyclerView.Adapter<MuseumFragmentAdapter.MuseumViewHolder>{

    private List<Showplace> showplaces, showplacesCopy;
    private Context context;

    public MuseumFragmentAdapter(List<Showplace> showplaces, Context context) {
        this.showplaces = showplaces;
        this.context = context;
        this.showplacesCopy = showplaces;
        Log.d("RVDebug", "RVCreate");
    }

    @Override
    public MuseumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Создаю view для каждого элемента в Recycle
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_rv, parent, false);
        return new MuseumViewHolder(view);
    }

//    Обработка каждого элемента на эране
    @Override
    public void onBindViewHolder(final MuseumViewHolder holder, int position) {

        final Showplace showplace =showplaces.get(position);

        holder.txtTitle.setText(showplace.getTitle());


        if(showplace.getDescription().length()>150){
            holder.txtDescription.setText(showplace.getDescription().substring(0, 150));
        }else {holder.txtDescription.setText(showplace.getDescription());}


        if(showplace.getImage()!=null){
            int resID = ((Activity)context).getResources().getIdentifier(showplace.getImage() , "drawable", "com.example.nata.project_samsung");
            holder.imgView.setImageResource(resID);}

        holder.cardViewClickListener.setRecord(showplace);

    }

    @Override
    public int getItemCount() {
        return showplaces.size();
    }

    class MuseumViewHolder extends RecyclerView.ViewHolder{

        TextView txtTitle, txtDescription;
        ImageView imgView;
        CardView cardView;

//        Инициализация слушателей
        CardViewClickListener cardViewClickListener = new CardViewClickListener();



        public MuseumViewHolder(View itemView) {
            super(itemView);

            txtTitle=itemView.findViewById(R.id.txt_rv_title);
            txtDescription=itemView.findViewById(R.id.txt_rv_description);
            imgView=itemView.findViewById(R.id.img_rv);
            cardView=itemView.findViewById(R.id.cv_rv);

            cardView.setOnClickListener(cardViewClickListener);

        }
    }

//    Метод для поиска с помошью SearchView
//public void filter(String text) {
//    showplaces.clear();
//    if(text.isEmpty()){
//        showplaces.addAll(showplacesCopy);
//    } else{
//        text = text.toLowerCase();
//        for(Showplace showplace: showplacesCopy){
//            if(showplace.title.toLowerCase().contains(text) ||
//                    showplace.description.toLowerCase().contains(text) ||
//                    showplace.address.toLowerCase().contains(text)){
//                showplaces.add(showplace);
//            }
//        }
//    }
//    notifyDataSetChanged();
//}




//    Обработка нажатий

        class CardViewClickListener implements View.OnClickListener{

            private Showplace showplace;

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShowplaceActivity.class);
                intent.putExtra("id", showplace.id);
                context.startActivity(intent);

            }


            void setRecord(Showplace showplace){
                this.showplace=showplace;
            }

        }
}
