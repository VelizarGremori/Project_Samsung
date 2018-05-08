package com.example.nata.project_samsung;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ShowplaceViewHolder>{

    private List<Showplace> showplaces, showplacesCopy;
    private Context context;

    public RVAdapter(List<Showplace> showplaces, Context context) {
        this.showplaces = showplaces;
        this.context = context;
        this.showplacesCopy = showplaces;
    }

    @Override
    public ShowplaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Создаю view для каждого элемента в Recycle
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_rv, parent, false);
        return new ShowplaceViewHolder(view);
    }

//    Обработка каждого элемента на эране
    @Override
    public void onBindViewHolder(ShowplaceViewHolder holder, int position) {

        final Showplace showplace =showplaces.get(position);

        holder.txtTitle.setText(showplace.getTitle());
        holder.txtDescription.setText(showplace.getDescription());
//        НАПИСАТЬ ОБРАБОТКУ КАРТИНКИ

        holder.cardViewClickListener.setRecord(showplace);

    }

    @Override
    public int getItemCount() {
        return showplaces.size();
    }

    class ShowplaceViewHolder extends RecyclerView.ViewHolder{

        TextView txtTitle, txtDescription;
        Button btnRemove;
        CardView cardView;

//        Инициализация слушателей
        CardViewClickListener cardViewClickListener = new CardViewClickListener();



        public ShowplaceViewHolder(View itemView) {
            super(itemView);

            txtTitle=itemView.findViewById(R.id.txt_rv_title);
            txtDescription=itemView.findViewById(R.id.txt_rv_description);
            btnRemove=itemView.findViewById(R.id.btn_rv_remove);
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
                context.startActivity(intent);

            }


            void setRecord(Showplace showplace){
                this.showplace=showplace;
            }

        }
}
