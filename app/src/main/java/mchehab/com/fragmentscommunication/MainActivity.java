package mchehab.com.fragmentscommunication;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragmentListener {

    private FirstFragment firstFragment = new FirstFragment();
    private SecondFragment secondFragment = new SecondFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            addFragment(firstFragment, R.id.frameLayout1);
            addFragment(secondFragment, R.id.frameLayout2);
        }else{
            firstFragment = (FirstFragment)getFragmentById(R.id.frameLayout1);
            secondFragment = (SecondFragment)getFragmentById(R.id.frameLayout2);
        }
    }

    private void addFragment(Fragment fragment, int layoutId){
        getSupportFragmentManager().beginTransaction().add(layoutId, fragment).commit();
    }

    private Fragment getFragmentById(int layoutId){
        return getSupportFragmentManager().findFragmentById(layoutId);
    }

    @Override
    public void getMessage(String message) {
        secondFragment.getTextView().setText(message);
    }
}