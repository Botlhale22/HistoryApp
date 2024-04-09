package com.example.historyapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Define the main activity class
class MainActivity : AppCompatActivity() {

    //  historical figures with their ages
    private val historicalFigures = listOf(
        HistoricalFigure("Nelson Mandela", 95),
        HistoricalFigure("William Shakespeare", 52),
        HistoricalFigure("Queen Elizabeth I", 69),
        HistoricalFigure("Leonardo da Vinci", 67),
        HistoricalFigure("Wolfgang Amadeus Mozart", 35),
        HistoricalFigure("Abraham Lincoln", 56),
        HistoricalFigure("Cleopatra VII", 39),
        HistoricalFigure("Mahatma Gandhi", 78),
        HistoricalFigure("Albert Einstein", 76),
        HistoricalFigure("Galileo Galilei", 77),
        HistoricalFigure("Joan of Arc", 19),
        HistoricalFigure("Alexander the Great", 32),
        HistoricalFigure("Martin Luther King Jr.", 39),
        HistoricalFigure("Julius Caesar", 55),
        HistoricalFigure("Marie Curie", 66),
        HistoricalFigure("Isaac Newton", 84),
        HistoricalFigure("Charles Darwin", 73),
        HistoricalFigure("Michelangelo", 88),
        HistoricalFigure("Queen Victoria", 81),
        HistoricalFigure("George Washington", 67),
        HistoricalFigure("Mansa Musa", 57),
        HistoricalFigure("Rosa Parks", 92),
        HistoricalFigure("Winston Churchill", 90),
        HistoricalFigure("Socrates", 71),
        HistoricalFigure("Emily Dickinson", 55),
        HistoricalFigure("Vincent van Gogh", 37),
        HistoricalFigure("Pablo Picasso", 91),
        HistoricalFigure("Sigmund Freud", 83),
        HistoricalFigure("Thomas Edison", 84),
        HistoricalFigure("Elizabeth I of England", 69),
        HistoricalFigure("Emily Brontë", 30),
        HistoricalFigure("Walt Disney", 65),
        HistoricalFigure("Mao Zedong", 82),
        HistoricalFigure("Joseph Stalin", 74),
        HistoricalFigure("Fidel Castro", 90),
        HistoricalFigure("Marilyn Monroe", 36),
        HistoricalFigure("Benjamin Franklin", 84),
        HistoricalFigure("Johann Sebastian Bach", 65),
        HistoricalFigure("Ludwig van Beethoven", 56),
        HistoricalFigure("Frida Kahlo", 47),

        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        val buttonClear: Button = findViewById(R.id.buttonClear)
        val buttonCheck: Button = findViewById(R.id.buttonGenerateHistory)
        val editTextAge: TextView = findViewById(R.id.editTextAge)
        val textViewOutput: TextView = findViewById(R.id.textViewOutput)

        // clear button
        buttonClear.setOnClickListener {
            editTextAge.text = ""
            textViewOutput.text = ""
        }

        // check button
        buttonCheck.setOnClickListener {
            val ageText = editTextAge.text.toString()
            if (ageText.isNotEmpty()) {
                val age = ageText.toIntOrNull()
                if (age != null && age in 20..100) {
                    // Finds the historical figure with the given age
                    val matchingFigure = historicalFigures.find { it.age == age }
                    if (matchingFigure != null) {
                        textViewOutput.text = "You are ${matchingFigure.age},which is the same age as ${matchingFigure.name}, who was : ${matchingFigure.age} and a historical Figure "
                    } else {
                        textViewOutput.text = "No historical figure found at this age"
                        // Displays a toast message if no historical figure is found
                        Toast.makeText(this, "No historical figure found at this age", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    textViewOutput.text = "Invalid age. Please enter a whole number between 20 and 100."
                    // Displays a toast message for invalid age input
                    Toast.makeText(this, "Invalid age. Please enter a whole number between 20 and 100.", Toast.LENGTH_SHORT).show()
                }
            } else {
                textViewOutput.text = "Please enter your age"
                // Displays a toast message if no age is entered
                Toast.makeText(this, "Please enter your age", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
