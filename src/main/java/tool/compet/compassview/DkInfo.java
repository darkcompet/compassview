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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DkInfo {
	@Expose
	@SerializedName("key")
	public String key;

	@Expose
	@SerializedName("value")
	public String value;

	@Expose
	@SerializedName("list")
	public List<DkInfo> children = new ArrayList<>();

	public DkInfo() {
	}

	public DkInfo(String key) {
		this.key = key;
	}

	public DkInfo(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public DkInfo addChild(DkInfo child) {
		if (child != null) {
			children.add(child);
		}
		return this;
	}
}
