package com.sparta.quizdemo.option.dto;

import com.sparta.quizdemo.option.entity.Option;
import lombok.Getter;

@Getter
public class OptionResponseDto {
    private Long id;
    private String category;
    private String optionName;
    private Long optionPrice;

    public OptionResponseDto(Option option) {
        this.id = option.getId();
        this.category = option.getCategory();
        this.optionName = option.getOptionName();
        this.optionPrice = option.getOptionPrice();
    }
}
