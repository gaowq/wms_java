package com.example.wms_java.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * menu
 *
 * @author
 */
@Repository
public class MyMenu implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer parentId;

    private String code;

    private String url;

    private String text;

    private Boolean checked;

    private String state;

    private MyMenu[] children;

    private List<MyMenu> childrenList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public MyMenu[] getChildren() {
        return children;
    }

    public void setChildren(MyMenu[] myMenus) {
        this.children = myMenus;
    }

    public void refreshChildren() {
        if (this.childrenList == null || this.childrenList.stream().count() == 0) {
            return;
        }

        this.children = this.childrenList.toArray(new MyMenu[childrenList.size()]);
    }

    public void addChildren(MyMenu children) {
        if (childrenList == null) {
            this.childrenList = new ArrayList<>();
        }

        this.childrenList.add(children);
    }
}
