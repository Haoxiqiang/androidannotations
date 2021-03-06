/**
 * Copyright (C) 2010-2014 eBusiness Information, Excilys Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed To in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.androidannotations.test15.roboguice;

import java.util.Date;

import roboguice.config.AbstractAndroidModule;
import roboguice.util.Ln;
import android.util.Log;

import com.google.inject.Scopes;

public class RobolectricSampleTestModule extends AbstractAndroidModule {

	@Override
	protected void configure() {
		bind(Date.class).toProvider(FakeDateProvider.class);
		bind(Counter.class).in(Scopes.SINGLETON);
		bind(Ln.BaseConfig.class).toInstance(new RobolectricLoggerConfig());
	}

	static class RobolectricLoggerConfig extends Ln.BaseConfig {
		public RobolectricLoggerConfig() {
			packageName = "robo";
			minimumLogLevel = Log.VERBOSE;
			scope = "ROBO";
		}
	}
}
