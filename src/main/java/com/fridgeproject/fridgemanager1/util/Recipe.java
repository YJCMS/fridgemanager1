package com.fridgeproject.fridgemanager1.util;

import com.fridgeproject.fridgemanager1.dto.RecipeDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 멜론차트 참고해서 수정 중인데...크롤링 어려운거 같습니다.
public class Recipe {
    public static List<RecipeDto> getRecipeList() {
        System.out.println("만개의 레시피 랭킹 100");
        List<RecipeDto> list = new ArrayList<RecipeDto>();
        String URL = "https://www.10000recipe.com/ranking/home_new.html?rtype=r&dtype=d";

        try {
            Document doc = Jsoup.connect(URL).get();

            Elements recipeTitle = doc.select("div.ellipsis.rank01 > span > a");
            Elements recipeLink = doc.select("div.ellipsis.rank02 > span");

            int rank = 0;
            // 임시 리스트
            List<String> tmpList = new ArrayList<>();
            for (Element e : recipeLink) {
                // System.out.println(e.text());
                tmpList.add(e.text());
            }
            for (Element e : recipeTitle) {
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
