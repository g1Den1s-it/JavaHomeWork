package org.example.Lab_17.elements.board;
import lombok.Data;

@Data
public class TrelloBoard {
    private String id;
    private String name;
    private String desc;
    private Object descData;
    private Boolean closed;
    private String idOrganization;
    private Object idEnterprise;
    private Boolean pinned;
    private String url;
    private String shortUrl;
    private TrelloPrefs prefs;
    private TrelloLabelNames labelNames;
    private Object limits;
}
