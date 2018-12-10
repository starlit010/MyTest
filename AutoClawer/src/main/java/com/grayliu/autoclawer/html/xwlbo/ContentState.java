package com.grayliu.autoclawer.html.xwlbo;

import com.alibaba.druid.util.StringUtils;

/**
 * Created by liuhui-ds9 on 2018/11/30.
 *
 * xwlbo的状态机
 */
public class ContentState {

    private State currentState = State.title;

    enum State{

        title,content

    }

    State updateState(String value){
        if(StringUtils.isEmpty(value)){
            return null;
        }
        if(value.startsWith("<p><strong>") && currentState == State.title){
            currentState = State.title;
        }else if(value.startsWith("<p>") && currentState == State.title){
            currentState = State.content;
        }else if(value.startsWith("<p><strong>") && currentState == State.content){
            currentState = State.title;
        }else if(value.startsWith("<p>") && currentState == State.content){
            currentState = State.content;
        }
        return currentState;
    }



}
