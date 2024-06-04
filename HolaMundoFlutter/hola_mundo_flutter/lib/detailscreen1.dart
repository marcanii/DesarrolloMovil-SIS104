import 'package:flutter/material.dart';

class DetailScreen1 extends StatelessWidget {
  const DetailScreen1({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Pantalla de detalles 1'),
      ),
      body: const Center(
        child: Text('¡Estás en la pantalla de detalles 1!'),
      ),
    );
  }
}
