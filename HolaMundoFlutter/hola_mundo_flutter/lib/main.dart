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
        appBar: AppBar(title: const Text('Contador de clicks')),
        body: const Center(
          child: ContenidoDinamico(),
        ),
      ),
    );
  }
}

class ContenidoDinamico extends StatefulWidget {
  const ContenidoDinamico({super.key});

  @override
  _ContenidoDinamicoState createState() => _ContenidoDinamicoState();
}

class _ContenidoDinamicoState extends State<ContenidoDinamico> {
  int _cont = 0;

  void _incrementarContador() {
    setState(() {
      _cont++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        const Text('Presiona el botón:', style: TextStyle(fontSize: 20)),
        Text('$_cont', style: const TextStyle(fontSize: 23)),
        ElevatedButton(
            onPressed: _incrementarContador,
            child: Text('Click aquí'),
            style: ElevatedButton.styleFrom(
                backgroundColor: const Color.fromARGB(255, 179, 214, 243))),
      ],
    );
  }
}
