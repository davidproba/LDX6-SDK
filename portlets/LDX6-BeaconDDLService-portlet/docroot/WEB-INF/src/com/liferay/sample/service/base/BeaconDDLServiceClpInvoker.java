/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.sample.service.base;

import com.liferay.sample.service.BeaconDDLServiceUtil;

import java.util.Arrays;

/**
 * @author David Proba
 * @generated
 */
public class BeaconDDLServiceClpInvoker {
	public BeaconDDLServiceClpInvoker() {
		_methodName18 = "getBeanIdentifier";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "setBeanIdentifier";

		_methodParameterTypes19 = new String[] { "java.lang.String" };

		_methodName24 = "getActiveBeaconUUID";

		_methodParameterTypes24 = new String[] { "java.lang.String" };

		_methodName25 = "getActiveBeaconMajor";

		_methodParameterTypes25 = new String[] { "java.lang.String" };

		_methodName26 = "getActiveBeaconMinor";

		_methodParameterTypes26 = new String[] { "java.lang.String" };

		_methodName27 = "getActiveBeaconHeader";

		_methodParameterTypes27 = new String[] { "java.lang.String" };

		_methodName28 = "getActiveBeaconBody";

		_methodParameterTypes28 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return BeaconDDLServiceUtil.getBeanIdentifier();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			BeaconDDLServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return BeaconDDLServiceUtil.getActiveBeaconUUID((java.lang.String)arguments[0]);
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return BeaconDDLServiceUtil.getActiveBeaconMajor((java.lang.String)arguments[0]);
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return BeaconDDLServiceUtil.getActiveBeaconMinor((java.lang.String)arguments[0]);
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return BeaconDDLServiceUtil.getActiveBeaconHeader((java.lang.String)arguments[0]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return BeaconDDLServiceUtil.getActiveBeaconBody((java.lang.String)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
}