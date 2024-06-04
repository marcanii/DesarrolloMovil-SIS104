import 'package:flutter/material.dart';

class DetailScreen2 extends StatelessWidget {
  const DetailScreen2({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Pantalla de detalles 2'),
      ),
      body: const Center(
        child: Text('¡Estás en la pantalla de detalles 2!'),
      ),
    );
  }
}
