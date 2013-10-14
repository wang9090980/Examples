/*
 * Copyright 2013 Peng fei Pan
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.xiaopan.examples.android.net.request;

import me.xiaopan.easy.network.android.http.Host;
import me.xiaopan.easy.network.android.http.Path;
import me.xiaopan.easy.network.android.http.Request;


@Host("http://www.weather.com.cn/data/cityinfo")
@Path("101010100.html")
public class WeatherRequest implements Request{
	
}
