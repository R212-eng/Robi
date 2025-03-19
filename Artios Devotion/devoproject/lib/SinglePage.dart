import 'package:devoproject/HomePage.dart';
//import 'package:devoproject/app.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

//import 'package:date_format/date_format.dart';
class SinglePage extends StatelessWidget {
  final HomePage collection;
  //final now = new DateTime.now();
  //DateFormat formatter = DateFormat.yMEd(num);
  SinglePage(this.collection);
  var controller = PageController(initialPage: 1);
  @override
  Widget build(BuildContext context) {
    return Scrollbar(
        child: SingleChildScrollView(
            child: Column(
                crossAxisAlignment: CrossAxisAlignment.center,
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
          Row(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                /*Container(
                    padding: const EdgeInsets.only(top: 18),
                    alignment: Alignment.topCenter,
                    child: new IconButton(
                        icon: const Icon(Icons.arrow_back),
                        onPressed: () => controller.previousPage(
                            duration: const Duration(seconds: 1),
                            curve: Curves.easeInOut))),*/
                //Spacer(),
                Container(
                  padding: const EdgeInsets.only(top: 25),
                  child: (Text("${collection.Date}")),
                  //DateFormat.jms().format(DateTime.now())
                  /*Container(
                  padding: const EdgeInsets.only(top: 18),
                  alignment: Alignment.topCenter,
                  child: new IconButton(
                      icon: const Icon(Icons.arrow_forward),
                      onPressed: () => controller.nextPage(
                          duration: const Duration(seconds: 1),
                          curve: Curves.easeInOut)),
                )*/
                )
              ]),
          //Spacer(),
          Container(
            padding: const EdgeInsets.all(5),
            alignment: Alignment.topCenter,
            child: Text("${collection.Title}",
                textAlign: TextAlign.center,
                style: const TextStyle(fontWeight: FontWeight.bold)),
          ),
          //Spacer(),
          Container(
              padding: const EdgeInsets.all(5),
              alignment: Alignment.topCenter,
              child: Text(
                "${collection.Verse}".toString(),
                textAlign: TextAlign.center,
                style: const TextStyle(fontStyle: FontStyle.italic),
              )),
          //Spacer(),
          Container(
              padding: const EdgeInsets.all(10),
              alignment: Alignment.topCenter,
              child: Text(
                "${collection.Reading}",
                textAlign: TextAlign.center,
                style: const TextStyle(fontSize: 16),
              )),

          //Spacer(),
          Container(
              padding: const EdgeInsets.all(10),
              alignment: Alignment.topCenter,
              child: Text("${collection.Internalize}".replaceAll("\\n", "\n"),
                  textAlign: TextAlign.center,
                  style: const TextStyle(fontWeight: FontWeight.w600))),
        ])));
    //
  }
}
