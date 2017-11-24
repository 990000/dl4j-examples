package com.linan.test;

public class FudanTokenizer {
	private CWSTagger tag;  
	  
    private StopWords stopWords;  
  
    public FudanTokenizer() {  
        String path = this.getClass().getClassLoader().getResource("").getPath();  
        System.out.println(path);  
        try {  
            tag = new CWSTagger(path + "models/seg.m");  
        } catch (LoadModelException e) {  
            e.printStackTrace();  
        }  
  
    }  
  
    public String processSentence(String context) {  
        String s = tag.tag(context);  
        return s;  
    }  
  
    public String processSentence(String sentence, boolean english) {  
        if (english) {  
            tag.setEnFilter(true);  
        }  
        return tag.tag(sentence);  
    }  
  
    public String processFile(String filename) {  
        String result = tag.tagFile(filename);  
  
        return result;  
    }  
  
    /** 
     * 设置分词词典 
     */  
    public boolean setDictionary() {  
        String dictPath = this.getClass().getClassLoader().getResource("models/dict.txt").getPath();  
  
        Dictionary dict = null;  
        try {  
            dict = new Dictionary(dictPath);  
        } catch (IOException e) {  
            return false;  
        }  
        tag.setDictionary(dict);  
        return true;  
    }  
  
    /** 
     * 去除停用词 
     */  
    public List<String> flitStopWords(String[] words) {  
        try {  
            List<String> baseWords = stopWords.phraseDel(words);  
            return baseWords;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
}
