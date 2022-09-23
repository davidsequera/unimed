//package com.unimed;
//
//public class SurfiFX {
//    String template = "" +
//            "<AnchorPane id=\"AnchorPane\">\n" +
//            "    <VBox layoutY=\"170.0\" prefWidth=\"557.0\">\n" +
//            "        // Start Loop\n" +
//            "          <Pane>\n" +
//            "             <children>\n" +
//            "                  <Label text=\"%text person%\" />\n" +
//            "                <Label text=\"%date of post%\" />\n" +
//            "                <TextArea text=\"%text in post%\"/>\n" +
//            "             </children>\n" +
//            "          </Pane>\n" +
//            "       // End Loop\n" +
//            "    </VBox>\n" +
//            "</AnchorPane>";
//
//    StringBuilder sb = new StringBuilder();
//    //Loop through the posts
//    for (int i = 0; i<postNumber; i++) {
//        sb.append(
//                template
//                        .replaceAll("%text person%", thePerson)
//                        .replaceAll("%date of post%", theDate)
//                        .replaceAll("%text in post%", text));
//    }
//    String outer =
//            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                    "\n" +
//                    "<?import java.lang.*?>\n" +
//                    "<?import java.util.*?>\n" +
//                    "<?import javafx.scene.*?>\n" +
//                    "<?import javafx.scene.control.*?>\n" +
//                    "<?import javafx.scene.layout.*?>\n" +
//                    "\n" +
//                    "<AnchorPane xmlns=\"http://javafx.com/javafx\"\n" +
//                    "            xmlns:fx=\"http://javafx.com/fxml\"\n" +
//                    "            fx:controller=\"me.mkdomain.deeplearning.D\"\n" +
//                    "            prefHeight=\"400.0\" prefWidth=\"600.0\">\n" +
//                    "%content%\n" +
//                    "</AnchorPane>";
//    String done = outer.replaceAll("%content%", sb.toString());
//    FileOutputStream out = new FileOutputStream("myfile.fxml");
//    out.write(done.getBytes());
//    out.close();
//    FXMLLoader loader = new FXMLLoader();
//    loader.load(new FileInputStream("myfile.fxml"));
//}
