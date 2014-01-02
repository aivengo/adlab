package adlab.lab1;

public class lab1 {
	
	public static double p1(int N, int n, int Df, int k){
		if( 0 == k ){
			if( 0 == n ){
				return 1;
			}else{  // n != 0
				double res = 1;
				for( int i = 1; i <= n; i++ ){
					res *= (1.0*(N-Df-i+1))/(N-i+1);
				}
				return res;
			}
		}else{  // k != 0
			if( 0 == n ){
				return 0;
			}else{
				if( n < k ){
					return 0;
				}else{
					double res = 1;
					if( n == k ){
						for( int i = 1; i <= n; i++ ){
							res *= ((1.0*(Df-i+1))/(N-i+1));
						}
						return res;
					}else{  // n > k
						for( int i = 1; i <= k; i++ ){
							res *= ( 1.0*(Df-i+1)*(n-i+1) )/(i*(N-n+i));
						}
						for( int i = 1; i <= (n-k); i++ ){
							res *= ( 1.0*(N-Df-i+1) )/( N-i+1 );
						}
						return res;
					}
				}
			}
		}
	}
	
	public static double p2(int N, int n, int Df, int k){
		return 0;
	}

	public static double p3(int N, int n, int Df, int k){
		return 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N, Dp, Dz, n_min, n_max, step, c = 0;
		double alpha, beta;
		
		n_min = 50;
		n_max = 100;
		step = 5;
		Dp = 25;
		N = 500;
		alpha = 0.01;
		double sum = 0;
		for( int n = n_min; n <= n_max; n += step){
			//System.out.println("n = " + n);
			for(int i = n; i >= 0; i--){
				sum += p1(N, n, Dp, i);
				//System.out.println("sum = " + sum + "  alpha = " + alpha);
				if ( alpha < sum ){
					c = i;
					sum = 0;
					break;
				}
			}
			System.out.println("c = " + c);
		}
	}
}
