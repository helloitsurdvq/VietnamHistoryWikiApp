package controller.helper;

import java.io.IOException;
import java.util.Map;

import collection.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import main.App;
import main.EntityPages;
import model.*;
import controller.detail.*;

public class FlowPaneUIHelp {
    
    public static void populateFigure(Map<String, Integer> figureMap, FlowPane flowPane) {
        if(figureMap == null){return;}
        for (Map.Entry<String, Integer> entry : figureMap.entrySet()) {
            Text figureText = new Text(entry.getKey());
            int id = entry.getValue();

            if (isValidFigureId(id)) {
                setLinkStyle(figureText);
                figureText.setOnMouseClicked(mouseEvent -> navigateFigureLink(id));
            }

            flowPane.getChildren().add(figureText);
        }

    }

    public static void populateEvent(Map<String, Integer> eventMap, FlowPane flowPane){
        if(eventMap == null){return;}
        for (Map.Entry<String, Integer> entry : eventMap.entrySet()) {
            Text eventText = new Text(entry.getKey());
            int id = entry.getValue();

            if (isValidEventId(id)) {
                setLinkStyle(eventText);
                eventText.setOnMouseClicked(mouseEvent -> navigateEventLink(id));
            }

            flowPane.getChildren().add(eventText);
        }
    }

    public static void populateRelic(Map<String, Integer> relicMap, FlowPane flowPane){
        if(relicMap == null){return;}
        for (Map.Entry<String, Integer> entry : relicMap.entrySet()) {
            Text relicText = new Text(entry.getKey());
            int id = entry.getValue();

            if (isValidRelicId(id)) {
                setLinkStyle(relicText);
                relicText.setOnMouseClicked(mouseEvent -> navigateRelicLink(id));
            }

            flowPane.getChildren().add(relicText);
        }
    }

    public static void polulateFestival(Map<String, Integer> festivalMap, FlowPane flowPane){
        if(festivalMap == null){return;}
        for (Map.Entry<String, Integer> entry : festivalMap.entrySet()) {
            Text festivalText = new Text(entry.getKey());
            int id = entry.getValue();

            if (isValidFestivalId(id)) {
                setLinkStyle(festivalText);
                festivalText.setOnMouseClicked(mouseEvent -> navigateFestivalLink(id));
            }

            flowPane.getChildren().add(festivalText);
        }
    }

    public static void polulateEra(Map<String, Integer> eraMap, FlowPane flowPane){
        if(eraMap == null){return;}
        for (Map.Entry<String, Integer> entry : eraMap.entrySet()) {
            Text eraText = new Text(entry.getKey());
            int id = entry.getValue();

            if (isValidEraId(id)) {
                setLinkStyle(eraText);
                eraText.setOnMouseClicked(mouseEvent -> navigateEraLink(id));
            }

            flowPane.getChildren().add(eraText);
        }
    }


    private static void setLinkStyle(Text textLink){
        textLink.setFill(Color.web("#3498db"));
        textLink.setOnMouseEntered(mouseEvent -> {
            textLink.setUnderline(true);
            textLink.setCursor(Cursor.HAND);
        });
        textLink.setOnMouseExited(mouseEvent -> {
            textLink.setUnderline(false);
            textLink.setCursor(Cursor.DEFAULT);
        });
    }

    private static void navigateEraLink(int id){
        Era linkFigure = EraData.data.getById(id);
        try {
            FXMLLoader loader = App.setAndReturnRoot(EntityPages.ERA_PAGES.getDetailPage());
            EraDetailController controller = loader.getController();
            controller.setEra(linkFigure);
            App.clickBackService.addEntityToClickBackStack(linkFigure);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void navigateFestivalLink(int id){
        Festival linkFigure = FestivalData.data.getById(id);
        try {
            FXMLLoader loader = App.setAndReturnRoot(EntityPages.FESTIVAL_PAGES.getDetailPage());
            FestivalDetailController controller = loader.getController();
            controller.setFestival(linkFigure);
            App.clickBackService.addEntityToClickBackStack(linkFigure);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void navigateFigureLink(int id){
        Figure linkFigure = FigureData.data.getById(id);
        try {
            FXMLLoader loader = App.setAndReturnRoot(EntityPages.FIGURE_PAGES.getDetailPage());
            FigureDetailController controller = loader.getController();
            controller.setFigure(linkFigure);
            App.clickBackService.addEntityToClickBackStack(linkFigure);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void navigateEventLink(int id){
        Event linkEvent = EventData.data.getById(id);
        try {
            FXMLLoader loader = App.setAndReturnRoot(EntityPages.EVENT_PAGES.getDetailPage());
            EventDetailController controller = loader.getController();
            controller.setEvent(linkEvent);
            App.clickBackService.addEntityToClickBackStack(linkEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void navigateRelicLink(int id){
        Relic linkRelic = RelicData.data.getById(id);
        try {
            FXMLLoader loader = App.setAndReturnRoot(EntityPages.RELIC_PAGES.getDetailPage());
            RelicDetailController controller = loader.getController();
            controller.setRelic(linkRelic);
            App.clickBackService.addEntityToClickBackStack(linkRelic);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidFigureId(int id){
        if(id <= 0) return false;
        if(id > FigureData.getNumOfFigure()) return false;
        return true;
    }

    private static boolean isValidRelicId(int id){
        if(id <= 0) return false;
        if(id > RelicData.getNumOfRelic()) return false;
        return true;
    }

    private static boolean isValidEraId(int id){
        if(id <= 0) return false;
        if(id > EraData.getNumOfEra()) return false;
        return true;
    }

    private static boolean isValidEventId(int id){
        if(id <= 0) return false;
        if(id > EventData.getNumOfEvent()) return false;
        return true;
    }

    private static boolean isValidFestivalId(int id){
        if(id <= 0) return false;
        if(id > FestivalData.getNumOfFestival()) return false;
        return true;
    }


}
