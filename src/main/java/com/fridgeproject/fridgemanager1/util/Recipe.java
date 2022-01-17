package com.fridgeproject.fridgemanager1.util;

import com.fridgeproject.fridgemanager1.dto.RecipeDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


public class Recipe {
    public static List<RecipeDto> getRecipeList() {
        java.util.List<RecipeDto> list = new ArrayList<RecipeDto>();
        String url = "https://www.10000recipe.com/ranking/home_new.html";

        try {
            Document doc = Jsoup.connect(url).get();
            Elements li = doc.select(".common_sp_list_li");  // 사진과 링크등등이 담긴 리스트

            int rank = 1;
            for (Element e : li) {
//                String title = e.text();
//                String link = "https://www.10000recipe.com" + e.select("a").attr("href");
//                String img = e.select("img").attr("src");

                RecipeDto dto = new RecipeDto();
                dto.setRank(rank++);
                dto.setTitle(e.text());
                dto.setLink("https://www.10000recipe.com" + e.select("a").attr("href"));
                dto.setImg(e.select("img").attr("src"));
                list.add(dto);


               // list.add(RecipeDto.builder().title(title).link(link).img(img).build());
//                System.out.println("title: " + e.text());
//                System.out.println("link: " +  "https://www.10000recipe.com" + e.select("a").attr("href"));
//                System.out.println("img: " + e.select("img").attr("src"));
//                String[] sp = e.attr("alt").split("사진 - ");
//                    list.add(new KidsMapDto(sName, sAddr, tmpList.get(i++)));
//                list.add(KidsMapDto.builder().store(sName).addr(sAddr).category(tmpList.get(i++)).build());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
            // 여길 살려서 여기에 디비로 넣으면 될것 같아요
            // 데이터베이스에 insert
//            ScrapMapDao dao = new ScrapMapDaoImpl();
//            dao.saveList(list);
//

        // 이거는 그냥 출력 해봄 여기있는 내용을 디비에 넣으면 되겠죠?
//        for (RecipeDto d : list) {
//            System.out.println(d.getTitle());
//            System.out.println(d.getLink());
//            System.out.println(d.getImg());
//        }
//        list.stream().forEach(dto -> System.out.println(dto.getCategory() + "\n" + dto.getStore() + "\n" + dto.getAddr()));
