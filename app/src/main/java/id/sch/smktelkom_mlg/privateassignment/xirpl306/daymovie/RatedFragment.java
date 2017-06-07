package id.sch.smktelkom_mlg.privateassignment.xirpl306.daymovie;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import id.sch.smktelkom_mlg.privateassignment.xirpl306.daymovie.adapter.Rated;
import id.sch.smktelkom_mlg.privateassignment.xirpl306.daymovie.model.ResultResponds;
import id.sch.smktelkom_mlg.privateassignment.xirpl306.daymovie.model.Results;
import id.sch.smktelkom_mlg.privateassignment.xirpl306.daymovie.service.GsonGetRequest;
import id.sch.smktelkom_mlg.privateassignment.xirpl306.daymovie.service.VolleySingleton;


/**
 * A simple {@link Fragment} subclass.
 */
public class RatedFragment extends Fragment {
    ArrayList<Results> mList = new ArrayList<>();
    Rated rated;

    public RatedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_popular, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recycler_popular);
        rv.setHasFixedSize(true);
        rated = new Rated(this, mList, getContext());
        rv.setAdapter(rated);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        downloadDataResource();
        return rootView;
    }

    private void downloadDataResource() {
        String url = " https://api.themoviedb.org/3/movie/popular?api_key=0e319904e648248b800ac4a16ce41acf&language=en-US&page=1";

        GsonGetRequest<ResultResponds> myRequest = new GsonGetRequest<ResultResponds>
                (url, ResultResponds.class, null, new Response.Listener<ResultResponds>() {

                    @Override
                    public void onResponse(ResultResponds response) {
                        Log.d("FLOW", "onResponse: " + (new Gson().toJson(response)));
                        fillColor(response.results);
                        mList.addAll(response.results);
                        rated.notifyDataSetChanged();
                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("FLOW", "onErrorResponse: ", error);
                    }
                });
        VolleySingleton.getInstance(this).addToRequestQueue(myRequest);
    }

    private void fillColor(List<Results> results) {
        for (int i = 0; i < results.size(); i++)
            results.get(i).color = ColorUtil.getRandomColor();
    }
}
