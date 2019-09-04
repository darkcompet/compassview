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

import android.animation.TypeEvaluator;
import android.content.Context;

import java.util.Collections;
import java.util.List;

class CompassController {
	private TypeEvaluator mArgbEvaluator;

	DkInfo readInfo(Context context, double degrees, List<DkRing> rings) {
		DkInfo root = new DkInfo();

		DkInfo northInfo = new DkInfo(context.getString(R.string.north));
		DkInfo eastInfo = new DkInfo(context.getString(R.string.east));
		DkInfo southInfo = new DkInfo(context.getString(R.string.south));
		DkInfo westInfo = new DkInfo(context.getString(R.string.west));

		root.addChild(northInfo).addChild(eastInfo).addChild(southInfo).addChild(westInfo);

		final double north = degrees;
		final double east = DkCompasses.calcDisplayAngle(north + 90);
		final double south = DkCompasses.calcDisplayAngle(north + 180);
		final double west = DkCompasses.calcDisplayAngle(north + 270);

		String northDegrees = DkCompasses.calcOneDecimalDisplayAngle(north);
		String eastDegrees = DkCompasses.calcOneDecimalDisplayAngle(east);
		String southDegrees = DkCompasses.calcOneDecimalDisplayAngle(south);
		String westDegrees = DkCompasses.calcOneDecimalDisplayAngle(west);
		String degreesKey = context.getString(R.string.degrees);

		northInfo.addChild(new DkInfo(degreesKey, northDegrees));
		eastInfo.addChild(new DkInfo(degreesKey, eastDegrees));
		southInfo.addChild(new DkInfo(degreesKey, southDegrees));
		westInfo.addChild(new DkInfo(degreesKey, westDegrees));

		// get ring names
		if (rings == null) {
			rings = Collections.emptyList();
		}
		for (DkRing ring : rings) {
			double rotateDegrees = ring.getRotatedDegrees();
			List<String> words = ring.getWords();
			final int wordCnt = words.size();
			double delta = 360.0 / wordCnt;
			double offset = DkCompasses.calcDisplayAngle(-delta / 2 + rotateDegrees);
			String ringName = ring.getRingName();

			for (int i = 0; i < wordCnt; ++i) {
				String word = words.get(i);
				double fromDegrees = DkCompasses.calcDisplayAngle(offset + i * delta);
				double toDegrees = DkCompasses.calcDisplayAngle(fromDegrees + delta);

				collectInfo(northInfo, ringName, north, fromDegrees, toDegrees, word);
				collectInfo(eastInfo, ringName, east, fromDegrees, toDegrees, word);
				collectInfo(southInfo, ringName, south, fromDegrees, toDegrees, word);
				collectInfo(westInfo, ringName, west, fromDegrees, toDegrees, word);
			}
		}

		return root;
	}

	private void collectInfo(DkInfo info, String ringName, double angle, double from, double to, String word) {
		if ((from <= angle && angle <= to) || (from > to && (from <= angle || angle <= to))) {
			info.addChild(new DkInfo(ringName, word));
		}
	}

	TypeEvaluator getArgbEvaluator() {
		if (mArgbEvaluator == null) {
			mArgbEvaluator = new MyArgbEvaluator();
		}
		return mArgbEvaluator;
	}

	class MyArgbEvaluator implements TypeEvaluator {
		@Override
		public Object evaluate(float fraction, Object startValue, Object endValue) {
			int startInt = (Integer) startValue;
			float startA = ((startInt >> 24) & 0xff) / 255.0f;
			float startR = ((startInt >> 16) & 0xff) / 255.0f;
			float startG = ((startInt >> 8) & 0xff) / 255.0f;
			float startB = (startInt & 0xff) / 255.0f;

			int endInt = (Integer) endValue;
			float endA = ((endInt >> 24) & 0xff) / 255.0f;
			float endR = ((endInt >> 16) & 0xff) / 255.0f;
			float endG = ((endInt >> 8) & 0xff) / 255.0f;
			float endB = (endInt & 0xff) / 255.0f;

			// convert from sRGB to linear
			startR = (float) Math.pow(startR, 2.2);
			startG = (float) Math.pow(startG, 2.2);
			startB = (float) Math.pow(startB, 2.2);

			endR = (float) Math.pow(endR, 2.2);
			endG = (float) Math.pow(endG, 2.2);
			endB = (float) Math.pow(endB, 2.2);

			// compute the interpolated color in linear space
			float a = startA + fraction * (endA - startA);
			float r = startR + fraction * (endR - startR);
			float g = startG + fraction * (endG - startG);
			float b = startB + fraction * (endB - startB);

			// convert back to sRGB in the [0..255] range
			a = a * 255.0f;
			r = (float) Math.pow(r, 1.0 / 2.2) * 255.0f;
			g = (float) Math.pow(g, 1.0 / 2.2) * 255.0f;
			b = (float) Math.pow(b, 1.0 / 2.2) * 255.0f;

			return Math.round(a) << 24 | Math.round(r) << 16 | Math.round(g) << 8 | Math.round(b);
		}
	}
}
