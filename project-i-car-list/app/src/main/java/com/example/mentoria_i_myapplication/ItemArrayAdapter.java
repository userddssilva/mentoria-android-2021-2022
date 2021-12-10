package com.example.mentoria_i_myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ItemArrayAdapter extends ArrayAdapter {
    ArrayList<Cars> cars = new ArrayList<Cars>();

    static class ItemViewHolder {
        TextView mEngineType;
        TextView mNumberForwardGears;
        TextView mModelYear;
        TextView mHorsepower;
    }

    public ItemArrayAdapter(Context context, int id) {
        super(context, id);
    }

    @Override
    public int getCount() {
        return this.cars.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return this.cars.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        ItemViewHolder itemViewHolder;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.content_cars, parent, false);
            itemViewHolder = new ItemViewHolder();
            itemViewHolder.mEngineType = view.findViewById(R.id.engine_type);
            itemViewHolder.mNumberForwardGears = view.findViewById(R.id.numberForward_gears);
            itemViewHolder.mModelYear = view.findViewById(R.id.model_year);
            itemViewHolder.mHorsepower = view.findViewById(R.id.horsepower);
            view.setTag(itemViewHolder);
        } else {
            itemViewHolder = (ItemViewHolder) view.getTag();
        }

        Cars currentCar = (Cars) getItem(position);
        itemViewHolder.mEngineType.setText(currentCar.getEngineType());
        itemViewHolder.mNumberForwardGears.setText(currentCar.getNumberForwardGears());
        itemViewHolder.mModelYear.setText(currentCar.getModelYear());
        itemViewHolder.mHorsepower.setText(currentCar.getHorsepower());

        return view;
    }

    public void add(Cars car) {
        cars.add(car);
        super.add(car);
    }
}
