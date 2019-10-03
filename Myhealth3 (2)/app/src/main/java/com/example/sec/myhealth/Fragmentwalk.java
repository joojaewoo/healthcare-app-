package com.example.sec.myhealth;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cookandroid.alarm.MainActivity;


public class Fragmentwalk extends Fragment {
    com.cookandroid.alarm.MainActivity activity;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

//        activity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();

        activity = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 인플레이션이 가능하다, container 이쪽으로 붙여달라, fragment_main을
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.drawer,container,false);
        getActivity();      // 액티비티위에 올라가게 한다.




        return rootview;            // 플레그먼트 화면으로 보여주게 된다.
    }

    // 결국 이렇게 되면 플래그먼트가 하나 만들어 지게 된것이다.
}
