package com.greg.mynotes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private Date updated;

    public Notes() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Notes(String title, String content, Date updated) {
        super();
        this.title = title;
        this.content = content;
        this.updated = updated;
    }

    /**
     * Get the note id
     * @return Note id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the note id
     * @param id note id before change
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the note title
     * @return note title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the note title
     * @param title note title to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the note content
     * @return note content
     */
    public String getContent() {
        return content;
    }

    /**
     * Set the note content
     * @param content content to be set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Get the note date updated
     * @return note update date
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Set the note updated date
     * @param updated date to set
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
