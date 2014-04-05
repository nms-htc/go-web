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
}
