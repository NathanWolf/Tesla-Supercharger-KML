package com.elmakers.tesla.parse;

import com.elmakers.tesla.bins.Supercharger;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class Parser implements Runnable {
    @SerializedName("Supercharger")
    List<Supercharger> superList;
    String fileLocation = "??";
    String superchargersJson = "";
    String superchargersOpenXML = "";
    String superchargersConstructionXML = "";
    String superchargersPermitXML = "";
    Gson gson;
    Output output;

    public Parser() {
    }

    public void loadPage() {
        InputStream is = null;
        this.output.setProgress(4, "Starting");
        this.sleep();

        try {
            URL url = new URL("https://supercharge.info/service/supercharge/allSites");
            is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            this.output.setProgress(7, "Downloading");
            this.sleep();

            String line;
            while((line = br.readLine()) != null) {
                this.superchargersJson = this.superchargersJson + line;
            }
        } catch (Exception var6) {
            System.out.println("could not load page");
        }

        this.gson = new Gson();
        Type listType = (new TypeToken<List<Supercharger>>() {
        }).getType();
        this.output.setProgress(18, "Parsing");
        this.sleep();
        this.superList = (List)this.gson.fromJson(this.superchargersJson, listType);
    }

    public void beanToXML() {
        Iterator var2 = this.superList.iterator();

        while(var2.hasNext()) {
            Supercharger s = (Supercharger)var2.next();
            if (s.getStatus().toLowerCase().equals("open")) {
                this.superchargersOpenXML = this.superchargersOpenXML + "\t\t\t<Placemark>\n";
                this.superchargersOpenXML = this.superchargersOpenXML + "\t\t\t\t<name>" + s.getName() + "</name>\n";
                this.superchargersOpenXML = this.superchargersOpenXML + "\t\t\t\t<description><![CDATA[<a href=\"" + s.getUrlDiscuss() + "\">Discus</a>&nbsp;&nbsp;&nbsp;</br>Address: " + s.getAddress().getStreet() + (s.getHours() == null ? "" : "&nbsp;&nbsp;&nbsp;</br>Hours: " + s.getHours()) + "&nbsp;&nbsp;&nbsp;</br>Stalls: " + s.getStallCount() + "]]></description>";
                this.superchargersOpenXML = this.superchargersOpenXML + "\t\t\t\t<LookAt>\n";
                this.superchargersOpenXML = this.superchargersOpenXML + "\t\t\t\t\t<longitude>" + s.getGps().getLongitude() + "</longitude>\n";
                this.superchargersOpenXML = this.superchargersOpenXML + "\t\t\t\t\t<latitude>" + s.getGps().getLatitude() + "</latitude>\n";
                this.superchargersOpenXML = this.superchargersOpenXML + "\t\t\t\t\t<altitude>0</altitude>\n";
                this.superchargersOpenXML = this.superchargersOpenXML + "\t\t\t\t\t<heading>0</heading>\n";
                this.superchargersOpenXML = this.superchargersOpenXML + "\t\t\t\t\t<tilt>0</tilt>\n";
                this.superchargersOpenXML = this.superchargersOpenXML + "\t\t\t\t\t<range>632.6829721769273</range>\n";
                this.superchargersOpenXML = this.superchargersOpenXML + "\t\t\t\t\t<gx:altitudeMode>relativeToSeaFloor</gx:altitudeMode>\n";
                this.superchargersOpenXML = this.superchargersOpenXML + "\t\t\t\t</LookAt>\n";
                this.superchargersOpenXML = this.superchargersOpenXML + "\t\t\t\t<styleUrl>#msn_ylw-pushpin1</styleUrl>\n";
                this.superchargersOpenXML = this.superchargersOpenXML + "\t\t\t\t<Point>\n";
                this.superchargersOpenXML = this.superchargersOpenXML + "\t\t\t\t\t<coordinates>" + s.getGps().getLongitude() + "," + s.getGps().getLatitude() + ",0</coordinates>\n";
                this.superchargersOpenXML = this.superchargersOpenXML + "\t\t\t\t</Point>\n";
                this.superchargersOpenXML = this.superchargersOpenXML + "\t\t\t</Placemark>\n";
            } else if (s.getStatus().toLowerCase().equals("construction")) {
                this.superchargersConstructionXML = this.superchargersConstructionXML + "\t\t\t<Placemark>\n";
                this.superchargersConstructionXML = this.superchargersConstructionXML + "\t\t\t\t<name>" + s.getName() + "</name>\n";
                this.superchargersConstructionXML = this.superchargersConstructionXML + "\t\t\t\t<description><![CDATA[<a href=\"" + s.getUrlDiscuss() + "\">Discus</a>&nbsp;&nbsp;&nbsp;</br>Address: " + s.getAddress().getStreet() + (s.getHours() == null ? "" : "&nbsp;&nbsp;&nbsp;</br>Hours: " + s.getHours()) + "&nbsp;&nbsp;&nbsp;</br>Stalls: " + s.getStallCount() + "]]></description>";
                this.superchargersConstructionXML = this.superchargersConstructionXML + "\t\t\t\t<LookAt>\n";
                this.superchargersConstructionXML = this.superchargersConstructionXML + "\t\t\t\t\t<longitude>" + s.getGps().getLongitude() + "</longitude>\n";
                this.superchargersConstructionXML = this.superchargersConstructionXML + "\t\t\t\t\t<latitude>" + s.getGps().getLatitude() + "</latitude>\n";
                this.superchargersConstructionXML = this.superchargersConstructionXML + "\t\t\t\t\t<altitude>0</altitude>\n";
                this.superchargersConstructionXML = this.superchargersConstructionXML + "\t\t\t\t\t<heading>0</heading>\n";
                this.superchargersConstructionXML = this.superchargersConstructionXML + "\t\t\t\t\t<tilt>0</tilt>\n";
                this.superchargersConstructionXML = this.superchargersConstructionXML + "\t\t\t\t\t<range>632.6829721769273</range>\n";
                this.superchargersConstructionXML = this.superchargersConstructionXML + "\t\t\t\t\t<gx:altitudeMode>relativeToSeaFloor</gx:altitudeMode>\n";
                this.superchargersConstructionXML = this.superchargersConstructionXML + "\t\t\t\t</LookAt>\n";
                this.superchargersConstructionXML = this.superchargersConstructionXML + "\t\t\t\t<styleUrl>#msn_ylw-pushpin</styleUrl>\n";
                this.superchargersConstructionXML = this.superchargersConstructionXML + "\t\t\t\t<Point>\n";
                this.superchargersConstructionXML = this.superchargersConstructionXML + "\t\t\t\t\t<coordinates>" + s.getGps().getLongitude() + "," + s.getGps().getLatitude() + ",0</coordinates>\n";
                this.superchargersConstructionXML = this.superchargersConstructionXML + "\t\t\t\t</Point>\n";
                this.superchargersConstructionXML = this.superchargersConstructionXML + "\t\t\t</Placemark>\n";
            } else if (s.getStatus().toLowerCase().equals("permit")) {
                this.superchargersPermitXML = this.superchargersPermitXML + "\t\t\t<Placemark>\n";
                this.superchargersPermitXML = this.superchargersPermitXML + "\t\t\t\t<name>" + s.getName() + "</name>\n";
                this.superchargersPermitXML = this.superchargersPermitXML + "\t\t\t\t<description><![CDATA[<a href=\"" + s.getUrlDiscuss() + "\">Discus</a>&nbsp;&nbsp;&nbsp;</br>Address: " + s.getAddress().getStreet() + (s.getHours() == null ? "" : "&nbsp;&nbsp;&nbsp;</br>Hours: " + s.getHours()) + "&nbsp;&nbsp;&nbsp;</br>Stalls: " + s.getStallCount() + "]]></description>";
                this.superchargersPermitXML = this.superchargersPermitXML + "\t\t\t\t<LookAt>\n";
                this.superchargersPermitXML = this.superchargersPermitXML + "\t\t\t\t\t<longitude>" + s.getGps().getLongitude() + "</longitude>\n";
                this.superchargersPermitXML = this.superchargersPermitXML + "\t\t\t\t\t<latitude>" + s.getGps().getLatitude() + "</latitude>\n";
                this.superchargersPermitXML = this.superchargersPermitXML + "\t\t\t\t\t<altitude>0</altitude>\n";
                this.superchargersPermitXML = this.superchargersPermitXML + "\t\t\t\t\t<heading>0</heading>\n";
                this.superchargersPermitXML = this.superchargersPermitXML + "\t\t\t\t\t<tilt>0</tilt>\n";
                this.superchargersPermitXML = this.superchargersPermitXML + "\t\t\t\t\t<range>632.6829721769273</range>\n";
                this.superchargersPermitXML = this.superchargersPermitXML + "\t\t\t\t\t<gx:altitudeMode>relativeToSeaFloor</gx:altitudeMode>\n";
                this.superchargersPermitXML = this.superchargersPermitXML + "\t\t\t\t</LookAt>\n";
                this.superchargersPermitXML = this.superchargersPermitXML + "\t\t\t\t<styleUrl>#msn_ylw-pushpin0</styleUrl>\n";
                this.superchargersPermitXML = this.superchargersPermitXML + "\t\t\t\t<Point>\n";
                this.superchargersPermitXML = this.superchargersPermitXML + "\t\t\t\t\t<coordinates>" + s.getGps().getLongitude() + "," + s.getGps().getLatitude() + ",0</coordinates>\n";
                this.superchargersPermitXML = this.superchargersPermitXML + "\t\t\t\t</Point>\n";
                this.superchargersPermitXML = this.superchargersPermitXML + "\t\t\t</Placemark>\n";
            }
        }

    }

    private void sleep() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

    }

    public void toFile(String filePath) throws FileNotFoundException, UnsupportedEncodingException {
        String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1, filePath.length());
        PrintWriter writer = new PrintWriter(filePath, "UTF-8");
        writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        writer.println("<kml xmlns=\"http://www.opengis.net/kml/2.2\" xmlns:gx=\"http://www.google.com/kml/ext/2.2\" xmlns:kml=\"http://www.opengis.net/kml/2.2\" xmlns:atom=\"http://www.w3.org/2005/Atom\">");
        writer.println("<Document>");
        writer.println("\t<name>" + fileName + "</name>");
        writer.println("\t<StyleMap id=\"msn_ylw-pushpin0\">");
        writer.println("\t\t<Pair>");
        writer.println("\t\t\t<key>normal</key>");
        writer.println("\t\t\t<styleUrl>#sn_ylw-pushpin1</styleUrl>");
        writer.println("\t\t</Pair>");
        writer.println("\t\t<Pair>");
        writer.println("\t\t\t<key>highlight</key>");
        writer.println("\t\t\t<styleUrl>#sh_ylw-pushpin1</styleUrl>");
        writer.println("\t\t</Pair>");
        writer.println("\t</StyleMap>");
        writer.println("\t<Style id=\"sh_ylw-pushpin1\">");
        writer.println("\t\t<IconStyle>");
        writer.println("\t\t\t<color>ff7f55ff</color>");
        writer.println("\t\t\t<scale>1.3</scale>");
        writer.println("\t\t\t<Icon>");
        writer.println("\t\t\t\t<href>http://maps.google.com/mapfiles/kml/pushpin/ylw-pushpin.png</href>");
        writer.println("\t\t\t</Icon>");
        writer.println("\t\t\t<hotSpot x=\"20\" y=\"2\" xunits=\"pixels\" yunits=\"pixels\"/>");
        writer.println("\t\t</IconStyle>");
        writer.println("\t</Style>");
        writer.println("\t<Style id=\"sn_ylw-pushpin1\">");
        writer.println("\t\t<IconStyle>");
        writer.println("\t\t\t<color>ff7f55ff</color>");
        writer.println("\t\t\t<scale>1.1</scale>");
        writer.println("\t\t\t<Icon>");
        writer.println("\t\t\t\t<href>http://maps.google.com/mapfiles/kml/pushpin/ylw-pushpin.png</href>");
        writer.println("\t\t\t</Icon>");
        writer.println("\t\t\t<hotSpot x=\"20\" y=\"2\" xunits=\"pixels\" yunits=\"pixels\"/>");
        writer.println("\t\t</IconStyle>");
        writer.println("\t</Style>");
        writer.println("\t<StyleMap id=\"msn_ylw-pushpin\">");
        writer.println("\t\t<Pair>");
        writer.println("\t\t\t<key>normal</key>");
        writer.println("\t\t\t<styleUrl>#sn_ylw-pushpin0</styleUrl>");
        writer.println("\t\t</Pair>");
        writer.println("\t\t<Pair>");
        writer.println("\t\t\t<key>highlight</key>");
        writer.println("\t\t\t<styleUrl>#sh_ylw-pushpin</styleUrl>");
        writer.println("\t\t</Pair>");
        writer.println("\t</StyleMap>");
        writer.println("\t<Style id=\"sn_ylw-pushpin0\">");
        writer.println("\t\t<IconStyle>");
        writer.println("\t\t\t<color>ff00aaff</color>");
        writer.println("\t\t\t<scale>1.1</scale>");
        writer.println("\t\t\t<Icon>");
        writer.println("\t\t\t\t<href>http://maps.google.com/mapfiles/kml/pushpin/ylw-pushpin.png</href>");
        writer.println("\t\t\t</Icon>");
        writer.println("\t\t\t<hotSpot x=\"20\" y=\"2\" xunits=\"pixels\" yunits=\"pixels\"/>");
        writer.println("\t\t</IconStyle>");
        writer.println("\t</Style>");
        writer.println("\t<Style id=\"sh_ylw-pushpin\">");
        writer.println("\t\t<IconStyle>");
        writer.println("\t\t\t<color>ff00aaff</color>");
        writer.println("\t\t\t<scale>1.3</scale>");
        writer.println("\t\t\t<Icon>");
        writer.println("\t\t\t\t<href>http://maps.google.com/mapfiles/kml/pushpin/ylw-pushpin.png</href>");
        writer.println("\t\t\t</Icon>");
        writer.println("\t\t\t<hotSpot x=\"20\" y=\"2\" xunits=\"pixels\" yunits=\"pixels\"/>");
        writer.println("\t\t</IconStyle>");
        writer.println("\t</Style>");
        writer.println("\t<Style id=\"sh_ylw-pushpin0\">");
        writer.println("\t\t<IconStyle>");
        writer.println("\t\t\t<color>ff00ff00</color>");
        writer.println("\t\t\t<scale>1.3</scale>");
        writer.println("\t\t\t<Icon>");
        writer.println("\t\t\t\t<href>http://maps.google.com/mapfiles/kml/pushpin/ylw-pushpin.png</href>");
        writer.println("\t\t\t</Icon>");
        writer.println("\t\t\t<hotSpot x=\"20\" y=\"2\" xunits=\"pixels\" yunits=\"pixels\"/>");
        writer.println("\t\t</IconStyle>");
        writer.println("\t</Style>");
        writer.println("\t<Style id=\"s_ylw-pushpin\">");
        writer.println("\t\t<IconStyle>");
        writer.println("\t\t\t<scale>1.1</scale>");
        writer.println("\t\t\t<Icon>");
        writer.println("\t\t\t\t<href>http://maps.google.com/mapfiles/kml/pushpin/ylw-pushpin.png</href>");
        writer.println("\t\t\t</Icon>");
        writer.println("\t\t\t<hotSpot x=\"20\" y=\"2\" xunits=\"pixels\" yunits=\"pixels\"/>");
        writer.println("\t\t</IconStyle>");
        writer.println("\t</Style>");
        writer.println("\t<Style id=\"sn_ylw-pushpin\">");
        writer.println("\t\t<IconStyle>");
        writer.println("\t\t\t<color>ff00ff00</color>");
        writer.println("\t\t\t<scale>1.1</scale>");
        writer.println("\t\t\t<Icon>");
        writer.println("\t\t\t\t<href>http://maps.google.com/mapfiles/kml/pushpin/ylw-pushpin.png</href>");
        writer.println("\t\t\t</Icon>");
        writer.println("\t\t\t<hotSpot x=\"20\" y=\"2\" xunits=\"pixels\" yunits=\"pixels\"/>");
        writer.println("\t\t</IconStyle>");
        writer.println("\t</Style>");
        writer.println("\t<StyleMap id=\"msn_ylw-pushpin1\">");
        writer.println("\t\t<Pair>");
        writer.println("\t\t\t<key>normal</key>");
        writer.println("\t\t\t<styleUrl>#sn_ylw-pushpin</styleUrl>");
        writer.println("\t\t</Pair>");
        writer.println("\t\t<Pair>");
        writer.println("\t\t\t<key>highlight</key>");
        writer.println("\t\t\t<styleUrl>#sh_ylw-pushpin0</styleUrl>");
        writer.println("\t\t</Pair>");
        writer.println("\t</StyleMap>");
        writer.println("\t<Style id=\"s_ylw-pushpin_hl\">");
        writer.println("\t\t<IconStyle>");
        writer.println("\t\t\t<scale>1.3</scale>");
        writer.println("\t\t\t<Icon>");
        writer.println("\t\t\t\t<href>http://maps.google.com/mapfiles/kml/pushpin/ylw-pushpin.png</href>");
        writer.println("\t\t\t</Icon>");
        writer.println("\t\t\t<hotSpot x=\"20\" y=\"2\" xunits=\"pixels\" yunits=\"pixels\"/>");
        writer.println("\t\t</IconStyle>");
        writer.println("\t</Style>");
        writer.println("\t<StyleMap id=\"m_ylw-pushpin\">");
        writer.println("\t\t<Pair>");
        writer.println("\t\t\t<key>normal</key>");
        writer.println("\t\t\t<styleUrl>#s_ylw-pushpin</styleUrl>");
        writer.println("\t\t</Pair>");
        writer.println("\t\t<Pair>");
        writer.println("\t\t\t<key>highlight</key>");
        writer.println("\t\t\t<styleUrl>#s_ylw-pushpin_hl</styleUrl>");
        writer.println("\t\t</Pair>");
        writer.println("\t</StyleMap>");
        writer.println("\t<Folder>");
        writer.println("\t\t<name>superchargers</name>");
        writer.println("\t\t<open>1</open>");
        writer.println("\t\t<Folder>");
        writer.println("\t\t\t<name>Open</name>");
        writer.println("\t\t\t<open>1</open>");
        this.output.setProgress(69, "Opened");
        this.sleep();
        writer.print(this.superchargersOpenXML);
        this.output.setProgress(90, "Comp. open");
        this.sleep();
        writer.println("\t\t</Folder>");
        writer.println("\t\t<Folder>");
        writer.println("\t\t\t<name>Construction</name>");
        writer.println("\t\t\t<open>1</open>");
        this.output.setProgress(91, "Construction");
        this.sleep();
        writer.print(this.superchargersConstructionXML);
        this.output.setProgress(95, "Comp. const.");
        this.sleep();
        writer.println("\t\t</Folder>");
        writer.println("\t\t<Folder>");
        writer.println("\t\t\t<name>Permit</name>");
        writer.println("\t\t\t<open>1</open>");
        this.output.setProgress(96, "Permit");
        this.sleep();
        writer.print(this.superchargersPermitXML);
        this.output.setProgress(98, "Comp. permit");
        this.sleep();
        writer.println("\t\t</Folder>");
        writer.println("\t</Folder>");
        writer.println("</Document>");
        writer.println("</kml>");
        this.output.setProgress(99, "Finishing");
        this.sleep();
        writer.close();
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public void run() {
        this.loadPage();
        this.output.setProgress(33, "Converting");
        this.sleep();
        this.beanToXML();
        this.output.setProgress(66, "Writing");
        this.sleep();

        try {
            this.toFile(this.fileLocation);
            this.output.setProgress(100, "Finished");
            Toolkit.getDefaultToolkit().beep();
        } catch (FileNotFoundException var2) {
            var2.printStackTrace();
        } catch (UnsupportedEncodingException var3) {
            var3.printStackTrace();
        }

    }
}
