package com.paxdron.testdcti;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paxdron.testdcti.utils.ViewPageAdapter;
import com.paxdron.testdcti.utils.interfaces.OnFragmentInteractionListener;

import mehdi.sakout.fancybuttons.FancyButton;

import static com.paxdron.testdcti.CartActivity.CONFIRM;
import static com.paxdron.testdcti.CartActivity.PAYMENT;
import static com.paxdron.testdcti.CartActivity.RETURN;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class PaymentFragment extends Fragment {

	private OnFragmentInteractionListener mListener;
	private TabLayout tabLayout;
	private ViewPager viewPager;
	private FancyButton btnBack, btnNext;
	public PaymentFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view= inflater.inflate(R.layout.fragment_payment, container, false);
		viewPager = (ViewPager)view.findViewById(R.id.viewpager);
		setupViewPager(viewPager);

		tabLayout = (TabLayout)view.findViewById(R.id.tabs);
		tabLayout.setupWithViewPager(viewPager);
		btnNext=(FancyButton)view.findViewById(R.id.btnNext);
		btnBack=(FancyButton)view.findViewById(R.id.btnBack);
		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		btnNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mListener.onFragmentInteraction(CONFIRM);
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
	private void setupViewPager(ViewPager viewPager) {
		ViewPageAdapter adapter = new ViewPageAdapter(getFragmentManager());
		adapter.addFragment(new CreditCardFragment(), "CREDIT CARD");
		adapter.addFragment(new CreditFragment(), "CREDIT");
		viewPager.setAdapter(adapter);
	}
}
