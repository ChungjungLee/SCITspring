package global.sesoc.web2.vo;

public class ConverterArr {

	/* mm, cm, m, km, inch, ft, yard, mile 순으로 변환 */
	private final static double[] converterArr =
			{1.0, 0.1, 0.01, 0.001, 39370.0787, 0.083333, 0.333333, 0.000568};
	
	private ConverterArr() {
		System.out.println("converter array class declared");
	}
	
	private static class Singleton {
		private static ConverterArr instance = new ConverterArr();
	}
	
	public static ConverterArr getInstance() {
		return Singleton.instance;
	}
	
	public static double convertion(double toConvert, int from, int to) {
		double result = toConvert;
		
		if (from > to) {
			for (int i = from; i > to; i--) {
				result = result / converterArr[i];
			}
		} else {
			for (int i = from; i < to; i++) {
				result = result * converterArr[i + 1];
			}
		}
			
		return result;
	}
}

