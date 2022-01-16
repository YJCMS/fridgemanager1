package com.fridgeproject.fridgemanager1.service;



import java.util.List;
import java.util.stream.Collectors;


import com.fridgeproject.fridgemanager1.domain.food.Food;
import com.fridgeproject.fridgemanager1.domain.food.FoodRepository;
import com.fridgeproject.fridgemanager1.dto.FoodListResponseDto;
import com.fridgeproject.fridgemanager1.dto.FoodSaveRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FoodService {
    private final FoodRepository foodRepository;

    // 데이터 넣기
    @Transactional
    public Long save(FoodSaveRequestDto requestDto) {
        return foodRepository.save(requestDto.toEntity()).getId();
    }

    // 전체 데이터 불러오기
    @Transactional(readOnly = true)
    public List<FoodListResponseDto> findAll() {
        return foodRepository.findAll().stream()
                .map(FoodListResponseDto::new)
                .collect(Collectors.toList());
    }

    // 데이터 수정
    @Transactional
    public Long update(Long id, FoodSaveRequestDto requestDto) {
        Food food = foodRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("수정할 메뉴가 없다." + id));
        food.update(requestDto.getFoodName(), requestDto.getQuantity(), requestDto.getExpDate());
        return id;
    }

    // 데이터 삭제
    @Transactional
    public void delete(Long id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("삭제할 데이터 없다." + id));
        foodRepository.delete(food);
    }

    
}
