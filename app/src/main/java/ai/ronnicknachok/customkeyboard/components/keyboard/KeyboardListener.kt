package ai.ronnicknachok.customkeyboard.components.keyboard

import ai.ronnicknachok.customkeyboard.components.keyboard.controllers.KeyboardController

interface KeyboardListener {
	fun characterClicked(c: Char)
	fun specialKeyClicked(key: KeyboardController.SpecialKey)
}