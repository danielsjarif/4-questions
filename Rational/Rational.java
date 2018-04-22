import java.util.Objects;

public class Rational implements Comparable <Rational>{
  private static Rational zero = new Rational(0, 1);

//initialize numerator and denominator
  private  int num, den;

//constructors for rational object

  public Rational(int numerator, int denominator){
    if(denominator == 0){
      throw new ArithmeticException("Cannot divide by 0");
    }

//Simplifies fractions
    int g = gcd(numerator, denominator);
    num = numerator/g;
    den = denominator/g;

    if(den < 0) {
      den = -den;
      num = -num;
    }
  }

  public int numerator() {
    return num;
  }

  public int denominator() {
    return den;
  }

  public String toString() {
    if(den == 1) {
      return num + "";
    } else return num + "/" + den;
  }

  public int compareTo(Rational r) {
    Rational s = this;
    int lhs = r.num * s.den;
    int rhs = r.den * s.num;
    if(lhs < rhs) { return -1; }
    if (rhs < lhs) { return +1; }
    return 0;
  }

//Equals method
  public boolean equals(Object other) {
    if(other == null){ return false; }
    if(other.getClass() != this.getClass()){
      return false;
    }
    Rational r = (Rational) other;
    return compareTo(r) == 0;
  }

//hashCode
  public int hashCode(){
    return this.toString().hashCode();
  }

//Create new rational, r.num + s.num / r.den + s.den
  public static Rational mediant(Rational r, Rational s){
    return new Rational(r.num + s.num, r.den + s.den);
  }

//gcd of absolute num, den
  public static int gcd(int m, int n){
    if (m < 0) { m = -m; }
    if (n < 0) { n = -n; }
    if (0 == n) { return m; }
    else return gcd(n, m % n);
  }

//lcm of absolute num, den
  public static int lcm(int m, int n){
    if (m < 0) { m = -m; }
    if (n < 0) { n = -n; }
    return m * (n / gcd(m,n));
  }

//Rational Addition, x + y
  public Rational add(Rational y){
    Rational x = this;
    if (x.compareTo(zero) == 0){ return y; }
    if (y.compareTo(zero) == 0){ return x; }

//gcd of the num and den of x/y
    int a = gcd(x.num, y.num);
    int b = gcd(x.den, y.den);

    Rational c = new Rational((x.num / a) * (y.den / b) + (y.num / a) * (x.den / b), lcm(x.den, y.den));
    c.num *= a;
    return c;
  }

//Negating, a = -a
  public Rational neg(){
    return new Rational(-num, den);
  }

//Absolute value, a = |a|
  public Rational abs(){
    if(num >= 0){ return this; }
    else return neg();
  }

//Rational Subtraction
  public Rational sub(Rational y){
    Rational x = this;
    return x.add(y.neg());
  }

//Multiplication
  public Rational times(Rational y){
    Rational w = this;
    Rational x = new Rational(w.num, y.den);
    Rational z = new Rational(y.num, w.den);
    return new Rational(x.num * z.num, x.den * z.den);
  }

//Returns the reciprocal... basically. a/b = b/a
  public Rational reciprocal() { return new Rational(den, num); }

//Division
  public Rational divide(Rational y){
    Rational x = this;
    return x.times(y.reciprocal());
  }

//From fraction to decimal
  public double toDecimal(Rational x){
    return (double)num/den;
  }

//Unit tests
   public static void main(String[] args) {
     Rational x, y, z;

//5/3 + 3/5 = 34/15
      x = new Rational(5, 3);
      y = new Rational(3, 5);
      z = x.add(y);
      System.out.println(z);

// 454325/23452345 * 32453245/23453425 =
      x = new Rational(454325, 23452345);
      y = new Rational(32453245, 23453425);
      z = x.times(y);
      System.out.println(z);

//(-1/6) - (-2/-6) = -1/2
      x = new Rational( -1,  6);
      y = new Rational(-2, -6);
      z = x.sub(y);
      System.out.println(z);

//If 0/1 = 0, it will print out true
      x = new Rational(0, 1);
      System.out.println(x.add(x).compareTo(x) == 0);

//
      x = new Rational(2, 3);
      System.out.println(x.toDecimal(x));

//2/0 will throw an ArithmeticException because we can't divide by 0 (obviously).
      x = new Rational(2, 0);
      System.out.println(x);


    }
}
