package com.pyxis.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectListToCSV {

	private static final Logger logger = LoggerFactory.getLogger(ObjectListToCSV.class);

	private static final String CSV_SEPARATOR = ",";

	public static <T> String convertListToCSV(List<T> objectList, boolean headerRequired, String... columns) {
		if (objectList.size() < 1) {
			logger.info("No data in the list to convert to CDR!");
			return "";
		}
		String csv = "";
		T t = objectList.get(0);
		Field[] declaredFields = t.getClass().getDeclaredFields();
		List<String> columnsList = new ArrayList<>(Arrays.asList(columns));
		ArrayList<Field> useableFields = getUseableFields(declaredFields, columnsList);
		if(headerRequired){
			csv = getCSVHeader(csv, useableFields, null, columnsList);
			csv = csv.concat("\n");
		}
		for (T object : objectList) {
			csv = addObjectValue(csv, useableFields, object, columnsList);
			csv = csv.concat("\n");
		}
		return csv;
	}

	private static <T> String addObjectValue(String csv, ArrayList<Field> useableFields, T object,List<String> requiredColumns) {
		for (Field field : useableFields) {
			try {
				if (canFieldUsedDirectly(field)) {
					if (object != null) {
						field.setAccessible(true);
						Object value = field.get(object);
						csv = csv.concat("\""+value + "\""+"");
						field.setAccessible(false);
					}
				} else {
					if (object != null) {
						field.setAccessible(true);
						Object value = field.get(object);
						field.setAccessible(false);
						csv = addObjectValue(csv, getUseableFields(field.getType().getDeclaredFields(), requiredColumns), value, requiredColumns);
					}
				}
			} catch (IllegalArgumentException e) {
				logger.error("");
			} catch (SecurityException e) {
				logger.error("");
			} catch (IllegalAccessException e) {
				logger.error("");
			}
			csv = csv.concat(CSV_SEPARATOR);
		}
		return csv;
	}

	private static boolean canFieldUsedDirectly(Field field) {
		return !field.getType().toString().contains("biplav");
	}

	private static ArrayList<Field> getUseableFields(Field[] declaredFields, List<String> requiredColumns) {
		ArrayList<Field> useableFields = new ArrayList<>();
		for (Field field : declaredFields) {
			if(null != requiredColumns && !requiredColumns.isEmpty()){
				if (!Modifier.isStatic(field.getModifiers()) && requiredColumns.contains(field.getName().toUpperCase())) {
					useableFields.add(field);
				}
			}else {
				if (!Modifier.isStatic(field.getModifiers())) {
					useableFields.add(field);
				}
			}
		}
		return useableFields;
	}

	private static String getCSVHeader(String csv, ArrayList<Field> useableFields, String prefix,List<String> requiredColumns) {
		prefix = (prefix == null) ? "" : prefix;
		for (Field field : useableFields) {
			if (canFieldUsedDirectly(field)) {
				csv = csv.concat(prefix + field.getName());
				csv = csv.concat(CSV_SEPARATOR);
			} else {
				csv = getCSVHeader(csv, getUseableFields(field.getType().getDeclaredFields(), requiredColumns), field.getName() + "_", requiredColumns);
			}
		}
		return csv;
	}
}
