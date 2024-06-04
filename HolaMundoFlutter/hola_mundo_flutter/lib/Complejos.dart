import 'package:flutter/material.dart';
import 'package:hola_mundo_flutter/Complex.dart';

class ComplexCalculator extends StatefulWidget {
  @override
  _ComplexCalculatorState createState() => _ComplexCalculatorState();
}

class _ComplexCalculatorState extends State<ComplexCalculator> {
  final TextEditingController realController1 = TextEditingController();
  final TextEditingController imaginaryController1 = TextEditingController();
  final TextEditingController realController2 = TextEditingController();
  final TextEditingController imaginaryController2 = TextEditingController();
  String result = '';

  void calculate() {
    final double real1 = double.parse(realController1.text);
    final double imaginary1 = double.parse(imaginaryController1.text);
    final double real2 = double.parse(realController2.text);
    final double imaginary2 = double.parse(imaginaryController2.text);

    Complex a = Complex(real1, imaginary1);
    Complex b = Complex(real2, imaginary2);

    Complex sum = a + b;
    Complex difference = a - b;
    Complex product = a * b;
    Complex quotient = a / b;

    setState(() {
      result = '''
      Suma: $sum
      Resta: $difference
      Producto: $product
      Cociente: $quotient
      ''';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Calculadora de Números Complejos'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: realController1,
              decoration: InputDecoration(labelText: 'Parte Real 1'),
              keyboardType: TextInputType.number,
            ),
            TextField(
              controller: imaginaryController1,
              decoration: InputDecoration(labelText: 'Parte Imaginaria 1'),
              keyboardType: TextInputType.number,
            ),
            TextField(
              controller: realController2,
              decoration: InputDecoration(labelText: 'Parte Real 2'),
              keyboardType: TextInputType.number,
            ),
            TextField(
              controller: imaginaryController2,
              decoration: InputDecoration(labelText: 'Parte Imaginaria 2'),
              keyboardType: TextInputType.number,
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: calculate,
              child: Text('Ejecutar'),
            ),
            SizedBox(height: 20),
            Text(
              result,
              textAlign: TextAlign.left,
            ),
          ],
        ),
      ),
    );
  }
}
