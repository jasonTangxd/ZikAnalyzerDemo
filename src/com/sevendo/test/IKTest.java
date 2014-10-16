package com.sevendo.test;

import java.io.IOException;
import java.io.StringReader;
import java.util.Vector;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;


public class IKTest {

	public IKTest() {
	}
	
	
	public static void main( String[] args ) throws IOException { 
	    /*String doc1 = "医生请问一下我的头为什么会痛？" ;
	    String doc2 = "就是想问一下我的肚子为什么会痛" ;*/
	    String doc1 = "我的头会痛？" ;
	    String doc2 = "我的肚子会痛" ;
	    
	    Vector<String> str1 = new Vector<String>() ;
	    Vector<String> str2 = new Vector<String>() ;
	    
	    StringReader reader = new StringReader(doc1); 
	    IKSegmenter ik = new IKSegmenter(reader,true);//当为true时，分词器进行最大词长切分 
	    Lexeme lexeme = null; 
	    while((lexeme = ik.next())!=null) {
	    	str1.add( lexeme.getLexemeText() ); 
	    }
	    
	    StringReader reader2 = new StringReader(doc2); 
	    IKSegmenter ik2 = new IKSegmenter(reader2,true);//当为true时，分词器进行最大词长切分 
	    
	    Lexeme lexeme2 = null; 
	    while((lexeme2 = ik2.next())!=null) {
	    	str2.add( lexeme2.getLexemeText() ); 
	    }
	    
	    System.out.println( IKAnalyzerUtil.getSimilarity( str1 , str2 ) ) ;
	    System.out.println(str1.toString() + str2.toString() );
	}
	
}
