package com.sevendo.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

/**
 * <b>Description:</b></br> 
 * <b>Title:</b>360问医生后台管理
 * @company:7dosoft
 * @author: txd
 * @Date: 2014-9-22下午1:20:34
 * @version 1.0
 */
public class IKAnalyzerUtil
{
	public static double getSimilarity(Vector<String> doc1, Vector<String> doc2) {
		int size = 0 , size2 = 0 ;
        if (doc1 != null && ( size = doc1.size() ) > 0 && doc2 != null && ( size2 = doc2.size() ) > 0) {
             
            Map<String, int[]> intersectMap = new HashMap<String, int[]>();
             
            //将两个字符串中的中文字符以及出现的总数封装到，intersectMap中
            for ( int i = 0 ; i < size ; i++ ) {
                String d1 = doc1.get(i);
                String charIndex = d1 ;
                if(charIndex != null){
                    int[] fq = intersectMap.get(charIndex);
                    if( fq != null && fq.length == 2 ){
                        fq[0]++;
                    }else {
                        fq = new int[2];
                        fq[0] = 1;
                        fq[1] = 0;
                        intersectMap.put(charIndex, fq);
                    }
                }
            }
 
            for ( int i = 0; i < size2 ; i++ ) {
                String d2 = doc2.get(i);
                String charIndex = d2 ;
                if(charIndex != null ){
                    int[] fq = intersectMap.get(charIndex);
                    if(fq != null && fq.length == 2){
                        fq[1]++;
                    }else {
                        fq = new int[2];
                        fq[0] = 0;
                        fq[1] = 1;
                        intersectMap.put(charIndex, fq);
                    }
                }
            }
            /*for (String key : intersectMap.keySet()) {
            	System.out.print( key + " " );
            }
            System.out.println() ;*/
            Iterator<String> iterator = intersectMap.keySet().iterator();
            double sqdoc1 = 0;
            double sqdoc2 = 0;
            double denominator = 0; 
            while(iterator.hasNext()){
                int[] c = intersectMap.get(iterator.next());
                denominator += c[0]*c[1];
                sqdoc1 += c[0]*c[0];
                sqdoc2 += c[1]*c[1];
            }
             
            return denominator / Math.sqrt(sqdoc1*sqdoc2);
        } else {
            throw new NullPointerException(
                    " the Document is null or have not cahrs!!");
        }
    }
	
}
