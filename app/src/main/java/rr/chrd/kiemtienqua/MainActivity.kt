package rr.chrd.kiemtienqua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import rr.chrd.kiemtienqua.Fragment.GuideFragment
import rr.chrd.kiemtienqua.Fragment.HomeFragment
import rr.chrd.kiemtienqua.Fragment.TipsFragment
import rr.chrd.kiemtienqua.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var  _binding : ActivityMainBinding
    lateinit var homeFragment: HomeFragment
    lateinit var  tipsFragment: TipsFragment
    lateinit var  guideFragment: GuideFragment
    private var bactoExit = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val toolbar: androidx.appcompat.widget.Toolbar = _binding.toolBar
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = _binding.drawerLayout
        val navigationView: NavigationView = _binding.navView

        val toggle = ActionBarDrawerToggle(

            this,
            drawerLayout,
            toolbar,
            R.string.open,
            R.string.close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
       when (item.itemId) {

           R.id.home -> {
               homeFragment = HomeFragment()
               supportFragmentManager
                   .beginTransaction()
                   .replace(R.id.fragmentView,homeFragment)
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .commit()
           }
           R.id.guide -> {
               guideFragment = GuideFragment()
               supportFragmentManager
                   .beginTransaction()
                   .replace(R.id.fragmentView,guideFragment)
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .commit()
           }

           R.id.tips -> {
               tipsFragment = TipsFragment()
               supportFragmentManager
                   .beginTransaction()
                   .replace(R.id.fragmentView,tipsFragment)
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .commit()
           }
       }

        _binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (bactoExit) {
            super.finishAffinity()
            return
        }
        this.bactoExit = true
        Toast.makeText(this, "Press back again to exit.", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ bactoExit = false }, 2000)
    }
}
