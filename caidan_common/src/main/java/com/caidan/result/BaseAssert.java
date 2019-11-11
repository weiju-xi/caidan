package com.caidan.result;

import java.util.Collection;
import java.util.Map;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.caidan.execption.DataValidException;


/**
 * @ClassName BaseAssert
 * @Description 断言验证，抛出异常，返回不同异常
 */
public class BaseAssert {

	/**
	 * 验证为空
	 * @param object
	 * @param message
	 */
	public static void isNull(Object object, String message) {
		if (object != null) {
			throw new DataValidException(message);
		}
	}
	/**
	 * 验证不为空
	 * @param object
	 * @param message
	 */
	public static void notNull(Object object, String message) {
		if (object == null) {
			throw new DataValidException(message);
		}
	}
	
	/**
	 * 验证字符串
	 * @param text
	 * @param message
	 */
	public static void hasLength(String text, String message) {
		if (!StringUtils.hasLength(text)) {
			throw new DataValidException(message);
		}
	}
	/**
	 * 验证字符串(包括空白符)
	 * @param text
	 * @param message
	 */
	public static void hasText(String text, String message) {
		if (!StringUtils.hasText(text)) {
			throw new DataValidException(message);
		}
	}
	/**
	 * 
	 * 验证字符串包含子字符串
	 * @param textToSearch
	 * @param substring
	 * @param message
	 */
	public static void doesNotContain(String textToSearch, String substring, String message) {
		if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring) &&
				textToSearch.contains(substring)) {
			throw new DataValidException(message);
		}
	}
	/**
	 * 验证数组不为空
	 * @param array
	 * @param message
	 */
	public static void notEmpty(Object[] array, String message) {
		if (ObjectUtils.isEmpty(array)) {
			throw new DataValidException(message);
		}
	}
	/**
	 * 验证数组内元素全不为空
	 * @param array
	 * @param message
	 */
	public static void noNullElements(Object[] array, String message) {
		if (array != null) {
			for (Object element : array) {
				if (element == null) {
					throw new DataValidException(message);
				}
			}
		}
	}
	/**
	 * 验证集合不为空
	 * @param collection
	 * @param message
	 */
	public static void notEmpty(Collection<?> collection, String message) {
		if (CollectionUtils.isEmpty(collection)) {
			throw new DataValidException(message);
		}
	}
	/**
	 * 验证map不为空
	 * @param map
	 * @param message
	 */
	public static void notEmpty(Map<?, ?> map, String message) {
		if (CollectionUtils.isEmpty(map)) {
			throw new DataValidException(message);
		}
	}
	
	/**
	 * 验证表达式为真，为假抛异常
	 * @param expression
	 * @param message
	 */
	public static void isTrue(boolean expression, String message) {
		if (!expression) {
			throw new DataValidException(message);
		}
	}
	
	/**
	 * 直接抛异常(用于数据校验判断不通过提示)
	 */
	public static void fail(String message) {
		throw new DataValidException(message);
	}
	
}
