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

package com.liferay.AdvancedTasks;

import com.liferay.portal.NoSuchModelException;

/**
 * @author David Proba
 */
public class NoSuchAdvTaskException extends NoSuchModelException {

	public NoSuchAdvTaskException() {
		super();
	}

	public NoSuchAdvTaskException(String msg) {
		super(msg);
	}

	public NoSuchAdvTaskException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchAdvTaskException(Throwable cause) {
		super(cause);
	}

}