package com.example.nata.project_samsung;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentAdapter.HomeViewHolder> {

    private List<Showplace> showplaces;
    private Context context;

    public HomeFragmentAdapter(List<Showplace> showplaces, Context context) {
        this.showplaces = showplaces;
        this.context = context;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_content_rv, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {

        final Showplace showplace = showplaces.get(position);

        holder.txtTitle.setText(showplace.getTitle());
        holder.txtAddress.setText(showplace.getAddress());
        if(showplace.getImage()!=null){
            int resID = ((Activity)context)
                    .getResources()
                    .getIdentifier
                            (showplace.getImage(),
                                    "drawable",
                                    "com.example.nata.project_samsung");
            holder.imgView.setImageResource(resID);
        }
        holder.cardViewClickListener.setRecord(showplace);
    }

    @Override
    public int getItemCount() {
        return showplaces.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle, txtAddress;
        ImageView imgView;
        CardView cardView;

        CardHomeViewClickListener cardViewClickListener = new CardHomeViewClickListener();


        public HomeViewHolder(View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.title_home);
            txtAddress = itemView.findViewById(R.id.address_home);
            imgView = itemView.findViewById(R.id.img_rv_home);
            cardView = itemView.findViewById(R.id.home_content_rv);

            cardView.setOnClickListener(cardViewClickListener);
        }
    }

    //    Обработка нажатий

    class CardHomeViewClickListener implements View.OnClickListener{

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
