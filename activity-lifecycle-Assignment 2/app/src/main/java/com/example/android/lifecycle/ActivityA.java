/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ActivityA extends Activity {

    public static int counter;
    private String mCounter;
    private String mActivityName;
    private TextView myView;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        if( savedInstanceState != null)
        {
            counter = savedInstanceState.getInt("MyInt");
        }
        else
        {
            counter = 0;
        }
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_a);
            mActivityName = getString(R.string.activity_a);
            myView = (TextView) findViewById(R.id.status_view_all_a);
            mCounter = Integer.toString(counter);
            myView.setText("Thread Counter : - " + mCounter);
        }



    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        counter++;
        mCounter = Integer.toString(counter);
        myView.setText("Thread Counter : - " + mCounter);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void startDialog(View v) {
        Intent intent = new Intent(ActivityA.this, DialogActivity.class);
        startActivity(intent);
    }

    public void startActivityB(View v) {
        Intent intent = new Intent(ActivityA.this, ActivityB.class);
        startActivity(intent);
    }

    public void finishActivityA(View v) {
        ActivityA.this.finish();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("MyInt", counter);
        super.onSaveInstanceState(savedInstanceState);
    }



}
