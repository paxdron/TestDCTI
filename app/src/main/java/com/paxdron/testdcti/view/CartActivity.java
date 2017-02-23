package com.paxdron.testdcti.view;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.paxdron.testdcti.view.fragments.CartFragment;
import com.paxdron.testdcti.view.fragments.PaymentFragment;
import com.paxdron.testdcti.R;
import com.paxdron.testdcti.view.fragments.ShipingFragment;
import com.paxdron.testdcti.utils.interfaces.OnFragmentInteractionListener;

import java.util.ArrayList;

import mehdi.sakout.fancybuttons.FancyButton;

public class CartActivity extends AppCompatActivity implements OnFragmentInteractionListener {

	public static final int FINISH = 0;
	public static final int RETURN = 1;
	public static final int SHIPING = 2;
	public static final int PAYMENT = 3;
	public static final int CONFIRM = 4;
	public static final int PLACEORDER = 5;
	private FancyButton btnBack, btNext;
	private Fragment fContenido;
	private FragmentManager fragmentManager;
	private FragmentTransaction fragmentTransaction;
	private ArrayList<Integer> selectedAnimals;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cart);
		Intent intent=getIntent();
		selectedAnimals=intent.getIntegerArrayListExtra(MainActivity.SELECTED_ANIMALS);
		fragmentManager=getSupportFragmentManager();
		fragmentTransaction=fragmentManager.beginTransaction();
		fContenido= CartFragment.newInstance(selectedAnimals);
		fragmentTransaction.add(R.id.fContenido,fContenido);
		fragmentTransaction.commit();
	}
	@Override
	public void onFragmentInteraction(int action) {
		switch (action){
			case FINISH:
				finish();
				break;
			case RETURN:

				break;
			case SHIPING:
				replaceFragment(new ShipingFragment());
				break;
			case PAYMENT:
				replaceFragment(new PaymentFragment());
				break;
			case CONFIRM:
				break;
			case PLACEORDER:
				break;
		}
	}

	private void replaceFragment(Fragment newFragment){
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.fContenido, newFragment);
		transaction.addToBackStack(null);
		transaction.commit();
	}


}
