package by.shmat.clienstmodule.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import by.shmat.clienstmodule.R;
import by.shmat.clienstmodule.database.Nationality;

public class NationalityListAdapter extends RecyclerView.Adapter<CityListAdapter.CatalogViewHolder> {

    private List<Nationality> nationalityList;
    private LayoutInflater inflater;
    private Context context;

    public NationalityListAdapter(List<Nationality> nationalityList, Context context) {
        this.nationalityList = nationalityList;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public CityListAdapter.CatalogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = inflater.inflate(R.layout.simple_list_item, parent, false);
        return new CityListAdapter.CatalogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CityListAdapter.CatalogViewHolder catalogViewHolder, int position) {
        final Nationality nationality = nationalityList.get(position);

        catalogViewHolder.nameView.setText(nationality.getName());
        catalogViewHolder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //final long cityID = cityList.get(catalogViewHolder.getAdapterPosition()).getId();
                //startBasketProductViewActivity(cityID);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nationalityList.size();
    }

    public static class CatalogViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView;
        final LinearLayout parentView;

        public CatalogViewHolder(View view) {
            super(view);
            parentView = (LinearLayout) view.findViewById(R.id.simple_parent_layout);
            nameView = (TextView) view.findViewById(R.id.simple_name_text);
        }
    }

}
