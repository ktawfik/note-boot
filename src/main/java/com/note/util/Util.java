package com.note.util;

import java.util.Collection;

/**
 * @author ktawfik
 *
 */
public class Util {

	/**
	 * utility method check if the passed collection is empty or not.
	 * @param c
	 * @return true, if the passed collection is null or empty
	 */
	public static boolean isNullOrEmptyCollection(Collection c){
		return c == null || c.isEmpty();
	}
}
