package ai.ronnicknachok.customkeyboard

import ai.ronnicknachok.customkeyboard.components.keyboard.CustomKeyboardView
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	private lateinit var keyboard: CustomKeyboardView
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		
		val numberField: EditText = findViewById(R.id.testNumberField)
		val numberDecimalField: EditText = findViewById(R.id.testNumberDecimalField)
		val qwertyField: EditText = findViewById(R.id.testQwertyField)
		
		keyboard = findViewById(R.id.customKeyboardView)
		keyboard.registerEditText(CustomKeyboardView.KeyboardType.NUMBER, numberField)
		keyboard.registerEditText(
			CustomKeyboardView.KeyboardType.NUMBER_DECIMAL,
			numberDecimalField
		)
		keyboard.registerEditText(CustomKeyboardView.KeyboardType.QWERTY, qwertyField)
		
		val switchActivitiesButton: Button = findViewById(R.id.switchActivitiesButton)
		switchActivitiesButton.setOnClickListener {
			startActivity(
				Intent(
					this@MainActivity,
					AdvancedFeaturesActivity::class.java
				)
			)
		}
	}
	
	override fun onBackPressed() {
		
		if (keyboard.isExpanded) {
			keyboard.translateLayout()
		} else {
			super.onBackPressed()
		}
	}
}