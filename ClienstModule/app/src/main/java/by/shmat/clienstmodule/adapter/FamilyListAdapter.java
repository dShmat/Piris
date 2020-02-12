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
import by.shmat.clienstmodule.database.FamilyPosition;

public class FamilyListAdapter extends RecyclerView.Adapter<FamilyListAdapter.CatalogViewHolder> {

    private List<FamilyPosition> familyPositionList;
    private LayoutInflater inflater;
    private Context context;

    public FamilyListAdapter(List<FamilyPosition> familyPositionList, Context context) {
        this.familyPositionList = familyPositionList;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public FamilyListAdapter.CatalogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = inflater.inflate(R.layout.simple_list_item, parent, false);
        return new FamilyListAdapter.CatalogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FamilyListAdapter.CatalogViewHolder catalogViewHolder, int position) {
        final FamilyPosition familyPosition = familyPositionList.get(position);

        catalogViewHolder.nameView.setText(familyPosition.getName());
        catalogViewHolder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //final long cityID = familyPositionList.get(catalogViewHolder.getAdapterPosition()).getId();
                //startBasketProductViewActivity(cityID);
            }
        });
    }

    @Override
    public int getItemCount() {
        return familyPositionList.size();
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
