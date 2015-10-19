package com.test.sensetive;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SensitivewordFilter {
	@SuppressWarnings("rawtypes")
	private Map sensitiveWordMap = null;
	public static int minMatchType = 1;
	public static int maxMatchType = 2;

	public SensitivewordFilter() {
		sensitiveWordMap = new SensitiveWordInit().initKeyWord();
	}

	public boolean isContaintSensitiveWord(String txt, int matchType){
		boolean flag = false;
		for(int i = 0; i < txt.length(); i++) {
			int matchFlag = this.CheckSensitiveWord(txt, i, matchType);
			if(matchFlag > 0) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public Set<String> getSensitiveWord(String txt, int matchType){
		Set<String> sensitiveWordList = new HashSet<String>();
		
		for(int i = 0; i < txt.length(); i++) {
			int length = CheckSensitiveWord(txt, i, matchType);
			if(length > 0) {
				sensitiveWordList.add(txt.substring(i, i+length));
				i = i + length - 1;
			}
		}
		
		return sensitiveWordList;
	}

	public String replaceSensitiveWord(String txt, int matchType, String replaceChar){
		String resultTxt = txt;
		Set<String> set = getSensitiveWord(txt, matchType);
		Iterator<String> iterator = set.iterator();
		String word = null;
		String replaceString = null;
		while (iterator.hasNext()) {
			word = iterator.next();
			replaceString = getReplaceChars(replaceChar, word.length());
			resultTxt = resultTxt.replaceAll(word, replaceString);
		}
		
		return resultTxt;
	}

	private String getReplaceChars(String replaceChar, int length){
		StringBuilder replaceBuilder = new StringBuilder();
		for(int i = 0; i < length; i++) {
			replaceBuilder.append(replaceChar);
		}
		return replaceBuilder.toString();
	}

	@SuppressWarnings({"rawtypes"})
	public int CheckSensitiveWord(String txt, int beginIndex, int matchType) {
		boolean  flag = false;
		int matchFlag = 0;
		char word = 0;
		Map nowMap = sensitiveWordMap;
		for(int i = beginIndex; i < txt.length(); i++) {
			word = txt.charAt(i);
			nowMap = (Map)nowMap.get(word);
			if(nowMap != null) {
				matchFlag++;
				if("1".equals(nowMap.get("isEnd"))){
					flag = true;
					if(SensitivewordFilter.minMatchType == matchType){
						break;
					}
				}
			}
			else{
				break;
			}
		}
		if(matchFlag < 2 || !flag){
			matchFlag = 0;
		}
		return matchFlag;
	}
	
	public static void main(String[] args) {
		SensitivewordFilter filter = new SensitivewordFilter();
		System.out.println("sensetive words count: " + filter.sensitiveWordMap.size());
		String string = "一次性交纳五百元送话费，出售二手24口交换机及一台独立服务器，要的手机联系我……," +
				"宝鸡巴士公司真诚欢迎来自江阴毛纺厂和江阴道路管理局及上海虹口交警支队的保持党员先进性爱国主义教育小组的领导们！" +
				"下午将参观模拟开放性交互式的全新网络，在此期间各色饮品由X牛酸酸乳房山分销点提供！" +
				"水乳交融 以死逼婚 成熟女性 众口交赞 上校鸡块";
		System.out.println("待检测语句字数：" + string.length());
		long beginTime = System.currentTimeMillis();
		Set<String> set = filter.getSensitiveWord(string, maxMatchType);
		long endTime = System.currentTimeMillis();
		System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
		System.out.println("总共消耗时间为：" + (endTime - beginTime));
	}
}
