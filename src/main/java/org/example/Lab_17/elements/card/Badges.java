package org.example.Lab_17.elements.card;

import lombok.Data;

@Data
public class Badges {
    private AttachmentsByType attachmentsByType;
    private Boolean location;
    private Integer votes;
    private Boolean viewingMemberVoted;
    private Boolean subscribed;
    private String fogbugz;
    private Integer checkItems;
    private Integer checkItemsChecked;
    private String checkItemsEarliestDue;
    private Integer comments;
    private Integer attachments;
    private Boolean description;
    private String due;
    private Boolean dueComplete;
    private String start;
}
