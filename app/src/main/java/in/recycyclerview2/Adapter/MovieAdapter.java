package in.recycyclerview2.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import in.recycyclerview2.Model.Movie;
import in.recycyclerview2.R;
import in.recycyclerview2.ViewHolder.MenuItemClickListener;

/**
 * Created by HP on 15-Dec-17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHOlder> {

    private Context context;
    private List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movieList){
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public MyViewHOlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card, parent, false);

        return new MyViewHOlder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHOlder holder, int position) {

        Movie movie = movieList.get(position);
        holder.name.setText(movie.getName());
        holder.rating.setText("Rating: "+String.valueOf( movie.getRating()));


        Glide.with(context).load(movie.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ShowPopupMenu(v);
            }
        });


    }


    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHOlder extends RecyclerView.ViewHolder{
        public TextView name, rating;
        public ImageView thumbnail, overflow;

        public MyViewHOlder(View v){
            super(v);

            name = v.findViewById(R.id.name);
            rating = v.findViewById(R.id.rating);
            thumbnail = v.findViewById(R.id.thumbnail);
            overflow = v.findViewById(R.id.overflow);
        }
    }

    private void ShowPopupMenu(View view){
        PopupMenu popupMenu = new PopupMenu(context, view);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.movie_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new MenuItemClickListener(context));

        popupMenu.show();
    }
}

