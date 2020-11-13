import java.util.ArrayList;
import java.util.List;

public class Converter {

	public static void main(String[] args) {
		
		convert("r1,p1,r2,p2,r3,p3:L10;x1,y1,x2,y2,x3,y3:L20;a1,b1,a2,b2,a3,b3:L30");

	}

	private static void convert(String str) {
		String[] stringArr = str.split(";");
		
		List<String> col1 = new ArrayList<>();
		
		int i1=0;
		for(String s : stringArr[0].split(",")) {
			if(i1%2==0) {
				col1.add(s);
			}
			i1++;
		}
		
		List<String> row1 = new ArrayList<>();
		for(int i=0; i<stringArr.length; i++) {
			String[] lock = stringArr[i].split("L");
			row1.add(lock[1]);
		}
		
		String[][] matrix = new String[col1.size()+1][row1.size()+1];
		matrix[0][0] = " ";
		
		int i = 1;
		for(String s : row1) {
			matrix[0][i++] = s;
		}
		
		i=1;
		for(String s : col1) {
			matrix[i++][0] = s;
		}
		
		for(int i2=0; i2<row1.size(); i2++) {
			int j = 1;
			int k=0;
			for(String s : stringArr[i2].split(",")) {
				if(s.contains(":")) {
					s= s.substring(0, s.indexOf(":"));
				}
				if(k%2!=0) matrix[j++][i2+1] = s;
				k++;
			}
		}
		
		for(int x = 0; x<=col1.size(); x++) {
			for(int y = 0; y<=row1.size(); y++) {
				System.out.print(matrix[x][y]+" ");
			}
			System.out.println("");
		}
	}

}
