import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class OtomataGanGen {

    static Map<String, String[][]> state;

    public static void main(String[] args) {
        OtomataGanGen instate = new OtomataGanGen();
        state=instate.state();
        String nama = null;
        System.out.println("Masukkan string: ");
        BufferedReader objek = new BufferedReader(new InputStreamReader(System.in));
        try {
            nama = objek.readLine();
        } catch(IOException ioe) {
            System.out.println("Error");
            System.exit(1);
        }
	char[] token = nama.replaceAll("\\W", "").toCharArray();
	cekToken(token);
    }

	

    static void cekToken(char[] token) {
	boolean check = true;
        String GanGen = null;

	String[][] Q = state.get("Q0");
	for (int i = 0; i < token.length; i++) {
            for (int j = 0; j < Q.length; j++) {
                if (String.valueOf(token[i]).equalsIgnoreCase(Q[j][0])) {
                    cetak(Q[j][0]);
                    cetakbr(Q[j][1]);
                    GanGen = Q[j][1]; //Get nama statanya
                    Q = state.get(Q[j][1]);
                    check = true;
                    break;
                } else {
                    check = false;
		}
            }
            if (check == false) {
                cetakbr(String.valueOf(token[i]) + "--WRONG--");
                i = token.length;
            }
	}
	if (!Q[0][0].equalsIgnoreCase("END") || check == false) {
            cetakbr("\nKARAKTER SALAH");
	} else if (GanGen.equalsIgnoreCase("QGanjil")) { //Kalau nama statanya QGanjil
            cetakbr("\nSTRING GANJIL");
	} else {
            cetakbr("\nSTRING GENAP");
        }
    }
        
    public Map<String, String[][]> state() {
	Map<String, String[][]> state = new HashMap<String, String[][]>();
        state.put("QGanjil", new String[][] { { "END", "END" } });
        state.put("QGenap", new String[][] { { "END", "END" } });
        state.put("Q0", new String[][] { { "1", "Q1" }, { "2", "Q2" }, { "3", "Q3" }, 
            { "4", "Q4" }, { "5", "Q5" }, { "6", "Q6" }, { "7", "Q7" }, { "8", "Q8" },
            { "9", "Q9" }, { "0", "Q10"} });
        //Looping Angka 1
        state.put("Q1", new String[][] { { "1", "Q1" }, { "2", "Q2" }, { "3", "Q3" }, 
            { "4", "Q4" }, { "5", "Q5" }, { "6", "Q6" }, { "7", "Q7" }, { "8", "Q8" },
            { "9", "Q9" }, { "0", "Q10"}, { "A", "QGanjil"} });
        //Looping Angka 2
        state.put("Q2", new String[][] { { "1", "Q1" }, { "2", "Q2" }, { "3", "Q3" }, 
            { "4", "Q4" }, { "5", "Q5" }, { "6", "Q6" }, { "7", "Q7" }, { "8", "Q8" },
            { "9", "Q9" }, { "0", "Q10"}, { "A", "QGenap"} });
        //Looping Angka 3
        state.put("Q3", new String[][] { { "1", "Q1" }, { "2", "Q2" }, { "3", "Q3" }, 
            { "4", "Q4" }, { "5", "Q5" }, { "6", "Q6" }, { "7", "Q7" }, { "8", "Q8" },
            { "9", "Q9" }, { "0", "Q10"}, { "A", "QGanjil"} });
        //Looping Angka 4
        state.put("Q4", new String[][] { { "1", "Q1" }, { "2", "Q2" }, { "3", "Q3" }, 
            { "4", "Q4" }, { "5", "Q5" }, { "6", "Q6" }, { "7", "Q7" }, { "8", "Q8" },
            { "9", "Q9" }, { "0", "Q10"}, { "A", "QGenap"} });
        //Looping Angka 5
        state.put("Q5", new String[][] { { "1", "Q1" }, { "2", "Q2" }, { "3", "Q3" }, 
            { "4", "Q4" }, { "5", "Q5" }, { "6", "Q6" }, { "7", "Q7" }, { "8", "Q8" },
            { "9", "Q9" }, { "0", "Q10"}, { "A", "QGanjil"} });
        //Looping Angka 6
        state.put("Q6", new String[][] { { "1", "Q1" }, { "2", "Q2" }, { "3", "Q3" }, 
            { "4", "Q4" }, { "5", "Q5" }, { "6", "Q6" }, { "7", "Q7" }, { "8", "Q8" },
            { "9", "Q9" }, { "0", "Q10"}, { "A", "QGenap"} });
        //Looping Angka 7
        state.put("Q7", new String[][] { { "1", "Q1" }, { "2", "Q2" }, { "3", "Q3" }, 
            { "4", "Q4" }, { "5", "Q5" }, { "6", "Q6" }, { "7", "Q7" }, { "8", "Q8" },
            { "9", "Q9" }, { "0", "Q10"}, { "A", "QGanjil"} });
        //Looping Angka 8
        state.put("Q8", new String[][] { { "1", "Q1" }, { "2", "Q2" }, { "3", "Q3" }, 
            { "4", "Q4" }, { "5", "Q5" }, { "6", "Q6" }, { "7", "Q7" }, { "8", "Q8" },
            { "9", "Q9" }, { "0", "Q10"}, { "A", "QGenap"} });
        //Looping Angka 9
        state.put("Q9", new String[][] { { "1", "Q1" }, { "2", "Q2" }, { "3", "Q3" }, 
            { "4", "Q4" }, { "5", "Q5" }, { "6", "Q6" }, { "7", "Q7" }, { "8", "Q8" },
            { "9", "Q9" }, { "0", "Q10"}, { "A", "QGanjil"} });
        //Looping Angka 0
        state.put("Q10", new String[][] { { "1", "Q1" }, { "2", "Q2" }, { "3", "Q3" }, 
            { "4", "Q4" }, { "5", "Q5" }, { "6", "Q6" }, { "7", "Q7" }, { "8", "Q8" },
            { "9", "Q9" }, { "0", "Q10"}, { "A", "QGenap"} });
                
        return state;

    }

    static void cetak(String a) {
	System.out.print(a);
    }

    static void cetakbr(String a) {
	System.out.println(a);
    }

}