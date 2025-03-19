class About {
  String? Info;
  String? Title;
  About();
  Map<String, dynamic> toJson() => {
        'Title': Title,
        'Info': Info,
      };
  About.fromSnapshot(snapshot)
      : Title = snapshot.data()['Title'],
        Info = snapshot.data()['Info'];
}
