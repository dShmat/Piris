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
import by.shmat.clienstmodule.database.City;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.CatalogViewHolder> {

    private List<City> cityList;
    private LayoutInflater inflater;
    private Context context;

    public CityListAdapter(List<City> cityList, Context context) {
        this.cityList = cityList;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public CityListAdapter.CatalogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = inflater.inflate(R.layout.city_list_item, parent, false);
        return new CityListAdapter.CatalogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CityListAdapter.CatalogViewHolder catalogViewHolder, int position) {
        final City city = cityList.get(position);

        catalogViewHolder.nameView.setText(city.getName());
        catalogViewHolder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final long cityID = cityList.get(catalogViewHolder.getAdapterPosition()).getId();
                //startBasketProductViewActivity(cityID);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    /*private void startBasketProductViewActivity(long productID) {
        Intent showProductIntent = new Intent(context, BasketProductViewActivity.class);
        showProductIntent.putExtra("productId", productID);
        context.startActivity(showProductIntent);
    }*/

    public static class CatalogViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView;
        final LinearLayout parentView;

        public CatalogViewHolder(View view) {
            super(view);
            parentView = (LinearLayout) view.findViewById(R.id.city_parent_layout);
            nameView = (TextView) view.findViewById(R.id.city_name_text);
        }
    }

}
