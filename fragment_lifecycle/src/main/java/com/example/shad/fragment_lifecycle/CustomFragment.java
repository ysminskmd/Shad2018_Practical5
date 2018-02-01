package com.example.shad.fragment_lifecycle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CustomFragment extends Fragment {

   private static final String TAG = "FLifecycle.Fragment";

   @Override
   public void onAttach(final Context context) {
      super.onAttach(context);
      Log.i(TAG, "onAttach");

      //Вызывается, когда фрагмент связывается с операцией (ему передается объект Activity).
   }

   @Override
   public void onCreate(@Nullable final Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Log.i(TAG, "onCreate");
   }

   @Nullable
   @Override
   public View onCreateView(@NonNull final LayoutInflater inflater,
                            @Nullable final ViewGroup container,
                            @Nullable final Bundle savedInstanceState) {
      //Вызывается для создания иерархии представлений, связанной с фрагментом.

      Log.i(TAG, "onCreateView");
      return inflater.inflate(R.layout.fragment, container, false);
   }

   @Override
   public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
      super.onActivityCreated(savedInstanceState);
      Log.i(TAG, "onActivityCreated");

      //Вызывается, когда метод onCreate(), принадлежащий операции, возвращает управление.
   }

   @Override
   public void onStart() {
      super.onStart();
      Log.i(TAG, "onStart");
   }

   @Override
   public void onResume() {
      super.onResume();
      Log.i(TAG, "onResume");
   }

   @Override
   public void onPause() {
      Log.i(TAG, "onPause");
      super.onPause();
   }

   @Override
   public void onStop() {
      Log.i(TAG, "onStop");
      super.onStop();
   }

   @Override
   public void onDestroyView() {
      Log.i(TAG, "onDestroyView");
      super.onDestroyView();

      //Вызывается при удалении иерархии представлений, связанной с фрагментом.
   }

   @Override
   public void onDestroy() {
      Log.i(TAG, "onDestroy");
      super.onDestroy();
   }

   @Override
   public void onDetach() {
      Log.i(TAG, "onDetach");
      super.onDetach();

      //Вызывается при разрыве связи фрагмента с операцией.
   }
}
