package com.paxdron.testdcti;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.paxdron.testdcti.model.Animal;
import com.paxdron.testdcti.model.AnimalTable;

import java.util.List;

/**
 * Created by Antonio on 22/02/2017.
 */

public class AnimalsTableAdapter extends ArrayAdapter {
	private Context context;
	private List<AnimalTable> animals;
	private AnimalTable current;

	public AnimalsTableAdapter(Context context, List objects) {
		super(context, R.layout.animal_table_item, objects);
		this.context=context;
		this.animals=objects;
	}

	@NonNull
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater layoutInflater= LayoutInflater.from(context);
		View item = layoutInflater.inflate(R.layout.animal_table_item,null);
		CheckBox cbSel=(CheckBox)item.findViewById(R.id.selectAnimal);
		TextView naabCode= (TextView)item.findViewById(R.id.naabCode);
		TextView name= (TextView)item.findViewById(R.id.name);
		TextView RegName= (TextView)item.findViewById(R.id.RegName);
		current=animals.get(position);
		cbSel.setChecked(((AnimalTable)current).isSelected());
		naabCode.setText(current.getNaabCode());
		name.setText(current.getName());
		RegName.setText(current.getRegName());
		cbSel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				((AnimalTable)current).setSelected(isChecked);
			}
		});
		return item;
	}
}
