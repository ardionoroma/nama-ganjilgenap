import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class OtomataNama {

	static Map<String, String[][]> state;

	public static void main(String[] args) {
            OtomataNama instate = new OtomataNama();
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

		String[][] Q = state.get("Q0");
		for (int i = 0; i < token.length; i++) {
			for (int j = 0; j < Q.length; j++) {
				if (String.valueOf(token[i]).equalsIgnoreCase(Q[j][0])) {
					cetak(Q[j][0]);
					cetakbr(Q[j][1]);
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
			cetakbr("\nNama Tidak Tersedia!");
		} else {
			cetakbr("\nNama Tersedia!");
		}
	}
        
        public Map<String, String[][]> state() {
		Map<String, String[][]> state = new HashMap<String, String[][]>();
			   state.put("Qend", new String[][] { { "END", "END" } });
               state.put("Q0", new String[][] { { "A", "Q1" }, { "B", "Q2" }, { "L", "QendINDA" }, 
                   { "M", "Q4" }, { "N", "Q5" }, { "R", "Q6" }, { "W", "QendINDA" }, { "Y", "Q8" } });
               //Huruf A
               state.put("Q1", new String[][] { { "F", "Q1s1"}, { "T", "Q1s2"} });
               //Afina
               state.put("Q1s1", new String[][] { {"I", "Q1s12"} });
               state.put("Q1s12", new String[][] { {"N", "QendA"} });
               state.put("QendA", new String[][] { {"A", "Qend"} });
               //Atha
               state.put("Q1s2", new String[][] { {"H", "QendA"} });
               //Brizky
               state.put("Q2", new String[][] { {"R", "Q2s1"} });
               state.put("Q2s1", new String[][] { {"I", "Q2s12"} });
               state.put("Q2s12", new String[][] { {"Z", "Q2s13"} });
               state.put("Q2s13", new String[][] { {"K", "QendY"} });
               state.put("QendY", new String[][] { {"Y", "Qend"} });
               //Linda
               state.put("QendINDA", new String[][] { {"I", "QendNDA"} });
               state.put("QendNDA", new String[][] { {"N", "QendDA"} });
               state.put("QendDA", new String[][] { {"D", "QendA"} });
               //Mufni
               state.put("Q4", new String[][] { {"U", "Q4s1"} });
               state.put("Q4s1", new String[][] { {"F", "Q4s12"} });
               state.put("Q4s12", new String[][] { {"N", "QendI"} });
               state.put("QendI", new String[][] { {"I", "Qend"} });
               //Nico
               state.put("Q5", new String[][] { {"I", "Q5s1"} });
               state.put("Q5s1", new String[][] { {"C", "QendO"} });
               state.put("QendO", new String[][] { {"O", "Qend"} });
               //Huruf R
               state.put("Q6", new String[][] { {"I", "Q6s1"}, {"O", "Q6s2"} });
               //Ridho & Rizki
               state.put("Q6s1", new String[][] { {"D", "Q6s11"}, {"Z", "Q6s12"} });
               //Ridho
               state.put("Q6s11", new String[][] { {"H", "QendO"} });
               //Rizki
               state.put("Q6s12", new String[][] { {"K", "QendI"} });
               //Roma
               state.put("Q6s2", new String[][] { {"M", "QendA"} });
               //Winda
               state.put("Q7", new String[][] { {"I", "QendNDA"} });
               //Yoga
               state.put("Q8", new String[][] { {"O", "Q8s1"} });
               state.put("Q8s1", new String[][] { {"G", "QendA"} });
                
                return state;

	}

	static void cetak(String a) {
		System.out.print(a);
	}

	static void cetakbr(String a) {
		System.out.println(a);
	}

}