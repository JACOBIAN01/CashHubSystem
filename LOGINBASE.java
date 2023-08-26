package ATM;
import ATM.AtmManage;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;
import java.io.File;
public class LOGINBASE {
    static HashMap<Integer, Integer> CN = new HashMap<Integer, Integer>();//Debit card Number:PIN
    static HashMap<Integer,String> CM = new HashMap<Integer,String>();//Account Number:Customer name;
    static HashMap<Integer,Integer> CO = new HashMap<Integer,Integer>();//Debit Card: Account Number
    LOGINBASE() {

        CN.put(70290, 0000);
        CM.put(199101000," SUBHADEEP GHORAI");
        CO.put(70290,199101000);


        CM.put(199101001,"KUNAL BAJANTRI");
        CO.put(81048,199101001);
        CN.put(81048,0001);

        CM.put(199101002,"AKSHAT P SINGH");
        CO.put(95551,199101002);
        CN.put(95551,0002);

        CM.put(199101003,"SHREYAN KABIRAJ");
        CO.put(80018,199101003);
        CN.put(80018,0003);

        CM.put(199101004,"AGNID BHATTACHARJEE");
        CO.put(70217,199101004);
        CN.put(70217,0004);

        CM.put(199101005,"BHANU");
        CO.put(83746,199101005);
        CN.put(83746,0005);

        CM.put(199101006,"ASWIN NAIR");
        CN.put(12345,0006);
        CO.put(12345,199101006);

        CM.put(199101007,"SOYAMSIDH DAS");
        CN.put(73588,0007);
        CO.put(73588,199101007);

        CM.put(199101008,"NEERAJA SINGH");
        CN.put(97114,0007);
        CO.put(97114,199101008);

    }
}
