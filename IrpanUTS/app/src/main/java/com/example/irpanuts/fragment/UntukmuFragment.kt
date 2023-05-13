package com.example.irpanuts.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.irpanuts.Komik
import com.example.irpanuts.R
import com.example.irpanuts.detailKomikActivity
import com.example.irpanuts.komikAdapter

class UntukmuFragment : Fragment() {
    private lateinit var adapter: komikAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var komikArrayList: ArrayList<Komik>

    lateinit var image: Array<Int>
    lateinit var detailimage: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>
    lateinit var chapter: Array<String>

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_untukmu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_komik)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = context?.let {
            komikAdapter(it, komikArrayList){
                val intent = Intent(context, detailKomikActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
        }

    }
    private fun dataInitialize(){
        komikArrayList = arrayListOf<Komik>()

        detailimage = arrayOf(
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.img_9,

            )

        image = arrayOf(
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.img_9,
        )

        title = arrayOf(
            "Ronny Pasla",
            "Robby Darwis",
            "Simson Rumahpasal",
            "Aji Santoso",
            "Bima Sakti",
            "Zulkarnaen Lubis",
            "Iswadi Idris",
            "Ronny Pattinasarany",
            "Soetjipto Soentoro",
            "Andi Ramang",
        )

        description = arrayOf(
            "Kendati mengawali karier olahraga dengan tenis, Ronny dikenal sebagai satu kiper terbaik yang pernah dimiliki Indonesia.",
            "Postur kekar dan kepiawaian dalam duel udara menjadikan Robby sebagai andalan timnas maupun Persib Bandung selama kariernya",
            "Posisi bek kanan timnas pada medio 1970-an hingga 1980-an identik dengan Simson. Kemampuannya menahan serangan menjadikan posisinya di timnas tak tergantikan. ",
            "Rasanya belum ada bek kiri timnas yang bisa melebihi kemampuan Aji. ",
            "Sosok pemain yang jarang disorot media ini adalah salah satu anggota tim Primavera PSSI yang dikirim ke Italia pada era 1990-an",
            "Dijuluki sebagai “Maradona Indonesia” jelas menunjukkan kualitas yang dimiliki seorang Zulkarnaen. ",
            "Salah satu pemain sayap terbaik yang pernah dimiliki Indonesia",
            "Kalau ada pertanyaan siapakah playmaker terbaik Indonesia, maka Ronny adalah jawabannya.",
            "Gareng, itulah nama panggilan striker terbaik yang pernah dimiliki Indonesia ini. ",
            "Striker PSM Makassar ini dikenal dengan kelihaiannya dalam mencetak gol dari berbagai situasi dan posisi. ",

            )

        chapter = arrayOf(
            "Chapter 2",
            "Chapter 5",
            "Chapter 4",
            "Chapter 2",
            "Chapter 6",
            "Chapter 3",
            "Chapter 5",
            "Chapter 4",
            "Chapter 4",
            "Chapter 5",
        )
        for (i in image.indices){
            val komik = Komik(image[i], title[i], description[i], detailimage[i], chapter[i],)
            komikArrayList.add(komik)
        }
    }


}