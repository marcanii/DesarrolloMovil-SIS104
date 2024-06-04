class Complex {
  final double real;
  final double imaginary;

  Complex(this.real, this.imaginary);

  // Suma de números complejos
  Complex operator +(Complex other) {
    return Complex(real + other.real, imaginary + other.imaginary);
  }

  // Resta de números complejos
  Complex operator -(Complex other) {
    return Complex(real - other.real, imaginary - other.imaginary);
  }

  // Multiplicación de números complejos
  Complex operator *(Complex other) {
    return Complex(
      real * other.real - imaginary * other.imaginary,
      real * other.imaginary + imaginary * other.real,
    );
  }

  // División de números complejos
  Complex operator /(Complex other) {
    double denom = other.real * other.real + other.imaginary * other.imaginary;
    return Complex(
      (real * other.real + imaginary * other.imaginary) / denom,
      (imaginary * other.real - real * other.imaginary) / denom,
    );
  }

  @override
  String toString() {
    return '${real.toStringAsFixed(2)} ${imaginary >= 0 ? '+' : '-'} ${imaginary.abs().toStringAsFixed(2)}i';
  }
}
