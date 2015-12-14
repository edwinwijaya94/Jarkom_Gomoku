/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomokugui;

import static gomokugui.FXMLDocumentRoomController.str;
import static gomokugui.FXMLDocumentStartController.in;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Vicko
 */
public class FXMLDocumentGameController implements Initializable {
    
    public static Socket socket;
    public static DataOutputStream out;
    
    @FXML
    private GridPane gridPane;
    @FXML
    private Label label0;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    @FXML
    private Label label8;
    @FXML
    private Label label9;
    @FXML
    private Label label10;
    @FXML
    private Label label11;
    @FXML
    private Label label12;
    @FXML
    private Label label13;
    @FXML
    private Label label14;
    @FXML
    private Label label15;
    @FXML
    private Label label16;
    @FXML
    private Label label17;
    @FXML
    private Label label18;
    @FXML
    private Label label19;
    @FXML
    private Label label20;
    @FXML
    private Label label21;
    @FXML
    private Label label22;
    @FXML
    private Label label23;
    @FXML
    private Label label24;
    @FXML
    private Label label25;
    @FXML
    private Label label26;
    @FXML
    private Label label27;
    @FXML
    private Label label28;
    @FXML
    private Label label29;
    @FXML
    private Label label30;
    @FXML
    private Label label31;
    @FXML
    private Label label32;
    @FXML
    private Label label33;
    @FXML
    private Label label34;
    @FXML
    private Label label35;
    @FXML
    private Label label36;
    @FXML
    private Label label37;
    @FXML
    private Label label38;
    @FXML
    private Label label39;
    @FXML
    private Label label40;
    @FXML
    private Label label41;
    @FXML
    private Label label42;
    @FXML
    private Label label43;
    @FXML
    private Label label44;
    @FXML
    private Label label45;
    @FXML
    private Label label46;
    @FXML
    private Label label47;
    @FXML
    private Label label48;
    @FXML
    private Label label49;
    @FXML
    private Label label50;
    @FXML
    private Label label51;
    @FXML
    private Label label52;
    @FXML
    private Label label53;
    @FXML
    private Label label54;
    @FXML
    private Label label55;
    @FXML
    private Label label56;
    @FXML
    private Label label57;
    @FXML
    private Label label58;
    @FXML
    private Label label59;
    @FXML
    private Label label60;
    @FXML
    private Label label61;
    @FXML
    private Label label62;
    @FXML
    private Label label63;
    @FXML
    private Label label64;
    @FXML
    private Label label65;
    @FXML
    private Label label66;
    @FXML
    private Label label67;
    @FXML
    private Label label68;
    @FXML
    private Label label69;
    @FXML
    private Label label70;
    @FXML
    private Label label71;
    @FXML
    private Label label72;
    @FXML
    private Label label73;
    @FXML
    private Label label74;
    @FXML
    private Label label75;
    @FXML
    private Label label76;
    @FXML
    private Label label77;
    @FXML
    private Label label78;
    @FXML
    private Label label79;
    @FXML
    private Label label80;
    @FXML
    private Label label81;
    @FXML
    private Label label82;
    @FXML
    private Label label83;
    @FXML
    private Label label84;
    @FXML
    private Label label85;
    @FXML
    private Label label86;
    @FXML
    private Label label87;
    @FXML
    private Label label88;
    @FXML
    private Label label89;
    @FXML
    private Label label90;
    @FXML
    private Label label91;
    @FXML
    private Label label92;
    @FXML
    private Label label93;
    @FXML
    private Label label94;
    @FXML
    private Label label95;
    @FXML
    private Label label96;
    @FXML
    private Label label97;
    @FXML
    private Label label98;
    @FXML
    private Label label99;
    @FXML
    private Label label100;
    @FXML
    private Label label101;
    @FXML
    private Label label102;
    @FXML
    private Label label103;
    @FXML
    private Label label104;
    @FXML
    private Label label105;
    @FXML
    private Label label106;
    @FXML
    private Label label107;
    @FXML
    private Label label108;
    @FXML
    private Label label109;
    @FXML
    private Label label110;
    @FXML
    private Label label111;
    @FXML
    private Label label112;
    @FXML
    private Label label113;
    @FXML
    private Label label114;
    @FXML
    private Label label115;
    @FXML
    private Label label116;
    @FXML
    private Label label117;
    @FXML
    private Label label118;
    @FXML
    private Label label119;
    @FXML
    private Label label120;
    @FXML
    private Label label121;
    @FXML
    private Label label122;
    @FXML
    private Label label123;
    @FXML
    private Label label124;
    @FXML
    private Label label125;
    @FXML
    private Label label126;
    @FXML
    private Label label127;
    @FXML
    private Label label128;
    @FXML
    private Label label129;
    @FXML
    private Label label130;
    @FXML
    private Label label131;
    @FXML
    private Label label132;
    @FXML
    private Label label133;
    @FXML
    private Label label134;
    @FXML
    private Label label135;
    @FXML
    private Label label136;
    @FXML
    private Label label137;
    @FXML
    private Label label138;
    @FXML
    private Label label139;
    @FXML
    private Label label140;
    @FXML
    private Label label141;
    @FXML
    private Label label142;
    @FXML
    private Label label143;
    @FXML
    private Label label144;
    @FXML
    private Label label145;
    @FXML
    private Label label146;
    @FXML
    private Label label147;
    @FXML
    private Label label148;
    @FXML
    private Label label149;
    @FXML
    private Label label150;
    @FXML
    private Label label151;
    @FXML
    private Label label152;
    @FXML
    private Label label153;
    @FXML
    private Label label154;
    @FXML
    private Label label155;
    @FXML
    private Label label156;
    @FXML
    private Label label157;
    @FXML
    private Label label158;
    @FXML
    private Label label159;
    @FXML
    private Label label160;
    @FXML
    private Label label161;
    @FXML
    private Label label162;
    @FXML
    private Label label163;
    @FXML
    private Label label164;
    @FXML
    private Label label165;
    @FXML
    private Label label166;
    @FXML
    private Label label167;
    @FXML
    private Label label168;
    @FXML
    private Label label169;
    @FXML
    private Label label170;
    @FXML
    private Label label171;
    @FXML
    private Label label172;
    @FXML
    private Label label173;
    @FXML
    private Label label174;
    @FXML
    private Label label175;
    @FXML
    private Label label176;
    @FXML
    private Label label177;
    @FXML
    private Label label178;
    @FXML
    private Label label179;
    @FXML
    private Label label180;
    @FXML
    private Label label181;
    @FXML
    private Label label182;
    @FXML
    private Label label183;
    @FXML
    private Label label184;
    @FXML
    private Label label185;
    @FXML
    private Label label186;
    @FXML
    private Label label187;
    @FXML
    private Label label188;
    @FXML
    private Label label189;
    @FXML
    private Label label190;
    @FXML
    private Label label191;
    @FXML
    private Label label192;
    @FXML
    private Label label193;
    @FXML
    private Label label194;
    @FXML
    private Label label195;
    @FXML
    private Label label196;
    @FXML
    private Label label197;
    @FXML
    private Label label198;
    @FXML
    private Label label199;
    @FXML
    private Label label200;
    @FXML
    private Label label201;
    @FXML
    private Label label202;
    @FXML
    private Label label203;
    @FXML
    private Label label204;
    @FXML
    private Label label205;
    @FXML
    private Label label206;
    @FXML
    private Label label207;
    @FXML
    private Label label208;
    @FXML
    private Label label209;
    @FXML
    private Label label210;
    @FXML
    private Label label211;
    @FXML
    private Label label212;
    @FXML
    private Label label213;
    @FXML
    private Label label214;
    @FXML
    private Label label215;
    @FXML
    private Label label216;
    @FXML
    private Label label217;
    @FXML
    private Label label218;
    @FXML
    private Label label219;
    @FXML
    private Label label220;
    @FXML
    private Label label221;
    @FXML
    private Label label222;
    @FXML
    private Label label223;
    @FXML
    private Label label224;
    @FXML
    private Label label225;
    @FXML
    private Label label226;
    @FXML
    private Label label227;
    @FXML
    private Label label228;
    @FXML
    private Label label229;
    @FXML
    private Label label230;
    @FXML
    private Label label231;
    @FXML
    private Label label232;
    @FXML
    private Label label233;
    @FXML
    private Label label234;
    @FXML
    private Label label235;
    @FXML
    private Label label236;
    @FXML
    private Label label237;
    @FXML
    private Label label238;
    @FXML
    private Label label239;
    @FXML
    private Label label240;
    @FXML
    private Label label241;
    @FXML
    private Label label242;
    @FXML
    private Label label243;
    @FXML
    private Label label244;
    @FXML
    private Label label245;
    @FXML
    private Label label246;
    @FXML
    private Label label247;
    @FXML
    private Label label248;
    @FXML
    private Label label249;
    @FXML
    private Label label250;
    @FXML
    private Label label251;
    @FXML
    private Label label252;
    @FXML
    private Label label253;
    @FXML
    private Label label254;
    @FXML
    private Label label255;
    @FXML
    private Label label256;
    @FXML
    private Label label257;
    @FXML
    private Label label258;
    @FXML
    private Label label259;
    @FXML
    private Label label260;
    @FXML
    private Label label261;
    @FXML
    private Label label262;
    @FXML
    private Label label263;
    @FXML
    private Label label264;
    @FXML
    private Label label265;
    @FXML
    private Label label266;
    @FXML
    private Label label267;
    @FXML
    private Label label268;
    @FXML
    private Label label269;
    @FXML
    private Label label270;
    @FXML
    private Label label271;
    @FXML
    private Label label272;
    @FXML
    private Label label273;
    @FXML
    private Label label274;
    @FXML
    private Label label275;
    @FXML
    private Label label276;
    @FXML
    private Label label277;
    @FXML
    private Label label278;
    @FXML
    private Label label279;
    @FXML
    private Label label280;
    @FXML
    private Label label281;
    @FXML
    private Label label282;
    @FXML
    private Label label283;
    @FXML
    private Label label284;
    @FXML
    private Label label285;
    @FXML
    private Label label286;
    @FXML
    private Label label287;
    @FXML
    private Label label288;
    @FXML
    private Label label289;
    @FXML
    private Label label290;
    @FXML
    private Label label291;
    @FXML
    private Label label292;
    @FXML
    private Label label293;
    @FXML
    private Label label294;
    @FXML
    private Label label295;
    @FXML
    private Label label296;
    @FXML
    private Label label297;
    @FXML
    private Label label298;
    @FXML
    private Label label299;
    @FXML
    private Label label300;
    @FXML
    private Label label301;
    @FXML
    private Label label302;
    @FXML
    private Label label303;
    @FXML
    private Label label304;
    @FXML
    private Label label305;
    @FXML
    private Label label306;
    @FXML
    private Label label307;
    @FXML
    private Label label308;
    @FXML
    private Label label309;
    @FXML
    private Label label310;
    @FXML
    private Label label311;
    @FXML
    private Label label312;
    @FXML
    private Label label313;
    @FXML
    private Label label314;
    @FXML
    private Label label315;
    @FXML
    private Label label316;
    @FXML
    private Label label317;
    @FXML
    private Label label318;
    @FXML
    private Label label319;
    @FXML
    private Label label320;
    @FXML
    private Label label321;
    @FXML
    private Label label322;
    @FXML
    private Label label323;
    @FXML
    private Label label324;
    @FXML
    private Label label325;
    @FXML
    private Label label326;
    @FXML
    private Label label327;
    @FXML
    private Label label328;
    @FXML
    private Label label329;
    @FXML
    private Label label330;
    @FXML
    private Label label331;
    @FXML
    private Label label332;
    @FXML
    private Label label333;
    @FXML
    private Label label334;
    @FXML
    private Label label335;
    @FXML
    private Label label336;
    @FXML
    private Label label337;
    @FXML
    private Label label338;
    @FXML
    private Label label339;
    @FXML
    private Label label340;
    @FXML
    private Label label341;
    @FXML
    private Label label342;
    @FXML
    private Label label343;
    @FXML
    private Label label344;
    @FXML
    private Label label345;
    @FXML
    private Label label346;
    @FXML
    private Label label347;
    @FXML
    private Label label348;
    @FXML
    private Label label349;
    @FXML
    private Label label350;
    @FXML
    private Label label351;
    @FXML
    private Label label352;
    @FXML
    private Label label353;
    @FXML
    private Label label354;
    @FXML
    private Label label355;
    @FXML
    private Label label356;
    @FXML
    private Label label357;
    @FXML
    private Label label358;
    @FXML
    private Label label359;
    @FXML
    private Label label360;
    @FXML
    private Label label361;
    @FXML
    private Label label362;
    @FXML
    private Label label363;
    @FXML
    private Label label364;
    @FXML
    private Label label365;
    @FXML
    private Label label366;
    @FXML
    private Label label367;
    @FXML
    private Label label368;
    @FXML
    private Label label369;
    @FXML
    private Label label370;
    @FXML
    private Label label371;
    @FXML
    private Label label372;
    @FXML
    private Label label373;
    @FXML
    private Label label374;
    @FXML
    private Label label375;
    @FXML
    private Label label376;
    @FXML
    private Label label377;
    @FXML
    private Label label378;
    @FXML
    private Label label379;
    @FXML
    private Label label380;
    @FXML
    private Label label381;
    @FXML
    private Label label382;
    @FXML
    private Label label383;
    @FXML
    private Label label384;
    @FXML
    private Label label385;
    @FXML
    private Label label386;
    @FXML
    private Label label387;
    @FXML
    private Label label388;
    @FXML
    private Label label389;
    @FXML
    private Label label390;
    @FXML
    private Label label391;
    @FXML
    private Label label392;
    @FXML
    private Label label393;
    @FXML
    private Label label394;
    @FXML
    private Label label395;
    @FXML
    private Label label396;
    @FXML
    private Label label397;
    @FXML
    private Label label398;
    @FXML
    private Label label399;
    @FXML
    private Label roomName;
    @FXML
    private SplitPane splitPane1;
    @FXML
    private Label namePlayer1;
    @FXML
    private Label iconPlayer1;
    @FXML
    private SplitPane splitPane2;
    @FXML
    private Label namePlayer2;
    @FXML
    private Label iconPlayer2;
    @FXML
    private SplitPane splitPane3;
    @FXML
    private Label namePlayer3;
    @FXML
    private Label iconPlayer3;
    @FXML
    private SplitPane splitPane4;
    @FXML
    private Label namePlayer4;
    @FXML
    private Label iconPlayer4;
    @FXML
    private SplitPane splitPane5;
    @FXML
    private Label namePlayer5;
    @FXML
    private Label iconPlayer5;

    private boolean isTurn = false;
    private boolean isBoard = false;
    
    private Label[][] labelMatrix = new Label[20][20];
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Task task = new Task<Void>() {
            @Override
            public Void call() {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Masuk task " + str.get());
                while(!str.get().equals("Game Ended")){
                    try {
                        str.set(in.readUTF());
                        System.out.println(str.get());
                        System.out.println("length="+str.get().length());
                        if(str.get().length() <= 8){
                            isBoard = true;
                            updateBoard(str.get());
                        }
                        if(str.get().equals("Your Move")){
                            System.out.println("Set isTurn = true");
                            isTurn = true;
                        }
                        //System.out.println(str.get());
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentRoomController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                System.out.println("keluar");

                return null;
            }
        };
        new Thread(task).start();
        
        Task task2 = new Task<Void>() {
            @Override
            public Void call() {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                ObservableList<Node> childrens = gridPane.getChildren();
                for(Node node : childrens) {
                    labelMatrix[GridPane.getRowIndex(node)][GridPane.getColumnIndex(node)] = (Label)node;
                }
                
                return null;
            }
        };
        new Thread(task2).start();
    }    

    @FXML
    private void handleClick(MouseEvent event) throws IOException {
        //System.out.println("isTurn = " + isTurn);
        if(!isTurn)
            return;
        
        Image image = new Image(getClass().getResourceAsStream("img/small/crop/1.png"));
        ImageView iv = new ImageView(image);
        //iv.setFitWidth(27);
        //iv.setFitHeight(27);
        ((Label)event.getSource()).setGraphic(iv);
        // System.out.println("Lalallaa");
        //System.out.println(((Label) event.getSource()).getId());
        Integer squareId = Integer.parseInt(((Label) event.getSource()).getId().substring(5));
        System.out.println(GridPane.getRowIndex(((Label)event.getSource())) + " ");
        System.out.println(GridPane.getColumnIndex(((Label)event.getSource())));
        int i = squareId / 20;
        int j = squareId % 20;
        //System.out.println(i +" " +j);
        
        //send coordinate
        out = new DataOutputStream(socket.getOutputStream());
        //out.writeUTF(Integer.toString(i));
        //out.writeUTF(Integer.toString(j));
        out.writeUTF(Integer.toString(GridPane.getRowIndex(((Label)event.getSource()))));
        out.writeUTF(Integer.toString(GridPane.getColumnIndex(((Label)event.getSource()))));
        
        isTurn = false;
    }
    
    public void updateBoard(String board){
        /*for(int i=0; i<board.length(); i++){
            int i2 = i / 20;
            int j2 = i % 20;
            Image image = new Image(getClass().getResourceAsStream("img/small/crop/"+board.substring(i,i)+".png"));
            ImageView iv = new ImageView(image);
            ((Label)this.getNodeByRowColumnIndex(i2,j2 , gridPane)).setGraphic(iv);
        }*/
        
        String[] updateString = board.split(" ");
        int i2 = Integer.parseInt(updateString[1]);
        int j2 = Integer.parseInt(updateString[2]);
        Image image = new Image(getClass().getResourceAsStream("img/small/crop/1.png"));
        ImageView iv = new ImageView(image);
        //System.out.println("row : " + i2);
        //System.out.println("column : " + j2);
        Platform.runLater(new Runnable() {
          @Override public void run() {
            //((Label)getNodeByRowColumnIndex(i2,j2 , gridPane)).setGraphic(iv);
            labelMatrix[i2][j2].setGraphic(iv);
          }  
        });
    }
    
    /*public Node getNodeByRowColumnIndex(final int row,final int column,GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();
        for(Node node : childrens) {
            if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        //System.out.println(result.getId());
        return result;
    }*/
}
