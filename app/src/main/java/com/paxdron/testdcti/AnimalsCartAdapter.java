package com.paxdron.testdcti;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.paxdron.testdcti.model.Animal;

import java.util.List;

/**
 * Created by Antonio on 23/02/2017.
 */

public class AnimalsCartAdapter extends RecyclerView.Adapter<AnimalsCartAdapter.ViewHolder> {

	List<Animal> animals;

	public AnimalsCartAdapter(List<Animal> animals) {
		this.animals = animals;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.animal_cart, parent, false);
		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {

	}

	@Override
	public int getItemCount() {
		return animals.size();
	}


	public static class ViewHolder extends RecyclerView.ViewHolder{
		ImageView image;
		public ViewHolder(View itemView) {
			super(itemView);
			//image=(ImageView) itemView.findViewById(R.id.image);
		}
	}
}
