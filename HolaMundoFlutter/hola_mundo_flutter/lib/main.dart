import 'package:flutter/material.dart';
import 'Calculadora.dart';

void main() {
  runApp(const Principal());
}

class Principal extends StatelessWidget {
  const Principal({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: Operaciones(),
    );
  }
}

class Operaciones extends StatefulWidget {
  const Operaciones({super.key});

  @override
  State<Operaciones> createState() => _OperacionesState();
}

class _OperacionesState extends State<Operaciones> {
  final TextEditingController num1 = TextEditingController();
  final TextEditingController num2 = TextEditingController();
  final Calculadora calculadora = Calculadora();
  int _resultado = 0;

  void _sumar() {
    setState(() {
      _resultado = calculadora.sumar(
        int.tryParse(num1.text) ?? 0,
        int.tryParse(num2.text) ?? 0,
      );
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Calculadora'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(50.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            TextField(
              controller: num1,
              keyboardType: TextInputType.number,
              decoration: const InputDecoration(labelText: 'Número 1'),
            ),
            TextField(
              controller: num2,
              keyboardType: TextInputType.number,
              decoration: const InputDecoration(labelText: 'Número 2'),
            ),
            ElevatedButton(
              onPressed: _sumar,
              child: const Text('Sumar'),
            ),
            Text('Resultado: $_resultado'),
          ],
        ),
      ),
    );
  }
}
