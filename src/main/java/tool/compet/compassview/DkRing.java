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

import static java.lang.Character.LOWERCASE_LETTER;
import static java.lang.Character.UPPERCASE_LETTER;

public class DkRing {
	public static final int DEFAULT_WORD_FONT_SIZE = 12;

	/** This ring will be visible or gone */
	private boolean isVisible = true;

	/** This ring will be rotated with a degrees */
	private float rotatedDegrees;

	/** Ring name */
	private String ringName;

	/** Words in this ring */
	private List<String> words;

	/** Word is in horizontal or vertical */
	private boolean isHorizontalWord;

	/** Word is curved or straight */
	private boolean isCurvedWord;

	/** Word is normal, uppercase or lowercase */
	private int wordCase;

	/** Word is normal, bold, italic */
	private int wordStyle;

	/** Font size of a word */
	private int wordFontSize = DEFAULT_WORD_FONT_SIZE;

	/** Number of characters will be shown from left for each word */
	private int shownCharCount;

	public void setWordCase(int wordCase) {
		switch (wordCase) {
			case UPPERCASE_LETTER:
				this.wordCase = UPPERCASE_LETTER;
				break;
			case LOWERCASE_LETTER:
				this.wordCase = LOWERCASE_LETTER;
				break;
		}
	}

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
	public String getRingName() {
		return ringName;
	}
	public boolean isHorizontalWord() {
		return isHorizontalWord;
	}
	public boolean isCurvedWord() {
		return isCurvedWord;
	}
	public int getWordStyle() {
		return wordStyle;
	}
	public int getWordFontSize() {
		return wordFontSize;
	}
	public int getShownCharCount() {
		return shownCharCount;
	}
	public boolean isVisible() {
		return isVisible;
	}

	public void setWordStyle(int wordStyle) {
		this.wordStyle = wordStyle;
	}
	public void setRotatedDegrees(float rotatedDegrees) {
		this.rotatedDegrees = rotatedDegrees;
	}
	public void setRingName(String ringName) {
		this.ringName = ringName;
	}
	public void setWords(List<String> words) {
		this.words = words;
	}
	public void setHorizontalWord(boolean horizontalWord) {
		isHorizontalWord = horizontalWord;
	}
	public void setCurvedWord(boolean curvedWord) {
		isCurvedWord = curvedWord;
	}
	public void setWordFontSize(int wordFontSize) {
		this.wordFontSize = wordFontSize;
	}
	public void setShownCharCount(int shownCharCount) {
		this.shownCharCount = shownCharCount;
	}
	public void setVisible(boolean visible) {
		isVisible = visible;
	}
}
