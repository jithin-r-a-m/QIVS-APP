package com.example.click
import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.widget.GridLayout
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.logging.Handler
import com.opencsv.CSVReader
import java.io.InputStreamReader
import java.util.ArrayList
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.CheckBox


class MainActivity : AppCompatActivity() {
    private val highlightedCells: MutableList<View> = mutableListOf()
    private lateinit var checkbox1: CheckBox
    private lateinit var checkbox2: CheckBox
    private lateinit var checkbox3: CheckBox
    private lateinit var checkbox4: CheckBox
    private lateinit var checkbox5: CheckBox
    private lateinit var checkbox6: CheckBox
    private lateinit var checkbox7: CheckBox
    private lateinit var bdy: TextView
    private lateinit var mod: TextView
    private lateinit var suff: TextView
    private lateinit var loadNextRowButton: Button
    private var csvData: List<Array<String>> = ArrayList()
    private  var currentRow: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get a reference to the TextView
        // Get a reference to the TextView
        timeTextView = findViewById(R.id.timeTextView)
        val dateTextView: TextView = findViewById(R.id.dateTextView)

        // Get the current date and format it (or provide your custom date string)
        val currentDate = getCurrentDate()

        // Set the text of the TextView to the formatted date
        dateTextView.text = currentDate


        bdy = findViewById(R.id.bdy)
        suff = findViewById(R.id.suff)
        mod = findViewById(R.id.mod)
        loadNextRowButton = findViewById(R.id.row)
        loadCsvData()

        // Set initial data
        displayCsvRow(currentRow)
        checkbox1 = findViewById(R.id.checkBox3)
        checkbox2 = findViewById(R.id.checkBox6)
        checkbox3 = findViewById(R.id.checkBox44)
        checkbox4 = findViewById(R.id.checkBox7)

        checkbox1.setOnCheckedChangeListener { _, _ -> checkRowButtonState() }
        checkbox2.setOnCheckedChangeListener { _, _ -> checkRowButtonState() }
        checkbox3.setOnCheckedChangeListener { _, _ -> checkRowButtonState() }
        checkbox4.setOnCheckedChangeListener { _, _ -> checkRowButtonState() }

        // Initialize your GridLayout and set onClick listeners for each grid cell
        val gridLayout: GridLayout = findViewById(R.id.gridLayout)
        val cell4:ImageView=findViewById(R.id.cell4)
        val cell5:ImageView=findViewById(R.id.cell5)
        val cell6:ImageView=findViewById(R.id.cell6)
        val cell8:ImageView=findViewById(R.id.cell8)
        val cell11:ImageView=findViewById(R.id.cell11)
        val cell12:ImageView=findViewById(R.id.cell15)
        val cell14:ImageView=findViewById(R.id.cell14)
        val cell15:ImageView=findViewById(R.id.cell15)
        val cell18:ImageView=findViewById(R.id.cell18)
        val cellt1:ImageView=findViewById(R.id.cellt1)
        val cellt2:ImageView=findViewById(R.id.cellt2)
        val cellt3:ImageView=findViewById(R.id.cellt3)
        val cellt7:ImageView=findViewById(R.id.cellt7)
        val cellt8:ImageView=findViewById(R.id.cellt8)
        val cellt11:ImageView=findViewById(R.id.cellt11)
        val cellt13:ImageView=findViewById(R.id.cellt13)
        val cellr1:ImageView=findViewById(R.id.cellr1)
        val cellr2:ImageView=findViewById(R.id.cellr2)
        val cellr7:ImageView=findViewById(R.id.cellr7)
        val cellr10:ImageView=findViewById(R.id.cellr10)
        val cellr11:ImageView=findViewById(R.id.cellr11)
        val cellr15:ImageView=findViewById(R.id.cellr15)
        val cellr16:ImageView=findViewById(R.id.cellr16)
        val cellr17:ImageView=findViewById(R.id.cellr17)
        val cellrr1:ImageView=findViewById(R.id.cellrr1)
        val cellrr2:ImageView=findViewById(R.id.cellrr1)
        val cellrr3:ImageView=findViewById(R.id.cellrr3)
        val cellrr7:ImageView=findViewById(R.id.cellrr7)
        val cellrr8:ImageView=findViewById(R.id.cellrr8)
        val cellrr13:ImageView=findViewById(R.id.cellrr13)
        val cellrr15:ImageView=findViewById(R.id.cellrr15)
        val cellrr16:ImageView=findViewById(R.id.cellrr16)
        val cellrr11:ImageView=findViewById(R.id.cellrr11)
        val cellrr17:ImageView=findViewById(R.id.cellrr17)
        val celllt1:ImageView=findViewById(R.id.celllt1)
        val celllt2:ImageView=findViewById(R.id.celllt2)
        val celllt3:ImageView=findViewById(R.id.celllt3)
        val celllt4:ImageView=findViewById(R.id.celllt4)
        val celllt5:ImageView=findViewById(R.id.celllt5)
        val celllt6:ImageView=findViewById(R.id.celllt6)
        val celllt7:ImageView=findViewById(R.id.celllt7)





        for (i in 0 until gridLayout.childCount) {
            val cell: View = gridLayout.getChildAt(i)

            if (cell is ImageView) {
                cell4.isClickable = false
                cell5.isClickable = false
                cell6.isClickable = false
                cell8.isClickable = false
                cell11.isClickable = false
                cell12.isClickable = false
                cell14.isClickable = false
                cell15.isClickable = false
                cell18.isClickable = false
                cellt1.isClickable = false
                cellt2.isClickable = false
                cellt3.isClickable = false
                cellt7.isClickable = false
                cellt8.isClickable = false
                cellt11.isClickable = false
                cellt13.isClickable = false
                cellr1.isClickable=false
                cellr2.isClickable=false
                cellr7.isClickable=false
                cellr10.isClickable=false
                cellr11.isClickable=false
                cellr15.isClickable=false
                cellr16.isClickable=false
                cellr17.isClickable=false
                cellrr1.isClickable=false
                cellrr2.isClickable=false
                cellrr3.isClickable=false
                cellrr7.isClickable=false
                cellrr8.isClickable=false
                cellrr13.isClickable=false
                cellrr15.isClickable=false
                cellrr16.isClickable=false
                cellrr11.isClickable=false
                cellrr17.isClickable=false


                cell.setOnClickListener { onGridItemClick(cell) }
            }
        }
    }

    fun onGridItemClick(view: View) {
        // Determine which grid cell (ImageView) was clicked based on its ID
        val clickedCellId = view.id

        // Create a PopupMenu
        val popupMenu = PopupMenu(this, view)
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.popup_menu, popupMenu.menu)

        // Set a click listener for the popup menu items
        popupMenu.setOnMenuItemClickListener { item ->
            // Handle the selected option

            val selectedOption = item.title.toString()


            view.setBackgroundResource(R.drawable.highlight)
            val cellData = CellData(
                cellId = clickedCellId,
                bdy = bdy.text.toString(),
                suff = suff.text.toString(),
                mod = mod.text.toString(),
                selectedOption = selectedOption
            )
            val dbHelper = DatabaseHelper(this)
            dbHelper.insertCellData(cellData)
            // Store the selected option and grid cell ID (ImageView ID) in the database
            // In this example, we're just showing a Toast message
            val message = "Selected $selectedOption for grid cell $clickedCellId"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            highlightedCells.add(view)
            true
        }

        // Show the popup menu
        popupMenu.show()
        loadNextRowButton.setOnClickListener { loadNextRow()
            resetHighlightedCells()
            checkbox1.isChecked = false
            checkbox2.isChecked = false
            checkbox3.isChecked = false
            checkbox4.isChecked = false


        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.popup_menu, menu)
        return true
    }
    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val currentDate = Date()
        return dateFormat.format(currentDate)
    }
    private lateinit var timeTextView: TextView
    private val handler = android.os.Handler()
    private val timeUpdateRunnable = object : Runnable {
        override fun run() {
            updateTime()
            handler.postDelayed(this, 1000) // Update every second (1000 milliseconds)
        }
    }
    override fun onResume() {
        super.onResume()
        handler.post(timeUpdateRunnable) // Start the time update runnable when the activity resumes
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(timeUpdateRunnable) // Stop the time update runnable when the activity pauses
    }

    private fun updateTime() {
        val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val currentTime = Date()
        val formattedTime = timeFormat.format(currentTime)
        timeTextView.text = formattedTime
    }
    private fun loadCsvData() {
        val inputStream = resources.openRawResource(R.raw.bodynumberdetails) // Replace with your CSV file resource
        val reader = CSVReader(InputStreamReader(inputStream))
        csvData = reader.readAll()
        reader.close()
    }

    private fun displayCsvRow(rowNumber: Int) {
        if (rowNumber < csvData.size) {
            val rowData = csvData[rowNumber]
            bdy.text = rowData[1]
            suff.text = rowData[2]
            mod.text = rowData[3]
        } else {
            // Handle the case when all rows have been displayed
            bdy.text = ""
            suff.text = ""
            mod.text = ""
            loadNextRowButton.isEnabled = false
        }
    }

    private fun loadNextRow() {
        currentRow++
        displayCsvRow(currentRow)
    }
    fun resetHighlightedCells() {
        // Reset the backgrounds of all highlighted cells
        for (cell in highlightedCells) {
            cell.setBackgroundResource(R.drawable.cellborder)
        }
        // Clear the list of Shighlighted cells
        highlightedCells.clear()
    }
    fun insertCellData(cellData: CellData): Long {
        val dbHelper = DatabaseHelper(this) // Replace 'context' with the appropriate context, usually 'this' in an Activity
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("cell_id", cellData.cellId)
            put("bdy", cellData.bdy)
            put("suff", cellData.suff)
            put("mod", cellData.mod)
            put("selected_option", cellData.selectedOption)
        }
        return db.insert("cell_data", null, values)
    }
    data class CellData(
        val cellId: Int,
        val bdy: String,
        val suff: String,
        val mod: String,
        val selectedOption: String
    )
    private fun checkRowButtonState() {
        // Check if all checkboxes are checked
        val allChecked = checkbox1.isChecked && checkbox2.isChecked &&  checkbox3.isChecked && checkbox4.isChecked

                loadNextRowButton.isEnabled = allChecked
    }
}

