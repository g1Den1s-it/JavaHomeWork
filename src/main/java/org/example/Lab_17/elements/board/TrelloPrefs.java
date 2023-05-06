package org.example.Lab_17.elements.board;

import java.util.List;
import lombok.Data;

@Data
public class TrelloPrefs {
    private String permissionLevel;
    private Boolean hideVotes;
    private String voting;
    private String comments;
    private String invitations;
    private Boolean selfJoin;
    private Boolean cardCovers;
    private Boolean isTemplate;
    private String cardAging;
    private Boolean calendarFeedEnabled;
    private List<Object> hiddenPluginBoardButtons;
    private List<TrelloSwitcherViews> switcherViews;
    private String background;
    private String backgroundColor;
    private Object backgroundImage;
    private Object backgroundImageScaled;
    private Boolean backgroundTile;
    private String backgroundBrightness;
    private String backgroundBottomColor;
    private String backgroundTopColor;
    private Boolean canBePublic;
    private Boolean canBeEnterprise;
    private Boolean canBeOrg;
    private Boolean canBePrivate;
    private Boolean canInvite;
}
