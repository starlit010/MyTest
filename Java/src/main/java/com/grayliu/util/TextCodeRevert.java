package com.grayliu.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class TextCodeRevert{

	public void revert(String inFileStr, String outFileStr, String oriCode, String newCode){
		
		try{
		
			File inFile = new File(inFileStr);
			File outFile = new File(outFileStr);
			
			FileReader fr = new FileReader(inFile);
			FileWriter fw = new FileWriter(outFile);
			
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String line = null;
			
			while(true){
				
					line = br.readLine();
					if(line != null){
						byte[] oriBytes = line.getBytes(oriCode);
						String newLine = new String(oriBytes,newCode);
						bw.write(newLine,0,newLine.length());
						bw.write("\r\n",0,2);
					}else{
						bw.close();
						break;
					}
				
			}
		
		}catch(Exception e){
			
			
		}
	
	}
	
	public static void main(String...args){
		new TextCodeRevert().revert(args[0],args[1],args[2],args[3]);
	}
}