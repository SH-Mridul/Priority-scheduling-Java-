package PriorityScheduling;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//get total process from user
		System.out.print("Enter process:");
		int process = input.nextInt(); //total process
		
		Process burstTime[] = new Process[process]; //burst time
		int ta[] = new int[process];     // turn around times
		int wt[] = new int[process];     // waiting times
		
		//getting burstTime and priority
		for(int i = 0; i<process;i++)
		{
			Process p = new Process();
			p.procesId = i+1;
			
			System.out.print("Enter burst time for process "+(i+1)+":");
			p.burstTime = input.nextInt();
	
			System.out.print("Enter priority for time for process "+(i+1)+":");
			p.priority = input.nextInt();
			
			burstTime[i] = p;
		}
		
		//sorting 
		bubbleSort(burstTime);
		
		//calculating T.A and W.T
		int totalTA = 0;
		float wtAv = 0;
		for(int i = 0;i<process;i++)
		{
			totalTA += burstTime[i].burstTime;
			ta[i] = totalTA-0;
			
			wt[i] = totalTA-burstTime[i].burstTime;
			wtAv+= wt[i];
		}
		
		
		float taT = 0;
        for(int i = 0;i<process;i++)
        {
        	taT += ta[i];
        }
		
		System.out.println("\n");
		System.out.println("----------------------------------------");
		System.out.println("P.Id\tB.T\tT.A\tW.T\tPriority");
		System.out.println("----------------------------------------");
		for(int i = 0; i<process;i++)
		{
			System.out.println(burstTime[i].procesId+"\t"+burstTime[i].burstTime+"\t"+ta[i]+"\t"+wt[i]+"\t  "+burstTime[i].priority);
		}
		
		System.out.println("---------------------------");
		System.out.println("   Avarage process time");
		System.out.println("---------------------------");
		
		System.out.println("Avrg.T.A.T:"+(taT/process));
		System.out.println("Avrg.W.T:"+(wtAv/process));
		System.out.println("---------------------------");
		
		System.out.println("\n\n---------------------------------------------------------------------------------");
		for(int i = 0; i<process; i++)
		{
			if(i == process-1)
			{
				System.out.print("|\tp"+(burstTime[i].procesId)+"\t|");
				continue;
			}
			System.out.print("|\tp"+burstTime[i].procesId+"\t");
		}
		System.out.println("\n---------------------------------------------------------------------------------");
							  
		
		for(int i = 0;i<process;i++)
		{
			if(i == 0)
			{
				System.out.print(0+"\t  \t"+ta[i]);
			}else {
				System.out.print("\t  \t"+ta[i]);
			}
		}
		
		input.close();
	}
	
	
	
	//sorting burst time according to priority
	public static void bubbleSort(Process arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j].priority > arr[j + 1].priority) {
                    Process temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
}
