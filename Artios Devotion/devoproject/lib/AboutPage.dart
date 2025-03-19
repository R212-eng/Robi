import 'package:flutter/widgets.dart';
import 'package:flutter/material.dart';
import 'package:devoproject/About.dart';

class AboutPage extends StatelessWidget {
  final About reader;
  AboutPage(this.reader);
  @override
  Widget build(BuildContext context) => Scaffold(
          body: Scrollbar(
              child: SingleChildScrollView(
                  child: Column(
                      crossAxisAlignment: CrossAxisAlignment.center,
                      mainAxisAlignment: MainAxisAlignment.start,
                      children: [
            Container(
                padding: const EdgeInsets.all(5),
                alignment: Alignment.topCenter,
                child: Text(
                  "${reader.Title}".toString(),
                  textAlign: TextAlign.center,
                  style: const TextStyle(fontStyle: FontStyle.italic),
                )),
            //Spacer(),
            Container(
                padding: const EdgeInsets.all(10),
                alignment: Alignment.topCenter,
                child: Text(
                  "${reader.Info}",
                  textAlign: TextAlign.center,
                  style: const TextStyle(fontSize: 16),
                ))
          ]))));
}
