/*
 * Copyright (c) 2018 DarkCompet. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tool.compet.compassview;

import java.util.List;

import static java.lang.Character.UPPERCASE_LETTER;

public class DkRing {
	/**
	 * Value true means this ring is visible, otherwise means this ring should be gone
	 */
	public boolean isVisible = true;

	/**
	 * Clockwise rotated angle in degrees.
	 */
	public float rotatedDegrees;

	/**
	 * Name of ring, anything you want to tag.
	 */
	public String ringName;

	/**
	 * Words of this ring.
	 */
	public List<String> words;

	/**
	 * Indicate each word is horizontal or vertical.
	 */
	public boolean isHorizontalWord;

	/**
	 * Indicate each word is curved or straight when drawing.
	 */
	public boolean isCurvedWord;

	/**
	 * Indicate each word is normal, uppercase or lowercase. Value is one of
	 * {Character.UNASSIGNED, Character.UPPERCASE_LETTER or Character.LOWERCASE_LETTER}.
	 */
	public int wordCase;

	/**
	 * Indicate each word is normal, bold or italic.
	 */
	public int wordStyle;

	/**
	 * Font size of each word.
	 */
	public int wordFontSize;

	/**
	 * Number of characters will be shown from left of each word when drawing.
	 */
	public int shownCharCount;

	public boolean isWordUpperCase() {
		return wordCase == UPPERCASE_LETTER;
	}
	public boolean isWordLowerCase() {
		return wordCase == UPPERCASE_LETTER;
	}
	public List<String> getWords() {
		return words;
	}
	public float getRotatedDegrees() {
		return rotatedDegrees;
	}
	public boolean isHorizontalWord() {
		return isHorizontalWord;
	}
	public int getShownCharCount() {
		return shownCharCount;
	}
	public boolean isVisible() {
		return isVisible;
	}
}
