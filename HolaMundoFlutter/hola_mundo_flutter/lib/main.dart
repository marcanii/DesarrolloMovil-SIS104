import 'package:flutter/material.dart';

void main() {
  runApp(const Principal());
}

class Principal extends StatelessWidget {
  const Principal({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Saludo'),
        ),
        body: const Center(
          child: MiClaseEstatica(),
        ),
      ),
    );
  }
}

class MiClaseEstatica extends StatelessWidget {
  const MiClaseEstatica({super.key});

  @override
  Widget build(BuildContext context) {
    return const Text('Hola Mundo!',
        style: TextStyle(
            fontSize: 24, color: Colors.blue, fontWeight: FontWeight.bold));
  }
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: Scaffold(
        body: Center(
          child: Text('Hello World!'),
        ),
      ),
    );
  }
}
