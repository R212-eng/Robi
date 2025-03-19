import 'package:flutter/material.dart';

void main() {
  var app = MaterialApp(
      home: Scaffold(
    appBar: AppBar(
      centerTitle: true,
      title: Text(
          '\u{12A0}\u{122D}\u{1275}\u{12EE}\u{1235} \u{12F2}\u{126E}\u{123D}\u{1295}'),
      actions: <Widget>[
        PopupMenuButton<String>(
          onSelected: handleClick,
          itemBuilder: (BuildContext context) {
            return {
              '\u{12A0}\u{122B}\u{130B}',
              '\u{1235}\u{1208} \u{12F2}\u{126E}\u{123D}\u{1295}'
            }.map((String choice) {
              return PopupMenuItem<String>(
                value: choice,
                child: Text(choice),
              );
            }).toList();
          },
        ),
      ],
    ),
  ));

  runApp(app);
}

void handleClick(String value) {
  switch (value) {
    case 'share':
      break;
    case 'help':
      break;
  }
}

