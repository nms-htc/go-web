/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.model.type;

public enum PageType {

    SINGLE_DOCUMENT(1), LIST_DOCUMENT(2), SPECIFIC_PAGE(3);

    private int _value;

    private PageType(int value) {
        _value = value;
    }

    public static PageType fromIntValue(int value) {
        switch (value) {
            case 1:
                return SINGLE_DOCUMENT;
            case 2:
                return LIST_DOCUMENT;
            case 3:
                return SPECIFIC_PAGE;
        }

        return null;
    }
    
    public int getValue() {
        return _value;
    }

    public String getLabel() {
        switch (this) {
            case SINGLE_DOCUMENT:
                return "single-document";
            case LIST_DOCUMENT:
                return "list-document";
            case SPECIFIC_PAGE:
                return "specific-page";
        }
        return null;
    }
}
