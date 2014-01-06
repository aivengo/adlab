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
		if( 0 == k ){
			if( 0 == n ){
				return 1;
			}else{  // n != 0
				double res = 1;
				double ro = (1.0*Df)/N;
				res = Math.pow(1-ro, n);
				return res;
			}
		}else{  // k != 0
			if( 0 == n ){
				return 0;
			}else{ // n != 0
				if( n < k ){
					return 0;
				}else{  // n >= k
					double res = 1;
					double ro = (1.0*Df)/N;
					if( n == k ){
						res = Math.pow(ro, n);
						return res;
					}else{  // n > k
						int nk = n - k;
						for( int i = 1; i <= k; i++ ){
							res *= ((1.0*nk)/i + 1 );
						}
						res *= Math.pow( (1-ro), nk )*Math.pow(ro, k);
						return res;
					}
				}
			}
		}
	}

	public static double p3(int N, int n, int Df, int k){
		double res = 1;
		double y = (1.0*n*Df)/N;
		for ( int i = 1; i <= k; i++ ){
			res *= y/i;
		}
		res *= Math.exp(-y);
		return res;
	}

	public static void main(String[] args) {

		int N, Dp, Dz, n_min, n_max, step;
		int c = 0;
		double alpha, beta = 0;
		
		N = 1000;
		Dp = 50;
		Dz = 100;
		n_min = 100;
		n_max = 200;
		step = 10;
		
		alpha = 0.1;
		double sum = 0;
		
		for( int n = n_min; n <= n_max; n += step ){
			System.out.println("n = " + n);
			
			//System.out.println("P#1");
			
			//Calculate c#1
			for(int i = n; i >= 0; i-- ){
				sum += p1(N, n, Dp, i);
				//System.out.println("sum = " + sum + "  alpha = " + alpha);
				if ( alpha < sum ){
					c = i;
					sum = 0;
					break;
				}
			}
			System.out.print("c = " + c + "  ");
			
			// Calculate beta#1
			for( int i = 0; i <= c; i++ ){
				beta += p1(N, n, Dz, i);
				//System.out.println("sum = " + beta);
			}
			//System.out.println("beta = " + beta);
			System.out.format("beta = %.3f%n", beta);
			sum = c = 0;
			beta = 0;
			
			
			//System.out.println("P#2");
			
			//Calculate c#2
			for(int i = n; i >= 0; i-- ){
				sum += p2(N, n, Dp, i);
				//System.out.println("sum = " + sum + "  alpha = " + alpha);
				if ( alpha < sum ){
					c = i;
					sum = 0;
					break;
				}
			}
			System.out.print("c = " + c + "  ");
			
			// Calculate beta#2
			for( int i = 0; i <= c; i++ ){
				beta += p2(N, n, Dz, i);
				//System.out.println("sum = " + beta);
			}
			//System.out.println("beta = " + beta);
			System.out.format("beta = %.3f%n", beta);
			sum = c = 0;
			beta = 0;
			
			
			//System.out.println("P#3");
			
			//Calculate c#3
			for(int i = n; i >= 0; i-- ){
				sum += p3(N, n, Dp, i);
				//System.out.println("sum = " + sum + "  alpha = " + alpha);
				if ( alpha < sum ){
					c = i;
					sum = 0;
					break;
				}
			}
			System.out.print("c = " + c + "  ");
			
			// Calculate beta#3
			for( int i = 0; i <= c; i++ ){
				beta += p3(N, n, Dz, i);
				//System.out.println("sum = " + beta);
			}
			//System.out.println("beta = " + beta);
			System.out.format("beta = %.3f%n", beta);
			sum = c = 0;
			beta = 0;
			
		}
		
	}
}
