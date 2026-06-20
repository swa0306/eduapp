package com.example.edu

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class SelectBoardActivity : AppCompatActivity() {

    private lateinit var spBoard: MaterialAutoCompleteTextView
    private lateinit var spClass: MaterialAutoCompleteTextView
    private lateinit var spSubject: MaterialAutoCompleteTextView
    private lateinit var btnContinue: MaterialButton

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_select_board)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        spBoard = findViewById(R.id.spBoard)
        spClass = findViewById(R.id.spClass)
        spSubject = findViewById(R.id.spSubject)
        btnContinue = findViewById(R.id.btnContinue)

        sharedPreferences =
            getSharedPreferences(
                "EduSphere",
                MODE_PRIVATE
            )

        loadBoards()

        btnContinue.setOnClickListener {

            val board = spBoard.text.toString().trim()
            val course = spClass.text.toString().trim()
            val subject = spSubject.text.toString().trim()

            if (board.isEmpty()) {
                spBoard.error = "Select Board"
                return@setOnClickListener
            }

            if (course.isEmpty()) {
                spClass.error = "Select Class"
                return@setOnClickListener
            }

            if (subject.isEmpty()) {
                spSubject.error = "Select Subject"
                return@setOnClickListener
            }

            sharedPreferences.edit()
                .putString("board", board)
                .putString("course", course)
                .putString("subject", subject)
                .putBoolean("board_selected", true)
                .apply()

            startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                )
            )

            finish()
        }
    }

    private fun loadBoards() {

        val boards = arrayOf(
            "CBSE",
            "SSC",
            "HSC",
            "MSBTE",
            "Engineering",
            "Medical"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            boards
        )

        spBoard.setAdapter(adapter)

        spBoard.setOnItemClickListener { _, _, position, _ ->

            when (boards[position]) {

                "CBSE" -> {
                    loadClasses(
                        arrayOf(
                            "8th",
                            "9th",
                            "10th",
                            "11th Science",
                            "12th Science"
                        )
                    )
                }

                "SSC" -> {
                    loadClasses(
                        arrayOf(
                            "8th",
                            "9th",
                            "10th"
                        )
                    )
                }

                "HSC" -> {
                    loadClasses(
                        arrayOf(
                            "11th Science",
                            "12th Science"
                        )
                    )
                }

                "MSBTE" -> {
                    loadClasses(
                        arrayOf(
                            "Computer",
                            "IT",
                            "Civil",
                            "Mechanical",
                            "Electrical"
                        )
                    )
                }

                "Engineering" -> {
                    loadClasses(
                        arrayOf(
                            "Computer Engineering",
                            "Information Technology",
                            "Civil Engineering",
                            "Mechanical Engineering"
                        )
                    )
                }
                "Medical" -> {
                    loadClasses(
                        arrayOf(
                            "MBBS",
                            "BDS",
                            "BHMS",
                            "BAMS",
                            "BUMS",
                            "BPT",
                            "Nursing",
                            "Pharmacy"
                        )
                    )
                }
            }
        }
    }

    private fun loadClasses(classes: Array<String>) {


        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            classes
        )

        spClass.setAdapter(adapter)

        spClass.setOnItemClickListener { _, _, position, _ ->

            when (classes[position]) {

                // SSC / CBSE

                "10th" -> {
                    loadSubjects(
                        arrayOf(
                            "Maths",
                            "Science",
                            "English",
                            "History",
                            "Geography"
                        )
                    )
                }

                // Diploma

                "Computer" -> {
                    loadSubjects(
                        arrayOf(
                            "Java",
                            "Python",
                            "Android",
                            "DBMS",
                            "Operating System"
                        )
                    )
                }

                "IT" -> {
                    loadSubjects(
                        arrayOf(
                            "Programming",
                            "Networking",
                            "Web Development",
                            "DBMS"
                        )
                    )
                }

                "Civil" -> {
                    loadSubjects(
                        arrayOf(
                            "Surveying",
                            "Construction",
                            "Building Design",
                            "Concrete Technology"
                        )
                    )
                }

                "Mechanical" -> {
                    loadSubjects(
                        arrayOf(
                            "Thermodynamics",
                            "Machine Design",
                            "Manufacturing",
                            "Automobile"
                        )
                    )
                }

                "Electrical" -> {
                    loadSubjects(
                        arrayOf(
                            "Electrical Machines",
                            "Power Systems",
                            "Control Systems",
                            "Circuit Theory"
                        )
                    )
                }

                // Engineering

                "Computer Engineering" -> {
                    loadSubjects(
                        arrayOf(
                            "Java",
                            "Android",
                            "DBMS",
                            "OSY",
                            "Data Structures",
                            "Computer Networks"
                        )
                    )
                }

                "Information Technology" -> {
                    loadSubjects(
                        arrayOf(
                            "Web Development",
                            "Java",
                            "Python",
                            "Networking",
                            "Cloud Computing"
                        )
                    )
                }

                "Civil Engineering" -> {
                    loadSubjects(
                        arrayOf(
                            "Structural Engineering",
                            "Surveying",
                            "Transportation",
                            "Geotechnical Engineering"
                        )
                    )
                }

                "Mechanical Engineering" -> {
                    loadSubjects(
                        arrayOf(
                            "Machine Design",
                            "Thermodynamics",
                            "Fluid Mechanics",
                            "Automobile Engineering"
                        )
                    )
                }

                // Medical

                "MBBS" -> {
                    loadSubjects(
                        arrayOf(
                            "Anatomy",
                            "Physiology",
                            "Biochemistry",
                            "Pathology",
                            "Pharmacology",
                            "Microbiology",
                            "Medicine",
                            "Surgery"
                        )
                    )
                }

                "BDS" -> {
                    loadSubjects(
                        arrayOf(
                            "Dental Anatomy",
                            "Oral Pathology",
                            "Orthodontics",
                            "Periodontics",
                            "Prosthodontics"
                        )
                    )
                }

                "BHMS" -> {
                    loadSubjects(
                        arrayOf(
                            "Organon of Medicine",
                            "Materia Medica",
                            "Homeopathic Pharmacy",
                            "Pathology",
                            "Repertory"
                        )
                    )
                }

                "BAMS" -> {
                    loadSubjects(
                        arrayOf(
                            "Ayurveda Samhita",
                            "Dravyaguna",
                            "Rachana Sharir",
                            "Kriya Sharir",
                            "Roga Nidana"
                        )
                    )
                }

                "BUMS" -> {
                    loadSubjects(
                        arrayOf(
                            "Tashreeh-ul-Badan",
                            "Ilmul Advia",
                            "Moalajat",
                            "Amraz"
                        )
                    )
                }

                "BPT" -> {
                    loadSubjects(
                        arrayOf(
                            "Human Anatomy",
                            "Physiology",
                            "Exercise Therapy",
                            "Electrotherapy"
                        )
                    )
                }

                "Nursing" -> {
                    loadSubjects(
                        arrayOf(
                            "Fundamentals of Nursing",
                            "Medical Surgical Nursing",
                            "Community Health Nursing",
                            "Mental Health Nursing",
                            "Child Health Nursing"
                        )
                    )
                }

                "Pharmacy" -> {
                    loadSubjects(
                        arrayOf(
                            "Pharmaceutics",
                            "Pharmacology",
                            "Pharmaceutical Chemistry",
                            "Biochemistry",
                            "Human Anatomy"
                        )
                    )
                }

                else -> {
                    loadSubjects(
                        arrayOf(
                            "Subject 1",
                            "Subject 2",
                            "Subject 3"
                        )
                    )
                }
            }
        }


    }

    private fun loadSubjects(subjects: Array<String>) {

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            subjects
        )

        spSubject.setAdapter(adapter)


    }

}


            /*private fun loadSubjects(subjects: Array<String>) {

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            subjects
        )

        spSubject.setAdapter(adapter)
    }
*/