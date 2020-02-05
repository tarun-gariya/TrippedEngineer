package com.netprohets.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TrippedEngineer {

	public static void main(String[] args) throws IOException {

	
		File file = new File("input.txt");
//		System.out.println(file.getAbsolutePath());
		FileInputStream fs = new FileInputStream(file);

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;

		st = br.readLine();
		int t = new Integer(st.trim());
		int count = 0;
		br.readLine();
		
		while (count != t) {
			ArrayList<String> fragmentList = new ArrayList<String>();
			while ((st = br.readLine()) != null && !(st.isEmpty())) {
//				System.out.println("st: " + st);
				fragmentList.add(st);
			}
			int numFragments = fragmentList.size();
			int numFiles = numFragments / 2;
			int Totalzero = 0;
			int Totalone = 0;
			int zero ,one ;
			ArrayList<Model> list = new ArrayList<Model>();
			
			for (int i = 0; i < numFragments; i++) {
				String fragment = fragmentList.get(i);
				Model model = new Model();
				zero = 0;
				one = 0;
				for (int j = 0; j < fragment.length(); j++) {

					if (fragment.charAt(j) == '1') {
						one += 1;
					} else if (fragment.charAt(j) == '0') {
						zero += 1;
					}
				}
				model.setNumOne(one);
				model.setNumZero(zero);
				list.add(model);
				Totalone += one;
				Totalzero += zero;

			}
			
			int n = list.size();
			int numberOfZerosInFile = Totalzero/ numFiles;
			int numberOfOnesInFile = Totalone/ numFiles;
			int lengthOfFile = numberOfOnesInFile + numberOfZerosInFile;

			/*
			 * System.out.println(numberOfZerosInFile);
			 * System.out.println(numberOfOnesInFile); System.out.println(lengthOfFile);
			 */
			
			/*
			 * for (int i = 0; i < list.size(); i++) {
			 * System.out.println(list.get(i).toString()); }
			 */
			Model model = new Model();
			model.setNumOne(numberOfOnesInFile);
			model.setNumZero(numberOfZerosInFile);

			
			/*
			 * if (isSubsetSum(list, n, model) == true) System.out.println("Found a subset"
			 * + " with given sum"); else System.out.println("No subset with" +
			 * " given sum");
			 */
//			Map<Model, Model> pairs = new HashMap();
			
			ArrayList<Combination> comboList =new ArrayList<Combination>();
			
			for (int x = 0; x < n; x++) {
				if(list.size()==0)
				break;
				
				for (int y = 0; y < list.size()-1; y++) {
//					System.out.println("2");
					Model i=list.get(0);
					Model j=list.get(y+1);
					
//					System.out.println("y: "+y);
					
					if(i.getTotalLength()+j.getTotalLength()==model.getTotalLength())
					{
						
//						System.out.println(i+"    "+j+"  "+i.getTotalLength()+"  "+j.getTotalLength()+"   "+model.getTotalLength());
						
						
						if(i.getNumOne()+j.getNumOne()==model.getNumOne()
								&&
								i.getNumZero()+j.getNumZero()==model.getNumZero())
						{
							
							Combination combo = new  Combination();
							combo.setA(fragmentList.get(0));
							combo.setB(fragmentList.get(y+1));
							/*
							 * System.out.println("fragment1:"+fragmentList.get(0));
							 * System.out.println("fragment2:" +fragmentList.get(y+1));
							 */							
							combo.setAbBa(fragmentList.get(0),fragmentList.get(y+1));
							comboList.add(combo);
							
							
							/*
							 * System.out.println("fragment ab "+combo.getAb());
							 * System.out.println("fragment ba "+combo.getBa());
							 * System.out.println("list.size(): "+list.size());
							 * 
							 */
							list.remove(y+1);
							list.remove(0);
							

							fragmentList.remove(y+1);
							fragmentList.remove(0);
							break;
							
						}
					}
				}
				/*
				 * Combination combo = new Combination(); combo.setA(fragmentList.get(0));
				 * combo.setB(fragmentList.get(1)); comboList.add(combo);
				 */
			}
			
			/*
			 * for (int i = 0; i < comboList.size(); i++) {
			 * System.out.println(comboList.get(i).toString()); }
			 */			
			
			
			ArrayList<PartialAnswer> partialList = new ArrayList<PartialAnswer>();
			ArrayList<String> finalList = new ArrayList<String>();
			PartialAnswer partialAnswer ;
			int max =1;
			int index=0;
			
			for (int i = 0; i < comboList.size(); i++) {
				if(finalList.isEmpty()) {
					finalList.add(comboList.get(i).getAb());
					finalList.add(comboList.get(i).getBa());
					partialAnswer = new PartialAnswer(comboList.get(i).getAb());
					partialList.add(partialAnswer);
					partialAnswer = new PartialAnswer(comboList.get(i).getBa());
					partialList.add(partialAnswer);
					continue;
				}
				
				int a;
				if (!finalList.contains(comboList.get(i).getAb())) {
					finalList.add(comboList.get(i).getAb());
					partialAnswer = new PartialAnswer(comboList.get(i).getAb());
						partialList.add(partialAnswer);
				}else {
					a=finalList.indexOf(comboList.get(i).getAb());
					int aa =partialList.get(a).increment();
					if(aa>max)
					{
						max=aa;
						index=a;
					}
				}
				
				if (!finalList.contains(comboList.get(i).getBa())) {
					finalList.add(comboList.get(i).getBa());
					partialAnswer = new PartialAnswer(comboList.get(i).getBa());	
					partialList.add(partialAnswer);
				}else {
					a=finalList.indexOf(comboList.get(i).getBa());
					int aa=partialList.get(a).increment();
					if(aa>max)
					{
						max=aa;
						index=a;
					}
				}
			}
			
			/*
			 * for (int i = 0; i < partialList.size(); i++) {
			 * System.out.println(partialList.get(i).toString()); }
			 */			
			System.out.println("answer: "+ finalList.get(index));
			
			
			
			/*
			 * String[] output =new String[comboList.size()]; String ans ="" ;
			 * if(comboList.get(0).getAb().equals(comboList.get(1).getAb())) {
			 * ans=comboList.get(0).getAb(); }else
			 * if(comboList.get(0).getAb().equals(comboList.get(1).getBa())) {
			 * ans=comboList.get(0).getAb(); }else
			 * if(comboList.get(0).getBa().equals(comboList.get(1).getAb())) {
			 * ans=comboList.get(1).getAb(); }else
			 * if(comboList.get(0).getBa().equals(comboList.get(1).getBa())) {
			 * ans=comboList.get(0).getBa(); }
			 * 
			 * 
			 * 
			 * //output store karne h bus fir show karnqa h after match
			 * output[0]=output[1]=ans;
			 * 
			 * 
			 * for (int i = 2; i < comboList.size(); i++) {
			 * if(comboList.get(i).getAb().equals(ans)) {
			 * output[i]=comboList.get(i).getAb(); }else
			 * if(comboList.get(i).getBa().equals(ans)) {
			 * 
			 * output[i]=comboList.get(0).getAb(); } else
			 * System.out.println("not martched"); }
			 * 
			 * for (int i = 0; i < output.length; i++) {
			 * System.out.println(i+"   "+output[i]); }
			 */
			
			count += 1;
		}

	}

	/*
	 * static boolean isSubsetSum(ArrayList<Model> list, int n, Model model) { //
	 * Base Cases if (model.getTotalLength()== 0) return true; if (n == 0 &&
	 * model.getTotalLength() != 0) return false;
	 * 
	 * // If last element is greater than // sum, then ignore it if (set[n - 1] >
	 * sum) return isSubsetSum(set, n - 1, sum);
	 * 
	 * 
	 * else, check if sum can be obtained by any of the following (a) including the
	 * last element (b) excluding the last element
	 * 
	 * return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n -
	 * 1]); }
	 */

}

//Set<String> set = new HashSet<String>();

/*
 * for (int i = 0; i < numFragments; i++) { String fragment=
 * fragmentList.get(i);
 * 
 * for (int j = 0; j < fragment.length(); j++) { String a =
 * fragment.substring(0,j); String b = fragment.substring(j,fragment.length());
 * if(!set.contains(a)){ set.add(a); }else{ set. }
 * 
 * 
 * set.add(b);
 * 
 * 
 * }
 * 
 * }
 */
