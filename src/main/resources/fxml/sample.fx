<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.web.*?>
<?import javafx.scene.chart.*?>
<?import javafx.scene.effect.*?>
<?import javafx.geometry.*?>
<?import javafx.scene.control.*?>
<?import javafx.scene.paint.*?>
<?import javafx.scene.text.*?>
<?import java.lang.*?>
<?import javafx.scene.layout.*?>
<?import javafx.geometry.Insets?>
<?import javafx.scene.layout.GridPane?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.cell.PropertyValueFactory?>

<VBox minHeight="300.0" minWidth="500.0" prefHeight="600.0" prefWidth="1450.0" xmlns="http://javafx.com/javafx/8" xmlns:fx="http://javafx.com/fxml/1" fx:controller="cn.gabongao.controller.MenuController">
    <children>
      <VBox>
         <children>
            <AnchorPane>
               <children>
                  <Button mnemonicParsing="false" prefHeight="27.0" text="Home" AnchorPane.bottomAnchor="5.0" AnchorPane.leftAnchor="20.0" AnchorPane.topAnchor="5.0" />
                  <Button layoutX="126.0" mnemonicParsing="false" prefHeight="27.0" text="Browser" AnchorPane.bottomAnchor="5.0" AnchorPane.leftAnchor="80.0" AnchorPane.topAnchor="5.0" />
                  <Button layoutX="228.0" layoutY="-1.0" minHeight="0.0" mnemonicParsing="false" prefHeight="27.0" text="Search" AnchorPane.bottomAnchor="5.0" AnchorPane.leftAnchor="150.0" AnchorPane.topAnchor="5.0">
                     <graphic>
                        <TextField minHeight="0.0" prefHeight="24.0" />
                     </graphic>
                  </Button>
                  <Button fx:id="hide" alignment="CENTER_RIGHT" layoutX="1156.0" layoutY="6.0" mnemonicParsing="false" prefHeight="27.0" text="Hide" AnchorPane.bottomAnchor="5.0" AnchorPane.rightAnchor="225.0" AnchorPane.topAnchor="5.0" />
                  <Button alignment="CENTER_RIGHT" layoutX="1352.0" layoutY="4.0" mnemonicParsing="false" prefHeight="27.0" text="Settings" AnchorPane.bottomAnchor="5.0" AnchorPane.rightAnchor="20.0" AnchorPane.topAnchor="5.0" />
                  <Button alignment="CENTER_RIGHT" layoutX="1286.0" layoutY="3.0" mnemonicParsing="false" prefHeight="27.0" text="Discuss" AnchorPane.bottomAnchor="5.0" AnchorPane.rightAnchor="90.0" AnchorPane.topAnchor="5.0" />
                  <Button alignment="CENTER_RIGHT" layoutX="1212.0" mnemonicParsing="false" prefHeight="27.0" text="Preium" AnchorPane.bottomAnchor="5.0" AnchorPane.rightAnchor="160.0" AnchorPane.topAnchor="5.0" />
               </children>
            </AnchorPane>
         </children>
      </VBox>
        <SplitPane dividerPositions="0.6" focusTraversable="true" prefHeight="-1.0" prefWidth="-1.0" VBox.vgrow="ALWAYS">
            <items>
                <TableView fx:id="table" prefHeight="568.0" prefWidth="497.0" tableMenuButtonVisible="true">
                    <columns>
                        <TableColumn fx:id="site" prefWidth="60.0" text="站点" />
                        <TableColumn fx:id="userName" text="用户名" />
                  <TableColumn fx:id="userID" prefWidth="60.0" text="UID" />
                        <TableColumn fx:id="upload" prefWidth="70.0" text="上传量" />
                        <TableColumn fx:id="download" prefWidth="70.0" text="下载量" />
                        <TableColumn fx:id="shareRatio" prefWidth="60.0" text="分享率" />
                  <TableColumn fx:id="bonus" prefWidth="60.0" text="魔力值" />
                  <TableColumn fx:id="uploadCount" prefWidth="70.0" text="做种数" />
                  <TableColumn fx:id="uploadSize" prefWidth="70.0" text="做种体积" />
                  <TableColumn fx:id="uploadTime" prefWidth="70.0" text="做种时间" visible="false" />
                  <TableColumn fx:id="downloadTime" prefWidth="70.0" text="下载时间" visible="false" />
                  <TableColumn fx:id="joinDate" prefWidth="60.0" text="加入天数" />
                  <TableColumn fx:id="grade" prefWidth="75.0" text="等级" />
                  <TableColumn fx:id="inviteCount" prefWidth="50.0" text="邀请数" />
                  <TableColumn fx:id="state" prefWidth="70.0" text="当前状态" />
                    </columns>
                </TableView>
                <SplitPane dividerPositions="0.4" orientation="VERTICAL" prefHeight="200.0" prefWidth="160.0">
                    <items>
                        <TableView fx:id="recentTable" prefHeight="270.0" prefWidth="632.0" tableMenuButtonVisible="true">
                            <columns>
                                <TableColumn fx:id="site2" prefWidth="70.0" text="站点" />
                                <TableColumn fx:id="upload2" prefWidth="70.0" text="上传量" />
                                <TableColumn fx:id="download2" prefWidth="70.0" text="下载量" />
                        <TableColumn fx:id="shareRatio2" prefWidth="70.0" text="分享率" />
                                <TableColumn fx:id="bonus2" prefWidth="70.0" text="魔力" />
                        <TableColumn fx:id="uploadCount2" prefWidth="70.0" text="做种数" />
                        <TableColumn fx:id="uploadSize2" prefWidth="70.0" text="做种体积" />
                        <TableColumn fx:id="date" text="记录日期" />
                            </columns>
                        </TableView>
                  <WebView fx:id="chart" prefHeight="200.0" prefWidth="200.0" />
                    </items>
                </SplitPane>
            </items>
        </SplitPane>
    </children>
</VBox>
