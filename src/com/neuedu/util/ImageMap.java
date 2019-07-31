package com.neuedu.util;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ImageMap {

    private static final Map<String, Image> map = new HashMap<>();

    static{
        map.put("bg1",ImageUtil.getImage("com\\neuedu\\imgs\\bg\\bg1.png"));

        map.put("my01",ImageUtil.getImage("com\\neuedu\\imgs\\plane\\my01.png"));

        map.put("mb01",ImageUtil.getImage("com\\neuedu\\imgs\\bullet\\myb_1.png"));

        map.put("ep01",ImageUtil.getImage("com\\neuedu\\imgs\\plane\\ep_1.png"));

        map.put("epb01",ImageUtil.getImage("com\\neuedu\\imgs\\bullet\\epb_1.png"));
    }

    public static Image get(String key){
        return map.get(key);
    }
}
