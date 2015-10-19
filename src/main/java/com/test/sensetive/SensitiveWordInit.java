package com.test.sensetive;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class SensitiveWordInit {
	@SuppressWarnings("rawtypes")
	public HashMap sensitiveWordMap;

	@SuppressWarnings("rawtypes")
	public Map initKeyWord() {
		try {
			Set<String> keyWordSet = readSensitiveWordFile();
			addSensitiveWordToHashMap(keyWordSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sensitiveWordMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addSensitiveWordToHashMap(Set<String> keyWordSet) {
		sensitiveWordMap = new HashMap(keyWordSet.size());
		String key = null;
		Map nowMap = null;
		Map<String, String> newWorMap = null;

		Iterator<String> iterator = keyWordSet.iterator();
		while(iterator.hasNext()){
			key = iterator.next();
			nowMap = sensitiveWordMap;
			for(int i = 0 ; i < key.length() ; i++) {
				char keyChar = key.charAt(i);
				Object wordMap = nowMap.get(keyChar);
				
				if(wordMap != null) {
					nowMap = (Map)wordMap;
				} else {
					newWorMap = new HashMap<String,String>();
					newWorMap.put("isEnd", "0");
					nowMap.put(keyChar, newWorMap);
					nowMap = newWorMap;
				}
				
				if(i == key.length() - 1) {
					nowMap.put("isEnd", "1");
				}
			}
		}
	}

	@SuppressWarnings("resource")
	private Set<String> readSensitiveWordFile() throws Exception{
		Set<String> set = null;
		ClassLoader loader = getClass().getClassLoader();
		InputStream stream = loader.getResourceAsStream("keywords");
		InputStreamReader reader = new InputStreamReader(stream, "UTF-8");

		try {
			set = new HashSet<String>();
			BufferedReader bufferedReader = new BufferedReader(reader);
			String txt = null;
			while((txt = bufferedReader.readLine()) != null){
				set.add(txt);
			}
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
			reader.close();
		}
		return set;
	}
}
