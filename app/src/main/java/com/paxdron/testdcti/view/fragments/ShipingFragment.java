package com.paxdron.testdcti.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paxdron.testdcti.R;
import com.paxdron.testdcti.utils.interfaces.OnFragmentInteractionListener;

import mehdi.sakout.fancybuttons.FancyButton;

import static com.paxdron.testdcti.view.CartActivity.PAYMENT;
import static com.paxdron.testdcti.view.CartActivity.RETURN;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ShipingFragment extends Fragment {

	private OnFragmentInteractionListener mListener;

	private FancyButton btnBack, btnNext;

	public ShipingFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view= inflater.inflate(R.layout.fragment_shiping, container, false);

		btnNext=(FancyButton)view.findViewById(R.id.btnNext);
		btnBack=(FancyButton)view.findViewById(R.id.btnBack);
		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mListener.onFragmentInteraction(RETURN);
			}
		});
		btnNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mListener.onFragmentInteraction(PAYMENT);
			}
		});

		return  view;
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

}
