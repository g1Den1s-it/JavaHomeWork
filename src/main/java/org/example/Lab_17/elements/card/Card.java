package org.example.Lab_17.elements.card;

import lombok.Data;

import java.util.List;
@Data
public class Card {
    private String id;
    private Badges badges;
    private List<CheckItemState> checkItemStates;
    private Boolean closed;
    private Boolean dueComplete;
    private String dateLastActivity;
    private String desc;
    private DescData descData;
    private String due;
    private String dueReminder;
    private String email;
    private String idBoard;
    private List<String> idChecklists;
    private String idList;
    private List<String> idMembers;
    private List<String> idMembersVoted;
    private Integer idShort;
    private String idAttachmentCover;
    private List<String> labels;
    private List<String> idLabels;
    private Boolean manualCoverAttachment;
    private String name;
    private Integer pos;
    private String shortLink;
    private String shortUrl;
    private String start;
    private Boolean subscribed;
    private String url;
    private Cover cover;
    private Boolean isTemplate;
    private String cardRole;
    private List<Attachment> attachments;
    private List<Sticker> stickers;
    private Limits limits;
}
