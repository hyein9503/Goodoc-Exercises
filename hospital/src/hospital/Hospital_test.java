/*진료하는 병원의 거리순 출력 
 * 국민대학교 20143054 남혜인  */

package hospital;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Hospital_test {

  public static void main(String[] args) {
    try {
      // csv 데이타 파일
      File csv = new File("./hospital_info.csv");

      BufferedReader br = new BufferedReader(new FileReader(csv));
  		
      String[][] table= new String[27][12];//자료 불러오는 이차원 배열
      
      int[] hospital_ok=new int[27];// 입력한 날짜에 해당하는 병원 리스트(행) 저장   
      int[] distance=new int[27];
  	
      String line = "";
      
      int total=0; // 입력한 날짜에 진료하는 병원의 수(초기값=0)
      int row =0;
      int i;
      
        
      //행을 1부터 병원정보 , 0행은 이름 , 날짜   

      while ((line = br.readLine()) != null) {
          // -1 옵션은 마지막 "," 이후 빈 공백도 읽기 위한 옵션
          String[] token = line.split(",", -1);
          for(i=0;i<12;i++)   table[row][i] = token[i];
          
          // CSV에서 읽어 배열에 옮긴 자료 확인하기 위한 출력
          /*for(i=0;i<12;i++)    System.out.print(table[row][i] + ",");
         System.out.println("");*/
          
          row++;
      }
    

      Scanner scan = new Scanner(System.in);      // 문자 입력을 인자로 Scanner 생성
      
      System.out.println("날짜를 입력하세요:");
      
     
      String message = scan.nextLine(); //날짜 입력  받기  
      
      int ok=0;//진료하는 병원을위한인덱스 
      
      for(int a=0;a<12;a++) {//입력한 날짜의 병원중 진료하는 병원 리스트 배열에 저장(행)
    	  
        if(message.equals(table[0][a])) { //입력한 날짜(해당하는 열)의 진료하는 병원 리스트를 뽑기위함   
        	 
        	  for(int b=0;b<27;b++) {
        		  //해당하는 날짜의 진료하는 병원에 해당하는 행 찾기 
        		  if( table[b][a].equals("O")) {hospital_ok[ok]=b;ok++;total++;}
        			  
        			  }
        		  }
        	  }
      
      //System.out.println(total);//진료하는 병원갯수 출력  
   
      /*   
     for(int q=0;q<27;q++) {
    	 
    	 System.out.println(hospital_ok[q]); //진료하는병원 행 출력  
    
     }*/
    
     int d=0;
     int hospital;
     int dis=0;//진료가능한병원의 거리 저장하기위한 인덱
     
     
    //출력 
    System.out.println("오늘진료하는 병원은"+total+"개 입니다.");
    System.out.println();
 
    
    
     while(hospital_ok[d]!=0) {
    		hospital=hospital_ok[d];//진료가능한 병원 인수에 저장(행)
    		 
    		
       //해당하는 날짜의 진료하는 병원에 해당하는 행 찾기 
       distance[dis]=Integer.parseInt(table[hospital][1]); //진료하는 병원에 해당하는 거리들을   배열에 저장  
       	dis++;	//진료하는병원만큼의 인덱스크기에 거리값 할당됨. 
       	d++;
    		}
      			  
       	int min=distance[0];//거리배열의 첫번째 원소를 최소값으로 지정해놈;
       
       	int temp=0;//임시저장변수( 가까운거리순으로 정렬하기위해 사용되는 변수)
  
       	/*
       	for(int e=0;e<total;e++)//진료하는병원의 거리출력(이름순)
       	{
       System.out.println(distance[e]);	
       	
       	}*/
       
       	
     //가까운순으로 거리 정렬하기  
        for(int q=0;q<total;q++) {
        		            for (int j =q + 1; j < total; j++) {
        		                if (distance[q] > distance[j]) {
        		                    temp =distance[q];
        		                    distance[q] = distance[j];
        		                    distance[j] = temp;
        		                }
        		            }
        		          
        		        }
        
        //출력
        System.out.println("가까운 순으로 오늘 진료하는 병원을 알려드리겠습니다.");
        System.out.print("-> ");
        
        String nearest="";//가장가까운병원 출력하기 위한 변수 
        
    	   for(int x=0;x<total;x++) {
    		   
    		   for(int near=1;near<27;near++)//1행부터 병원이름이므
    	       {
    		   if(distance[x]==Integer.parseInt(table[near][1]))/*거리는 1열*/{
    			   //거리에 해당하는 병원이름 출력
    			   
    			 System.out.print(table[near][0]+" ("+distance[x]+"),");//가까운순으로 정렬된 거리에 해당하는 병원 차례대로 출력(병원이름은 0번째 열 )
    			   
    			 if(x==0) nearest=table[near][0];
    		   }
    	       
    	   }
    		   
    		
       }
    	  
      System.out.print("가장 가까운 병원은 "+ nearest +" 입니다.");

      br.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
