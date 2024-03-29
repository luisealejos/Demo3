package com.ug.telescopio.fragments;

import com.ug.telescopio.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;

public class PhotoDialogFragment extends DialogFragment {
	NoticeDialogListener listener;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			listener = (NoticeDialogListener)getActivity();
		} catch (ClassCastException e) {
			Log.e("ERROR", Log.getStackTraceString(e));
		}
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage(R.string.btn_photo)
			   .setPositiveButton(R.string.msg_yes, 
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							listener.onDialogPositiveClick();
						}
					})
				.setNegativeButton(R.string.msg_no, 
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							listener.onDialogNegativeClick();
						}
					});
		return builder.create();
	}

	public interface NoticeDialogListener {
		public void onDialogPositiveClick();
		public void onDialogNegativeClick();
	}
	
}
