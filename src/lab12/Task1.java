package Lab12;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Task1 {
    public static String url = "https://www.moscowmap.ru/metro.html#lines";

    public static ArrayList<String> numbersOfLines = new ArrayList<>();
    public static ArrayList<String> listOfLines = new ArrayList<>();
    public static ArrayList<Station> metro= new ArrayList<>();

    public static void main(String[] args) throws IOException {
        getMetro();
        writeToJson();

        Gson gson = new Gson();
        Metro metro = gson.fromJson(parseFile(), Metro.class);

        System.out.println(metro);

    }

    public static String parseFile(){
        StringBuilder builder = new StringBuilder();

        try{
            List<String> files = Files.readAllLines(Paths.get("src/Lab12/test.json"));
            files.forEach(file -> builder.append(file).append("\n"));
        } catch (Exception e){
            e.printStackTrace();
        }

        return builder.toString();
    }

    public static void writeToJson() throws IOException{
        //заполняем Stations[] в Метро
        Metro metroList = new Metro();
        for (int i = 0; i < numbersOfLines.size(); i++){
            metroList.stations[i].setNum(numbersOfLines.get(i));
            for (Station station : metro){
                if (station.number.equals(numbersOfLines.get(i)))
                    metroList.stations[i].line.add(station.name);
            }
        }

        //заполняем Lines[] в метро
        for (int i = 0; i < numbersOfLines.size(); i++){
            metroList.lines[i].number = numbersOfLines.get(i);
            metroList.lines[i].name = listOfLines.get(i);
        }

        //пишем
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();//это методы для красоты
        FileWriter writer = new FileWriter("src/Lab12/test.json");
        gson.toJson(metroList, writer);
        writer.flush();
        writer.close();
    }

    public static void getMetro() throws IOException{
        Document doc = Jsoup.connect(url).get();
        Elements lines = doc.select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln");

        //берем линии
        for (Element line : lines)
            listOfLines.add(line.text());

        //берем номера линий
        for (Element line : lines){
            String str = line.toString().split("\"")[3];
            numbersOfLines.add(str);
        }

        //берем станции и раскидываем все полученные данные по объектам
        Elements stations = doc.select("div.t-metrostation-list-table");
        int n = -1;
        String[] strs = stations.toString().split("\n");
        for (String str : strs) {
            if (str.contains("js-metro-stations") && n < numbersOfLines.size()) n++;
            if (str.contains("span")) {
                str = str.split(">")[5].split("<")[0];
                Station station = new Station(str, numbersOfLines.get(n), listOfLines.get(n));
                metro.add(station);
            }
        }

    }
}

//класса для списка, в нем хранятся станции для записи в класс Метро
class Station{
    String name;
    String number;
    String line;

    public Station(String name, String number, String line){
        this.name = name;
        this.number = number;
        this.line = line;
    }
}


//класс для поля в Метро
class Stations{
    String num;
    ArrayList<String> line;

    public Stations(){
        line = new ArrayList<>();
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "\t"  + num+ ": " + line + "\n";
    }
}

//Класс для поля в Метро
class Line{
    String number;
    String name;

    @Override
    public String toString() {
        return "\t"+ number + ": " + name + "\n";
    }
}

//Класс, который записывается в Json
class Metro{
    Stations[] stations;
    Line[] lines;

    public Metro(){
        stations = new Stations[17];
        for (int i = 0; i < 17; i++)
            stations[i] = new Stations();

        lines = new Line[17];
        for (int i = 0; i < 17; i++)
            lines[i] = new Line();
    }

    @Override
    public String toString() {
        return "Metro" + "\n" +
                "\t" + "stations:" + "\n" + Arrays.toString(stations)
                                                    .replace("[", "\t")
                                                    .replace("]", "")
                                                    .replace(",", "\t") + "\n" +
                "\t" + "lines:" + "\n"+Arrays.toString(lines)
                                                    .replace("[", "\t")
                                                    .replace("]", "")
                                                    .replace(",", "\t");
    }
}
