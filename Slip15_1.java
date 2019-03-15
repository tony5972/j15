
import java.io.*;
import java.util.*;
class item
{
                String name,id;
                int qty;
                double price,total;

                item(String i,String n,String p,String q)
                {
                                name=n;
                                id=i;
                                qty=Integer.parseInt(q);
                                price=Double.parseDouble(p);
                                total=qty*price;
                }

                public    String toString()
                {

                                String s=name+" "+id+" "+qty+" "+price+" "+total;
                                return(s);
                }
                public static void search(item[] arr,int n)throws IOException
                {

                                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                                String s=br.readLine();
                                for(int i=0;i<n;i++)
                                {
                                                if(arr[i].name.equals(s)){
                                                                System.out.println(arr[i].toString());return;}

                                }
                                System.out.println("No Records Found");           
                }

                public static void search_cost(item[] arr,int n)
                {

                                double max=0;int c=0;

                                for(int i=0;i<n;i++)
                                {
                                                if(arr[i].price > max){
                                                                c=i;
                                                }
                                }
                                System.out.println(arr[c].toString());
                }

}
class Slip15_1
{
                public static void main(String[] args)throws IOException
                {
                                String s,space=" ";
                                int ch,i;
                                BufferedReader b=new BufferedReader(new InputStreamReader(System.in));

                                System.out.println("Enter no. of records");
                                int n=Integer.parseInt(b.readLine());

                                System.out.println("Enter Records:\n<id><name><price><qty> :");

                                File f = new File ("item.dat");
                                RandomAccessFile rf = new RandomAccessFile (f, "rw");

                                for( i=0;i<n;i++)
                                {
                                                s=b.readLine()+"\n";
                                                rf.writeBytes(s);
                                }
                                rf.close();

                                item it[]=new item[20];
                                RandomAccessFile rf1 = new RandomAccessFile (f, "r");
                                for(i=0;i<n;i++)
                                {
                                                s=rf1.readLine();
                                                StringTokenizer t = new StringTokenizer(s,space);
                                                String id=new String(t.nextToken());
                                                String pname=new String(t.nextToken());
                                                String price=new String(t.nextToken());
                                                String qty=new String(t.nextToken());
                                                it[i]=new item(id,pname,price,qty);

                                }

                                do {
                                                System.out.println("Menu :\n"+"1:Search for a item by name\n"+"2:Find costliest item\n"+"3:Display all items and total cost\n4:Exit\n"+"Choice :" );
                                                ch=Integer.parseInt(b.readLine());

                                                switch (ch) {
                                                                case 1: System.out.println("Enter item name to be searched:");
                                                                                item.search(it,n);
                                                                                break;
                                                                case 2: System.out.println("Costliest Item :");
                                                                                item.search_cost(it,n);
                                                                                break;
                                                                case 3:  for(i=0;i<n;i++)
                                                                                                 System.out.println(it[i].toString());        
                                                                                 break;
                                                                case 4: break;
                                                                default:System.out.println("Invalid Option");
                                                }

                                }while(ch!=4);
                }
}