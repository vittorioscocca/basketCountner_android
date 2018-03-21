package com.vittorioscocca.vscocca.basketcourtcounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var teamAPoints = 0
    var teamBPoints = 0
    var lastPointAddedA: ArrayList<Int> = ArrayList()
    var lastPointAddedB: ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item!!.itemId) {
            R.id.new_game -> {
                reset()
                return true
            }
            R.id.help -> {
                Log.i("main_activity", "ciao") //Log an information
                Log.e("","") //Log an error
                Log.d("","") //Log a debug strings
                Log.w("","") //Log a Warning
                Log.v("","") //Log verbose
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    fun addThreePoints(v: View){
        if (v.id == R.id.button9) teamAPoints += 3  else teamBPoints += 3
        if (v.id == R.id.button9) displayPointsTeamA() else displayPointsTeamB()
        if (v.id == R.id.button9) lastPointAddedA.add(3) else  lastPointAddedB.add(3)
    }

    fun addTwoPoints(v: View){
        if (v.id == R.id.button10) teamAPoints += 2  else teamBPoints += 2
        if (v.id == R.id.button10) displayPointsTeamA() else displayPointsTeamB()
        if (v.id == R.id.button10) lastPointAddedA.add(2) else  lastPointAddedB.add(2)
    }

    fun addOnePoint(v: View){
        if (v.id == R.id.button12) teamAPoints += 1  else teamBPoints += 1
        if (v.id == R.id.button12) displayPointsTeamA() else displayPointsTeamB()
        if (v.id == R.id.button12) lastPointAddedA.add(1) else  lastPointAddedB.add(1)
    }

    fun reset() {
        teamAPoints = 0
        teamBPoints = 0
        lastPointAddedA.clear()
        lastPointAddedB.clear()
        displayPointsTeamA()
        displayPointsTeamB()
    }
    fun reset(v: View){
        reset()
    }

    fun undo(v: View) {
        if (v.id == R.id.button14) {
            if (!lastPointAddedA.isEmpty()) {
                teamAPoints -= lastPointAddedA.last()
                lastPointAddedA.removeAt(lastPointAddedA.size -1)
                displayPointsTeamA()
            }
        } else {
            if (!lastPointAddedB.isEmpty()) {
                teamBPoints -= lastPointAddedB.last()
                lastPointAddedB.removeAt(lastPointAddedB.size -1)
                displayPointsTeamB()
            }
        }
    }

    private fun displayPointsTeamA(){
        val editText = findViewById<TextView>(R.id.textView3)
        editText.setText("" + teamAPoints)
    }

    private fun displayPointsTeamB(){
        val editText = findViewById<TextView>(R.id.textView4)
        editText.setText("" + teamBPoints)
    }
}
