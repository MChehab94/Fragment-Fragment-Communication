package mchehab.com.fragmentscommunication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FirstFragment extends Fragment {

    private EditText editText;
    private Button buttonSendMessage;
    private FirstFragmentListener firstFragmentListener;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        editText = view.findViewById(R.id.editText);
        buttonSendMessage = view.findViewById(R.id.buttonSendMessage);

        buttonSendMessage.setOnClickListener(e -> {
            if(firstFragmentListener != null){
                firstFragmentListener.getMessage(editText.getText().toString());
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FirstFragmentListener){
            firstFragmentListener = (FirstFragmentListener)context;
        }
    }
}