package com.baizhi.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/8/28.
 */
public class Menu {
    private Integer id;
    private String title;
    private String href;
    private String iconCls;
    private Integer parentId;

    private List<Menu> content;

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", parentId=" + parentId +
                ", content=" + content +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (id != null ? !id.equals(menu.id) : menu.id != null) return false;
        if (title != null ? !title.equals(menu.title) : menu.title != null) return false;
        if (href != null ? !href.equals(menu.href) : menu.href != null) return false;
        if (iconCls != null ? !iconCls.equals(menu.iconCls) : menu.iconCls != null) return false;
        if (parentId != null ? !parentId.equals(menu.parentId) : menu.parentId != null) return false;
        return content != null ? content.equals(menu.content) : menu.content == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (href != null ? href.hashCode() : 0);
        result = 31 * result + (iconCls != null ? iconCls.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getContent() {
        return content;
    }

    public void setContent(List<Menu> content) {
        this.content = content;
    }

    public Menu(Integer id, String title, String href, String iconCls, Integer parentId, List<Menu> content) {

        this.id = id;
        this.title = title;
        this.href = href;
        this.iconCls = iconCls;
        this.parentId = parentId;
        this.content = content;
    }

    public Menu() {

    }
}
