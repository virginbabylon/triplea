package games.strategy.engine.auto.update;

import games.strategy.engine.ClientContext;
import games.strategy.engine.framework.map.download.DownloadMapsWindow;
import games.strategy.engine.framework.map.download.MapDownloadController;
import games.strategy.ui.SwingComponents;

class TutorialMapCheck {
  static void checkForTutorialMap() {
    final MapDownloadController mapDownloadController = ClientContext.mapDownloadController();
    final boolean promptToDownloadTutorialMap = mapDownloadController.shouldPromptToDownloadTutorialMap();
    mapDownloadController.preventPromptToDownloadTutorialMap();
    if (!promptToDownloadTutorialMap) {
      return;
    }

    final String message = "<html>Would you like to download the tutorial map?<br><br>"
        + "(You can always download it later using the Download Maps<br>"
        + "command if you don't want to do it now.)</html>";
    SwingComponents.promptUser("Welcome to TripleA", message, () -> {
      DownloadMapsWindow.showDownloadMapsWindowAndDownload("Tutorial");
    });
  }
}
