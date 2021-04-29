package com.markhub.common.lang;

import lombok.Data;

@Data
public class Result {
    private int code;//200正常，非200异常
    private String msg;
    private Object data;

    public static Result succ(Object data){
        return Result.succ(200,"操作成功",data);
    }
    public static Result succ(int code,String msg,Object data){
        Result r=new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result fail(String msg){

        return Result.fail(400,msg,null);
    }

    public static Result fail(String msg,Object data){

        return Result.fail(400,msg,data);
    }

    public static Result fail(int code,String msg,Object data){
        Result r=new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
}
