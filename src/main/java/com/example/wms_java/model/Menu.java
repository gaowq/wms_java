package com.example.wms_java.model;

import java.io.Serializable;
import org.springframework.stereotype.Repository;

/**
 * menu
 * @author
 */
@Repository
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer parentid;

    private String url;

    private String text;

    private Boolean checked;

    private String state;

    private Menu[] children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Menu[] getChildren() {
        return children;
    }

    public void setChildren(Menu[] children) {
        this.children = children;
    }
}
