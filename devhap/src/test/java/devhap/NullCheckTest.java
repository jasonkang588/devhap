package devhap;

public class NullCheckTest {
	public void nullCheck() {
		String strNull = null;
		/*if(strNull.equals("")) {
			System.out.println("yes null string is ok!");
		}*/
		
		if("".equals(strNull)) {
			System.out.println("yes null string is ok!");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NullCheckTest nct = new NullCheckTest();
		nct.nullCheck();
	}

}
