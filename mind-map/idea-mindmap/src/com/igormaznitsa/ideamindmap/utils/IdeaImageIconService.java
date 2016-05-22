package com.igormaznitsa.ideamindmap.utils;

import com.igormaznitsa.mindmap.swing.services.DefaultImageIconService;
import com.igormaznitsa.mindmap.swing.services.IconID;
import com.igormaznitsa.mindmap.swing.services.ImageIconService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.swing.Icon;
import java.util.EnumMap;
import java.util.Map;

public class IdeaImageIconService implements ImageIconService {
  private static final Map<IconID, Icon> MAP = new EnumMap<IconID, Icon>(IconID.class);

  private static final DefaultImageIconService DELEGATE = new DefaultImageIconService();

  static {
    MAP.put(IconID.ICON_PRINTER, AllIcons.PopUp.PRINTER);
    MAP.put(IconID.ICON_PAGE, AllIcons.PopUp.PAGE);
    MAP.put(IconID.ICON_EMOTICONS, AllIcons.PopUp.EMOTICONS);
    MAP.put(IconID.POPUP_EXTRAS_TEXT, AllIcons.PopUp.NOTE);
    MAP.put(IconID.POPUP_EXTRAS_FILE, AllIcons.PopUp.FILE);
    MAP.put(IconID.POPUP_EXTRAS_JUMP, AllIcons.PopUp.TOPIC);
    MAP.put(IconID.POPUP_EXTRAS_URI, AllIcons.PopUp.URL);
    MAP.put(IconID.POPUP_EDIT_TEXT, AllIcons.PopUp.EDITTEXT);
    MAP.put(IconID.POPUP_ADD_CHILD, AllIcons.PopUp.ADD);
    MAP.put(IconID.POPUP_CLONE_TOPIC, AllIcons.PopUp.CLONE);
    MAP.put(IconID.POPUP_REMOVE_TOPIC, AllIcons.PopUp.DELETE);
    MAP.put(IconID.POPUP_ABOUT, AllIcons.PopUp.INFO);
    MAP.put(IconID.POPUP_OPTIONS, AllIcons.PopUp.OPTIONS);
    MAP.put(IconID.POPUP_SHOWJUMPS, AllIcons.PopUp.SHOWJUMPS);
    MAP.put(IconID.POPUP_UNFOLDALL, AllIcons.PopUp.EXPANDALL);
    MAP.put(IconID.POPUP_COLLAPSEALL, AllIcons.PopUp.COLLAPSEALL);
    MAP.put(IconID.POPUP_CHANGECOLOR, AllIcons.PopUp.COLORS);
  }

  @Nullable @Override public Icon getIconForId(@Nonnull final IconID imageIconID) {
    Icon result = MAP.get(imageIconID);
    if (result == null) {
      result = DELEGATE.getIconForId(imageIconID);
    }
    return result;
  }
}
