package com.example.myspinner
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity as AppCompatActivity1


class MainActivity : AppCompatActivity1() {


    var selectedWhisky = ""
    var selectedArtist = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val whiskies = resources.getStringArray(R.array.whiskies)
        val prices = resources.getStringArray(R.array.prices)
        val artist = resources.getStringArray(R.array.artist)
        val infoText = findViewById<TextView>(R.id.textView)
        val infoText2 = findViewById<TextView>(R.id.textView2)
        val spinner: Spinner = findViewById(R.id.spinner)
        val spinner2: Spinner = findViewById(R.id.spinner2)

        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, whiskies)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int,
                                        id: Long) {

                val selectedIndex = spinner.getSelectedItemPosition();
                if (selectedIndex > 0) {
                    selectedWhisky =
                        whiskies[selectedIndex] + "Price: " + prices[selectedIndex - 1]
                    displayImageResourceWhiskyImage(selectedIndex)
                }
                else
                    selectedWhisky = ""
                printInfo(infoText)
            }

        }

        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, artist)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = adapter
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int,
                                        id: Long) {
                val selectedIndex = spinner2.getSelectedItemPosition();
                if (selectedIndex > 0) {
                    selectedArtist = artist[selectedIndex]
                    displayImageResourceArtistImage(selectedIndex)
                }
                else
                    selectedArtist = ""
                printInfo2(infoText2)
            }
        }





    }




    private fun displayImageResourceWhiskyImage(resId: Int) {

         val intImageID = intArrayOf(
            R.drawable.lagavulin,
            R.drawable.oban,
            R.drawable.talisker,
            R.drawable.ardbeg,
            R.drawable.glenlivet,
            R.drawable.bunnahabhain,
            R.drawable.laphroaig,
            R.drawable.caolila,
            R.drawable.auchentoshan)

            val imageView = findViewById<ImageView>(R.id.whisky0)
        imageView.setImageResource(intImageID[resId-1])

    }

    private fun displayImageResourceArtistImage(resId: Int) {

        val intImageID = intArrayOf(
            R.drawable.artist1,
            R.drawable.artist2,
            R.drawable.artist3,
            R.drawable.artist4,
            R.drawable.artist5,
            R.drawable.artist6,
            R.drawable.artist7,
            R.drawable.artist8,
            R.drawable.artist9)

        val imageView = findViewById<ImageView>(R.id.artist0)
        imageView.setImageResource(intImageID[resId-1])

    }


    @SuppressLint("SetTextI18n")
    fun printInfo(tView: TextView) {
        if (!selectedWhisky.equals(""))
            tView.text = "Your favourite whisky is " + selectedWhisky
        else
            tView.text = "Please choose your favourite whisky."
    }

    @SuppressLint("SetTextI18n")
    fun printInfo2(tView: TextView) {
        if (!selectedArtist.equals(""))
            tView.text = "Your favourite artist is " + selectedArtist
        else
            tView.text = "Please choose your favourite artist."
    }


}