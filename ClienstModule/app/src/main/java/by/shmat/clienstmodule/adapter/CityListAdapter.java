package by.shmat.clienstmodule.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

import static android.app.Activity.RESULT_OK;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.ViewHolder> {

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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = inflater.inflate(R.layout.simple_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        final City city = cityList.get(position);

        viewHolder.nameView.setText(city.getName());
        viewHolder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("cityName", cityList.get(viewHolder.getAdapterPosition()).getName());
                ((Activity) context).setResult(RESULT_OK, intent);
                ((Activity) context).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView;
        final LinearLayout parentView;

        public ViewHolder(View view) {
            super(view);
            parentView = (LinearLayout) view.findViewById(R.id.simple_parent_layout);
            nameView = (TextView) view.findViewById(R.id.simple_name_text);
        }
    }

}
