import 'package:flutter/material.dart';
import 'package:hola_mundo_flutter/custom_button.dart';
import 'package:hola_mundo_flutter/detailscreen1.dart';
import 'package:hola_mundo_flutter/detailscreen2.dart';
import 'package:hola_mundo_flutter/Complejos.dart';

void main() {
  runApp(const Principal());
}

class Principal extends StatelessWidget {
  const Principal({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      home: MyHomePage(),
      routes: <String, WidgetBuilder>{
        '/details1': (BuildContext context) => new DetailScreen1(),
        '/details2': (BuildContext context) => new DetailScreen2(),
        '/complejos': (BuildContext context) => ComplexCalculator(),
      },
    );
  }
}

class MyHomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: AppBar(
        title: const Text('TestProject'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const SizedBox(height: 20),
            CustomButton(
              text: 'Base de Datos',
              color: Colors.green.shade300,
              onPressed: () {
                Navigator.of(context).pushNamed('/details2');
              },
            ),
            const SizedBox(height: 20),
            CustomButton(
              text: 'Calculadora',
              color: Colors.pink.shade200,
              onPressed: () {
                Navigator.of(context).pushNamed('/details2');
              },
            ),
            const SizedBox(height: 20),
            CustomButton(
              text: 'Complejos',
              color: Colors.blue.shade300,
              onPressed: () {
                Navigator.of(context).pushNamed('/complejos');
              },
            ),
            const SizedBox(height: 20),
            CustomButton(
              text: 'Web Services',
              color: Colors.orange.shade300,
              onPressed: () {
                Navigator.of(context).pushNamed('/details2');
              },
            ),
            const SizedBox(height: 20),
            CustomButton(
              text: 'Salir',
              color: Colors.red.shade500,
              onPressed: () {
                Navigator.of(context).pushNamed('/details2');
              },
            ),
          ],
        ),
      ),
    );
  }
}
