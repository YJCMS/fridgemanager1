package com.fridgeproject.fridgemanager1.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fridgeproject.fridgemanager1.dto.RecipeDto;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Recipe {
    public static List<RecipeDto> getRecipeList() {
        System.out.println("레시피 100 출력");
        List<RecipeDto> list = new ArrayList<RecipeDto>();
        String URL = "https://www.melon.com/chart/index.htm";

        try {
            Document doc = Jsoup.connect(URL).get();

            Elements title = doc.select("div.ellipsis.rank01 > span > a");
            Elements link = doc.select("div.ellipsis.rank02 > span");

            int rank = 0;
            // 임시 리스트
            List<String> tmpList = new ArrayList<>();
            for (Element e : link) {
                // System.out.println(e.text());
                tmpList.add(e.text());
            }
            for (Element e : title) {
                // System.out.println(e.text());
                RecipeDto dto = new RecipeDto();
                dto.setRank(rank + 1);
                dto.setTitle(e.text());
                dto.setLink(tmpList.get(rank++));
                list.add(dto);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return list;
    }
}
