package com.paxdron.testdcti.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paxdron.testdcti.AnimalsCartAdapter;
import com.paxdron.testdcti.R;
import com.paxdron.testdcti.model.Animal;
import com.paxdron.testdcti.model.AnimalTable;
import com.paxdron.testdcti.utils.interfaces.OnFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;

import mehdi.sakout.fancybuttons.FancyButton;

import static com.paxdron.testdcti.view.CartActivity.FINISH;
import static com.paxdron.testdcti.view.CartActivity.SHIPING;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "param1";


	private List<String> articles;
	private List<Animal> selectedAnimals;
	private RecyclerView recyclerViewAnimals;
	private AnimalsCartAdapter adapter;
	private RecyclerView.LayoutManager layoutManager;
	private OnFragmentInteractionListener mListener;
	private FancyButton btnNext, btnBack;

	public CartFragment() {
		// Required empty public constructor
	}

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param param1 Parameter 1.
	 * @return A new instance of fragment CartFragment.
	 */
	// TODO: Rename and change types and number of parameters
	public static CartFragment newInstance(ArrayList<Integer> param1) {
		CartFragment fragment = new CartFragment();
		Bundle args = new Bundle();
		args.putIntegerArrayList(ARG_PARAM1, param1);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			articles = getArguments().getStringArrayList(ARG_PARAM1);
			selectedAnimals= new ArrayList<>();
			initializeList();
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view =inflater.inflate(R.layout.fragment_cart, container, false);
		selectedAnimals= new ArrayList<>();
		initializeList();
		recyclerViewAnimals=(RecyclerView)view.findViewById(R.id.rvCart);
		btnNext=(FancyButton)view.findViewById(R.id.btnNext);
		btnBack=(FancyButton)view.findViewById(R.id.btnBack);
		layoutManager=new LinearLayoutManager(getActivity());
		recyclerViewAnimals.setLayoutManager(layoutManager);
		adapter= new AnimalsCartAdapter(selectedAnimals);
		recyclerViewAnimals.setAdapter(adapter);
		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mListener.onFragmentInteraction(FINISH);
			}
		});
		btnNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mListener.onFragmentInteraction(SHIPING);
			}
		});
		return view;
	}
	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof OnFragmentInteractionListener) {
			mListener = (OnFragmentInteractionListener) context;
		} else {
			throw new RuntimeException(context.toString()
					+ " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}
	private void initializeList(){
		selectedAnimals.add(new AnimalTable(1,"551HO03269","Battle","qwertyui","ST45680",2.9F,false,"Cow"));
		selectedAnimals.add(new AnimalTable(2, "551HO03373","Rubi-Agronaut","asdfghjkl","ST45680",2.9F,false,"Cow"));
		selectedAnimals.add(new AnimalTable(3, "551HO03169","Desoto","asdfghjkl","ST45680",2.9F,false,"Cow"));
		selectedAnimals.add(new AnimalTable(4, "551HO03169","Delta-Lambda","asdfghjkl","ST45680",2.9F,false,"Cow"));
		selectedAnimals.add(new AnimalTable(5, "551HO03169","Delta","asdfghjkl","ST45680",2.9F,false,"Cow"));
		selectedAnimals.add(new AnimalTable(6, "551HO03169","Windfall","asdfghjkl","ST45680",2.9F,false,"Cow"));
	}
}
