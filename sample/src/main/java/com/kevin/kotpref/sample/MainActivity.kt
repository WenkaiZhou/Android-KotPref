package com.kevin.kotpref.sample

import android.app.Activity
import android.os.Bundle
import com.kevin.kotpref.KotPref
import com.kevin.kotpref.pref

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

    val name by pref("zwenkai")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KotPref.init(this)
    }
}