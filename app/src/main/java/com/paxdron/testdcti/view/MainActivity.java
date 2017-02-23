package com.paxdron.testdcti.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.paxdron.testdcti.AnimalsTableAdapter;
import com.paxdron.testdcti.CartActivity;
import com.paxdron.testdcti.R;
import com.paxdron.testdcti.SearchActivity;
import com.paxdron.testdcti.model.Animal;
import com.paxdron.testdcti.model.AnimalTable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	public static final String SELECTED_ANIMALS = "SEL_AN";
	private List<Animal> animals;
	private CheckBox cbSelAll;
	private AnimalsTableAdapter animalsTableAdapter;
	private ListView lvAnimals;
	private TextView tvNoAnimals;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		animals= new ArrayList<>();
		initializeList();
		cbSelAll=(CheckBox)findViewById(R.id.selectAll);
		lvAnimals=(ListView)findViewById(R.id.lvAnimales);
		tvNoAnimals=(TextView)findViewById(R.id.tvNoAnimals);
		animalsTableAdapter = new AnimalsTableAdapter(this,animals);
		lvAnimals.setAdapter(animalsTableAdapter);
		cbSelAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				for (Animal animal :
						animals) {
					((AnimalTable)animal).setSelected(isChecked);
				}
				animalsTableAdapter.notifyDataSetChanged();
			}
		});
		tvNoAnimals.setText(String.format(getString(R.string.tvNoAnimales), animals.size()));
	}

	public void showSearch(View view){
		startActivity(new Intent(this, SearchActivity.class));
	}

	public void gotoCart(View V){
		ArrayList <Integer>selected= new ArrayList<>();
		for (Animal animal :
				animals) {
			if(((AnimalTable)animal).isSelected())
				selected.add(animal.getId());
		}
		if(!selected.isEmpty()) {
			Intent intent=new Intent(this, CartActivity.class);
			intent.putExtra(SELECTED_ANIMALS,selected);
			startActivity(intent);
		}
		else{
			Toast.makeText(this, getString(R.string.noAnimalSel), Toast.LENGTH_SHORT).show();
		}
	}

	private void initializeList(){
		animals.add(new AnimalTable(1,"551HO03269","Battle","qwertyui","ST45680",2.9F,false,"Cow"));
		animals.add(new AnimalTable(2, "551HO03373","Rubi-Agronaut","asdfghjkl","ST45680",2.9F,false,"Cow"));
		animals.add(new AnimalTable(3, "551HO03169","Desoto","asdfghjkl","ST45680",2.9F,false,"Cow"));
		animals.add(new AnimalTable(4, "551HO03169","Delta-Lambda","asdfghjkl","ST45680",2.9F,false,"Cow"));
		animals.add(new AnimalTable(5, "551HO03169","Delta","asdfghjkl","ST45680",2.9F,false,"Cow"));
		animals.add(new AnimalTable(6, "551HO03169","Windfall","asdfghjkl","ST45680",2.9F,false,"Cow"));
		animals.add(new AnimalTable(7, "551HO03169","Dixieland","asdfghjkl","ST45680",2.9F,false,"Cow"));
	}
}
