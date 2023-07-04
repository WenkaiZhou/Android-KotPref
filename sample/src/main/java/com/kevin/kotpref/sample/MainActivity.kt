package com.kevin.kotpref.sample

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.kevin.kotpref.KotPref
import com.kevin.kotpref.pref
import com.kevin.kotpref.sample.databinding.ActivityMainBinding

/**
 * Test
 *
 * @author zwenkai@foxmail.com, Created on 2023-05-23 20:18:07
 *         Major Function：<b></b>
 *         <p/>
 *         Note: If you modify this class please fill in the following content as a record.
 * @author mender，Modified Date Modify Content:
 */
class MainActivity: Activity() {

    private var count by pref(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        KotPref.init(this)

        binding.fab.setOnClickListener {
            Toast.makeText(MainActivity@this, "$count", Toast.LENGTH_SHORT).show()
            count += 1
        }
    }
}